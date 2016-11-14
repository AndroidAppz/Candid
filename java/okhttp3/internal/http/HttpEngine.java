package okhttp3.internal.http;

import java.io.IOException;
import java.net.ProtocolException;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSocketFactory;
import okhttp3.Address;
import okhttp3.CertificatePinner;
import okhttp3.Connection;
import okhttp3.Cookie;
import okhttp3.CookieJar;
import okhttp3.Headers;
import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.Interceptor.Chain;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Request.Builder;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okhttp3.internal.Internal;
import okhttp3.internal.InternalCache;
import okhttp3.internal.Util;
import okhttp3.internal.Version;
import okio.Buffer;
import okio.BufferedSink;
import okio.BufferedSource;
import okio.GzipSource;
import okio.Okio;
import okio.Sink;
import okio.Source;
import okio.Timeout;

public final class HttpEngine {
    private static final ResponseBody EMPTY_BODY = new ResponseBody() {
        public MediaType contentType() {
            return null;
        }

        public long contentLength() {
            return 0;
        }

        public BufferedSource source() {
            return new Buffer();
        }
    };
    public static final int MAX_FOLLOW_UPS = 20;
    public final boolean bufferRequestBody;
    private BufferedSink bufferedRequestBody;
    private Response cacheResponse;
    private CacheStrategy cacheStrategy;
    private final boolean callerWritesRequestBody;
    final OkHttpClient client;
    private final boolean forWebSocket;
    private HttpStream httpStream;
    private Request networkRequest;
    private final Response priorResponse;
    private Sink requestBodyOut;
    long sentRequestMillis = -1;
    private CacheRequest storeRequest;
    public final StreamAllocation streamAllocation;
    private boolean transparentGzip;
    private final Request userRequest;
    private Response userResponse;

    class NetworkInterceptorChain implements Chain {
        private int calls;
        private final int index;
        private final Request request;

        NetworkInterceptorChain(int index, Request request) {
            this.index = index;
            this.request = request;
        }

        public Connection connection() {
            return HttpEngine.this.streamAllocation.connection();
        }

        public Request request() {
            return this.request;
        }

        public Response proceed(Request request) throws IOException {
            this.calls++;
            if (this.index > 0) {
                Interceptor caller = (Interceptor) HttpEngine.this.client.networkInterceptors().get(this.index - 1);
                Address address = connection().route().address();
                if (!request.url().host().equals(address.url().host()) || request.url().port() != address.url().port()) {
                    throw new IllegalStateException("network interceptor " + caller + " must retain the same host and port");
                } else if (this.calls > 1) {
                    throw new IllegalStateException("network interceptor " + caller + " must call proceed() exactly once");
                }
            }
            if (this.index < HttpEngine.this.client.networkInterceptors().size()) {
                NetworkInterceptorChain chain = new NetworkInterceptorChain(this.index + 1, request);
                Interceptor interceptor = (Interceptor) HttpEngine.this.client.networkInterceptors().get(this.index);
                Response intercept = interceptor.intercept(chain);
                if (chain.calls != 1) {
                    throw new IllegalStateException("network interceptor " + interceptor + " must call proceed() exactly once");
                } else if (intercept != null) {
                    return intercept;
                } else {
                    throw new NullPointerException("network interceptor " + interceptor + " returned null");
                }
            }
            HttpEngine.this.httpStream.writeRequestHeaders(request);
            HttpEngine.this.networkRequest = request;
            if (HttpEngine.this.permitsRequestBody(request) && request.body() != null) {
                BufferedSink bufferedRequestBody = Okio.buffer(HttpEngine.this.httpStream.createRequestBody(request, request.body().contentLength()));
                request.body().writeTo(bufferedRequestBody);
                bufferedRequestBody.close();
            }
            Response response = HttpEngine.this.readNetworkResponse();
            int code = response.code();
            if ((code != 204 && code != 205) || response.body().contentLength() <= 0) {
                return response;
            }
            throw new ProtocolException("HTTP " + code + " had non-zero Content-Length: " + response.body().contentLength());
        }
    }

    public void sendRequest() throws okhttp3.internal.http.RequestException, okhttp3.internal.http.RouteException, java.io.IOException {
        /* JADX: method processing error */
/*
Error: java.util.NoSuchElementException
	at java.util.HashMap$HashIterator.nextEntry(HashMap.java:789)
	at java.util.HashMap$KeyIterator.next(HashMap.java:814)
	at jadx.core.dex.visitors.blocksmaker.BlockFinallyExtract.applyRemove(BlockFinallyExtract.java:535)
	at jadx.core.dex.visitors.blocksmaker.BlockFinallyExtract.extractFinally(BlockFinallyExtract.java:175)
	at jadx.core.dex.visitors.blocksmaker.BlockFinallyExtract.processExceptionHandler(BlockFinallyExtract.java:79)
	at jadx.core.dex.visitors.blocksmaker.BlockFinallyExtract.visit(BlockFinallyExtract.java:51)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:286)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:173)
*/
        /*
        r10 = this;
        r8 = r10.cacheStrategy;
        if (r8 == 0) goto L_0x0005;
    L_0x0004:
        return;
    L_0x0005:
        r8 = r10.httpStream;
        if (r8 == 0) goto L_0x000f;
    L_0x0009:
        r8 = new java.lang.IllegalStateException;
        r8.<init>();
        throw r8;
    L_0x000f:
        r8 = r10.userRequest;
        r1 = r10.networkRequest(r8);
        r8 = okhttp3.internal.Internal.instance;
        r9 = r10.client;
        r6 = r8.internalCache(r9);
        if (r6 == 0) goto L_0x008f;
    L_0x001f:
        r0 = r6.get(r1);
    L_0x0023:
        r4 = java.lang.System.currentTimeMillis();
        r8 = new okhttp3.internal.http.CacheStrategy$Factory;
        r8.<init>(r4, r1, r0);
        r8 = r8.get();
        r10.cacheStrategy = r8;
        r8 = r10.cacheStrategy;
        r8 = r8.networkRequest;
        r10.networkRequest = r8;
        r8 = r10.cacheStrategy;
        r8 = r8.cacheResponse;
        r10.cacheResponse = r8;
        if (r6 == 0) goto L_0x0045;
    L_0x0040:
        r8 = r10.cacheStrategy;
        r6.trackResponse(r8);
    L_0x0045:
        if (r0 == 0) goto L_0x0052;
    L_0x0047:
        r8 = r10.cacheResponse;
        if (r8 != 0) goto L_0x0052;
    L_0x004b:
        r8 = r0.body();
        okhttp3.internal.Util.closeQuietly(r8);
    L_0x0052:
        r8 = r10.networkRequest;
        if (r8 != 0) goto L_0x0091;
    L_0x0056:
        r8 = r10.cacheResponse;
        if (r8 != 0) goto L_0x0091;
    L_0x005a:
        r8 = new okhttp3.Response$Builder;
        r8.<init>();
        r9 = r10.userRequest;
        r8 = r8.request(r9);
        r9 = r10.priorResponse;
        r9 = stripBody(r9);
        r8 = r8.priorResponse(r9);
        r9 = okhttp3.Protocol.HTTP_1_1;
        r8 = r8.protocol(r9);
        r9 = 504; // 0x1f8 float:7.06E-43 double:2.49E-321;
        r8 = r8.code(r9);
        r9 = "Unsatisfiable Request (only-if-cached)";
        r8 = r8.message(r9);
        r9 = EMPTY_BODY;
        r8 = r8.body(r9);
        r8 = r8.build();
        r10.userResponse = r8;
        goto L_0x0004;
    L_0x008f:
        r0 = 0;
        goto L_0x0023;
    L_0x0091:
        r8 = r10.networkRequest;
        if (r8 != 0) goto L_0x00c5;
    L_0x0095:
        r8 = r10.cacheResponse;
        r8 = r8.newBuilder();
        r9 = r10.userRequest;
        r8 = r8.request(r9);
        r9 = r10.priorResponse;
        r9 = stripBody(r9);
        r8 = r8.priorResponse(r9);
        r9 = r10.cacheResponse;
        r9 = stripBody(r9);
        r8 = r8.cacheResponse(r9);
        r8 = r8.build();
        r10.userResponse = r8;
        r8 = r10.userResponse;
        r8 = r10.unzip(r8);
        r10.userResponse = r8;
        goto L_0x0004;
    L_0x00c5:
        r7 = 0;
        r8 = r10.connect();	 Catch:{ all -> 0x00ee }
        r10.httpStream = r8;	 Catch:{ all -> 0x00ee }
        r8 = r10.httpStream;	 Catch:{ all -> 0x00ee }
        r8.setHttpEngine(r10);	 Catch:{ all -> 0x00ee }
        r8 = r10.writeRequestHeadersEagerly();	 Catch:{ all -> 0x00ee }
        if (r8 == 0) goto L_0x0110;	 Catch:{ all -> 0x00ee }
    L_0x00d7:
        r2 = okhttp3.internal.http.OkHeaders.contentLength(r1);	 Catch:{ all -> 0x00ee }
        r8 = r10.bufferRequestBody;	 Catch:{ all -> 0x00ee }
        if (r8 == 0) goto L_0x0126;	 Catch:{ all -> 0x00ee }
    L_0x00df:
        r8 = 2147483647; // 0x7fffffff float:NaN double:1.060997895E-314;	 Catch:{ all -> 0x00ee }
        r8 = (r2 > r8 ? 1 : (r2 == r8 ? 0 : -1));	 Catch:{ all -> 0x00ee }
        if (r8 <= 0) goto L_0x00fb;	 Catch:{ all -> 0x00ee }
    L_0x00e6:
        r8 = new java.lang.IllegalStateException;	 Catch:{ all -> 0x00ee }
        r9 = "Use setFixedLengthStreamingMode() or setChunkedStreamingMode() for requests larger than 2 GiB.";	 Catch:{ all -> 0x00ee }
        r8.<init>(r9);	 Catch:{ all -> 0x00ee }
        throw r8;	 Catch:{ all -> 0x00ee }
    L_0x00ee:
        r8 = move-exception;
        if (r7 != 0) goto L_0x00fa;
    L_0x00f1:
        if (r0 == 0) goto L_0x00fa;
    L_0x00f3:
        r9 = r0.body();
        okhttp3.internal.Util.closeQuietly(r9);
    L_0x00fa:
        throw r8;
    L_0x00fb:
        r8 = -1;
        r8 = (r2 > r8 ? 1 : (r2 == r8 ? 0 : -1));
        if (r8 == 0) goto L_0x011e;
    L_0x0101:
        r8 = r10.httpStream;	 Catch:{ all -> 0x00ee }
        r9 = r10.networkRequest;	 Catch:{ all -> 0x00ee }
        r8.writeRequestHeaders(r9);	 Catch:{ all -> 0x00ee }
        r8 = new okhttp3.internal.http.RetryableSink;	 Catch:{ all -> 0x00ee }
        r9 = (int) r2;	 Catch:{ all -> 0x00ee }
        r8.<init>(r9);	 Catch:{ all -> 0x00ee }
        r10.requestBodyOut = r8;	 Catch:{ all -> 0x00ee }
    L_0x0110:
        r7 = 1;
        if (r7 != 0) goto L_0x0004;
    L_0x0113:
        if (r0 == 0) goto L_0x0004;
    L_0x0115:
        r8 = r0.body();
        okhttp3.internal.Util.closeQuietly(r8);
        goto L_0x0004;
    L_0x011e:
        r8 = new okhttp3.internal.http.RetryableSink;	 Catch:{ all -> 0x00ee }
        r8.<init>();	 Catch:{ all -> 0x00ee }
        r10.requestBodyOut = r8;	 Catch:{ all -> 0x00ee }
        goto L_0x0110;	 Catch:{ all -> 0x00ee }
    L_0x0126:
        r8 = r10.httpStream;	 Catch:{ all -> 0x00ee }
        r9 = r10.networkRequest;	 Catch:{ all -> 0x00ee }
        r8.writeRequestHeaders(r9);	 Catch:{ all -> 0x00ee }
        r8 = r10.httpStream;	 Catch:{ all -> 0x00ee }
        r9 = r10.networkRequest;	 Catch:{ all -> 0x00ee }
        r8 = r8.createRequestBody(r9, r2);	 Catch:{ all -> 0x00ee }
        r10.requestBodyOut = r8;	 Catch:{ all -> 0x00ee }
        goto L_0x0110;
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.http.HttpEngine.sendRequest():void");
    }

    public HttpEngine(OkHttpClient client, Request request, boolean bufferRequestBody, boolean callerWritesRequestBody, boolean forWebSocket, StreamAllocation streamAllocation, RetryableSink requestBodyOut, Response priorResponse) {
        this.client = client;
        this.userRequest = request;
        this.bufferRequestBody = bufferRequestBody;
        this.callerWritesRequestBody = callerWritesRequestBody;
        this.forWebSocket = forWebSocket;
        if (streamAllocation == null) {
            streamAllocation = new StreamAllocation(client.connectionPool(), createAddress(client, request));
        }
        this.streamAllocation = streamAllocation;
        this.requestBodyOut = requestBodyOut;
        this.priorResponse = priorResponse;
    }

    private boolean writeRequestHeadersEagerly() {
        return this.callerWritesRequestBody && permitsRequestBody(this.networkRequest) && this.requestBodyOut == null;
    }

    private HttpStream connect() throws RouteException, RequestException, IOException {
        return this.streamAllocation.newStream(this.client.connectTimeoutMillis(), this.client.readTimeoutMillis(), this.client.writeTimeoutMillis(), this.client.retryOnConnectionFailure(), !this.networkRequest.method().equals("GET"));
    }

    private static Response stripBody(Response response) {
        return (response == null || response.body() == null) ? response : response.newBuilder().body(null).build();
    }

    public void writingRequestHeaders() {
        if (this.sentRequestMillis != -1) {
            throw new IllegalStateException();
        }
        this.sentRequestMillis = System.currentTimeMillis();
    }

    boolean permitsRequestBody(Request request) {
        return HttpMethod.permitsRequestBody(request.method());
    }

    public Sink getRequestBody() {
        if (this.cacheStrategy != null) {
            return this.requestBodyOut;
        }
        throw new IllegalStateException();
    }

    public BufferedSink getBufferedRequestBody() {
        BufferedSink result = this.bufferedRequestBody;
        if (result != null) {
            return result;
        }
        BufferedSink buffer;
        Sink requestBody = getRequestBody();
        if (requestBody != null) {
            buffer = Okio.buffer(requestBody);
            this.bufferedRequestBody = buffer;
        } else {
            buffer = null;
        }
        return buffer;
    }

    public boolean hasResponse() {
        return this.userResponse != null;
    }

    public Request getRequest() {
        return this.userRequest;
    }

    public Response getResponse() {
        if (this.userResponse != null) {
            return this.userResponse;
        }
        throw new IllegalStateException();
    }

    public Connection getConnection() {
        return this.streamAllocation.connection();
    }

    public HttpEngine recover(IOException e, Sink requestBodyOut) {
        if (!this.streamAllocation.recover(e, requestBodyOut) || !this.client.retryOnConnectionFailure()) {
            return null;
        }
        return new HttpEngine(this.client, this.userRequest, this.bufferRequestBody, this.callerWritesRequestBody, this.forWebSocket, close(), (RetryableSink) requestBodyOut, this.priorResponse);
    }

    public HttpEngine recover(IOException e) {
        return recover(e, this.requestBodyOut);
    }

    private void maybeCache() throws IOException {
        InternalCache responseCache = Internal.instance.internalCache(this.client);
        if (responseCache != null) {
            if (CacheStrategy.isCacheable(this.userResponse, this.networkRequest)) {
                this.storeRequest = responseCache.put(stripBody(this.userResponse));
            } else if (HttpMethod.invalidatesCache(this.networkRequest.method())) {
                try {
                    responseCache.remove(this.networkRequest);
                } catch (IOException e) {
                }
            }
        }
    }

    public void releaseStreamAllocation() throws IOException {
        this.streamAllocation.release();
    }

    public void cancel() {
        this.streamAllocation.cancel();
    }

    public StreamAllocation close() {
        if (this.bufferedRequestBody != null) {
            Util.closeQuietly(this.bufferedRequestBody);
        } else if (this.requestBodyOut != null) {
            Util.closeQuietly(this.requestBodyOut);
        }
        if (this.userResponse != null) {
            Util.closeQuietly(this.userResponse.body());
        } else {
            this.streamAllocation.connectionFailed(null);
        }
        return this.streamAllocation;
    }

    private Response unzip(Response response) throws IOException {
        if (!this.transparentGzip || !"gzip".equalsIgnoreCase(this.userResponse.header("Content-Encoding")) || response.body() == null) {
            return response;
        }
        Source responseBody = new GzipSource(response.body().source());
        Headers strippedHeaders = response.headers().newBuilder().removeAll("Content-Encoding").removeAll("Content-Length").build();
        return response.newBuilder().headers(strippedHeaders).body(new RealResponseBody(strippedHeaders, Okio.buffer(responseBody))).build();
    }

    public static boolean hasBody(Response response) {
        if (response.request().method().equals("HEAD")) {
            return false;
        }
        int responseCode = response.code();
        if ((responseCode < 100 || responseCode >= 200) && responseCode != 204 && responseCode != 304) {
            return true;
        }
        if (OkHeaders.contentLength(response) != -1 || "chunked".equalsIgnoreCase(response.header("Transfer-Encoding"))) {
            return true;
        }
        return false;
    }

    private Request networkRequest(Request request) throws IOException {
        Builder result = request.newBuilder();
        if (request.header("Host") == null) {
            result.header("Host", Util.hostHeader(request.url(), false));
        }
        if (request.header("Connection") == null) {
            result.header("Connection", "Keep-Alive");
        }
        if (request.header("Accept-Encoding") == null) {
            this.transparentGzip = true;
            result.header("Accept-Encoding", "gzip");
        }
        List<Cookie> cookies = this.client.cookieJar().loadForRequest(request.url());
        if (!cookies.isEmpty()) {
            result.header("Cookie", cookieHeader(cookies));
        }
        if (request.header("User-Agent") == null) {
            result.header("User-Agent", Version.userAgent());
        }
        return result.build();
    }

    private String cookieHeader(List<Cookie> cookies) {
        StringBuilder cookieHeader = new StringBuilder();
        int size = cookies.size();
        for (int i = 0; i < size; i++) {
            if (i > 0) {
                cookieHeader.append("; ");
            }
            Cookie cookie = (Cookie) cookies.get(i);
            cookieHeader.append(cookie.name()).append('=').append(cookie.value());
        }
        return cookieHeader.toString();
    }

    public void readResponse() throws IOException {
        if (this.userResponse == null) {
            if (this.networkRequest == null && this.cacheResponse == null) {
                throw new IllegalStateException("call sendRequest() first!");
            } else if (this.networkRequest != null) {
                Response networkResponse;
                if (this.forWebSocket) {
                    this.httpStream.writeRequestHeaders(this.networkRequest);
                    networkResponse = readNetworkResponse();
                } else if (this.callerWritesRequestBody) {
                    if (this.bufferedRequestBody != null && this.bufferedRequestBody.buffer().size() > 0) {
                        this.bufferedRequestBody.emit();
                    }
                    if (this.sentRequestMillis == -1) {
                        if (OkHeaders.contentLength(this.networkRequest) == -1 && (this.requestBodyOut instanceof RetryableSink)) {
                            this.networkRequest = this.networkRequest.newBuilder().header("Content-Length", Long.toString(((RetryableSink) this.requestBodyOut).contentLength())).build();
                        }
                        this.httpStream.writeRequestHeaders(this.networkRequest);
                    }
                    if (this.requestBodyOut != null) {
                        if (this.bufferedRequestBody != null) {
                            this.bufferedRequestBody.close();
                        } else {
                            this.requestBodyOut.close();
                        }
                        if (this.requestBodyOut instanceof RetryableSink) {
                            this.httpStream.writeRequestBody((RetryableSink) this.requestBodyOut);
                        }
                    }
                    networkResponse = readNetworkResponse();
                } else {
                    networkResponse = new NetworkInterceptorChain(0, this.networkRequest).proceed(this.networkRequest);
                }
                receiveHeaders(networkResponse.headers());
                if (this.cacheResponse != null) {
                    if (validate(this.cacheResponse, networkResponse)) {
                        this.userResponse = this.cacheResponse.newBuilder().request(this.userRequest).priorResponse(stripBody(this.priorResponse)).headers(combine(this.cacheResponse.headers(), networkResponse.headers())).cacheResponse(stripBody(this.cacheResponse)).networkResponse(stripBody(networkResponse)).build();
                        networkResponse.body().close();
                        releaseStreamAllocation();
                        InternalCache responseCache = Internal.instance.internalCache(this.client);
                        responseCache.trackConditionalCacheHit();
                        responseCache.update(this.cacheResponse, stripBody(this.userResponse));
                        this.userResponse = unzip(this.userResponse);
                        return;
                    }
                    Util.closeQuietly(this.cacheResponse.body());
                }
                this.userResponse = networkResponse.newBuilder().request(this.userRequest).priorResponse(stripBody(this.priorResponse)).cacheResponse(stripBody(this.cacheResponse)).networkResponse(stripBody(networkResponse)).build();
                if (hasBody(this.userResponse)) {
                    maybeCache();
                    this.userResponse = unzip(cacheWritingResponse(this.storeRequest, this.userResponse));
                }
            }
        }
    }

    private Response readNetworkResponse() throws IOException {
        this.httpStream.finishRequest();
        Response networkResponse = this.httpStream.readResponseHeaders().request(this.networkRequest).handshake(this.streamAllocation.connection().handshake()).header(OkHeaders.SENT_MILLIS, Long.toString(this.sentRequestMillis)).header(OkHeaders.RECEIVED_MILLIS, Long.toString(System.currentTimeMillis())).build();
        if (!this.forWebSocket) {
            networkResponse = networkResponse.newBuilder().body(this.httpStream.openResponseBody(networkResponse)).build();
        }
        if ("close".equalsIgnoreCase(networkResponse.request().header("Connection")) || "close".equalsIgnoreCase(networkResponse.header("Connection"))) {
            this.streamAllocation.noNewStreams();
        }
        return networkResponse;
    }

    private Response cacheWritingResponse(final CacheRequest cacheRequest, Response response) throws IOException {
        if (cacheRequest == null) {
            return response;
        }
        Sink cacheBodyUnbuffered = cacheRequest.body();
        if (cacheBodyUnbuffered == null) {
            return response;
        }
        final BufferedSource source = response.body().source();
        final BufferedSink cacheBody = Okio.buffer(cacheBodyUnbuffered);
        return response.newBuilder().body(new RealResponseBody(response.headers(), Okio.buffer(new Source() {
            boolean cacheRequestClosed;

            public long read(Buffer sink, long byteCount) throws IOException {
                try {
                    long bytesRead = source.read(sink, byteCount);
                    if (bytesRead == -1) {
                        if (!this.cacheRequestClosed) {
                            this.cacheRequestClosed = true;
                            cacheBody.close();
                        }
                        return -1;
                    }
                    sink.copyTo(cacheBody.buffer(), sink.size() - bytesRead, bytesRead);
                    cacheBody.emitCompleteSegments();
                    return bytesRead;
                } catch (IOException e) {
                    if (!this.cacheRequestClosed) {
                        this.cacheRequestClosed = true;
                        cacheRequest.abort();
                    }
                    throw e;
                }
            }

            public Timeout timeout() {
                return source.timeout();
            }

            public void close() throws IOException {
                if (!(this.cacheRequestClosed || Util.discard(this, 100, TimeUnit.MILLISECONDS))) {
                    this.cacheRequestClosed = true;
                    cacheRequest.abort();
                }
                source.close();
            }
        }))).build();
    }

    private static boolean validate(Response cached, Response network) {
        if (network.code() == 304) {
            return true;
        }
        Date lastModified = cached.headers().getDate("Last-Modified");
        if (lastModified != null) {
            Date networkLastModified = network.headers().getDate("Last-Modified");
            if (networkLastModified != null && networkLastModified.getTime() < lastModified.getTime()) {
                return true;
            }
        }
        return false;
    }

    private static Headers combine(Headers cachedHeaders, Headers networkHeaders) throws IOException {
        int i;
        Headers.Builder result = new Headers.Builder();
        int size = cachedHeaders.size();
        for (i = 0; i < size; i++) {
            String fieldName = cachedHeaders.name(i);
            String value = cachedHeaders.value(i);
            if (!("Warning".equalsIgnoreCase(fieldName) && value.startsWith("1")) && (!OkHeaders.isEndToEnd(fieldName) || networkHeaders.get(fieldName) == null)) {
                result.add(fieldName, value);
            }
        }
        size = networkHeaders.size();
        for (i = 0; i < size; i++) {
            fieldName = networkHeaders.name(i);
            if (!"Content-Length".equalsIgnoreCase(fieldName) && OkHeaders.isEndToEnd(fieldName)) {
                result.add(fieldName, networkHeaders.value(i));
            }
        }
        return result.build();
    }

    public void receiveHeaders(Headers headers) throws IOException {
        if (this.client.cookieJar() != CookieJar.NO_COOKIES) {
            List<Cookie> cookies = Cookie.parseAll(this.userRequest.url(), headers);
            if (!cookies.isEmpty()) {
                this.client.cookieJar().saveFromResponse(this.userRequest.url(), cookies);
            }
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public okhttp3.Request followUpRequest() throws java.io.IOException {
        /*
        r13 = this;
        r10 = 0;
        r11 = r13.userResponse;
        if (r11 != 0) goto L_0x000b;
    L_0x0005:
        r10 = new java.lang.IllegalStateException;
        r10.<init>();
        throw r10;
    L_0x000b:
        r11 = r13.streamAllocation;
        r0 = r11.connection();
        if (r0 == 0) goto L_0x0027;
    L_0x0013:
        r6 = r0.route();
    L_0x0017:
        r11 = r13.userResponse;
        r4 = r11.code();
        r11 = r13.userRequest;
        r2 = r11.method();
        switch(r4) {
            case 300: goto L_0x0063;
            case 301: goto L_0x0063;
            case 302: goto L_0x0063;
            case 303: goto L_0x0063;
            case 307: goto L_0x0053;
            case 308: goto L_0x0053;
            case 401: goto L_0x0046;
            case 407: goto L_0x0029;
            case 408: goto L_0x00dc;
            default: goto L_0x0026;
        };
    L_0x0026:
        return r10;
    L_0x0027:
        r6 = r10;
        goto L_0x0017;
    L_0x0029:
        if (r6 == 0) goto L_0x003f;
    L_0x002b:
        r8 = r6.proxy();
    L_0x002f:
        r10 = r8.type();
        r11 = java.net.Proxy.Type.HTTP;
        if (r10 == r11) goto L_0x0046;
    L_0x0037:
        r10 = new java.net.ProtocolException;
        r11 = "Received HTTP_PROXY_AUTH (407) code while not using proxy";
        r10.<init>(r11);
        throw r10;
    L_0x003f:
        r10 = r13.client;
        r8 = r10.proxy();
        goto L_0x002f;
    L_0x0046:
        r10 = r13.client;
        r10 = r10.authenticator();
        r11 = r13.userResponse;
        r10 = r10.authenticate(r6, r11);
        goto L_0x0026;
    L_0x0053:
        r11 = "GET";
        r11 = r2.equals(r11);
        if (r11 != 0) goto L_0x0063;
    L_0x005b:
        r11 = "HEAD";
        r11 = r2.equals(r11);
        if (r11 == 0) goto L_0x0026;
    L_0x0063:
        r11 = r13.client;
        r11 = r11.followRedirects();
        if (r11 == 0) goto L_0x0026;
    L_0x006b:
        r11 = r13.userResponse;
        r12 = "Location";
        r1 = r11.header(r12);
        if (r1 == 0) goto L_0x0026;
    L_0x0075:
        r11 = r13.userRequest;
        r11 = r11.url();
        r9 = r11.resolve(r1);
        if (r9 == 0) goto L_0x0026;
    L_0x0081:
        r11 = r9.scheme();
        r12 = r13.userRequest;
        r12 = r12.url();
        r12 = r12.scheme();
        r7 = r11.equals(r12);
        if (r7 != 0) goto L_0x009d;
    L_0x0095:
        r11 = r13.client;
        r11 = r11.followSslRedirects();
        if (r11 == 0) goto L_0x0026;
    L_0x009d:
        r11 = r13.userRequest;
        r3 = r11.newBuilder();
        r11 = okhttp3.internal.http.HttpMethod.permitsRequestBody(r2);
        if (r11 == 0) goto L_0x00c3;
    L_0x00a9:
        r11 = okhttp3.internal.http.HttpMethod.redirectsToGet(r2);
        if (r11 == 0) goto L_0x00d8;
    L_0x00af:
        r11 = "GET";
        r3.method(r11, r10);
    L_0x00b4:
        r10 = "Transfer-Encoding";
        r3.removeHeader(r10);
        r10 = "Content-Length";
        r3.removeHeader(r10);
        r10 = "Content-Type";
        r3.removeHeader(r10);
    L_0x00c3:
        r10 = r13.sameConnection(r9);
        if (r10 != 0) goto L_0x00ce;
    L_0x00c9:
        r10 = "Authorization";
        r3.removeHeader(r10);
    L_0x00ce:
        r10 = r3.url(r9);
        r10 = r10.build();
        goto L_0x0026;
    L_0x00d8:
        r3.method(r2, r10);
        goto L_0x00b4;
    L_0x00dc:
        r11 = r13.requestBodyOut;
        if (r11 == 0) goto L_0x00e6;
    L_0x00e0:
        r11 = r13.requestBodyOut;
        r11 = r11 instanceof okhttp3.internal.http.RetryableSink;
        if (r11 == 0) goto L_0x00f1;
    L_0x00e6:
        r5 = 1;
    L_0x00e7:
        r11 = r13.callerWritesRequestBody;
        if (r11 == 0) goto L_0x00ed;
    L_0x00eb:
        if (r5 == 0) goto L_0x0026;
    L_0x00ed:
        r10 = r13.userRequest;
        goto L_0x0026;
    L_0x00f1:
        r5 = 0;
        goto L_0x00e7;
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.http.HttpEngine.followUpRequest():okhttp3.Request");
    }

    public boolean sameConnection(HttpUrl followUp) {
        HttpUrl url = this.userRequest.url();
        return url.host().equals(followUp.host()) && url.port() == followUp.port() && url.scheme().equals(followUp.scheme());
    }

    private static Address createAddress(OkHttpClient client, Request request) {
        SSLSocketFactory sslSocketFactory = null;
        HostnameVerifier hostnameVerifier = null;
        CertificatePinner certificatePinner = null;
        if (request.isHttps()) {
            sslSocketFactory = client.sslSocketFactory();
            hostnameVerifier = client.hostnameVerifier();
            certificatePinner = client.certificatePinner();
        }
        return new Address(request.url().host(), request.url().port(), client.dns(), client.socketFactory(), sslSocketFactory, hostnameVerifier, certificatePinner, client.proxyAuthenticator(), client.proxy(), client.protocols(), client.connectionSpecs(), client.proxySelector());
    }
}
