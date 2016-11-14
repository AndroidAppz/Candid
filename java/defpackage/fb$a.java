package defpackage;

import android.content.res.ColorStateList;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import java.util.WeakHashMap;

/* compiled from: ViewCompat */
class fb$a implements fb$m {
    WeakHashMap<View, fv> a = null;

    fb$a() {
    }

    public boolean a(View v, int direction) {
        return (v instanceof ex) && a((ex) v, direction);
    }

    public boolean b(View v, int direction) {
        return (v instanceof ex) && b((ex) v, direction);
    }

    public int a(View v) {
        return 2;
    }

    public void a(View v, ds delegate) {
    }

    public boolean b(View v) {
        return false;
    }

    public void a(View v, AccessibilityEvent event) {
    }

    public void a(View v, gi info) {
    }

    public boolean c(View view) {
        return false;
    }

    public void d(View view) {
        view.invalidate();
    }

    public void a(View view, int left, int top, int right, int bottom) {
        view.invalidate(left, top, right, bottom);
    }

    public void a(View view, Runnable action) {
        view.postDelayed(action, a());
    }

    public void a(View view, Runnable action, long delayMillis) {
        view.postDelayed(action, a() + delayMillis);
    }

    long a() {
        return 10;
    }

    public int e(View view) {
        return 0;
    }

    public void c(View view, int mode) {
    }

    public boolean a(View view, int action, Bundle arguments) {
        return false;
    }

    public float f(View view) {
        return 1.0f;
    }

    public void a(View view, int layerType, Paint paint) {
    }

    public int g(View view) {
        return 0;
    }

    public void a(View view, Paint p) {
    }

    public int h(View view) {
        return 0;
    }

    public ViewParent i(View view) {
        return view.getParent();
    }

    public boolean j(View view) {
        Drawable bg = view.getBackground();
        if (bg == null || bg.getOpacity() != -1) {
            return false;
        }
        return true;
    }

    public int a(int size, int measureSpec, int childMeasuredState) {
        return View.resolveSize(size, measureSpec);
    }

    public int k(View view) {
        return view.getMeasuredWidth();
    }

    public int l(View view) {
        return view.getMeasuredHeight();
    }

    public int m(View view) {
        return 0;
    }

    public void d(View view, int mode) {
    }

    public int n(View view) {
        return view.getPaddingLeft();
    }

    public int o(View view) {
        return view.getPaddingRight();
    }

    public void b(View view, int start, int top, int end, int bottom) {
        view.setPadding(start, top, end, bottom);
    }

    public boolean p(View view) {
        return true;
    }

    public float q(View view) {
        return 0.0f;
    }

    public float r(View view) {
        return 0.0f;
    }

    public float s(View view) {
        return 0.0f;
    }

    public int t(View view) {
        return fc.d(view);
    }

    public int u(View view) {
        return fc.e(view);
    }

    public fv v(View view) {
        return new fv(view);
    }

    public void a(View view, float value) {
    }

    public void b(View view, float value) {
    }

    public void c(View view, float value) {
    }

    public void d(View view, float value) {
    }

    public void e(View view, float value) {
    }

    public int w(View view) {
        return 0;
    }

    public void x(View view) {
    }

    public void f(View view, float elevation) {
    }

    public float y(View view) {
        return 0.0f;
    }

    public float z(View view) {
        return 0.0f;
    }

    public void a(ViewGroup viewGroup, boolean enabled) {
    }

    public boolean A(View view) {
        return false;
    }

    public void a(View view, boolean fitSystemWindows) {
    }

    public void B(View view) {
    }

    public void a(View view, eu listener) {
    }

    public gc a(View v, gc insets) {
        return insets;
    }

    public gc b(View v, gc insets) {
        return insets;
    }

    public void b(View v, boolean enabled) {
    }

    public void c(View view, boolean activated) {
    }

    public boolean C(View view) {
        return false;
    }

    public boolean D(View view) {
        if (view instanceof eq) {
            return ((eq) view).isNestedScrollingEnabled();
        }
        return false;
    }

    public ColorStateList E(View view) {
        return fc.a(view);
    }

    public void a(View view, ColorStateList tintList) {
        fc.a(view, tintList);
    }

    public void a(View view, Mode mode) {
        fc.a(view, mode);
    }

    public Mode F(View view) {
        return fc.b(view);
    }

    private boolean a(ex view, int direction) {
        int offset = view.computeHorizontalScrollOffset();
        int range = view.computeHorizontalScrollRange() - view.computeHorizontalScrollExtent();
        if (range == 0) {
            return false;
        }
        if (direction < 0) {
            if (offset <= 0) {
                return false;
            }
            return true;
        } else if (offset >= range - 1) {
            return false;
        } else {
            return true;
        }
    }

    private boolean b(ex view, int direction) {
        int offset = view.computeVerticalScrollOffset();
        int range = view.computeVerticalScrollRange() - view.computeVerticalScrollExtent();
        if (range == 0) {
            return false;
        }
        if (direction < 0) {
            if (offset <= 0) {
                return false;
            }
            return true;
        } else if (offset >= range - 1) {
            return false;
        } else {
            return true;
        }
    }

    public void G(View view) {
        if (view instanceof eq) {
            ((eq) view).stopNestedScroll();
        }
    }

    public boolean H(View view) {
        return fc.c(view);
    }

    public int a(int curState, int newState) {
        return curState | newState;
    }

    public float I(View view) {
        return z(view) + y(view);
    }

    public boolean J(View view) {
        return fc.f(view);
    }

    public boolean K(View view) {
        return false;
    }

    public void a(View view, int indicators, int mask) {
    }

    public void e(View view, int offset) {
        fc.b(view, offset);
    }

    public void f(View view, int offset) {
        fc.a(view, offset);
    }
}
