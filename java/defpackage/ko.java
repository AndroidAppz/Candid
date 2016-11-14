package defpackage;

import android.content.ContentResolver;
import android.content.Context;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import java.io.FileNotFoundException;
import java.io.IOException;

/* compiled from: FileDescriptorLocalUriFetcher */
public class ko extends kq<ParcelFileDescriptor> {
    protected /* synthetic */ Object b(Uri x0, ContentResolver x1) throws FileNotFoundException {
        return a(x0, x1);
    }

    public ko(Context context, Uri uri) {
        super(context, uri);
    }

    protected ParcelFileDescriptor a(Uri uri, ContentResolver contentResolver) throws FileNotFoundException {
        return contentResolver.openAssetFileDescriptor(uri, "r").getParcelFileDescriptor();
    }

    protected void a(ParcelFileDescriptor data) throws IOException {
        data.close();
    }
}
