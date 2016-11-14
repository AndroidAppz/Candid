package defpackage;

import android.content.ContentResolver;
import android.content.Context;
import android.net.Uri;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

/* compiled from: StreamLocalUriFetcher */
public class ks extends kq<InputStream> {
    protected /* synthetic */ Object b(Uri x0, ContentResolver x1) throws FileNotFoundException {
        return a(x0, x1);
    }

    public ks(Context context, Uri uri) {
        super(context, uri);
    }

    protected InputStream a(Uri uri, ContentResolver contentResolver) throws FileNotFoundException {
        return contentResolver.openInputStream(uri);
    }

    protected void a(InputStream data) throws IOException {
        data.close();
    }
}
