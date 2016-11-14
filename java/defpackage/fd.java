package defpackage;

import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* compiled from: ViewCompatEclairMr1 */
class fd {
    private static Method a;

    public static boolean a(View view) {
        return view.isOpaque();
    }

    public static void a(ViewGroup viewGroup, boolean enabled) {
        if (a == null) {
            try {
                a = ViewGroup.class.getDeclaredMethod("setChildrenDrawingOrderEnabled", new Class[]{Boolean.TYPE});
            } catch (NoSuchMethodException e) {
                Log.e("ViewCompat", "Unable to find childrenDrawingOrderEnabled", e);
            }
            a.setAccessible(true);
        }
        try {
            a.invoke(viewGroup, new Object[]{Boolean.valueOf(enabled)});
        } catch (IllegalAccessException e2) {
            Log.e("ViewCompat", "Unable to invoke childrenDrawingOrderEnabled", e2);
        } catch (IllegalArgumentException e3) {
            Log.e("ViewCompat", "Unable to invoke childrenDrawingOrderEnabled", e3);
        } catch (InvocationTargetException e4) {
            Log.e("ViewCompat", "Unable to invoke childrenDrawingOrderEnabled", e4);
        }
    }
}
