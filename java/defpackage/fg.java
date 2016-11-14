package defpackage;

import android.view.View;
import android.view.View.AccessibilityDelegate;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;

/* compiled from: ViewCompatICS */
class fg {
    public static boolean a(View v, int direction) {
        return v.canScrollHorizontally(direction);
    }

    public static boolean b(View v, int direction) {
        return v.canScrollVertically(direction);
    }

    public static void a(View v, Object delegate) {
        v.setAccessibilityDelegate((AccessibilityDelegate) delegate);
    }

    public static void a(View v, AccessibilityEvent event) {
        v.onInitializeAccessibilityEvent(event);
    }

    public static void b(View v, Object info) {
        v.onInitializeAccessibilityNodeInfo((AccessibilityNodeInfo) info);
    }

    public static void a(View view, boolean fitSystemWindows) {
        view.setFitsSystemWindows(fitSystemWindows);
    }
}
