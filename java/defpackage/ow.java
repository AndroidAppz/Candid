package defpackage;

import android.content.res.Resources;
import android.graphics.Bitmap;

/* compiled from: GlideBitmapDrawableTranscoder */
public class ow implements ox<Bitmap, nq> {
    private final Resources a;
    private final lf b;

    public ow(Resources resources, lf bitmapPool) {
        this.a = resources;
        this.b = bitmapPool;
    }

    public lb<nq> a(lb<Bitmap> toTranscode) {
        return new nr(new nq(this.a, (Bitmap) toTranscode.b()), this.b);
    }

    public String a() {
        return "GlideBitmapDrawableTranscoder.com.bumptech.glide.load.resource.transcode";
    }
}
