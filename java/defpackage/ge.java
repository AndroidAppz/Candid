package defpackage;

import android.os.Build.VERSION;
import android.view.accessibility.AccessibilityEvent;

/* compiled from: AccessibilityEventCompat */
public final class ge {
    private static final ge$d a;

    static {
        if (VERSION.SDK_INT >= 19) {
            a = new ge$b();
        } else if (VERSION.SDK_INT >= 14) {
            a = new ge$a();
        } else {
            a = new ge$c();
        }
    }

    public static gs a(AccessibilityEvent event) {
        return new gs(event);
    }

    public static void a(AccessibilityEvent event, int changeTypes) {
        a.a(event, changeTypes);
    }

    public static int b(AccessibilityEvent event) {
        return a.a(event);
    }
}
