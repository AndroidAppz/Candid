package defpackage;

import android.content.res.ColorStateList;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;

/* compiled from: ViewCompat */
public final class fb {
    static final fb$m a;

    static {
        int version = VERSION.SDK_INT;
        if (version >= 23) {
            a = new fb$l();
        } else if (version >= 21) {
            a = new fb$k();
        } else if (version >= 19) {
            a = new fb$j();
        } else if (version >= 17) {
            a = new fb$h();
        } else if (version >= 16) {
            a = new fb$g();
        } else if (version >= 15) {
            a = new fb$e();
        } else if (version >= 14) {
            a = new fb$f();
        } else if (version >= 11) {
            a = new fb$d();
        } else if (version >= 9) {
            a = new fb$c();
        } else if (version >= 7) {
            a = new fb$b();
        } else {
            a = new fb$a();
        }
    }

    public static boolean a(View v, int direction) {
        return a.a(v, direction);
    }

    public static boolean b(View v, int direction) {
        return a.b(v, direction);
    }

    public static int a(View v) {
        return a.a(v);
    }

    public static void a(View v, AccessibilityEvent event) {
        a.a(v, event);
    }

    public static void a(View v, gi info) {
        a.a(v, info);
    }

    public static void a(View v, ds delegate) {
        a.a(v, delegate);
    }

    public static boolean b(View v) {
        return a.b(v);
    }

    public static boolean c(View view) {
        return a.c(view);
    }

    public static void d(View view) {
        a.d(view);
    }

    public static void a(View view, int left, int top, int right, int bottom) {
        a.a(view, left, top, right, bottom);
    }

    public static void a(View view, Runnable action) {
        a.a(view, action);
    }

    public static void a(View view, Runnable action, long delayMillis) {
        a.a(view, action, delayMillis);
    }

    public static int e(View view) {
        return a.e(view);
    }

    public static void c(View view, int mode) {
        a.c(view, mode);
    }

    public static boolean a(View view, int action, Bundle arguments) {
        return a.a(view, action, arguments);
    }

    public static float f(View view) {
        return a.f(view);
    }

    public static void a(View view, int layerType, Paint paint) {
        a.a(view, layerType, paint);
    }

    public static int g(View view) {
        return a.g(view);
    }

    public static void a(View view, Paint paint) {
        a.a(view, paint);
    }

    public static int h(View view) {
        return a.h(view);
    }

    public static ViewParent i(View view) {
        return a.i(view);
    }

    public static boolean j(View view) {
        return a.j(view);
    }

    public static int a(int size, int measureSpec, int childMeasuredState) {
        return a.a(size, measureSpec, childMeasuredState);
    }

    public static int k(View view) {
        return a.k(view);
    }

    public static int l(View view) {
        return a.l(view);
    }

    public static int m(View view) {
        return a.m(view);
    }

    public static int a(int curState, int newState) {
        return a.a(curState, newState);
    }

    public static void d(View view, int mode) {
        a.d(view, mode);
    }

    public static int n(View view) {
        return a.n(view);
    }

    public static int o(View view) {
        return a.o(view);
    }

    public static void b(View view, int start, int top, int end, int bottom) {
        a.b(view, start, top, end, bottom);
    }

    public static float p(View view) {
        return a.q(view);
    }

    public static float q(View view) {
        return a.r(view);
    }

    public static int r(View view) {
        return a.t(view);
    }

    public static int s(View view) {
        return a.u(view);
    }

    public static fv t(View view) {
        return a.v(view);
    }

    public static void a(View view, float value) {
        a.a(view, value);
    }

    public static void b(View view, float value) {
        a.b(view, value);
    }

    public static void c(View view, float value) {
        a.c(view, value);
    }

    public static void d(View view, float value) {
        a.d(view, value);
    }

    public static void e(View view, float value) {
        a.e(view, value);
    }

    public static float u(View view) {
        return a.s(view);
    }

    public static void f(View view, float elevation) {
        a.f(view, elevation);
    }

    public static float v(View view) {
        return a.y(view);
    }

    public static int w(View view) {
        return a.w(view);
    }

    public static void x(View view) {
        a.x(view);
    }

    public static void a(ViewGroup viewGroup, boolean enabled) {
        a.a(viewGroup, enabled);
    }

    public static boolean y(View v) {
        return a.A(v);
    }

    public static void a(View view, boolean fitSystemWindows) {
        a.a(view, fitSystemWindows);
    }

    public static void z(View v) {
        a.B(v);
    }

    public static void a(View v, eu listener) {
        a.a(v, listener);
    }

    public static gc a(View view, gc insets) {
        return a.a(view, insets);
    }

    public static gc b(View view, gc insets) {
        return a.b(view, insets);
    }

    public static void b(View v, boolean enabled) {
        a.b(v, enabled);
    }

    public static void c(View view, boolean activated) {
        a.c(view, activated);
    }

    public static boolean A(View view) {
        return a.p(view);
    }

    public static boolean B(View view) {
        return a.C(view);
    }

    public static ColorStateList C(View view) {
        return a.E(view);
    }

    public static void a(View view, ColorStateList tintList) {
        a.a(view, tintList);
    }

    public static Mode D(View view) {
        return a.F(view);
    }

    public static void a(View view, Mode mode) {
        a.a(view, mode);
    }

    public static boolean E(View view) {
        return a.D(view);
    }

    public static void F(View view) {
        a.G(view);
    }

    public static boolean G(View view) {
        return a.H(view);
    }

    public static float H(View view) {
        return a.I(view);
    }

    public static void e(View view, int offset) {
        a.f(view, offset);
    }

    public static void f(View view, int offset) {
        a.e(view, offset);
    }

    public static boolean I(View view) {
        return a.J(view);
    }

    public static boolean J(View view) {
        return a.K(view);
    }

    public static void a(View view, int indicators, int mask) {
        a.a(view, indicators, mask);
    }
}
