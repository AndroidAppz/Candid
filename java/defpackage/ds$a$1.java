package defpackage;

import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;

/* compiled from: AccessibilityDelegateCompat */
class ds$a$1 implements dt$a {
    final /* synthetic */ ds a;
    final /* synthetic */ ds$a b;

    ds$a$1(ds$a ds_a, ds dsVar) {
        this.b = ds_a;
        this.a = dsVar;
    }

    public boolean a(View host, AccessibilityEvent event) {
        return this.a.dispatchPopulateAccessibilityEvent(host, event);
    }

    public void b(View host, AccessibilityEvent event) {
        this.a.onInitializeAccessibilityEvent(host, event);
    }

    public void a(View host, Object info) {
        this.a.onInitializeAccessibilityNodeInfo(host, new gi(info));
    }

    public void c(View host, AccessibilityEvent event) {
        this.a.onPopulateAccessibilityEvent(host, event);
    }

    public boolean a(ViewGroup host, View child, AccessibilityEvent event) {
        return this.a.onRequestSendAccessibilityEvent(host, child, event);
    }

    public void a(View host, int eventType) {
        this.a.sendAccessibilityEvent(host, eventType);
    }

    public void d(View host, AccessibilityEvent event) {
        this.a.sendAccessibilityEventUnchecked(host, event);
    }
}
