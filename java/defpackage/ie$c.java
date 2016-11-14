package defpackage;

import java.io.IOException;
import okhttp3.Interceptor;
import okhttp3.Interceptor.Chain;
import okhttp3.Response;

/* compiled from: ApiService */
class ie$c implements Interceptor {
    final /* synthetic */ ie a;
    private final String b;

    public ie$c(ie ieVar, String userAgent) {
        this.a = ieVar;
        this.b = userAgent;
    }

    public Response intercept(Chain chain) throws IOException {
        return chain.proceed(chain.request().newBuilder().header("User-Agent", this.b).build());
    }
}
