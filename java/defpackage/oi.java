package defpackage;

import android.graphics.Bitmap;

/* compiled from: GifDrawableTransformation */
public class oi implements kj<of> {
    private final kj<Bitmap> a;
    private final lf b;

    public oi(kj<Bitmap> wrapped, lf bitmapPool) {
        this.a = wrapped;
        this.b = bitmapPool;
    }

    public lb<of> a(lb<of> lbVar, int outWidth, int outHeight) {
        of drawable = (of) lbVar.b();
        Bitmap firstFrame = ((of) lbVar.b()).b();
        Bitmap transformedFrame = (Bitmap) this.a.a(new nj(firstFrame, this.b), outWidth, outHeight).b();
        if (transformedFrame.equals(firstFrame)) {
            return lbVar;
        }
        return new oh(new of(drawable, transformedFrame, this.a));
    }

    public String a() {
        return this.a.a();
    }
}
