package defpackage;

import android.content.Context;
import android.net.Uri;
import android.os.ParcelFileDescriptor;

/* compiled from: FileDescriptorUriLoader */
public class mu$a implements mk<Uri, ParcelFileDescriptor> {
    public mj<Uri, ParcelFileDescriptor> a(Context context, ma factories) {
        return new mu(context, factories.a(mb.class, ParcelFileDescriptor.class));
    }

    public void a() {
    }
}
