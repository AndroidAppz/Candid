/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.os.Build
 *  android.os.Build$VERSION
 *  android.view.View
 *  android.view.ViewParent
 *  android.view.accessibility.AccessibilityEvent
 *  android.view.accessibility.AccessibilityManager
 *  java.lang.Object
 *  java.lang.String
 */
import android.content.Context;
import android.os.Build;
import android.view.View;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;

public final class fs {
    static final b a;

    static {
        int n2 = Build.VERSION.SDK_INT;
        a = n2 >= 21 ? new d() : (n2 >= 19 ? new c() : (n2 >= 14 ? new a() : new e()));
    }

    public static void a(ViewParent viewParent, View view) {
        a.a(viewParent, view);
    }

    public static void a(ViewParent viewParent, View view, int n2, int n3, int n4, int n5) {
        a.a(viewParent, view, n2, n3, n4, n5);
    }

    public static void a(ViewParent viewParent, View view, int n2, int n3, int[] arrn) {
        a.a(viewParent, view, n2, n3, arrn);
    }

    public static boolean a(ViewParent viewParent, View view, float f2, float f3) {
        return a.a(viewParent, view, f2, f3);
    }

    public static boolean a(ViewParent viewParent, View view, float f2, float f3, boolean bl2) {
        return a.a(viewParent, view, f2, f3, bl2);
    }

    public static boolean a(ViewParent viewParent, View view, View view2, int n2) {
        return a.a(viewParent, view, view2, n2);
    }

    public static boolean a(ViewParent viewParent, View view, AccessibilityEvent accessibilityEvent) {
        return a.a(viewParent, view, accessibilityEvent);
    }

    public static void b(ViewParent viewParent, View view, View view2, int n2) {
        a.b(viewParent, view, view2, n2);
    }

    static class a
    extends e {
        a() {
        }

        @Override
        public boolean a(ViewParent viewParent, View view, AccessibilityEvent accessibilityEvent) {
            return ft.a(viewParent, view, accessibilityEvent);
        }
    }

    static interface b {
        public void a(ViewParent var1, View var2);

        public void a(ViewParent var1, View var2, int var3, int var4, int var5, int var6);

        public void a(ViewParent var1, View var2, int var3, int var4, int[] var5);

        public boolean a(ViewParent var1, View var2, float var3, float var4);

        public boolean a(ViewParent var1, View var2, float var3, float var4, boolean var5);

        public boolean a(ViewParent var1, View var2, View var3, int var4);

        public boolean a(ViewParent var1, View var2, AccessibilityEvent var3);

        public void b(ViewParent var1, View var2, View var3, int var4);
    }

    static class c
    extends a {
        c() {
        }
    }

    static class d
    extends c {
        d() {
        }

        @Override
        public void a(ViewParent viewParent, View view) {
            fu.a(viewParent, view);
        }

        @Override
        public void a(ViewParent viewParent, View view, int n2, int n3, int n4, int n5) {
            fu.a(viewParent, view, n2, n3, n4, n5);
        }

        @Override
        public void a(ViewParent viewParent, View view, int n2, int n3, int[] arrn) {
            fu.a(viewParent, view, n2, n3, arrn);
        }

        @Override
        public boolean a(ViewParent viewParent, View view, float f2, float f3) {
            return fu.a(viewParent, view, f2, f3);
        }

        @Override
        public boolean a(ViewParent viewParent, View view, float f2, float f3, boolean bl2) {
            return fu.a(viewParent, view, f2, f3, bl2);
        }

        @Override
        public boolean a(ViewParent viewParent, View view, View view2, int n2) {
            return fu.a(viewParent, view, view2, n2);
        }

        @Override
        public void b(ViewParent viewParent, View view, View view2, int n2) {
            fu.b(viewParent, view, view2, n2);
        }
    }

    static class e
    implements b {
        e() {
        }

        @Override
        public void a(ViewParent viewParent, View view) {
            if (viewParent instanceof es) {
                ((es)viewParent).onStopNestedScroll(view);
            }
        }

        @Override
        public void a(ViewParent viewParent, View view, int n2, int n3, int n4, int n5) {
            if (viewParent instanceof es) {
                ((es)viewParent).onNestedScroll(view, n2, n3, n4, n5);
            }
        }

        @Override
        public void a(ViewParent viewParent, View view, int n2, int n3, int[] arrn) {
            if (viewParent instanceof es) {
                ((es)viewParent).onNestedPreScroll(view, n2, n3, arrn);
            }
        }

        @Override
        public boolean a(ViewParent viewParent, View view, float f2, float f3) {
            if (viewParent instanceof es) {
                return ((es)viewParent).onNestedPreFling(view, f2, f3);
            }
            return false;
        }

        @Override
        public boolean a(ViewParent viewParent, View view, float f2, float f3, boolean bl2) {
            if (viewParent instanceof es) {
                return ((es)viewParent).onNestedFling(view, f2, f3, bl2);
            }
            return false;
        }

        @Override
        public boolean a(ViewParent viewParent, View view, View view2, int n2) {
            if (viewParent instanceof es) {
                return ((es)viewParent).onStartNestedScroll(view, view2, n2);
            }
            return false;
        }

        @Override
        public boolean a(ViewParent viewParent, View view, AccessibilityEvent accessibilityEvent) {
            if (view == null) {
                return false;
            }
            ((AccessibilityManager)view.getContext().getSystemService("accessibility")).sendAccessibilityEvent(accessibilityEvent);
            return true;
        }

        @Override
        public void b(ViewParent viewParent, View view, View view2, int n2) {
            if (viewParent instanceof es) {
                ((es)viewParent).onNestedScrollAccepted(view, view2, n2);
            }
        }
    }

}

