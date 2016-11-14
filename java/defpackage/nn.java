package defpackage;

import android.graphics.Bitmap;
import android.os.ParcelFileDescriptor;
import com.bumptech.glide.load.DecodeFormat;
import java.io.File;

/* compiled from: FileDescriptorBitmapDataLoadProvider */
public class nn implements pq<ParcelFileDescriptor, Bitmap> {
    private final kh<File, Bitmap> a;
    private final no b;
    private final ni c = new ni();
    private final ke<ParcelFileDescriptor> d = nd.b();

    public nn(lf bitmapPool, DecodeFormat decodeFormat) {
        this.a = new oc(new nv(bitmapPool, decodeFormat));
        this.b = new no(bitmapPool, decodeFormat);
    }

    public kh<File, Bitmap> a() {
        return this.a;
    }

    public kh<ParcelFileDescriptor, Bitmap> b() {
        return this.b;
    }

    public ke<ParcelFileDescriptor> c() {
        return this.d;
    }

    public ki<Bitmap> d() {
        return this.c;
    }
}
