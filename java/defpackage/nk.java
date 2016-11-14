package defpackage;

import android.content.Context;
import android.graphics.Bitmap;

/* compiled from: BitmapTransformation */
public abstract class nk implements kj<Bitmap> {
    private lf a;

    protected abstract Bitmap a(lf lfVar, Bitmap bitmap, int i, int i2);

    public nk(Context context) {
        this(jp.a(context).a());
    }

    public nk(lf bitmapPool) {
        this.a = bitmapPool;
    }

    public final lb<Bitmap> a(lb<Bitmap> resource, int outWidth, int outHeight) {
        if (ra.a(outWidth, outHeight)) {
            int targetWidth;
            int targetHeight;
            Bitmap toTransform = (Bitmap) resource.b();
            if (outWidth == Integer.MIN_VALUE) {
                targetWidth = toTransform.getWidth();
            } else {
                targetWidth = outWidth;
            }
            if (outHeight == Integer.MIN_VALUE) {
                targetHeight = toTransform.getHeight();
            } else {
                targetHeight = outHeight;
            }
            Bitmap transformed = a(this.a, toTransform, targetWidth, targetHeight);
            if (toTransform.equals(transformed)) {
                return resource;
            }
            return nj.a(transformed, this.a);
        }
        throw new IllegalArgumentException("Cannot apply transformation on width: " + outWidth + " or height: " + outHeight + " less than or equal to zero and not Target.SIZE_ORIGINAL");
    }
}
