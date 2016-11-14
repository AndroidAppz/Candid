package defpackage;

import android.os.Bundle;
import android.view.View;
import android.view.View.AccessibilityDelegate;

/* compiled from: AccessibilityDelegateCompatJellyBean */
class du {
    public static Object a(du$a bridge) {
        return new du$1(bridge);
    }

    public static Object a(Object delegate, View host) {
        return ((AccessibilityDelegate) delegate).getAccessibilityNodeProvider(host);
    }

    public static boolean a(Object delegate, View host, int action, Bundle args) {
        return ((AccessibilityDelegate) delegate).performAccessibilityAction(host, action, args);
    }
}
