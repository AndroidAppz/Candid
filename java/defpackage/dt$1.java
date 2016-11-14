package defpackage;

import android.view.View;
import android.view.View.AccessibilityDelegate;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;

/* compiled from: AccessibilityDelegateCompatIcs */
class dt$1 extends AccessibilityDelegate {
    final /* synthetic */ dt$a a;

    dt$1(dt$a dt_a) {
        this.a = dt_a;
    }

    public boolean dispatchPopulateAccessibilityEvent(View host, AccessibilityEvent event) {
        return this.a.a(host, event);
    }

    public void onInitializeAccessibilityEvent(View host, AccessibilityEvent event) {
        this.a.b(host, event);
    }

    public void onInitializeAccessibilityNodeInfo(View host, AccessibilityNodeInfo info) {
        this.a.a(host, (Object) info);
    }

    public void onPopulateAccessibilityEvent(View host, AccessibilityEvent event) {
        this.a.c(host, event);
    }

    public boolean onRequestSendAccessibilityEvent(ViewGroup host, View child, AccessibilityEvent event) {
        return this.a.a(host, child, event);
    }

    public void sendAccessibilityEvent(View host, int eventType) {
        this.a.a(host, eventType);
    }

    public void sendAccessibilityEventUnchecked(View host, AccessibilityEvent event) {
        this.a.d(host, event);
    }
}
