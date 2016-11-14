/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.os.Build
 *  android.os.Build$VERSION
 *  android.os.Bundle
 *  android.view.View
 *  android.view.ViewGroup
 *  android.view.accessibility.AccessibilityEvent
 *  java.lang.Object
 */
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;

public class ds {
    private static final Object DEFAULT_DELEGATE;
    private static final b IMPL;
    final Object mBridge;

    /*
     * Enabled aggressive block sorting
     */
    static {
        IMPL = Build.VERSION.SDK_INT >= 16 ? new c() : (Build.VERSION.SDK_INT >= 14 ? new a() : new d());
        DEFAULT_DELEGATE = IMPL.a();
    }

    public ds() {
        this.mBridge = IMPL.a(this);
    }

    public boolean dispatchPopulateAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
        return IMPL.a(DEFAULT_DELEGATE, view, accessibilityEvent);
    }

    public gp getAccessibilityNodeProvider(View view) {
        return IMPL.a(DEFAULT_DELEGATE, view);
    }

    Object getBridge() {
        return this.mBridge;
    }

    public void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
        IMPL.b(DEFAULT_DELEGATE, view, accessibilityEvent);
    }

    public void onInitializeAccessibilityNodeInfo(View view, gi gi2) {
        IMPL.a(DEFAULT_DELEGATE, view, gi2);
    }

    public void onPopulateAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
        IMPL.c(DEFAULT_DELEGATE, view, accessibilityEvent);
    }

    public boolean onRequestSendAccessibilityEvent(ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent) {
        return IMPL.a(DEFAULT_DELEGATE, viewGroup, view, accessibilityEvent);
    }

    public boolean performAccessibilityAction(View view, int n2, Bundle bundle) {
        return IMPL.a(DEFAULT_DELEGATE, view, n2, bundle);
    }

    public void sendAccessibilityEvent(View view, int n2) {
        IMPL.a(DEFAULT_DELEGATE, view, n2);
    }

    public void sendAccessibilityEventUnchecked(View view, AccessibilityEvent accessibilityEvent) {
        IMPL.d(DEFAULT_DELEGATE, view, accessibilityEvent);
    }

    static class a
    extends d {
        a() {
        }

        @Override
        public Object a() {
            return dt.a();
        }

        @Override
        public Object a(final ds ds2) {
            return dt.a(new dt.a(){

                @Override
                public void a(View view, int n2) {
                    ds2.sendAccessibilityEvent(view, n2);
                }

                @Override
                public void a(View view, Object object) {
                    ds2.onInitializeAccessibilityNodeInfo(view, new gi(object));
                }

                @Override
                public boolean a(View view, AccessibilityEvent accessibilityEvent) {
                    return ds2.dispatchPopulateAccessibilityEvent(view, accessibilityEvent);
                }

                @Override
                public boolean a(ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent) {
                    return ds2.onRequestSendAccessibilityEvent(viewGroup, view, accessibilityEvent);
                }

                @Override
                public void b(View view, AccessibilityEvent accessibilityEvent) {
                    ds2.onInitializeAccessibilityEvent(view, accessibilityEvent);
                }

                @Override
                public void c(View view, AccessibilityEvent accessibilityEvent) {
                    ds2.onPopulateAccessibilityEvent(view, accessibilityEvent);
                }

                @Override
                public void d(View view, AccessibilityEvent accessibilityEvent) {
                    ds2.sendAccessibilityEventUnchecked(view, accessibilityEvent);
                }
            });
        }

        @Override
        public void a(Object object, View view, int n2) {
            dt.a(object, view, n2);
        }

        @Override
        public void a(Object object, View view, gi gi2) {
            dt.a(object, view, gi2.a());
        }

        @Override
        public boolean a(Object object, View view, AccessibilityEvent accessibilityEvent) {
            return dt.a(object, view, accessibilityEvent);
        }

        @Override
        public boolean a(Object object, ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent) {
            return dt.a(object, viewGroup, view, accessibilityEvent);
        }

        @Override
        public void b(Object object, View view, AccessibilityEvent accessibilityEvent) {
            dt.b(object, view, accessibilityEvent);
        }

        @Override
        public void c(Object object, View view, AccessibilityEvent accessibilityEvent) {
            dt.c(object, view, accessibilityEvent);
        }

        @Override
        public void d(Object object, View view, AccessibilityEvent accessibilityEvent) {
            dt.d(object, view, accessibilityEvent);
        }

    }

    static interface b {
        public gp a(Object var1, View var2);

        public Object a();

        public Object a(ds var1);

        public void a(Object var1, View var2, int var3);

        public void a(Object var1, View var2, gi var3);

        public boolean a(Object var1, View var2, int var3, Bundle var4);

        public boolean a(Object var1, View var2, AccessibilityEvent var3);

        public boolean a(Object var1, ViewGroup var2, View var3, AccessibilityEvent var4);

        public void b(Object var1, View var2, AccessibilityEvent var3);

        public void c(Object var1, View var2, AccessibilityEvent var3);

        public void d(Object var1, View var2, AccessibilityEvent var3);
    }

    static class c
    extends a {
        c() {
        }

        @Override
        public gp a(Object object, View view) {
            Object object2 = du.a(object, view);
            if (object2 != null) {
                return new gp(object2);
            }
            return null;
        }

        @Override
        public Object a(final ds ds2) {
            return du.a(new du.a(){

                @Override
                public Object a(View view) {
                    gp gp2 = ds2.getAccessibilityNodeProvider(view);
                    if (gp2 != null) {
                        return gp2.getProvider();
                    }
                    return null;
                }

                @Override
                public void a(View view, int n2) {
                    ds2.sendAccessibilityEvent(view, n2);
                }

                @Override
                public void a(View view, Object object) {
                    ds2.onInitializeAccessibilityNodeInfo(view, new gi(object));
                }

                @Override
                public boolean a(View view, int n2, Bundle bundle) {
                    return ds2.performAccessibilityAction(view, n2, bundle);
                }

                @Override
                public boolean a(View view, AccessibilityEvent accessibilityEvent) {
                    return ds2.dispatchPopulateAccessibilityEvent(view, accessibilityEvent);
                }

                @Override
                public boolean a(ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent) {
                    return ds2.onRequestSendAccessibilityEvent(viewGroup, view, accessibilityEvent);
                }

                @Override
                public void b(View view, AccessibilityEvent accessibilityEvent) {
                    ds2.onInitializeAccessibilityEvent(view, accessibilityEvent);
                }

                @Override
                public void c(View view, AccessibilityEvent accessibilityEvent) {
                    ds2.onPopulateAccessibilityEvent(view, accessibilityEvent);
                }

                @Override
                public void d(View view, AccessibilityEvent accessibilityEvent) {
                    ds2.sendAccessibilityEventUnchecked(view, accessibilityEvent);
                }
            });
        }

        @Override
        public boolean a(Object object, View view, int n2, Bundle bundle) {
            return du.a(object, view, n2, bundle);
        }

    }

    static class d
    implements b {
        d() {
        }

        @Override
        public gp a(Object object, View view) {
            return null;
        }

        @Override
        public Object a() {
            return null;
        }

        @Override
        public Object a(ds ds2) {
            return null;
        }

        @Override
        public void a(Object object, View view, int n2) {
        }

        @Override
        public void a(Object object, View view, gi gi2) {
        }

        @Override
        public boolean a(Object object, View view, int n2, Bundle bundle) {
            return false;
        }

        @Override
        public boolean a(Object object, View view, AccessibilityEvent accessibilityEvent) {
            return false;
        }

        @Override
        public boolean a(Object object, ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent) {
            return true;
        }

        @Override
        public void b(Object object, View view, AccessibilityEvent accessibilityEvent) {
        }

        @Override
        public void c(Object object, View view, AccessibilityEvent accessibilityEvent) {
        }

        @Override
        public void d(Object object, View view, AccessibilityEvent accessibilityEvent) {
        }
    }

}

