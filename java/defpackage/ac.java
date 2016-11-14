package defpackage;

import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Interpolator;

/* compiled from: ValueAnimatorCompatImplEclairMr1 */
class ac extends ab$e {
    private static final Handler a = new Handler(Looper.getMainLooper());
    private long b;
    private boolean c;
    private final int[] d = new int[2];
    private final float[] e = new float[2];
    private int f = 200;
    private Interpolator g;
    private ab$e$a h;
    private ab$e$b i;
    private float j;
    private final Runnable k = new ac$1(this);

    ac() {
    }

    public void a() {
        if (!this.c) {
            if (this.g == null) {
                this.g = new AccelerateDecelerateInterpolator();
            }
            this.b = SystemClock.uptimeMillis();
            this.c = true;
            if (this.h != null) {
                this.h.a();
            }
            a.postDelayed(this.k, 10);
        }
    }

    public boolean b() {
        return this.c;
    }

    public void a(Interpolator interpolator) {
        this.g = interpolator;
    }

    public void a(ab$e$a listener) {
        this.h = listener;
    }

    public void a(ab$e$b updateListener) {
        this.i = updateListener;
    }

    public void a(int from, int to) {
        this.d[0] = from;
        this.d[1] = to;
    }

    public int c() {
        return k.a(this.d[0], this.d[1], f());
    }

    public void a(float from, float to) {
        this.e[0] = from;
        this.e[1] = to;
    }

    public float d() {
        return k.a(this.e[0], this.e[1], f());
    }

    public void a(int duration) {
        this.f = duration;
    }

    public void e() {
        this.c = false;
        a.removeCallbacks(this.k);
        if (this.h != null) {
            this.h.c();
        }
    }

    public float f() {
        return this.j;
    }

    public long g() {
        return (long) this.f;
    }

    private void h() {
        if (this.c) {
            float linearFraction = ((float) (SystemClock.uptimeMillis() - this.b)) / ((float) this.f);
            if (this.g != null) {
                linearFraction = this.g.getInterpolation(linearFraction);
            }
            this.j = linearFraction;
            if (this.i != null) {
                this.i.a();
            }
            if (SystemClock.uptimeMillis() >= this.b + ((long) this.f)) {
                this.c = false;
                if (this.h != null) {
                    this.h.b();
                }
            }
        }
        if (this.c) {
            a.postDelayed(this.k, 10);
        }
    }
}
