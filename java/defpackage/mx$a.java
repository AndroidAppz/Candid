package defpackage;

import android.content.Context;
import android.net.Uri;
import java.io.File;
import java.io.InputStream;

/* compiled from: StreamFileLoader */
public class mx$a implements mk<File, InputStream> {
    public mj<File, InputStream> a(Context context, ma factories) {
        return new mx(factories.a(Uri.class, InputStream.class));
    }

    public void a() {
    }
}
