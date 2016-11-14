package defpackage;

import java.io.InputStream;
import okhttp3.Call.Factory;

/* compiled from: OkHttpUrlLoader */
public class kd implements mj<mb, InputStream> {
    private final Factory a;

    public kd(Factory client) {
        this.a = client;
    }

    public km<InputStream> a(mb model, int width, int height) {
        return new kc(this.a, model);
    }
}
