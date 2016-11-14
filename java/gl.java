/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  android.view.accessibility.AccessibilityNodeInfo
 *  java.lang.Object
 */
import android.view.View;
import android.view.accessibility.AccessibilityNodeInfo;

class gl {
    public static void a(Object object, int n2) {
        ((AccessibilityNodeInfo)object).setMovementGranularities(n2);
    }

    public static void a(Object object, View view, int n2) {
        ((AccessibilityNodeInfo)object).addChild(view, n2);
    }

    public static void a(Object object, boolean bl2) {
        ((AccessibilityNodeInfo)object).setVisibleToUser(bl2);
    }

    public static boolean a(Object object) {
        return ((AccessibilityNodeInfo)object).isVisibleToUser();
    }

    public static int b(Object object) {
        return ((AccessibilityNodeInfo)object).getMovementGranularities();
    }

    public static void b(Object object, View view, int n2) {
        ((AccessibilityNodeInfo)object).setSource(view, n2);
    }

    public static void b(Object object, boolean bl2) {
        ((AccessibilityNodeInfo)object).setAccessibilityFocused(bl2);
    }

    public static boolean c(Object object) {
        return ((AccessibilityNodeInfo)object).isAccessibilityFocused();
    }
}

