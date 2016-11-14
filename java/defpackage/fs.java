package defpackage;

import android.os.Build.VERSION;
import android.view.View;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;

/* compiled from: ViewParentCompat */
public final class fs {
    static final fs$b a;

    static {
        int version = VERSION.SDK_INT;
        if (version >= 21) {
            a = new fs$d();
        } else if (version >= 19) {
            a = new fs$c();
        } else if (version >= 14) {
            a = new fs$a();
        } else {
            a = new fs$e();
        }
    }

    public static boolean a(ViewParent parent, View child, AccessibilityEvent event) {
        return a.a(parent, child, event);
    }

    public static boolean a(ViewParent parent, View child, View target, int nestedScrollAxes) {
        return a.a(parent, child, target, nestedScrollAxes);
    }

    public static void b(ViewParent parent, View child, View target, int nestedScrollAxes) {
        a.b(parent, child, target, nestedScrollAxes);
    }

    public static void a(ViewParent parent, View target) {
        a.a(parent, target);
    }

    public static void a(ViewParent parent, View target, int dxConsumed, int dyConsumed, int dxUnconsumed, int dyUnconsumed) {
        a.a(parent, target, dxConsumed, dyConsumed, dxUnconsumed, dyUnconsumed);
    }

    public static void a(ViewParent parent, View target, int dx, int dy, int[] consumed) {
        a.a(parent, target, dx, dy, consumed);
    }

    public static boolean a(ViewParent parent, View target, float velocityX, float velocityY, boolean consumed) {
        return a.a(parent, target, velocityX, velocityY, consumed);
    }

    public static boolean a(ViewParent parent, View target, float velocityX, float velocityY) {
        return a.a(parent, target, velocityX, velocityY);
    }
}
