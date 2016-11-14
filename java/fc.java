/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.content.res.ColorStateList
 *  android.graphics.PorterDuff
 *  android.graphics.PorterDuff$Mode
 *  android.os.IBinder
 *  android.view.View
 *  android.view.ViewParent
 *  java.lang.Exception
 *  java.lang.Integer
 *  java.lang.Math
 *  java.lang.NoSuchFieldException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.reflect.Field
 */
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.os.IBinder;
import android.view.View;
import android.view.ViewParent;
import java.lang.reflect.Field;

class fc {
    private static Field a;
    private static boolean b;
    private static Field c;
    private static boolean d;

    static ColorStateList a(View view) {
        if (view instanceof ey) {
            return ((ey)view).getSupportBackgroundTintList();
        }
        return null;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    static void a(View view, int n2) {
        int n3 = view.getTop();
        view.offsetTopAndBottom(n2);
        if (n2 == 0) return;
        ViewParent viewParent = view.getParent();
        if (viewParent instanceof View) {
            int n4 = Math.abs((int)n2);
            ((View)viewParent).invalidate(view.getLeft(), n3 - n4, view.getRight(), n4 + (n3 + view.getHeight()));
            return;
        }
        view.invalidate();
    }

    static void a(View view, ColorStateList colorStateList) {
        if (view instanceof ey) {
            ((ey)view).setSupportBackgroundTintList(colorStateList);
        }
    }

    static void a(View view, PorterDuff.Mode mode) {
        if (view instanceof ey) {
            ((ey)view).setSupportBackgroundTintMode(mode);
        }
    }

    static PorterDuff.Mode b(View view) {
        if (view instanceof ey) {
            return ((ey)view).getSupportBackgroundTintMode();
        }
        return null;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    static void b(View view, int n2) {
        int n3 = view.getLeft();
        view.offsetLeftAndRight(n2);
        if (n2 == 0) return;
        ViewParent viewParent = view.getParent();
        if (viewParent instanceof View) {
            int n4 = Math.abs((int)n2);
            ((View)viewParent).invalidate(n3 - n4, view.getTop(), n4 + (n3 + view.getWidth()), view.getBottom());
            return;
        }
        view.invalidate();
    }

    static boolean c(View view) {
        if (view.getWidth() > 0 && view.getHeight() > 0) {
            return true;
        }
        return false;
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive exception aggregation
     */
    static int d(View var0) {
        if (fc.b) ** GOTO lbl9
        try {
            fc.a = View.class.getDeclaredField("mMinWidth");
            fc.a.setAccessible(true);
        }
        catch (NoSuchFieldException var3_3) {
            ** continue;
        }
lbl7: // 2 sources:
        do {
            fc.b = true;
lbl9: // 2 sources:
            if (fc.a != null) {
                try {
                    var2_1 = (Integer)fc.a.get((Object)var0);
                    return var2_1;
                }
                catch (Exception var1_2) {
                    // empty catch block
                }
            }
            return 0;
            break;
        } while (true);
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive exception aggregation
     */
    static int e(View var0) {
        if (fc.d) ** GOTO lbl9
        try {
            fc.c = View.class.getDeclaredField("mMinHeight");
            fc.c.setAccessible(true);
        }
        catch (NoSuchFieldException var3_3) {
            ** continue;
        }
lbl7: // 2 sources:
        do {
            fc.d = true;
lbl9: // 2 sources:
            if (fc.c != null) {
                try {
                    var2_1 = (Integer)fc.c.get((Object)var0);
                    return var2_1;
                }
                catch (Exception var1_2) {
                    // empty catch block
                }
            }
            return 0;
            break;
        } while (true);
    }

    static boolean f(View view) {
        if (view.getWindowToken() != null) {
            return true;
        }
        return false;
    }
}

