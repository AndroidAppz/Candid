package defpackage;

import android.graphics.Bitmap;

/* compiled from: BitmapResource */
public class nj implements lb<Bitmap> {
    private final Bitmap a;
    private final lf b;

    public /* synthetic */ Object b() {
        return a();
    }

    public static nj a(Bitmap bitmap, lf bitmapPool) {
        if (bitmap == null) {
            return null;
        }
        return new nj(bitmap, bitmapPool);
    }

    public nj(Bitmap bitmap, lf bitmapPool) {
        if (bitmap == null) {
            throw new NullPointerException("Bitmap must not be null");
        } else if (bitmapPool == null) {
            throw new NullPointerException("BitmapPool must not be null");
        } else {
            this.a = bitmap;
            this.b = bitmapPool;
        }
    }

    public Bitmap a() {
        return this.a;
    }

    public int c() {
        return ra.a(this.a);
    }

    public void d() {
        if (!this.b.a(this.a)) {
            this.a.recycle();
        }
    }
}
