package defpackage;

import android.content.Context;
import android.net.Uri;
import java.io.InputStream;

/* compiled from: StreamStringLoader */
public class na$a implements mk<String, InputStream> {
    public mj<String, InputStream> a(Context context, ma factories) {
        return new na(factories.a(Uri.class, InputStream.class));
    }

    public void a() {
    }
}
