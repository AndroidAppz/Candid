package defpackage;

import android.graphics.Bitmap;
import java.io.File;
import java.io.InputStream;

/* compiled from: ImageVideoGifDrawableLoadProvider */
public class ou implements pq<me, oo> {
    private final kh<File, oo> a;
    private final kh<me, oo> b;
    private final ki<oo> c;
    private final ke<me> d;

    public ou(pq<me, Bitmap> bitmapProvider, pq<InputStream, of> gifProvider, lf bitmapPool) {
        oq decoder = new oq(bitmapProvider.b(), gifProvider.b(), bitmapPool);
        this.a = new oc(new os(decoder));
        this.b = decoder;
        this.c = new or(bitmapProvider.d(), gifProvider.d());
        this.d = bitmapProvider.c();
    }

    public kh<File, oo> a() {
        return this.a;
    }

    public kh<me, oo> b() {
        return this.b;
    }

    public ke<me> c() {
        return this.d;
    }

    public ki<oo> d() {
        return this.c;
    }
}
