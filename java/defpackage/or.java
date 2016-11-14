package defpackage;

import android.graphics.Bitmap;
import java.io.OutputStream;

/* compiled from: GifBitmapWrapperResourceEncoder */
public class or implements ki<oo> {
    private final ki<Bitmap> a;
    private final ki<of> b;
    private String c;

    public or(ki<Bitmap> bitmapEncoder, ki<of> gifEncoder) {
        this.a = bitmapEncoder;
        this.b = gifEncoder;
    }

    public boolean a(lb<oo> resource, OutputStream os) {
        oo gifBitmap = (oo) resource.b();
        lb<Bitmap> bitmapResource = gifBitmap.b();
        if (bitmapResource != null) {
            return this.a.a(bitmapResource, os);
        }
        return this.b.a(gifBitmap.c(), os);
    }

    public String a() {
        if (this.c == null) {
            this.c = this.a.a() + this.b.a();
        }
        return this.c;
    }
}
