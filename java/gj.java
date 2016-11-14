/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.view.accessibility.AccessibilityNodeInfo
 *  android.view.accessibility.AccessibilityNodeInfo$AccessibilityAction
 *  android.view.accessibility.AccessibilityNodeInfo$CollectionInfo
 *  android.view.accessibility.AccessibilityNodeInfo$CollectionItemInfo
 *  java.lang.CharSequence
 *  java.lang.Object
 */
import android.view.accessibility.AccessibilityNodeInfo;

class gj {
    public static Object a(int n2, int n3, int n4, int n5, boolean bl2, boolean bl3) {
        return AccessibilityNodeInfo.CollectionItemInfo.obtain((int)n2, (int)n3, (int)n4, (int)n5, (boolean)bl2, (boolean)bl3);
    }

    public static Object a(int n2, int n3, boolean bl2, int n4) {
        return AccessibilityNodeInfo.CollectionInfo.obtain((int)n2, (int)n3, (boolean)bl2, (int)n4);
    }

    static Object a(int n2, CharSequence charSequence) {
        return new AccessibilityNodeInfo.AccessibilityAction(n2, charSequence);
    }

    public static void a(Object object, CharSequence charSequence) {
        ((AccessibilityNodeInfo)object).setError(charSequence);
    }

    public static boolean a(Object object, Object object2) {
        return ((AccessibilityNodeInfo)object).removeAction((AccessibilityNodeInfo.AccessibilityAction)object2);
    }
}

