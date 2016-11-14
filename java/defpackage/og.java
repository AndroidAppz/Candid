package defpackage;

import android.content.Context;
import java.io.File;
import java.io.InputStream;

/* compiled from: GifDrawableLoadProvider */
public class og implements pq<InputStream, of> {
    private final om a;
    private final on b;
    private final mm c;
    private final oc<of> d = new oc(this.a);

    public og(Context context, lf bitmapPool) {
        this.a = new om(context, bitmapPool);
        this.b = new on(bitmapPool);
        this.c = new mm();
    }

    public kh<File, of> a() {
        return this.d;
    }

    public kh<InputStream, of> b() {
        return this.a;
    }

    public ke<InputStream> c() {
        return this.c;
    }

    public ki<of> d() {
        return this.b;
    }
}
