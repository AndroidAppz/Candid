package defpackage;

import android.content.Context;
import android.net.Uri;
import java.io.InputStream;

/* compiled from: StreamUriLoader */
public class nb$a implements mk<Uri, InputStream> {
    public mj<Uri, InputStream> a(Context context, ma factories) {
        return new nb(context, factories.a(mb.class, InputStream.class));
    }

    public void a() {
    }
}
