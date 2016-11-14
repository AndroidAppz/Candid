/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.os.Build
 *  android.os.Build$VERSION
 *  android.view.ViewConfiguration
 *  java.lang.Object
 */
import android.os.Build;
import android.view.ViewConfiguration;

public final class fn {
    static final e a = Build.VERSION.SDK_INT >= 14 ? new d() : (Build.VERSION.SDK_INT >= 11 ? new c() : (Build.VERSION.SDK_INT >= 8 ? new b() : new a()));

    public static int a(ViewConfiguration viewConfiguration) {
        return a.a(viewConfiguration);
    }

    public static boolean b(ViewConfiguration viewConfiguration) {
        return a.b(viewConfiguration);
    }

    static class a
    implements e {
        a() {
        }

        @Override
        public int a(ViewConfiguration viewConfiguration) {
            return viewConfiguration.getScaledTouchSlop();
        }

        @Override
        public boolean b(ViewConfiguration viewConfiguration) {
            return true;
        }
    }

    static class b
    extends a {
        b() {
        }

        @Override
        public int a(ViewConfiguration viewConfiguration) {
            return fo.a(viewConfiguration);
        }
    }

    static class c
    extends b {
        c() {
        }

        @Override
        public boolean b(ViewConfiguration viewConfiguration) {
            return false;
        }
    }

    static class d
    extends c {
        d() {
        }

        @Override
        public boolean b(ViewConfiguration viewConfiguration) {
            return fp.a(viewConfiguration);
        }
    }

    static interface e {
        public int a(ViewConfiguration var1);

        public boolean b(ViewConfiguration var1);
    }

}

