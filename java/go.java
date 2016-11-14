/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.view.accessibility.AccessibilityNodeInfo
 *  android.view.accessibility.AccessibilityNodeInfo$CollectionInfo
 *  android.view.accessibility.AccessibilityNodeInfo$CollectionItemInfo
 *  java.lang.Object
 */
import android.view.accessibility.AccessibilityNodeInfo;

class go {
    public static Object a(int n2, int n3, int n4, int n5, boolean bl2) {
        return AccessibilityNodeInfo.CollectionItemInfo.obtain((int)n2, (int)n3, (int)n4, (int)n5, (boolean)bl2);
    }

    public static Object a(int n2, int n3, boolean bl2, int n4) {
        return AccessibilityNodeInfo.CollectionInfo.obtain((int)n2, (int)n3, (boolean)bl2);
    }

    public static void a(Object object, Object object2) {
        ((AccessibilityNodeInfo)object).setCollectionInfo((AccessibilityNodeInfo.CollectionInfo)object2);
    }

    public static void a(Object object, boolean bl2) {
        ((AccessibilityNodeInfo)object).setContentInvalid(bl2);
    }

    public static void b(Object object, Object object2) {
        ((AccessibilityNodeInfo)object).setCollectionItemInfo((AccessibilityNodeInfo.CollectionItemInfo)object2);
    }
}

