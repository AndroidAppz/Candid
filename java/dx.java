/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.graphics.Rect
 *  android.os.Build
 *  android.os.Build$VERSION
 *  android.view.Gravity
 *  java.lang.Object
 */
import android.graphics.Rect;
import android.os.Build;
import android.view.Gravity;

public final class dx {
    static final a a = Build.VERSION.SDK_INT >= 17 ? new c() : new b();

    public static int a(int n2, int n3) {
        return a.a(n2, n3);
    }

    public static void a(int n2, int n3, int n4, Rect rect, Rect rect2, int n5) {
        a.a(n2, n3, n4, rect, rect2, n5);
    }

    static interface a {
        public int a(int var1, int var2);

        public void a(int var1, int var2, int var3, Rect var4, Rect var5, int var6);
    }

    static class b
    implements a {
        b() {
        }

        @Override
        public int a(int n2, int n3) {
            return -8388609 & n2;
        }

        @Override
        public void a(int n2, int n3, int n4, Rect rect, Rect rect2, int n5) {
            Gravity.apply((int)n2, (int)n3, (int)n4, (Rect)rect, (Rect)rect2);
        }
    }

    static class c
    implements a {
        c() {
        }

        @Override
        public int a(int n2, int n3) {
            return dy.a(n2, n3);
        }

        @Override
        public void a(int n2, int n3, int n4, Rect rect, Rect rect2, int n5) {
            dy.a(n2, n3, n4, rect, rect2, n5);
        }
    }

}

