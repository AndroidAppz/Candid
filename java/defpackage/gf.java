package defpackage;

import android.view.accessibility.AccessibilityEvent;

/* compiled from: AccessibilityEventCompatKitKat */
class gf {
    public static void a(AccessibilityEvent event, int changeTypes) {
        event.setContentChangeTypes(changeTypes);
    }

    public static int a(AccessibilityEvent event) {
        return event.getContentChangeTypes();
    }
}
