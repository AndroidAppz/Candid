/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.os.Build
 *  android.os.Build$VERSION
 *  android.view.View
 *  java.lang.Class
 *  java.lang.Object
 */
import android.os.Build;
import android.view.View;

public class gs {
    private static final c a = Build.VERSION.SDK_INT >= 16 ? new d() : (Build.VERSION.SDK_INT >= 15 ? new b() : (Build.VERSION.SDK_INT >= 14 ? new a() : new e()));
    private final Object b;

    public gs(Object object) {
        this.b = object;
    }

    public void a(int n2) {
        a.b(this.b, n2);
    }

    public void a(View view, int n2) {
        a.a(this.b, view, n2);
    }

    public void a(boolean bl2) {
        a.a(this.b, bl2);
    }

    public void b(int n2) {
        a.a(this.b, n2);
    }

    public void c(int n2) {
        a.e(this.b, n2);
    }

    public void d(int n2) {
        a.c(this.b, n2);
    }

    public void e(int n2) {
        a.d(this.b, n2);
    }

    /*
     * Enabled aggressive block sorting
     */
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null) {
            return false;
        }
        if (this.getClass() != object.getClass()) {
            return false;
        }
        gs gs2 = (gs)object;
        if (this.b == null) {
            if (gs2.b == null) return true;
            return false;
        }
        if (!this.b.equals(gs2.b)) return false;
        return true;
    }

    public void f(int n2) {
        a.f(this.b, n2);
    }

    public void g(int n2) {
        a.g(this.b, n2);
    }

    public int hashCode() {
        if (this.b == null) {
            return 0;
        }
        return this.b.hashCode();
    }

    static class a
    extends e {
        a() {
        }

        @Override
        public void a(Object object, int n2) {
            gt.a(object, n2);
        }

        @Override
        public void a(Object object, boolean bl2) {
            gt.a(object, bl2);
        }

        @Override
        public void b(Object object, int n2) {
            gt.b(object, n2);
        }

        @Override
        public void c(Object object, int n2) {
            gt.c(object, n2);
        }

        @Override
        public void d(Object object, int n2) {
            gt.d(object, n2);
        }

        @Override
        public void e(Object object, int n2) {
            gt.e(object, n2);
        }
    }

    static class b
    extends a {
        b() {
        }

        @Override
        public void f(Object object, int n2) {
            gu.a(object, n2);
        }

        @Override
        public void g(Object object, int n2) {
            gu.b(object, n2);
        }
    }

    static interface c {
        public void a(Object var1, int var2);

        public void a(Object var1, View var2, int var3);

        public void a(Object var1, boolean var2);

        public void b(Object var1, int var2);

        public void c(Object var1, int var2);

        public void d(Object var1, int var2);

        public void e(Object var1, int var2);

        public void f(Object var1, int var2);

        public void g(Object var1, int var2);
    }

    static class d
    extends b {
        d() {
        }

        @Override
        public void a(Object object, View view, int n2) {
            gv.a(object, view, n2);
        }
    }

    static class e
    implements c {
        e() {
        }

        @Override
        public void a(Object object, int n2) {
        }

        @Override
        public void a(Object object, View view, int n2) {
        }

        @Override
        public void a(Object object, boolean bl2) {
        }

        @Override
        public void b(Object object, int n2) {
        }

        @Override
        public void c(Object object, int n2) {
        }

        @Override
        public void d(Object object, int n2) {
        }

        @Override
        public void e(Object object, int n2) {
        }

        @Override
        public void f(Object object, int n2) {
        }

        @Override
        public void g(Object object, int n2) {
        }
    }

}

