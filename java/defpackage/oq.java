package defpackage;

import android.graphics.Bitmap;
import com.bumptech.glide.load.resource.bitmap.ImageHeaderParser.ImageType;
import java.io.IOException;
import java.io.InputStream;

/* compiled from: GifBitmapWrapperResourceDecoder */
public class oq implements kh<me, oo> {
    private static final oq$b a = new oq$b();
    private static final oq$a b = new oq$a();
    private final kh<me, Bitmap> c;
    private final kh<InputStream, of> d;
    private final lf e;
    private final oq$b f;
    private final oq$a g;
    private String h;

    public oq(kh<me, Bitmap> bitmapDecoder, kh<InputStream, of> gifDecoder, lf bitmapPool) {
        this(bitmapDecoder, gifDecoder, bitmapPool, a, b);
    }

    oq(kh<me, Bitmap> bitmapDecoder, kh<InputStream, of> gifDecoder, lf bitmapPool, oq$b parser, oq$a streamFactory) {
        this.c = bitmapDecoder;
        this.d = gifDecoder;
        this.e = bitmapPool;
        this.f = parser;
        this.g = streamFactory;
    }

    public lb<oo> a(me source, int width, int height) throws IOException {
        qt pool = qt.a();
        byte[] tempBytes = pool.b();
        oo ooVar = null;
        try {
            ooVar = a(source, width, height, tempBytes);
            return ooVar != null ? new op(ooVar) : null;
        } finally {
            pool.a(tempBytes);
        }
    }

    private oo a(me source, int width, int height, byte[] bytes) throws IOException {
        if (source.a() != null) {
            return b(source, width, height, bytes);
        }
        return b(source, width, height);
    }

    private oo b(me source, int width, int height, byte[] bytes) throws IOException {
        InputStream bis = this.g.a(source.a(), bytes);
        bis.mark(2048);
        ImageType type = this.f.a(bis);
        bis.reset();
        oo result = null;
        if (type == ImageType.a) {
            result = a(bis, width, height);
        }
        if (result == null) {
            return b(new me(bis, source.b()), width, height);
        }
        return result;
    }

    private oo a(InputStream bis, int width, int height) throws IOException {
        lb<of> gifResource = this.d.a(bis, width, height);
        if (gifResource == null) {
            return null;
        }
        of drawable = (of) gifResource.b();
        if (drawable.e() > 1) {
            return new oo(null, gifResource);
        }
        return new oo(new nj(drawable.b(), this.e), null);
    }

    private oo b(me toDecode, int width, int height) throws IOException {
        lb<Bitmap> bitmapResource = this.c.a(toDecode, width, height);
        if (bitmapResource != null) {
            return new oo(bitmapResource, null);
        }
        return null;
    }

    public String a() {
        if (this.h == null) {
            this.h = this.d.a() + this.c.a();
        }
        return this.h;
    }
}
