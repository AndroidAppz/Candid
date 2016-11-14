package defpackage;

import android.view.animation.Interpolator;

/* compiled from: ValueAnimatorCompat */
public class ab {
    private final ab$e a;

    ab(ab$e impl) {
        this.a = impl;
    }

    public void a() {
        this.a.a();
    }

    public boolean b() {
        return this.a.b();
    }

    public void a(Interpolator interpolator) {
        this.a.a(interpolator);
    }

    public void a(ab$c updateListener) {
        if (updateListener != null) {
            this.a.a(new ab$1(this, updateListener));
        } else {
            this.a.a(null);
        }
    }

    public void a(ab$a listener) {
        if (listener != null) {
            this.a.a(new ab$2(this, listener));
        } else {
            this.a.a(null);
        }
    }

    public void a(int from, int to) {
        this.a.a(from, to);
    }

    public int c() {
        return this.a.c();
    }

    public void a(float from, float to) {
        this.a.a(from, to);
    }

    public float d() {
        return this.a.d();
    }

    public void a(int duration) {
        this.a.a(duration);
    }

    public void e() {
        this.a.e();
    }

    public float f() {
        return this.a.f();
    }

    public long g() {
        return this.a.g();
    }
}
