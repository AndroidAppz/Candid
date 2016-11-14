/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.os.Build
 *  android.os.Build$VERSION
 *  android.view.ViewGroup
 *  android.view.ViewGroup$MarginLayoutParams
 *  java.lang.Object
 */
import android.os.Build;
import android.view.ViewGroup;

public final class eh {
    static final a a = Build.VERSION.SDK_INT >= 17 ? new c() : new b();

    public static int a(ViewGroup.MarginLayoutParams marginLayoutParams) {
        return a.a(marginLayoutParams);
    }

    public static void a(ViewGroup.MarginLayoutParams marginLayoutParams, int n2) {
        a.a(marginLayoutParams, n2);
    }

    public static int b(ViewGroup.MarginLayoutParams marginLayoutParams) {
        return a.b(marginLayoutParams);
    }

    public static void b(ViewGroup.MarginLayoutParams marginLayoutParams, int n2) {
        a.b(marginLayoutParams, n2);
    }

    public static void c(ViewGroup.MarginLayoutParams marginLayoutParams, int n2) {
        a.c(marginLayoutParams, n2);
    }

    static interface a {
        public int a(ViewGroup.MarginLayoutParams var1);

        public void a(ViewGroup.MarginLayoutParams var1, int var2);

        public int b(ViewGroup.MarginLayoutParams var1);

        public void b(ViewGroup.MarginLayoutParams var1, int var2);

        public void c(ViewGroup.MarginLayoutParams var1, int var2);
    }

    static class b
    implements a {
        b() {
        }

        @Override
        public int a(ViewGroup.MarginLayoutParams marginLayoutParams) {
            return marginLayoutParams.leftMargin;
        }

        @Override
        public void a(ViewGroup.MarginLayoutParams marginLayoutParams, int n2) {
            marginLayoutParams.leftMargin = n2;
        }

        @Override
        public int b(ViewGroup.MarginLayoutParams marginLayoutParams) {
            return marginLayoutParams.rightMargin;
        }

        @Override
        public void b(ViewGroup.MarginLayoutParams marginLayoutParams, int n2) {
            marginLayoutParams.rightMargin = n2;
        }

        @Override
        public void c(ViewGroup.MarginLayoutParams marginLayoutParams, int n2) {
        }
    }

    static class c
    implements a {
        c() {
        }

        @Override
        public int a(ViewGroup.MarginLayoutParams marginLayoutParams) {
            return ei.a(marginLayoutParams);
        }

        @Override
        public void a(ViewGroup.MarginLayoutParams marginLayoutParams, int n2) {
            ei.a(marginLayoutParams, n2);
        }

        @Override
        public int b(ViewGroup.MarginLayoutParams marginLayoutParams) {
            return ei.b(marginLayoutParams);
        }

        @Override
        public void b(ViewGroup.MarginLayoutParams marginLayoutParams, int n2) {
            ei.b(marginLayoutParams, n2);
        }

        @Override
        public void c(ViewGroup.MarginLayoutParams marginLayoutParams, int n2) {
            ei.c(marginLayoutParams, n2);
        }
    }

}

