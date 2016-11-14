package defpackage;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable.ConstantState;
import android.os.Build.VERSION;
import android.view.Gravity;

/* compiled from: GifDrawable */
public class of extends nz implements oj$b {
    private final Paint a;
    private final Rect b;
    private final of$a c;
    private final jv d;
    private final oj e;
    private boolean f;
    private boolean g;
    private boolean h;
    private boolean i;
    private int j;
    private int k;
    private boolean l;

    public of(Context context, jv$a bitmapProvider, lf bitmapPool, kj<Bitmap> frameTransformation, int targetFrameWidth, int targetFrameHeight, jx gifHeader, byte[] data, Bitmap firstFrame) {
        this(new of$a(gifHeader, data, context, frameTransformation, targetFrameWidth, targetFrameHeight, bitmapProvider, bitmapPool, firstFrame));
    }

    public of(of other, Bitmap firstFrame, kj<Bitmap> frameTransformation) {
        this(new of$a(other.c.a, other.c.b, other.c.c, frameTransformation, other.c.e, other.c.f, other.c.g, other.c.h, firstFrame));
    }

    of(of$a state) {
        this.b = new Rect();
        this.i = true;
        this.k = -1;
        if (state == null) {
            throw new NullPointerException("GifState must not be null");
        }
        this.c = state;
        this.d = new jv(state.g);
        this.a = new Paint();
        this.d.a(state.a, state.b);
        this.e = new oj(state.c, this, this.d, state.e, state.f);
        this.e.a(state.d);
    }

    public Bitmap b() {
        return this.c.i;
    }

    public kj<Bitmap> c() {
        return this.c.d;
    }

    public byte[] d() {
        return this.c.b;
    }

    public int e() {
        return this.d.c();
    }

    private void g() {
        this.j = 0;
    }

    public void start() {
        this.g = true;
        g();
        if (this.i) {
            i();
        }
    }

    public void stop() {
        this.g = false;
        j();
        if (VERSION.SDK_INT < 11) {
            h();
        }
    }

    private void h() {
        this.e.c();
        invalidateSelf();
    }

    private void i() {
        if (this.d.c() == 1) {
            invalidateSelf();
        } else if (!this.f) {
            this.f = true;
            this.e.a();
            invalidateSelf();
        }
    }

    private void j() {
        this.f = false;
        this.e.b();
    }

    public boolean setVisible(boolean visible, boolean restart) {
        this.i = visible;
        if (!visible) {
            j();
        } else if (this.g) {
            i();
        }
        return super.setVisible(visible, restart);
    }

    public int getIntrinsicWidth() {
        return this.c.i.getWidth();
    }

    public int getIntrinsicHeight() {
        return this.c.i.getHeight();
    }

    public boolean isRunning() {
        return this.f;
    }

    protected void onBoundsChange(Rect bounds) {
        super.onBoundsChange(bounds);
        this.l = true;
    }

    public void draw(Canvas canvas) {
        if (!this.h) {
            if (this.l) {
                Gravity.apply(119, getIntrinsicWidth(), getIntrinsicHeight(), getBounds(), this.b);
                this.l = false;
            }
            Bitmap currentFrame = this.e.d();
            canvas.drawBitmap(currentFrame != null ? currentFrame : this.c.i, null, this.b, this.a);
        }
    }

    public void setAlpha(int i) {
        this.a.setAlpha(i);
    }

    public void setColorFilter(ColorFilter colorFilter) {
        this.a.setColorFilter(colorFilter);
    }

    public int getOpacity() {
        return -2;
    }

    @TargetApi(11)
    public void b(int frameIndex) {
        if (VERSION.SDK_INT < 11 || getCallback() != null) {
            invalidateSelf();
            if (frameIndex == this.d.c() - 1) {
                this.j++;
            }
            if (this.k != -1 && this.j >= this.k) {
                stop();
                return;
            }
            return;
        }
        stop();
        h();
    }

    public ConstantState getConstantState() {
        return this.c;
    }

    public void f() {
        this.h = true;
        this.c.h.a(this.c.i);
        this.e.c();
        this.e.b();
    }

    public boolean a() {
        return true;
    }

    public void a(int loopCount) {
        if (loopCount <= 0 && loopCount != -1 && loopCount != 0) {
            throw new IllegalArgumentException("Loop count must be greater than 0, or equal to GlideDrawable.LOOP_FOREVER, or equal to GlideDrawable.LOOP_INTRINSIC");
        } else if (loopCount == 0) {
            this.k = this.d.e();
        } else {
            this.k = loopCount;
        }
    }
}
