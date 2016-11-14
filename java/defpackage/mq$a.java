package defpackage;

import android.content.Context;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import java.io.File;

/* compiled from: FileDescriptorFileLoader */
public class mq$a implements mk<File, ParcelFileDescriptor> {
    public mj<File, ParcelFileDescriptor> a(Context context, ma factories) {
        return new mq(factories.a(Uri.class, ParcelFileDescriptor.class));
    }

    public void a() {
    }
}
