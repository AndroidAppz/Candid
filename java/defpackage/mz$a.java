package defpackage;

import android.content.Context;
import android.net.Uri;
import java.io.InputStream;

/* compiled from: StreamResourceLoader */
public class mz$a implements mk<Integer, InputStream> {
    public mj<Integer, InputStream> a(Context context, ma factories) {
        return new mz(context, factories.a(Uri.class, InputStream.class));
    }

    public void a() {
    }
}
