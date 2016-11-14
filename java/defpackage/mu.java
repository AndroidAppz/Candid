package defpackage;

import android.content.Context;
import android.net.Uri;
import android.os.ParcelFileDescriptor;

/* compiled from: FileDescriptorUriLoader */
public class mu extends mo<ParcelFileDescriptor> implements mr<Uri> {
    public mu(Context context, mj<mb, ParcelFileDescriptor> urlLoader) {
        super(context, urlLoader);
    }

    protected km<ParcelFileDescriptor> a(Context context, Uri uri) {
        return new ko(context, uri);
    }

    protected km<ParcelFileDescriptor> a(Context context, String assetPath) {
        return new kn(context.getApplicationContext().getAssets(), assetPath);
    }
}
