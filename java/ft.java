/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  android.view.ViewParent
 *  android.view.accessibility.AccessibilityEvent
 *  java.lang.Object
 */
import android.view.View;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;

class ft {
    public static boolean a(ViewParent viewParent, View view, AccessibilityEvent accessibilityEvent) {
        return viewParent.requestSendAccessibilityEvent(view, accessibilityEvent);
    }
}

