package defpackage;

import android.graphics.Bitmap;
import com.bumptech.glide.load.DecodeFormat;
import java.io.InputStream;

/* compiled from: StreamBitmapDecoder */
public class nv implements kh<InputStream, Bitmap> {
    private final nm a;
    private lf b;
    private DecodeFormat c;
    private String d;

    public nv(lf bitmapPool, DecodeFormat decodeFormat) {
        this(nm.a, bitmapPool, decodeFormat);
    }

    public nv(nm downsampler, lf bitmapPool, DecodeFormat decodeFormat) {
        this.a = downsampler;
        this.b = bitmapPool;
        this.c = decodeFormat;
    }

    public lb<Bitmap> a(InputStream source, int width, int height) {
        return nj.a(this.a.a(source, this.b, width, height, this.c), this.b);
    }

    public String a() {
        if (this.d == null) {
            this.d = "StreamBitmapDecoder.com.bumptech.glide.load.resource.bitmap" + this.a.a() + this.c.name();
        }
        return this.d;
    }
}
