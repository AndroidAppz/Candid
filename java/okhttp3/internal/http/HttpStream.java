package okhttp3.internal.http;

import java.io.IOException;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.Response.Builder;
import okhttp3.ResponseBody;
import okio.Sink;

public interface HttpStream {
    public static final int DISCARD_STREAM_TIMEOUT_MILLIS = 100;

    void cancel();

    Sink createRequestBody(Request request, long j) throws IOException;

    void finishRequest() throws IOException;

    ResponseBody openResponseBody(Response response) throws IOException;

    Builder readResponseHeaders() throws IOException;

    void setHttpEngine(HttpEngine httpEngine);

    void writeRequestBody(RetryableSink retryableSink) throws IOException;

    void writeRequestHeaders(Request request) throws IOException;
}
