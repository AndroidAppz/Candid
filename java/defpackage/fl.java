package defpackage;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.view.View;
import android.view.ViewParent;
import android.view.WindowInsets;

/* compiled from: ViewCompatLollipop */
class fl {
    private static ThreadLocal<Rect> a;

    public static void a(View view) {
        view.requestApplyInsets();
    }

    public static void a(View view, float elevation) {
        view.setElevation(elevation);
    }

    public static float b(View view) {
        return view.getElevation();
    }

    public static float c(View view) {
        return view.getTranslationZ();
    }

    public static void a(View view, eu listener) {
        if (listener == null) {
            view.setOnApplyWindowInsetsListener(null);
        } else {
            view.setOnApplyWindowInsetsListener(new fl$1(listener));
        }
    }

    static ColorStateList d(View view) {
        return view.getBackgroundTintList();
    }

    static void a(View view, ColorStateList tintList) {
        view.setBackgroundTintList(tintList);
        if (VERSION.SDK_INT == 21) {
            Drawable background = view.getBackground();
            boolean hasTint = (view.getBackgroundTintList() == null || view.getBackgroundTintMode() == null) ? false : true;
            if (background != null && hasTint) {
                if (background.isStateful()) {
                    background.setState(view.getDrawableState());
                }
                view.setBackground(background);
            }
        }
    }

    static Mode e(View view) {
        return view.getBackgroundTintMode();
    }

    static void a(View view, Mode mode) {
        view.setBackgroundTintMode(mode);
        if (VERSION.SDK_INT == 21) {
            Drawable background = view.getBackground();
            boolean hasTint = (view.getBackgroundTintList() == null || view.getBackgroundTintMode() == null) ? false : true;
            if (background != null && hasTint) {
                if (background.isStateful()) {
                    background.setState(view.getDrawableState());
                }
                view.setBackground(background);
            }
        }
    }

    public static gc a(View v, gc insets) {
        if (!(insets instanceof gd)) {
            return insets;
        }
        WindowInsets unwrapped = ((gd) insets).g();
        WindowInsets result = v.onApplyWindowInsets(unwrapped);
        if (result != unwrapped) {
            return new gd(result);
        }
        return insets;
    }

    public static gc b(View v, gc insets) {
        if (!(insets instanceof gd)) {
            return insets;
        }
        WindowInsets unwrapped = ((gd) insets).g();
        WindowInsets result = v.dispatchApplyWindowInsets(unwrapped);
        if (result != unwrapped) {
            return new gd(result);
        }
        return insets;
    }

    public static boolean f(View view) {
        return view.isNestedScrollingEnabled();
    }

    public static void g(View view) {
        view.stopNestedScroll();
    }

    public static float h(View view) {
        return view.getZ();
    }

    static void a(View view, int offset) {
        Rect parentRect = fl.a();
        boolean needInvalidateWorkaround = false;
        ViewParent parent = view.getParent();
        if (parent instanceof View) {
            View p = (View) parent;
            parentRect.set(p.getLeft(), p.getTop(), p.getRight(), p.getBottom());
            needInvalidateWorkaround = !parentRect.intersects(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
        }
        ff.a(view, offset);
        if (needInvalidateWorkaround && parentRect.intersect(view.getLeft(), view.getTop(), view.getRight(), view.getBottom())) {
            ((View) parent).invalidate(parentRect);
        }
    }

    static void b(View view, int offset) {
        Rect parentRect = fl.a();
        boolean needInvalidateWorkaround = false;
        ViewParent parent = view.getParent();
        if (parent instanceof View) {
            View p = (View) parent;
            parentRect.set(p.getLeft(), p.getTop(), p.getRight(), p.getBottom());
            needInvalidateWorkaround = !parentRect.intersects(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
        }
        ff.b(view, offset);
        if (needInvalidateWorkaround && parentRect.intersect(view.getLeft(), view.getTop(), view.getRight(), view.getBottom())) {
            ((View) parent).invalidate(parentRect);
        }
    }

    private static Rect a() {
        if (a == null) {
            a = new ThreadLocal();
        }
        Rect rect = (Rect) a.get();
        if (rect == null) {
            rect = new Rect();
            a.set(rect);
        }
        rect.setEmpty();
        return rect;
    }
}
