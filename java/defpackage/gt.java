package defpackage;

import android.view.accessibility.AccessibilityRecord;

/* compiled from: AccessibilityRecordCompatIcs */
class gt {
    public static void a(Object record, int fromIndex) {
        ((AccessibilityRecord) record).setFromIndex(fromIndex);
    }

    public static void b(Object record, int itemCount) {
        ((AccessibilityRecord) record).setItemCount(itemCount);
    }

    public static void c(Object record, int scrollX) {
        ((AccessibilityRecord) record).setScrollX(scrollX);
    }

    public static void d(Object record, int scrollY) {
        ((AccessibilityRecord) record).setScrollY(scrollY);
    }

    public static void a(Object record, boolean scrollable) {
        ((AccessibilityRecord) record).setScrollable(scrollable);
    }

    public static void e(Object record, int toIndex) {
        ((AccessibilityRecord) record).setToIndex(toIndex);
    }
}
