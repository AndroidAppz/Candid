package defpackage;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.view.View;
import android.view.ViewParent;
import java.lang.reflect.Field;

/* compiled from: ViewCompatBase */
class fc {
    private static Field a;
    private static boolean b;
    private static Field c;
    private static boolean d;

    static ColorStateList a(View view) {
        return view instanceof ey ? ((ey) view).getSupportBackgroundTintList() : null;
    }

    static void a(View view, ColorStateList tintList) {
        if (view instanceof ey) {
            ((ey) view).setSupportBackgroundTintList(tintList);
        }
    }

    static Mode b(View view) {
        return view instanceof ey ? ((ey) view).getSupportBackgroundTintMode() : null;
    }

    static void a(View view, Mode mode) {
        if (view instanceof ey) {
            ((ey) view).setSupportBackgroundTintMode(mode);
        }
    }

    static boolean c(View view) {
        return view.getWidth() > 0 && view.getHeight() > 0;
    }

    static int d(View view) {
        if (!b) {
            try {
                a = View.class.getDeclaredField("mMinWidth");
                a.setAccessible(true);
            } catch (NoSuchFieldException e) {
            }
            b = true;
        }
        if (a != null) {
            try {
                return ((Integer) a.get(view)).intValue();
            } catch (Exception e2) {
            }
        }
        return 0;
    }

    static int e(View view) {
        if (!d) {
            try {
                c = View.class.getDeclaredField("mMinHeight");
                c.setAccessible(true);
            } catch (NoSuchFieldException e) {
            }
            d = true;
        }
        if (c != null) {
            try {
                return ((Integer) c.get(view)).intValue();
            } catch (Exception e2) {
            }
        }
        return 0;
    }

    static boolean f(View view) {
        return view.getWindowToken() != null;
    }

    static void a(View view, int offset) {
        int currentTop = view.getTop();
        view.offsetTopAndBottom(offset);
        if (offset != 0) {
            ViewParent parent = view.getParent();
            if (parent instanceof View) {
                int absOffset = Math.abs(offset);
                ((View) parent).invalidate(view.getLeft(), currentTop - absOffset, view.getRight(), (view.getHeight() + currentTop) + absOffset);
                return;
            }
            view.invalidate();
        }
    }

    static void b(View view, int offset) {
        int currentLeft = view.getLeft();
        view.offsetLeftAndRight(offset);
        if (offset != 0) {
            ViewParent parent = view.getParent();
            if (parent instanceof View) {
                int absOffset = Math.abs(offset);
                ((View) parent).invalidate(currentLeft - absOffset, view.getTop(), (view.getWidth() + currentLeft) + absOffset, view.getBottom());
                return;
            }
            view.invalidate();
        }
    }
}
