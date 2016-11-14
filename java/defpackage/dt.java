package defpackage;

import android.view.View;
import android.view.View.AccessibilityDelegate;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;

/* compiled from: AccessibilityDelegateCompatIcs */
class dt {
    public static Object a() {
        return new AccessibilityDelegate();
    }

    public static Object a(dt$a bridge) {
        return new dt$1(bridge);
    }

    public static boolean a(Object delegate, View host, AccessibilityEvent event) {
        return ((AccessibilityDelegate) delegate).dispatchPopulateAccessibilityEvent(host, event);
    }

    public static void b(Object delegate, View host, AccessibilityEvent event) {
        ((AccessibilityDelegate) delegate).onInitializeAccessibilityEvent(host, event);
    }

    public static void a(Object delegate, View host, Object info) {
        ((AccessibilityDelegate) delegate).onInitializeAccessibilityNodeInfo(host, (AccessibilityNodeInfo) info);
    }

    public static void c(Object delegate, View host, AccessibilityEvent event) {
        ((AccessibilityDelegate) delegate).onPopulateAccessibilityEvent(host, event);
    }

    public static boolean a(Object delegate, ViewGroup host, View child, AccessibilityEvent event) {
        return ((AccessibilityDelegate) delegate).onRequestSendAccessibilityEvent(host, child, event);
    }

    public static void a(Object delegate, View host, int eventType) {
        ((AccessibilityDelegate) delegate).sendAccessibilityEvent(host, eventType);
    }

    public static void d(Object delegate, View host, AccessibilityEvent event) {
        ((AccessibilityDelegate) delegate).sendAccessibilityEventUnchecked(host, event);
    }
}
