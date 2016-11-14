package defpackage;

import android.graphics.Bitmap;

/* compiled from: GifBitmapWrapperTransformation */
public class ot implements kj<oo> {
    private final kj<Bitmap> a;
    private final kj<of> b;

    public ot(lf bitmapPool, kj<Bitmap> bitmapTransformation) {
        this((kj) bitmapTransformation, new oi(bitmapTransformation, bitmapPool));
    }

    ot(kj<Bitmap> bitmapTransformation, kj<of> gifDataTransformation) {
        this.a = bitmapTransformation;
        this.b = gifDataTransformation;
    }

    public lb<oo> a(lb<oo> resource, int outWidth, int outHeight) {
        lb<Bitmap> bitmapResource = ((oo) resource.b()).b();
        lb<of> gifResource = ((oo) resource.b()).c();
        if (bitmapResource != null && this.a != null) {
            lb<Bitmap> transformed = this.a.a(bitmapResource, outWidth, outHeight);
            if (bitmapResource.equals(transformed)) {
                return resource;
            }
            return new op(new oo(transformed, ((oo) resource.b()).c()));
        } else if (gifResource == null || this.b == null) {
            return resource;
        } else {
            lb<of> transformed2 = this.b.a(gifResource, outWidth, outHeight);
            if (gifResource.equals(transformed2)) {
                return resource;
            }
            return new op(new oo(((oo) resource.b()).b(), transformed2));
        }
    }

    public String a() {
        return this.a.a();
    }
}
