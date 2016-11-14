package defpackage;

import android.os.Looper;

/* compiled from: EngineResource */
class kz<Z> implements lb<Z> {
    private final lb<Z> a;
    private final boolean b;
    private kz$a c;
    private kf d;
    private int e;
    private boolean f;

    kz(lb<Z> toWrap, boolean isCacheable) {
        if (toWrap == null) {
            throw new NullPointerException("Wrapped resource must not be null");
        }
        this.a = toWrap;
        this.b = isCacheable;
    }

    void a(kf key, kz$a listener) {
        this.d = key;
        this.c = listener;
    }

    boolean a() {
        return this.b;
    }

    public Z b() {
        return this.a.b();
    }

    public int c() {
        return this.a.c();
    }

    public void d() {
        if (this.e > 0) {
            throw new IllegalStateException("Cannot recycle a resource while it is still acquired");
        } else if (this.f) {
            throw new IllegalStateException("Cannot recycle a resource that has already been recycled");
        } else {
            this.f = true;
            this.a.d();
        }
    }

    void e() {
        if (this.f) {
            throw new IllegalStateException("Cannot acquire a recycled resource");
        } else if (Looper.getMainLooper().equals(Looper.myLooper())) {
            this.e++;
        } else {
            throw new IllegalThreadStateException("Must call acquire on the main thread");
        }
    }

    void f() {
        if (this.e <= 0) {
            throw new IllegalStateException("Cannot release a recycled or not yet acquired resource");
        } else if (Looper.getMainLooper().equals(Looper.myLooper())) {
            int i = this.e - 1;
            this.e = i;
            if (i == 0) {
                this.c.b(this.d, this);
            }
        } else {
            throw new IllegalThreadStateException("Must call release on the main thread");
        }
    }
}
