package defpackage;

import android.content.Context;
import java.io.InputStream;
import okhttp3.Call.Factory;
import okhttp3.OkHttpClient;

/* compiled from: OkHttpUrlLoader */
public class kd$a implements mk<mb, InputStream> {
    private static volatile Factory a;
    private Factory b;

    public kd$a() {
        this(kd$a.b());
    }

    public kd$a(Factory client) {
        this.b = client;
    }

    private static Factory b() {
        if (a == null) {
            synchronized (kd$a.class) {
                if (a == null) {
                    a = new OkHttpClient();
                }
            }
        }
        return a;
    }

    public mj<mb, InputStream> a(Context context, ma factories) {
        return new kd(this.b);
    }

    public void a() {
    }
}
