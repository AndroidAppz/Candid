/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 *  android.view.View
 *  android.view.View$AccessibilityDelegate
 *  android.view.ViewGroup
 *  android.view.accessibility.AccessibilityEvent
 *  android.view.accessibility.AccessibilityNodeInfo
 *  android.view.accessibility.AccessibilityNodeProvider
 *  java.lang.Object
 */
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityNodeProvider;

class du {
    public static Object a(final a a2) {
        return new View.AccessibilityDelegate(){

            public boolean dispatchPopulateAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
                return a2.a(view, accessibilityEvent);
            }

            public AccessibilityNodeProvider getAccessibilityNodeProvider(View view) {
                return (AccessibilityNodeProvider)a2.a(view);
            }

            public void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
                a2.b(view, accessibilityEvent);
            }

            public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfo accessibilityNodeInfo) {
                a2.a(view, (Object)accessibilityNodeInfo);
            }

            public void onPopulateAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
                a2.c(view, accessibilityEvent);
            }

            public boolean onRequestSendAccessibilityEvent(ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent) {
                return a2.a(viewGroup, view, accessibilityEvent);
            }

            public boolean performAccessibilityAction(View view, int n2, Bundle bundle) {
                return a2.a(view, n2, bundle);
            }

            public void sendAccessibilityEvent(View view, int n2) {
                a2.a(view, n2);
            }

            public void sendAccessibilityEventUnchecked(View view, AccessibilityEvent accessibilityEvent) {
                a2.d(view, accessibilityEvent);
            }
        };
    }

    public static Object a(Object object, View view) {
        return ((View.AccessibilityDelegate)object).getAccessibilityNodeProvider(view);
    }

    public static boolean a(Object object, View view, int n2, Bundle bundle) {
        return ((View.AccessibilityDelegate)object).performAccessibilityAction(view, n2, bundle);
    }

    public static interface a {
        public Object a(View var1);

        public void a(View var1, int var2);

        public void a(View var1, Object var2);

        public boolean a(View var1, int var2, Bundle var3);

        public boolean a(View var1, AccessibilityEvent var2);

        public boolean a(ViewGroup var1, View var2, AccessibilityEvent var3);

        public void b(View var1, AccessibilityEvent var2);

        public void c(View var1, AccessibilityEvent var2);

        public void d(View var1, AccessibilityEvent var2);
    }

}

