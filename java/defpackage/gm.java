package defpackage;

import android.view.View;
import android.view.accessibility.AccessibilityNodeInfo;

/* compiled from: AccessibilityNodeInfoCompatJellybeanMr1 */
class gm {
    public static void a(Object info, View labeled) {
        ((AccessibilityNodeInfo) info).setLabelFor(labeled);
    }
}
