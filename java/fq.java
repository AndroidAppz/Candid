/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.os.Build
 *  android.os.Build$VERSION
 *  android.view.ViewGroup
 *  java.lang.Object
 */
import android.os.Build;
import android.view.ViewGroup;

public final class fq {
    static final c a;

    static {
        int n2 = Build.VERSION.SDK_INT;
        a = n2 >= 21 ? new e() : (n2 >= 18 ? new d() : (n2 >= 14 ? new b() : (n2 >= 11 ? new a() : new f())));
    }

    public static void a(ViewGroup viewGroup, boolean bl2) {
        a.a(viewGroup, bl2);
    }

    static class a
    extends f {
        a() {
        }

        @Override
        public void a(ViewGroup viewGroup, boolean bl2) {
            fr.a(viewGroup, bl2);
        }
    }

    static class b
    extends a {
        b() {
        }
    }

    static interface c {
        public void a(ViewGroup var1, boolean var2);
    }

    static class d
    extends b {
        d() {
        }
    }

    static class e
    extends d {
        e() {
        }
    }

    static class f
    implements c {
        f() {
        }

        @Override
        public void a(ViewGroup viewGroup, boolean bl2) {
        }
    }

}

