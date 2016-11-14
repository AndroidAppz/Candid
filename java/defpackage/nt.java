package defpackage;

import android.graphics.Bitmap;
import android.os.ParcelFileDescriptor;
import java.io.File;
import java.io.InputStream;

/* compiled from: ImageVideoDataLoadProvider */
public class nt implements pq<me, Bitmap> {
    private final ns a;
    private final kh<File, Bitmap> b;
    private final ki<Bitmap> c;
    private final mf d;

    public nt(pq<InputStream, Bitmap> streamBitmapProvider, pq<ParcelFileDescriptor, Bitmap> fileDescriptorBitmapProvider) {
        this.c = streamBitmapProvider.d();
        this.d = new mf(streamBitmapProvider.c(), fileDescriptorBitmapProvider.c());
        this.b = streamBitmapProvider.a();
        this.a = new ns(streamBitmapProvider.b(), fileDescriptorBitmapProvider.b());
    }

    public kh<File, Bitmap> a() {
        return this.b;
    }

    public kh<me, Bitmap> b() {
        return this.a;
    }

    public ke<me> c() {
        return this.d;
    }

    public ki<Bitmap> d() {
        return this.c;
    }
}
