package defpackage;

import android.graphics.Bitmap;

/* compiled from: GifFrameResourceDecoder */
class ol implements kh<jv, Bitmap> {
    private final lf a;

    public ol(lf bitmapPool) {
        this.a = bitmapPool;
    }

    public lb<Bitmap> a(jv source, int width, int height) {
        return nj.a(source.f(), this.a);
    }

    public String a() {
        return "GifFrameResourceDecoder.com.bumptech.glide.load.resource.gif";
    }
}
