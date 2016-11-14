package okhttp3.logging;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.UnsupportedCharsetException;
import java.util.concurrent.TimeUnit;
import okhttp3.Connection;
import okhttp3.Headers;
import okhttp3.Interceptor;
import okhttp3.Interceptor.Chain;
import okhttp3.MediaType;
import okhttp3.Protocol;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okhttp3.internal.Platform;
import okhttp3.internal.http.HttpEngine;
import okio.Buffer;
import okio.BufferedSource;

public final class HttpLoggingInterceptor implements Interceptor {
    private static final Charset UTF8 = Charset.forName("UTF-8");
    private volatile Level level;
    private final Logger logger;

    public enum Level {
        NONE,
        BASIC,
        HEADERS,
        BODY
    }

    public interface Logger {
        public static final Logger DEFAULT = new Logger() {
            public void log(String message) {
                Platform.get().log(message);
            }
        };

        void log(String str);
    }

    public HttpLoggingInterceptor() {
        this(Logger.DEFAULT);
    }

    public HttpLoggingInterceptor(Logger logger) {
        this.level = Level.NONE;
        this.logger = logger;
    }

    public HttpLoggingInterceptor setLevel(Level level) {
        if (level == null) {
            throw new NullPointerException("level == null. Use Level.NONE instead.");
        }
        this.level = level;
        return this;
    }

    public Level getLevel() {
        return this.level;
    }

    public Response intercept(Chain chain) throws IOException {
        Level level = this.level;
        Request request = chain.request();
        if (level == Level.NONE) {
            return chain.proceed(request);
        }
        Headers headers;
        int count;
        int i;
        Charset charset;
        MediaType contentType;
        boolean logBody = level == Level.BODY;
        boolean logHeaders = logBody || level == Level.HEADERS;
        RequestBody requestBody = request.body();
        boolean hasRequestBody = requestBody != null;
        Connection connection = chain.connection();
        String requestStartMessage = "--> " + request.method() + ' ' + request.url() + ' ' + (connection != null ? connection.protocol() : Protocol.HTTP_1_1);
        if (!logHeaders && hasRequestBody) {
            requestStartMessage = requestStartMessage + " (" + requestBody.contentLength() + "-byte body)";
        }
        this.logger.log(requestStartMessage);
        if (logHeaders) {
            if (hasRequestBody) {
                if (requestBody.contentType() != null) {
                    this.logger.log("Content-Type: " + requestBody.contentType());
                }
                if (requestBody.contentLength() != -1) {
                    this.logger.log("Content-Length: " + requestBody.contentLength());
                }
            }
            headers = request.headers();
            count = headers.size();
            for (i = 0; i < count; i++) {
                String name = headers.name(i);
                if (!("Content-Type".equalsIgnoreCase(name) || "Content-Length".equalsIgnoreCase(name))) {
                    this.logger.log(name + ": " + headers.value(i));
                }
            }
            if (!logBody || !hasRequestBody) {
                this.logger.log("--> END " + request.method());
            } else if (bodyEncoded(request.headers())) {
                this.logger.log("--> END " + request.method() + " (encoded body omitted)");
            } else {
                Buffer buffer = new Buffer();
                requestBody.writeTo(buffer);
                charset = UTF8;
                contentType = requestBody.contentType();
                if (contentType != null) {
                    charset = contentType.charset(UTF8);
                }
                this.logger.log("");
                this.logger.log(buffer.readString(charset));
                this.logger.log("--> END " + request.method() + " (" + requestBody.contentLength() + "-byte body)");
            }
        }
        long startNs = System.nanoTime();
        Response response = chain.proceed(request);
        long tookMs = TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - startNs);
        ResponseBody responseBody = response.body();
        long contentLength = responseBody.contentLength();
        this.logger.log("<-- " + response.code() + ' ' + response.message() + ' ' + response.request().url() + " (" + tookMs + "ms" + (!logHeaders ? ", " + (contentLength != -1 ? contentLength + "-byte" : "unknown-length") + " body" : "") + ')');
        if (!logHeaders) {
            return response;
        }
        headers = response.headers();
        count = headers.size();
        for (i = 0; i < count; i++) {
            this.logger.log(headers.name(i) + ": " + headers.value(i));
        }
        if (!logBody || !HttpEngine.hasBody(response)) {
            this.logger.log("<-- END HTTP");
            return response;
        } else if (bodyEncoded(response.headers())) {
            this.logger.log("<-- END HTTP (encoded body omitted)");
            return response;
        } else {
            BufferedSource source = responseBody.source();
            source.request(Long.MAX_VALUE);
            buffer = source.buffer();
            charset = UTF8;
            contentType = responseBody.contentType();
            if (contentType != null) {
                try {
                    charset = contentType.charset(UTF8);
                } catch (UnsupportedCharsetException e) {
                    this.logger.log("");
                    this.logger.log("Couldn't decode the response body; charset is likely malformed.");
                    this.logger.log("<-- END HTTP");
                    return response;
                }
            }
            if (contentLength != 0) {
                this.logger.log("");
                this.logger.log(buffer.clone().readString(charset));
            }
            this.logger.log("<-- END HTTP (" + buffer.size() + "-byte body)");
            return response;
        }
    }

    private boolean bodyEncoded(Headers headers) {
        String contentEncoding = headers.get("Content-Encoding");
        return (contentEncoding == null || contentEncoding.equalsIgnoreCase("identity")) ? false : true;
    }
}
