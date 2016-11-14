package defpackage;

import com.bumptech.glide.Priority;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map.Entry;
import okhttp3.Call;
import okhttp3.Call.Factory;
import okhttp3.Request.Builder;
import okhttp3.Response;
import okhttp3.ResponseBody;

/* compiled from: OkHttpStreamFetcher */
public class kc implements km<InputStream> {
    private final Factory a;
    private final mb b;
    private InputStream c;
    private ResponseBody d;
    private volatile Call e;

    public /* synthetic */ Object b(Priority x0) throws Exception {
        return a(x0);
    }

    public kc(Factory client, mb url) {
        this.a = client;
        this.b = url;
    }

    public InputStream a(Priority priority) throws Exception {
        Builder requestBuilder = new Builder().url(this.b.b());
        for (Entry<String, String> headerEntry : this.b.c().entrySet()) {
            requestBuilder.addHeader((String) headerEntry.getKey(), (String) headerEntry.getValue());
        }
        this.e = this.a.newCall(requestBuilder.build());
        Response response = this.e.execute();
        this.d = response.body();
        if (response.isSuccessful()) {
            this.c = qu.a(this.d.byteStream(), this.d.contentLength());
            return this.c;
        }
        throw new IOException("Request failed with code: " + response.code());
    }

    public void a() {
        try {
            if (this.c != null) {
                this.c.close();
            }
        } catch (IOException e) {
        }
        if (this.d != null) {
            this.d.close();
        }
    }

    public String b() {
        return this.b.d();
    }

    public void c() {
        Call local = this.e;
        if (local != null) {
            local.cancel();
        }
    }
}
