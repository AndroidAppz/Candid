package defpackage;

import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityNodeInfo.CollectionInfo;
import android.view.accessibility.AccessibilityNodeInfo.CollectionItemInfo;

/* compiled from: AccessibilityNodeInfoCompatKitKat */
class go {
    public static void a(Object info, Object collectionInfo) {
        ((AccessibilityNodeInfo) info).setCollectionInfo((CollectionInfo) collectionInfo);
    }

    public static void b(Object info, Object collectionItemInfo) {
        ((AccessibilityNodeInfo) info).setCollectionItemInfo((CollectionItemInfo) collectionItemInfo);
    }

    public static Object a(int rowCount, int columnCount, boolean hierarchical, int selectionMode) {
        return CollectionInfo.obtain(rowCount, columnCount, hierarchical);
    }

    public static Object a(int rowIndex, int rowSpan, int columnIndex, int columnSpan, boolean heading) {
        return CollectionItemInfo.obtain(rowIndex, rowSpan, columnIndex, columnSpan, heading);
    }

    public static void a(Object info, boolean contentInvalid) {
        ((AccessibilityNodeInfo) info).setContentInvalid(contentInvalid);
    }
}
