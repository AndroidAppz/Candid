package defpackage;

import android.content.Context;
import android.net.Uri;
import java.io.InputStream;

/* compiled from: StreamUriLoader */
public class nb extends mo<InputStream> implements my<Uri> {
    public nb(Context context, mj<mb, InputStream> urlLoader) {
        super(context, urlLoader);
    }

    protected km<InputStream> a(Context context, Uri uri) {
        return new ks(context, uri);
    }

    protected km<InputStream> a(Context context, String assetPath) {
        return new kr(context.getApplicationContext().getAssets(), assetPath);
    }
}
