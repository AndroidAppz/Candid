package defpackage;

import android.graphics.Bitmap;
import com.bumptech.glide.load.DecodeFormat;
import java.io.File;
import java.io.InputStream;

/* compiled from: StreamBitmapDataLoadProvider */
public class nu implements pq<InputStream, Bitmap> {
    private final nv a;
    private final ni b;
    private final mm c = new mm();
    private final oc<Bitmap> d;

    public nu(lf bitmapPool, DecodeFormat decodeFormat) {
        this.a = new nv(bitmapPool, decodeFormat);
        this.b = new ni();
        this.d = new oc(this.a);
    }

    public kh<File, Bitmap> a() {
        return this.d;
    }

    public kh<InputStream, Bitmap> b() {
        return this.a;
    }

    public ke<InputStream> c() {
        return this.c;
    }

    public ki<Bitmap> d() {
        return this.b;
    }
}
