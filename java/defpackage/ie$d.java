package defpackage;

import java.io.IOException;
import okhttp3.Interceptor;
import okhttp3.Interceptor.Chain;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okio.Buffer;
import okio.BufferedSink;

/* compiled from: ApiService */
class ie$d implements Interceptor {
    final /* synthetic */ ie a;
    private it b = new it();

    public ie$d(ie ieVar) {
        this.a = ieVar;
    }

    public Response intercept(Chain chain) throws IOException {
        Request origRequest = chain.request();
        BufferedSink encodedSink = new Buffer();
        origRequest.body().writeTo(encodedSink);
        byte[] encBuf = this.b.a(encodedSink.buffer().readUtf8());
        encodedSink.close();
        Response response = chain.proceed(origRequest.newBuilder().header("Candid-Encoded", "1").method(origRequest.method(), RequestBody.create(origRequest.body().contentType(), encBuf)).build());
        return response.newBuilder().body(ResponseBody.create(response.body().contentType(), this.b.b(response.body().string()))).build();
    }
}
