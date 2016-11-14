package defpackage;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.LayoutInflater.Factory;
import android.view.LayoutInflater.Factory2;
import java.lang.reflect.Field;

/* compiled from: LayoutInflaterCompatHC */
class ee {
    private static Field a;
    private static boolean b;

    static void a(LayoutInflater inflater, eg factory) {
        Factory2 factory2 = factory != null ? new ee$a(factory) : null;
        inflater.setFactory2(factory2);
        Factory f = inflater.getFactory();
        if (f instanceof Factory2) {
            ee.a(inflater, (Factory2) f);
        } else {
            ee.a(inflater, factory2);
        }
    }

    static void a(LayoutInflater inflater, Factory2 factory) {
        if (!b) {
            try {
                a = LayoutInflater.class.getDeclaredField("mFactory2");
                a.setAccessible(true);
            } catch (NoSuchFieldException e) {
                Log.e("LayoutInflaterCompatHC", "forceSetFactory2 Could not find field 'mFactory2' on class " + LayoutInflater.class.getName() + "; inflation may have unexpected results.", e);
            }
            b = true;
        }
        if (a != null) {
            try {
                a.set(inflater, factory);
            } catch (IllegalAccessException e2) {
                Log.e("LayoutInflaterCompatHC", "forceSetFactory2 could not set the Factory2 on LayoutInflater " + inflater + "; inflation may have unexpected results.", e2);
            }
        }
    }
}
