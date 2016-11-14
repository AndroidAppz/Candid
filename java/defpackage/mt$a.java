package defpackage;

import android.content.Context;
import android.net.Uri;
import android.os.ParcelFileDescriptor;

/* compiled from: FileDescriptorStringLoader */
public class mt$a implements mk<String, ParcelFileDescriptor> {
    public mj<String, ParcelFileDescriptor> a(Context context, ma factories) {
        return new mt(factories.a(Uri.class, ParcelFileDescriptor.class));
    }

    public void a() {
    }
}
