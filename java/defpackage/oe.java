package defpackage;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;

/* compiled from: GifBitmapProvider */
class oe implements jv$a {
    private final lf a;

    public oe(lf bitmapPool) {
        this.a = bitmapPool;
    }

    public Bitmap a(int width, int height, Config config) {
        return this.a.b(width, height, config);
    }

    public void a(Bitmap bitmap) {
        if (!this.a.a(bitmap)) {
            bitmap.recycle();
        }
    }
}
