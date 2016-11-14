package defpackage;

import android.graphics.Bitmap;

/* compiled from: GifBitmapWrapper */
public class oo {
    private final lb<of> a;
    private final lb<Bitmap> b;

    public oo(lb<Bitmap> bitmapResource, lb<of> gifResource) {
        if (bitmapResource != null && gifResource != null) {
            throw new IllegalArgumentException("Can only contain either a bitmap resource or a gif resource, not both");
        } else if (bitmapResource == null && gifResource == null) {
            throw new IllegalArgumentException("Must contain either a bitmap resource or a gif resource");
        } else {
            this.b = bitmapResource;
            this.a = gifResource;
        }
    }

    public int a() {
        if (this.b != null) {
            return this.b.c();
        }
        return this.a.c();
    }

    public lb<Bitmap> b() {
        return this.b;
    }

    public lb<of> c() {
        return this.a;
    }
}
