package defpackage;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;

/* compiled from: AccessibilityDelegateCompat */
class ds$c$1 implements du$a {
    final /* synthetic */ ds a;
    final /* synthetic */ ds$c b;

    ds$c$1(ds$c ds_c, ds dsVar) {
        this.b = ds_c;
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

    public Object a(View host) {
        gp provider = this.a.getAccessibilityNodeProvider(host);
        return provider != null ? provider.getProvider() : null;
    }

    public boolean a(View host, int action, Bundle args) {
        return this.a.performAccessibilityAction(host, action, args);
    }
}
