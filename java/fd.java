/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.util.Log
 *  android.view.View
 *  android.view.ViewGroup
 *  java.lang.Boolean
 *  java.lang.Class
 *  java.lang.IllegalAccessException
 *  java.lang.IllegalArgumentException
 *  java.lang.NoSuchMethodException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.Throwable
 *  java.lang.reflect.InvocationTargetException
 *  java.lang.reflect.Method
 */
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

class fd {
    private static Method a;

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static void a(ViewGroup viewGroup, boolean bl2) {
        if (a == null) {
            try {
                Class[] arrclass = new Class[]{Boolean.TYPE};
                a = ViewGroup.class.getDeclaredMethod("setChildrenDrawingOrderEnabled", arrclass);
            }
            catch (NoSuchMethodException var11_5) {
                Log.e((String)"ViewCompat", (String)"Unable to find childrenDrawingOrderEnabled", (Throwable)var11_5);
            }
            a.setAccessible(true);
        }
        try {
            Method method = a;
            Object[] arrobject = new Object[]{bl2};
            method.invoke((Object)viewGroup, arrobject);
            return;
        }
        catch (IllegalAccessException var6_6) {
            Log.e((String)"ViewCompat", (String)"Unable to invoke childrenDrawingOrderEnabled", (Throwable)var6_6);
            return;
        }
        catch (IllegalArgumentException var4_7) {
            Log.e((String)"ViewCompat", (String)"Unable to invoke childrenDrawingOrderEnabled", (Throwable)var4_7);
            return;
        }
        catch (InvocationTargetException var2_8) {
            Log.e((String)"ViewCompat", (String)"Unable to invoke childrenDrawingOrderEnabled", (Throwable)var2_8);
            return;
        }
    }

    public static boolean a(View view) {
        return view.isOpaque();
    }
}

