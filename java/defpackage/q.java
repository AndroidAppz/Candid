package defpackage;

import android.graphics.drawable.Drawable.ConstantState;
import android.graphics.drawable.DrawableContainer;
import android.graphics.drawable.DrawableContainer.DrawableContainerState;
import android.os.Build.VERSION;
import android.util.Log;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/* compiled from: DrawableUtils */
public class q {
    private static Method a;
    private static boolean b;
    private static Field c;
    private static boolean d;

    public static boolean a(DrawableContainer drawable, ConstantState constantState) {
        if (VERSION.SDK_INT >= 9) {
            return q.b(drawable, constantState);
        }
        return q.c(drawable, constantState);
    }

    private static boolean b(DrawableContainer drawable, ConstantState constantState) {
        if (!b) {
            try {
                a = DrawableContainer.class.getDeclaredMethod("setConstantState", new Class[]{DrawableContainerState.class});
                a.setAccessible(true);
            } catch (NoSuchMethodException e) {
                Log.e("DrawableUtils", "Could not fetch setConstantState(). Oh well.");
            }
            b = true;
        }
        if (a != null) {
            try {
                a.invoke(drawable, new Object[]{constantState});
                return true;
            } catch (Exception e2) {
                Log.e("DrawableUtils", "Could not invoke setConstantState(). Oh well.");
            }
        }
        return false;
    }

    private static boolean c(DrawableContainer drawable, ConstantState constantState) {
        if (!d) {
            try {
                c = DrawableContainer.class.getDeclaredField("mDrawableContainerStateField");
                c.setAccessible(true);
            } catch (NoSuchFieldException e) {
                Log.e("DrawableUtils", "Could not fetch mDrawableContainerStateField. Oh well.");
            }
            d = true;
        }
        if (c != null) {
            try {
                c.set(drawable, constantState);
                return true;
            } catch (Exception e2) {
                Log.e("DrawableUtils", "Could not set mDrawableContainerStateField. Oh well.");
            }
        }
        return false;
    }
}
