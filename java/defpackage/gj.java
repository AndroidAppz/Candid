package defpackage;

import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityNodeInfo.AccessibilityAction;
import android.view.accessibility.AccessibilityNodeInfo.CollectionInfo;
import android.view.accessibility.AccessibilityNodeInfo.CollectionItemInfo;

/* compiled from: AccessibilityNodeInfoCompatApi21 */
class gj {
    public static boolean a(Object info, Object action) {
        return ((AccessibilityNodeInfo) info).removeAction((AccessibilityAction) action);
    }

    public static Object a(int rowCount, int columnCount, boolean hierarchical, int selectionMode) {
        return CollectionInfo.obtain(rowCount, columnCount, hierarchical, selectionMode);
    }

    public static Object a(int rowIndex, int rowSpan, int columnIndex, int columnSpan, boolean heading, boolean selected) {
        return CollectionItemInfo.obtain(rowIndex, rowSpan, columnIndex, columnSpan, heading, selected);
    }

    public static void a(Object info, CharSequence error) {
        ((AccessibilityNodeInfo) info).setError(error);
    }

    static Object a(int actionId, CharSequence label) {
        return new AccessibilityAction(actionId, label);
    }
}
