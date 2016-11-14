package okhttp3.internal;

import java.io.IOException;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.internal.http.CacheRequest;
import okhttp3.internal.http.CacheStrategy;

public interface InternalCache {
    Response get(Request request) throws IOException;

    CacheRequest put(Response response) throws IOException;

    void remove(Request request) throws IOException;

    void trackConditionalCacheHit();

    void trackResponse(CacheStrategy cacheStrategy);

    void update(Response response, Response response2) throws IOException;
}
