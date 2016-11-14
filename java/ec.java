/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.os.Build
 *  android.os.Build$VERSION
 *  android.view.LayoutInflater
 *  java.lang.Object
 */
import android.os.Build;
import android.view.LayoutInflater;

public final class ec {
    static final a a;

    static {
        int n2 = Build.VERSION.SDK_INT;
        a = n2 >= 21 ? new d() : (n2 >= 11 ? new c() : new b());
    }

    public static eg a(LayoutInflater layoutInflater) {
        return a.a(layoutInflater);
    }

    public static void a(LayoutInflater layoutInflater, eg eg2) {
        a.a(layoutInflater, eg2);
    }

    static interface a {
        public eg a(LayoutInflater var1);

        public void a(LayoutInflater var1, eg var2);
    }

    static class b
    implements a {
        b() {
        }

        @Override
        public eg a(LayoutInflater layoutInflater) {
            return ed.a(layoutInflater);
        }

        @Override
        public void a(LayoutInflater layoutInflater, eg eg2) {
            ed.a(layoutInflater, eg2);
        }
    }

    static class c
    extends b {
        c() {
        }

        @Override
        public void a(LayoutInflater layoutInflater, eg eg2) {
            ee.a(layoutInflater, eg2);
        }
    }

    static class d
    extends c {
        d() {
        }

        @Override
        public void a(LayoutInflater layoutInflater, eg eg2) {
            ef.a(layoutInflater, eg2);
        }
    }

}

