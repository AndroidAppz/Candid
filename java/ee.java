/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.util.AttributeSet
 *  android.util.Log
 *  android.view.LayoutInflater
 *  android.view.LayoutInflater$Factory
 *  android.view.LayoutInflater$Factory2
 *  android.view.View
 *  java.lang.IllegalAccessException
 *  java.lang.NoSuchFieldException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.Throwable
 *  java.lang.reflect.Field
 */
import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import java.lang.reflect.Field;

class ee {
    private static Field a;
    private static boolean b;

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    static void a(LayoutInflater layoutInflater, LayoutInflater.Factory2 factory2) {
        if (!b) {
            try {
                a = LayoutInflater.class.getDeclaredField("mFactory2");
                a.setAccessible(true);
            }
            catch (NoSuchFieldException var4_2) {
                Log.e((String)"LayoutInflaterCompatHC", (String)("forceSetFactory2 Could not find field 'mFactory2' on class " + LayoutInflater.class.getName() + "; inflation may have unexpected results."), (Throwable)var4_2);
            }
            b = true;
        }
        if (a == null) return;
        try {
            a.set((Object)layoutInflater, (Object)factory2);
            return;
        }
        catch (IllegalAccessException var2_3) {
            Log.e((String)"LayoutInflaterCompatHC", (String)("forceSetFactory2 could not set the Factory2 on LayoutInflater " + (Object)layoutInflater + "; inflation may have unexpected results."), (Throwable)var2_3);
            return;
        }
    }

    /*
     * Enabled aggressive block sorting
     */
    static void a(LayoutInflater layoutInflater, eg eg2) {
        a a2 = eg2 != null ? new a(eg2) : null;
        layoutInflater.setFactory2((LayoutInflater.Factory2)a2);
        LayoutInflater.Factory factory = layoutInflater.getFactory();
        if (factory instanceof LayoutInflater.Factory2) {
            ee.a(layoutInflater, (LayoutInflater.Factory2)factory);
            return;
        }
        ee.a(layoutInflater, a2);
    }

    static class a
    extends ed.a
    implements LayoutInflater.Factory2 {
        a(eg eg2) {
            super(eg2);
        }

        public View onCreateView(View view, String string2, Context context, AttributeSet attributeSet) {
            return this.a.onCreateView(view, string2, context, attributeSet);
        }
    }

}

