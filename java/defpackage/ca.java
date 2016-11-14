package defpackage;

import android.graphics.drawable.Drawable;
import android.util.Log;
import java.lang.reflect.Method;

/* compiled from: DrawableCompatJellybeanMr1 */
class ca {
    private static Method a;
    private static boolean b;
    private static Method c;
    private static boolean d;

    public static void a(Drawable drawable, int layoutDirection) {
        if (!b) {
            try {
                a = Drawable.class.getDeclaredMethod("setLayoutDirection", new Class[]{Integer.TYPE});
                a.setAccessible(true);
            } catch (NoSuchMethodException e) {
                Log.i("DrawableCompatJellybeanMr1", "Failed to retrieve setLayoutDirection(int) method", e);
            }
            b = true;
        }
        if (a != null) {
            try {
                a.invoke(drawable, new Object[]{Integer.valueOf(layoutDirection)});
            } catch (Exception e2) {
                Log.i("DrawableCompatJellybeanMr1", "Failed to invoke setLayoutDirection(int) via reflection", e2);
                a = null;
            }
        }
    }

    public static int a(Drawable drawable) {
        if (!d) {
            try {
                c = Drawable.class.getDeclaredMethod("getLayoutDirection", new Class[0]);
                c.setAccessible(true);
            } catch (NoSuchMethodException e) {
                Log.i("DrawableCompatJellybeanMr1", "Failed to retrieve getLayoutDirection() method", e);
            }
            d = true;
        }
        if (c != null) {
            try {
                return ((Integer) c.invoke(drawable, new Object[0])).intValue();
            } catch (Exception e2) {
                Log.i("DrawableCompatJellybeanMr1", "Failed to invoke getLayoutDirection() via reflection", e2);
                c = null;
            }
        }
        return -1;
    }
}
