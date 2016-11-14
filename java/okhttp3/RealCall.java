package okhttp3;

import java.io.IOException;
import java.net.ProtocolException;
import java.util.logging.Level;
import okhttp3.Interceptor.Chain;
import okhttp3.Request.Builder;
import okhttp3.internal.Internal;
import okhttp3.internal.NamedRunnable;
import okhttp3.internal.http.HttpEngine;
import okhttp3.internal.http.RequestException;
import okhttp3.internal.http.RouteException;
import okhttp3.internal.http.StreamAllocation;

final class RealCall implements Call {
    volatile boolean canceled;
    private final OkHttpClient client;
    HttpEngine engine;
    private boolean executed;
    Request originalRequest;

    class ApplicationInterceptorChain implements Chain {
        private final boolean forWebSocket;
        private final int index;
        private final Request request;

        ApplicationInterceptorChain(int index, Request request, boolean forWebSocket) {
            this.index = index;
            this.request = request;
            this.forWebSocket = forWebSocket;
        }

        public Connection connection() {
            return null;
        }

        public Request request() {
            return this.request;
        }

        public Response proceed(Request request) throws IOException {
            if (this.index >= RealCall.this.client.interceptors().size()) {
                return RealCall.this.getResponse(request, this.forWebSocket);
            }
            Interceptor interceptor = (Interceptor) RealCall.this.client.interceptors().get(this.index);
            Response intercept = interceptor.intercept(new ApplicationInterceptorChain(this.index + 1, request, this.forWebSocket));
            if (intercept != null) {
                return intercept;
            }
            throw new NullPointerException("application interceptor " + interceptor + " returned null");
        }
    }

    final class AsyncCall extends NamedRunnable {
        private final boolean forWebSocket;
        private final Callback responseCallback;

        private AsyncCall(Callback responseCallback, boolean forWebSocket) {
            super("OkHttp %s", this$0.originalRequest.url().toString());
            this.responseCallback = responseCallback;
            this.forWebSocket = forWebSocket;
        }

        String host() {
            return RealCall.this.originalRequest.url().host();
        }

        Request request() {
            return RealCall.this.originalRequest;
        }

        Object tag() {
            return RealCall.this.originalRequest.tag();
        }

        void cancel() {
            RealCall.this.cancel();
        }

        RealCall get() {
            return RealCall.this;
        }

        protected void execute() {
            boolean signalledCallback = false;
            try {
                Response response = RealCall.this.getResponseWithInterceptorChain(this.forWebSocket);
                if (RealCall.this.canceled) {
                    this.responseCallback.onFailure(RealCall.this, new IOException("Canceled"));
                } else {
                    signalledCallback = true;
                    this.responseCallback.onResponse(RealCall.this, response);
                }
                RealCall.this.client.dispatcher().finished(this);
            } catch (IOException e) {
                if (signalledCallback) {
                    Internal.logger.log(Level.INFO, "Callback failure for " + RealCall.this.toLoggableString(), e);
                } else {
                    this.responseCallback.onFailure(RealCall.this, e);
                }
                RealCall.this.client.dispatcher().finished(this);
            } catch (Throwable th) {
                RealCall.this.client.dispatcher().finished(this);
            }
        }
    }

    protected RealCall(OkHttpClient client, Request originalRequest) {
        this.client = client;
        this.originalRequest = originalRequest;
    }

    public Request request() {
        return this.originalRequest;
    }

    public Response execute() throws IOException {
        synchronized (this) {
            if (this.executed) {
                throw new IllegalStateException("Already Executed");
            }
            this.executed = true;
        }
        try {
            this.client.dispatcher().executed(this);
            Response result = getResponseWithInterceptorChain(false);
            if (result != null) {
                return result;
            }
            throw new IOException("Canceled");
        } finally {
            this.client.dispatcher().finished((Call) this);
        }
    }

    Object tag() {
        return this.originalRequest.tag();
    }

    public void enqueue(Callback responseCallback) {
        enqueue(responseCallback, false);
    }

    void enqueue(Callback responseCallback, boolean forWebSocket) {
        synchronized (this) {
            if (this.executed) {
                throw new IllegalStateException("Already Executed");
            }
            this.executed = true;
        }
        this.client.dispatcher().enqueue(new AsyncCall(responseCallback, forWebSocket));
    }

    public void cancel() {
        this.canceled = true;
        if (this.engine != null) {
            this.engine.cancel();
        }
    }

    public synchronized boolean isExecuted() {
        return this.executed;
    }

    public boolean isCanceled() {
        return this.canceled;
    }

    private String toLoggableString() {
        return (this.canceled ? "canceled call" : "call") + " to " + this.originalRequest.url().resolve("/...");
    }

    private Response getResponseWithInterceptorChain(boolean forWebSocket) throws IOException {
        return new ApplicationInterceptorChain(0, this.originalRequest, forWebSocket).proceed(this.originalRequest);
    }

    Response getResponse(Request request, boolean forWebSocket) throws IOException {
        HttpEngine retryEngine;
        RequestBody body = request.body();
        if (body != null) {
            Builder requestBuilder = request.newBuilder();
            MediaType contentType = body.contentType();
            if (contentType != null) {
                requestBuilder.header("Content-Type", contentType.toString());
            }
            long contentLength = body.contentLength();
            if (contentLength != -1) {
                requestBuilder.header("Content-Length", Long.toString(contentLength));
                requestBuilder.removeHeader("Transfer-Encoding");
            } else {
                requestBuilder.header("Transfer-Encoding", "chunked");
                requestBuilder.removeHeader("Content-Length");
            }
            request = requestBuilder.build();
        }
        this.engine = new HttpEngine(this.client, request, false, false, forWebSocket, null, null, null);
        int followUpCount = 0;
        while (!this.canceled) {
            try {
                this.engine.sendRequest();
                this.engine.readResponse();
                if (false) {
                    this.engine.close().release();
                }
                Response response = this.engine.getResponse();
                Request followUp = this.engine.followUpRequest();
                if (followUp == null) {
                    if (!forWebSocket) {
                        this.engine.releaseStreamAllocation();
                    }
                    return response;
                }
                StreamAllocation streamAllocation = this.engine.close();
                followUpCount++;
                if (followUpCount > 20) {
                    streamAllocation.release();
                    throw new ProtocolException("Too many follow-up requests: " + followUpCount);
                }
                if (!this.engine.sameConnection(followUp.url())) {
                    streamAllocation.release();
                    streamAllocation = null;
                }
                this.engine = new HttpEngine(this.client, followUp, false, false, forWebSocket, streamAllocation, null, response);
            } catch (RequestException e) {
                throw e.getCause();
            } catch (RouteException e2) {
                retryEngine = this.engine.recover(e2.getLastConnectException(), null);
                if (retryEngine != null) {
                    this.engine = retryEngine;
                    if (false) {
                        this.engine.close().release();
                    }
                } else {
                    throw e2.getLastConnectException();
                }
            } catch (IOException e3) {
                retryEngine = this.engine.recover(e3, null);
                if (retryEngine != null) {
                    this.engine = retryEngine;
                    if (false) {
                        this.engine.close().release();
                    }
                } else {
                    throw e3;
                }
            } catch (Throwable th) {
                if (true) {
                    this.engine.close().release();
                }
            }
        }
        this.engine.releaseStreamAllocation();
        throw new IOException("Canceled");
    }
}
