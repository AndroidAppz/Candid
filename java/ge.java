/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.os.Build
 *  android.os.Build$VERSION
 *  android.view.accessibility.AccessibilityEvent
 *  java.lang.Object
 */
import android.os.Build;
import android.view.accessibility.AccessibilityEvent;

public final class ge {
    private static final d a = Build.VERSION.SDK_INT >= 19 ? new b() : (Build.VERSION.SDK_INT >= 14 ? new a() : new c());

    public static gs a(AccessibilityEvent accessibilityEvent) {
        return new gs((Object)accessibilityEvent);
    }

    public static void a(AccessibilityEvent accessibilityEvent, int n2) {
        a.a(accessibilityEvent, n2);
    }

    public static int b(AccessibilityEvent accessibilityEvent) {
        return a.a(accessibilityEvent);
    }

    static class a
    extends c {
        a() {
        }
    }

    static class b
    extends a {
        b() {
        }

        @Override
        public int a(AccessibilityEvent accessibilityEvent) {
            return gf.a(accessibilityEvent);
        }

        @Override
        public void a(AccessibilityEvent accessibilityEvent, int n2) {
            gf.a(accessibilityEvent, n2);
        }
    }

    static class c
    implements d {
        c() {
        }

        @Override
        public int a(AccessibilityEvent accessibilityEvent) {
            return 0;
        }

        @Override
        public void a(AccessibilityEvent accessibilityEvent, int n2) {
        }
    }

    static interface d {
        public int a(AccessibilityEvent var1);

        public void a(AccessibilityEvent var1, int var2);
    }

}

