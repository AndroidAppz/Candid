package defpackage;

import android.os.Build.VERSION;
import android.view.accessibility.AccessibilityManager;

/* compiled from: AccessibilityManagerCompat */
public final class gg {
    private static final gg$c a;

    static {
        if (VERSION.SDK_INT >= 14) {
            a = new gg$a();
        } else {
            a = new gg$b();
        }
    }

    public static boolean a(AccessibilityManager manager) {
        return a.a(manager);
    }
}
