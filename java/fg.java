/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  android.view.View$AccessibilityDelegate
 *  android.view.accessibility.AccessibilityEvent
 *  android.view.accessibility.AccessibilityNodeInfo
 *  java.lang.Object
 */
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;

class fg {
    public static void a(View view, AccessibilityEvent accessibilityEvent) {
        view.onInitializeAccessibilityEvent(accessibilityEvent);
    }

    public static void a(View view, Object object) {
        view.setAccessibilityDelegate((View.AccessibilityDelegate)object);
    }

    public static void a(View view, boolean bl2) {
        view.setFitsSystemWindows(bl2);
    }

    public static boolean a(View view, int n2) {
        return view.canScrollHorizontally(n2);
    }

    public static void b(View view, Object object) {
        view.onInitializeAccessibilityNodeInfo((AccessibilityNodeInfo)object);
    }

    public static boolean b(View view, int n2) {
        return view.canScrollVertically(n2);
    }
}

