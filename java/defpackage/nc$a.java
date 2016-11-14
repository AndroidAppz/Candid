package defpackage;

import android.content.Context;
import java.io.InputStream;
import java.net.URL;

/* compiled from: StreamUrlLoader */
public class nc$a implements mk<URL, InputStream> {
    public mj<URL, InputStream> a(Context context, ma factories) {
        return new nc(factories.a(mb.class, InputStream.class));
    }

    public void a() {
    }
}
