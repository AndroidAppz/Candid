package defpackage;

import android.graphics.Bitmap;

/* compiled from: GifBitmapWrapperDrawableTranscoder */
public class ov implements ox<oo, nz> {
    private final ox<Bitmap, nq> a;

    public ov(ox<Bitmap, nq> bitmapDrawableResourceTranscoder) {
        this.a = bitmapDrawableResourceTranscoder;
    }

    public lb<nz> a(lb<oo> toTranscode) {
        oo gifBitmap = (oo) toTranscode.b();
        lb<Bitmap> bitmapResource = gifBitmap.b();
        if (bitmapResource != null) {
            return this.a.a(bitmapResource);
        }
        return gifBitmap.c();
    }

    public String a() {
        return "GifBitmapWrapperDrawableTranscoder.com.bumptech.glide.load.resource.transcode";
    }
}
