package defpackage;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;

/* compiled from: GlideBitmapDrawable */
class nq$a extends ConstantState {
    private static final Paint d = new Paint(6);
    final Bitmap a;
    int b;
    Paint c;

    public nq$a(Bitmap bitmap) {
        this.c = d;
        this.a = bitmap;
    }

    nq$a(nq$a other) {
        this(other.a);
        this.b = other.b;
    }

    void a(ColorFilter colorFilter) {
        a();
        this.c.setColorFilter(colorFilter);
    }

    void a(int alpha) {
        a();
        this.c.setAlpha(alpha);
    }

    void a() {
        if (d == this.c) {
            this.c = new Paint(6);
        }
    }

    public Drawable newDrawable() {
        return new nq(null, this);
    }

    public Drawable newDrawable(Resources res) {
        return new nq(res, this);
    }

    public int getChangingConfigurations() {
        return 0;
    }
}
