/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.os.Build
 *  android.os.Build$VERSION
 *  android.view.accessibility.AccessibilityManager
 *  java.lang.Object
 */
import android.os.Build;
import android.view.accessibility.AccessibilityManager;

public final class gg {
    private static final c a = Build.VERSION.SDK_INT >= 14 ? new a() : new b();

    public static boolean a(AccessibilityManager accessibilityManager) {
        return a.a(accessibilityManager);
    }

    static class a
    extends b {
        a() {
        }

        @Override
        public boolean a(AccessibilityManager accessibilityManager) {
            return gh.a(accessibilityManager);
        }
    }

    static class b
    implements c {
        b() {
        }

        @Override
        public boolean a(AccessibilityManager accessibilityManager) {
            return false;
        }
    }

    static interface c {
        public boolean a(AccessibilityManager var1);
    }

}

