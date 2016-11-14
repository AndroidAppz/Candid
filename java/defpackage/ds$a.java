package defpackage;

import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;

/* compiled from: AccessibilityDelegateCompat */
class ds$a extends ds$d {
    ds$a() {
    }

    public Object a() {
        return dt.a();
    }

    public Object a(ds compat) {
        return dt.a(new ds$a$1(this, compat));
    }

    public boolean a(Object delegate, View host, AccessibilityEvent event) {
        return dt.a(delegate, host, event);
    }

    public void b(Object delegate, View host, AccessibilityEvent event) {
        dt.b(delegate, host, event);
    }

    public void a(Object delegate, View host, gi info) {
        dt.a(delegate, host, info.a());
    }

    public void c(Object delegate, View host, AccessibilityEvent event) {
        dt.c(delegate, host, event);
    }

    public boolean a(Object delegate, ViewGroup host, View child, AccessibilityEvent event) {
        return dt.a(delegate, host, child, event);
    }

    public void a(Object delegate, View host, int eventType) {
        dt.a(delegate, host, eventType);
    }

    public void d(Object delegate, View host, AccessibilityEvent event) {
        dt.d(delegate, host, event);
    }
}
