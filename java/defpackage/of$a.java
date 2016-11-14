package defpackage;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;

/* compiled from: GifDrawable */
class of$a extends ConstantState {
    jx a;
    byte[] b;
    Context c;
    kj<Bitmap> d;
    int e;
    int f;
    jv$a g;
    lf h;
    Bitmap i;

    public of$a(jx header, byte[] data, Context context, kj<Bitmap> frameTransformation, int targetWidth, int targetHeight, jv$a provider, lf bitmapPool, Bitmap firstFrame) {
        if (firstFrame == null) {
            throw new NullPointerException("The first frame of the GIF must not be null");
        }
        this.a = header;
        this.b = data;
        this.h = bitmapPool;
        this.i = firstFrame;
        this.c = context.getApplicationContext();
        this.d = frameTransformation;
        this.e = targetWidth;
        this.f = targetHeight;
        this.g = provider;
    }

    public Drawable newDrawable(Resources res) {
        return newDrawable();
    }

    public Drawable newDrawable() {
        return new of(this);
    }

    public int getChangingConfigurations() {
        return 0;
    }
}
