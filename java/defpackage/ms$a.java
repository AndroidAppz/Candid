package defpackage;

import android.content.Context;
import android.net.Uri;
import android.os.ParcelFileDescriptor;

/* compiled from: FileDescriptorResourceLoader */
public class ms$a implements mk<Integer, ParcelFileDescriptor> {
    public mj<Integer, ParcelFileDescriptor> a(Context context, ma factories) {
        return new ms(context, factories.a(Uri.class, ParcelFileDescriptor.class));
    }

    public void a() {
    }
}
