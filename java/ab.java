/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.view.animation.Interpolator
 *  java.lang.Object
 */
import android.view.animation.Interpolator;

public class ab {
    private final e a;

    ab(e e2) {
        this.a = e2;
    }

    public void a() {
        this.a.a();
    }

    public void a(float f2, float f3) {
        this.a.a(f2, f3);
    }

    public void a(int n2) {
        this.a.a(n2);
    }

    public void a(int n2, int n3) {
        this.a.a(n2, n3);
    }

    public void a(final a a2) {
        if (a2 != null) {
            this.a.a(new e.a(){

                @Override
                public void a() {
                    a2.b(ab.this);
                }

                @Override
                public void b() {
                    a2.a(ab.this);
                }

                @Override
                public void c() {
                    a2.c(ab.this);
                }
            });
            return;
        }
        this.a.a((e.a)null);
    }

    public void a(final c c2) {
        if (c2 != null) {
            this.a.a(new e.b(){

                @Override
                public void a() {
                    c2.a(ab.this);
                }
            });
            return;
        }
        this.a.a((e.b)null);
    }

    public void a(Interpolator interpolator) {
        this.a.a(interpolator);
    }

    public boolean b() {
        return this.a.b();
    }

    public int c() {
        return this.a.c();
    }

    public float d() {
        return this.a.d();
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

    public static interface a {
        public void a(ab var1);

        public void b(ab var1);

        public void c(ab var1);
    }

    public static class b
    implements a {
        @Override
        public void a(ab ab2) {
        }

        @Override
        public void b(ab ab2) {
        }

        @Override
        public void c(ab ab2) {
        }
    }

    public static interface c {
        public void a(ab var1);
    }

    static interface d {
        public ab a();
    }

    static abstract class e {
        e() {
        }

        abstract void a();

        abstract void a(float var1, float var2);

        abstract void a(int var1);

        abstract void a(int var1, int var2);

        abstract void a(a var1);

        abstract void a(b var1);

        abstract void a(Interpolator var1);

        abstract boolean b();

        abstract int c();

        abstract float d();

        abstract void e();

        abstract float f();

        abstract long g();

        static interface a {
            public void a();

            public void b();

            public void c();
        }

        static interface b {
            public void a();
        }

    }

}

