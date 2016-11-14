package defpackage;

import android.graphics.Bitmap;

/* compiled from: FitCenter */
public class np extends nk {
    public np(lf bitmapPool) {
        super(bitmapPool);
    }

    protected Bitmap a(lf pool, Bitmap toTransform, int outWidth, int outHeight) {
        return nw.a(toTransform, pool, outWidth, outHeight);
    }

    public String a() {
        return "FitCenter.com.bumptech.glide.load.resource.bitmap";
    }
}
