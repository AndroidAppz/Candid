/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.view.accessibility.AccessibilityEvent
 *  java.lang.Object
 */
import android.view.accessibility.AccessibilityEvent;

class gf {
    public static int a(AccessibilityEvent accessibilityEvent) {
        return accessibilityEvent.getContentChangeTypes();
    }

    public static void a(AccessibilityEvent accessibilityEvent, int n2) {
        accessibilityEvent.setContentChangeTypes(n2);
    }
}

