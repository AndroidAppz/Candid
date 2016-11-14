package defpackage;

import android.view.accessibility.AccessibilityRecord;

/* compiled from: AccessibilityRecordCompatIcsMr1 */
class gu {
    public static void a(Object record, int maxScrollX) {
        ((AccessibilityRecord) record).setMaxScrollX(maxScrollX);
    }

    public static void b(Object record, int maxScrollY) {
        ((AccessibilityRecord) record).setMaxScrollY(maxScrollY);
    }
}
