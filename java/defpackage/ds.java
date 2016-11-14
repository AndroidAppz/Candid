package defpackage;

import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;

/* compiled from: AccessibilityDelegateCompat */
public class ds {
    private static final Object DEFAULT_DELEGATE = IMPL.a();
    private static final ds$b IMPL;
    final Object mBridge = IMPL.a(this);

    static {
        if (VERSION.SDK_INT >= 16) {
            IMPL = new ds$c();
        } else if (VERSION.SDK_INT >= 14) {
            IMPL = new ds$a();
        } else {
            IMPL = new ds$d();
        }
    }

    Object getBridge() {
        return this.mBridge;
    }

    public void sendAccessibilityEvent(View host, int eventType) {
        IMPL.a(DEFAULT_DELEGATE, host, eventType);
    }

    public void sendAccessibilityEventUnchecked(View host, AccessibilityEvent event) {
        IMPL.d(DEFAULT_DELEGATE, host, event);
    }

    public boolean dispatchPopulateAccessibilityEvent(View host, AccessibilityEvent event) {
        return IMPL.a(DEFAULT_DELEGATE, host, event);
    }

    public void onPopulateAccessibilityEvent(View host, AccessibilityEvent event) {
        IMPL.c(DEFAULT_DELEGATE, host, event);
    }

    public void onInitializeAccessibilityEvent(View host, AccessibilityEvent event) {
        IMPL.b(DEFAULT_DELEGATE, host, event);
    }

    public void onInitializeAccessibilityNodeInfo(View host, gi info) {
        IMPL.a(DEFAULT_DELEGATE, host, info);
    }

    public boolean onRequestSendAccessibilityEvent(ViewGroup host, View child, AccessibilityEvent event) {
        return IMPL.a(DEFAULT_DELEGATE, host, child, event);
    }

    public gp getAccessibilityNodeProvider(View host) {
        return IMPL.a(DEFAULT_DELEGATE, host);
    }

    public boolean performAccessibilityAction(View host, int action, Bundle args) {
        return IMPL.a(DEFAULT_DELEGATE, host, action, args);
    }
}
