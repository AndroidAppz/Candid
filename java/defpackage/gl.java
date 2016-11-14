package defpackage;

import android.view.View;
import android.view.accessibility.AccessibilityNodeInfo;

/* compiled from: AccessibilityNodeInfoCompatJellyBean */
class gl {
    public static void a(Object info, View child, int virtualDescendantId) {
        ((AccessibilityNodeInfo) info).addChild(child, virtualDescendantId);
    }

    public static void b(Object info, View root, int virtualDescendantId) {
        ((AccessibilityNodeInfo) info).setSource(root, virtualDescendantId);
    }

    public static boolean a(Object info) {
        return ((AccessibilityNodeInfo) info).isVisibleToUser();
    }

    public static void a(Object info, boolean visibleToUser) {
        ((AccessibilityNodeInfo) info).setVisibleToUser(visibleToUser);
    }

    public static void a(Object info, int granularities) {
        ((AccessibilityNodeInfo) info).setMovementGranularities(granularities);
    }

    public static int b(Object info) {
        return ((AccessibilityNodeInfo) info).getMovementGranularities();
    }

    public static boolean c(Object info) {
        return ((AccessibilityNodeInfo) info).isAccessibilityFocused();
    }

    public static void b(Object info, boolean focused) {
        ((AccessibilityNodeInfo) info).setAccessibilityFocused(focused);
    }
}
