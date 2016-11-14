package defpackage;

import android.graphics.Bitmap;

/* compiled from: GifBitmapWrapperResource */
public class op implements lb<oo> {
    private final oo a;

    public /* synthetic */ Object b() {
        return a();
    }

    public op(oo data) {
        if (data == null) {
            throw new NullPointerException("Data must not be null");
        }
        this.a = data;
    }

    public oo a() {
        return this.a;
    }

    public int c() {
        return this.a.a();
    }

    public void d() {
        lb<Bitmap> bitmapResource = this.a.b();
        if (bitmapResource != null) {
            bitmapResource.d();
        }
        lb<of> gifDataResource = this.a.c();
        if (gifDataResource != null) {
            gifDataResource.d();
        }
    }
}
