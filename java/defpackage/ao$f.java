package defpackage;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;

/* compiled from: VectorDrawableCompat */
class ao$f extends ConstantState {
    int a;
    ao$e b;
    ColorStateList c;
    Mode d;
    boolean e;
    Bitmap f;
    ColorStateList g;
    Mode h;
    int i;
    boolean j;
    boolean k;
    Paint l;

    public ao$f(ao$f copy) {
        this.c = null;
        this.d = ao.b;
        if (copy != null) {
            this.a = copy.a;
            this.b = new ao$e(copy.b);
            if (copy.b.m != null) {
                this.b.m = new Paint(copy.b.m);
            }
            if (copy.b.l != null) {
                this.b.l = new Paint(copy.b.l);
            }
            this.c = copy.c;
            this.d = copy.d;
            this.e = copy.e;
        }
    }

    public void a(Canvas canvas, ColorFilter filter, Rect originalBounds) {
        canvas.drawBitmap(this.f, null, originalBounds, a(filter));
    }

    public boolean a() {
        return this.b.a() < 255;
    }

    public Paint a(ColorFilter filter) {
        if (!a() && filter == null) {
            return null;
        }
        if (this.l == null) {
            this.l = new Paint();
            this.l.setFilterBitmap(true);
        }
        this.l.setAlpha(this.b.a());
        this.l.setColorFilter(filter);
        return this.l;
    }

    public void a(int width, int height) {
        this.f.eraseColor(0);
        this.b.a(new Canvas(this.f), width, height, null);
    }

    public void b(int width, int height) {
        if (this.f == null || !c(width, height)) {
            this.f = Bitmap.createBitmap(width, height, Config.ARGB_8888);
            this.k = true;
        }
    }

    public boolean c(int width, int height) {
        if (width == this.f.getWidth() && height == this.f.getHeight()) {
            return true;
        }
        return false;
    }

    public boolean b() {
        if (!this.k && this.g == this.c && this.h == this.d && this.j == this.e && this.i == this.b.a()) {
            return true;
        }
        return false;
    }

    public void c() {
        this.g = this.c;
        this.h = this.d;
        this.i = this.b.a();
        this.j = this.e;
        this.k = false;
    }

    public ao$f() {
        this.c = null;
        this.d = ao.b;
        this.b = new ao$e();
    }

    public Drawable newDrawable() {
        return new ao();
    }

    public Drawable newDrawable(Resources res) {
        return new ao();
    }

    public int getChangingConfigurations() {
        return this.a;
    }
}
