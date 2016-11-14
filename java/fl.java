/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.content.res.ColorStateList
 *  android.graphics.PorterDuff
 *  android.graphics.PorterDuff$Mode
 *  android.graphics.Rect
 *  android.graphics.drawable.Drawable
 *  android.os.Build
 *  android.os.Build$VERSION
 *  android.view.View
 *  android.view.View$OnApplyWindowInsetsListener
 *  android.view.ViewParent
 *  android.view.WindowInsets
 *  java.lang.Object
 *  java.lang.ThreadLocal
 */
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.view.View;
import android.view.ViewParent;
import android.view.WindowInsets;

class fl {
    private static ThreadLocal<Rect> a;

    private static Rect a() {
        Rect rect;
        if (a == null) {
            a = new ThreadLocal();
        }
        if ((rect = (Rect)a.get()) == null) {
            rect = new Rect();
            a.set((Object)rect);
        }
        rect.setEmpty();
        return rect;
    }

    public static gc a(View view, gc gc2) {
        WindowInsets windowInsets;
        WindowInsets windowInsets2;
        if (gc2 instanceof gd && (windowInsets = view.onApplyWindowInsets(windowInsets2 = ((gd)gc2).g())) != windowInsets2) {
            gc2 = new gd(windowInsets);
        }
        return gc2;
    }

    public static void a(View view) {
        view.requestApplyInsets();
    }

    public static void a(View view, float f2) {
        view.setElevation(f2);
    }

    /*
     * Enabled aggressive block sorting
     */
    static void a(View view, int n2) {
        Rect rect = fl.a();
        ViewParent viewParent = view.getParent();
        boolean bl2 = viewParent instanceof View;
        boolean bl3 = false;
        if (bl2) {
            View view2 = (View)viewParent;
            rect.set(view2.getLeft(), view2.getTop(), view2.getRight(), view2.getBottom());
            bl3 = !rect.intersects(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
        }
        ff.a(view, n2);
        if (bl3 && rect.intersect(view.getLeft(), view.getTop(), view.getRight(), view.getBottom())) {
            ((View)viewParent).invalidate(rect);
        }
    }

    /*
     * Enabled aggressive block sorting
     */
    static void a(View view, ColorStateList colorStateList) {
        view.setBackgroundTintList(colorStateList);
        if (Build.VERSION.SDK_INT == 21) {
            Drawable drawable = view.getBackground();
            boolean bl2 = view.getBackgroundTintList() != null && view.getBackgroundTintMode() != null;
            if (drawable == null) return;
            if (bl2) {
                if (drawable.isStateful()) {
                    drawable.setState(view.getDrawableState());
                }
                view.setBackground(drawable);
            }
        }
    }

    /*
     * Enabled aggressive block sorting
     */
    static void a(View view, PorterDuff.Mode mode) {
        view.setBackgroundTintMode(mode);
        if (Build.VERSION.SDK_INT == 21) {
            Drawable drawable = view.getBackground();
            boolean bl2 = view.getBackgroundTintList() != null && view.getBackgroundTintMode() != null;
            if (drawable == null) return;
            if (bl2) {
                if (drawable.isStateful()) {
                    drawable.setState(view.getDrawableState());
                }
                view.setBackground(drawable);
            }
        }
    }

    public static void a(View view, final eu eu2) {
        if (eu2 == null) {
            view.setOnApplyWindowInsetsListener(null);
            return;
        }
        view.setOnApplyWindowInsetsListener(new View.OnApplyWindowInsetsListener(){

            public WindowInsets onApplyWindowInsets(View view, WindowInsets windowInsets) {
                gd gd2 = new gd(windowInsets);
                return ((gd)eu2.onApplyWindowInsets(view, gd2)).g();
            }
        });
    }

    public static float b(View view) {
        return view.getElevation();
    }

    public static gc b(View view, gc gc2) {
        WindowInsets windowInsets;
        WindowInsets windowInsets2;
        if (gc2 instanceof gd && (windowInsets = view.dispatchApplyWindowInsets(windowInsets2 = ((gd)gc2).g())) != windowInsets2) {
            gc2 = new gd(windowInsets);
        }
        return gc2;
    }

    /*
     * Enabled aggressive block sorting
     */
    static void b(View view, int n2) {
        Rect rect = fl.a();
        ViewParent viewParent = view.getParent();
        boolean bl2 = viewParent instanceof View;
        boolean bl3 = false;
        if (bl2) {
            View view2 = (View)viewParent;
            rect.set(view2.getLeft(), view2.getTop(), view2.getRight(), view2.getBottom());
            bl3 = !rect.intersects(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
        }
        ff.b(view, n2);
        if (bl3 && rect.intersect(view.getLeft(), view.getTop(), view.getRight(), view.getBottom())) {
            ((View)viewParent).invalidate(rect);
        }
    }

    public static float c(View view) {
        return view.getTranslationZ();
    }

    static ColorStateList d(View view) {
        return view.getBackgroundTintList();
    }

    static PorterDuff.Mode e(View view) {
        return view.getBackgroundTintMode();
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

}

