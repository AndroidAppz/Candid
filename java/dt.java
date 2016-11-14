/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  android.view.View$AccessibilityDelegate
 *  android.view.ViewGroup
 *  android.view.accessibility.AccessibilityEvent
 *  android.view.accessibility.AccessibilityNodeInfo
 *  java.lang.Object
 */
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;

class dt {
    public static Object a() {
        return new View.AccessibilityDelegate();
    }

    public static Object a(final a a2) {
        return new View.AccessibilityDelegate(){

            public boolean dispatchPopulateAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
                return a2.a(view, accessibilityEvent);
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

            public void sendAccessibilityEvent(View view, int n2) {
                a2.a(view, n2);
            }

            public void sendAccessibilityEventUnchecked(View view, AccessibilityEvent accessibilityEvent) {
                a2.d(view, accessibilityEvent);
            }
        };
    }

    public static void a(Object object, View view, int n2) {
        ((View.AccessibilityDelegate)object).sendAccessibilityEvent(view, n2);
    }

    public static void a(Object object, View view, Object object2) {
        ((View.AccessibilityDelegate)object).onInitializeAccessibilityNodeInfo(view, (AccessibilityNodeInfo)object2);
    }

    public static boolean a(Object object, View view, AccessibilityEvent accessibilityEvent) {
        return ((View.AccessibilityDelegate)object).dispatchPopulateAccessibilityEvent(view, accessibilityEvent);
    }

    public static boolean a(Object object, ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent) {
        return ((View.AccessibilityDelegate)object).onRequestSendAccessibilityEvent(viewGroup, view, accessibilityEvent);
    }

    public static void b(Object object, View view, AccessibilityEvent accessibilityEvent) {
        ((View.AccessibilityDelegate)object).onInitializeAccessibilityEvent(view, accessibilityEvent);
    }

    public static void c(Object object, View view, AccessibilityEvent accessibilityEvent) {
        ((View.AccessibilityDelegate)object).onPopulateAccessibilityEvent(view, accessibilityEvent);
    }

    public static void d(Object object, View view, AccessibilityEvent accessibilityEvent) {
        ((View.AccessibilityDelegate)object).sendAccessibilityEventUnchecked(view, accessibilityEvent);
    }

    public static interface a {
        public void a(View var1, int var2);

        public void a(View var1, Object var2);

        public boolean a(View var1, AccessibilityEvent var2);

        public boolean a(ViewGroup var1, View var2, AccessibilityEvent var3);

        public void b(View var1, AccessibilityEvent var2);

        public void c(View var1, AccessibilityEvent var2);

        public void d(View var1, AccessibilityEvent var2);
    }

}

