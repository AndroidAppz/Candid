/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.os.Handler
 *  android.os.Looper
 *  android.os.SystemClock
 *  android.view.animation.AccelerateDecelerateInterpolator
 *  android.view.animation.Interpolator
 *  java.lang.Object
 *  java.lang.Runnable
 */
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Interpolator;

class ac
extends ab.e {
    private static final Handler a = new Handler(Looper.getMainLooper());
    private long b;
    private boolean c;
    private final int[] d = new int[2];
    private final float[] e = new float[2];
    private int f = 200;
    private Interpolator g;
    private ab.e.a h;
    private ab.e.b i;
    private float j;
    private final Runnable k;

    ac() {
        this.k = new Runnable(){

            public void run() {
                ac.this.h();
            }
        };
    }

    private void h() {
        if (this.c) {
            float f2 = (float)(SystemClock.uptimeMillis() - this.b) / (float)this.f;
            if (this.g != null) {
                f2 = this.g.getInterpolation(f2);
            }
            this.j = f2;
            if (this.i != null) {
                this.i.a();
            }
            if (SystemClock.uptimeMillis() >= this.b + (long)this.f) {
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

    @Override
    public void a() {
        if (this.c) {
            return;
        }
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

    @Override
    public void a(float f2, float f3) {
        this.e[0] = f2;
        this.e[1] = f3;
    }

    @Override
    public void a(int n2) {
        this.f = n2;
    }

    @Override
    public void a(int n2, int n3) {
        this.d[0] = n2;
        this.d[1] = n3;
    }

    @Override
    public void a(ab.e.a a2) {
        this.h = a2;
    }

    @Override
    public void a(ab.e.b b2) {
        this.i = b2;
    }

    @Override
    public void a(Interpolator interpolator) {
        this.g = interpolator;
    }

    @Override
    public boolean b() {
        return this.c;
    }

    @Override
    public int c() {
        return k.a(this.d[0], this.d[1], this.f());
    }

    @Override
    public float d() {
        return k.a(this.e[0], this.e[1], this.f());
    }

    @Override
    public void e() {
        this.c = false;
        a.removeCallbacks(this.k);
        if (this.h != null) {
            this.h.c();
        }
    }

    @Override
    public float f() {
        return this.j;
    }

    @Override
    public long g() {
        return this.f;
    }

}

