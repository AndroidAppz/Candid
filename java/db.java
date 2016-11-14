/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.util.Log
 *  java.lang.Class
 *  java.lang.Exception
 *  java.lang.IllegalAccessException
 *  java.lang.IllegalStateException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.Throwable
 *  java.lang.reflect.InvocationTargetException
 *  java.lang.reflect.Method
 *  java.util.Locale
 */
import android.util.Log;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Locale;

class db {
    private static Method a;

    static {
        try {
            a = Class.forName((String)"libcore.icu.ICU").getMethod("addLikelySubtags", new Class[]{Locale.class});
            return;
        }
        catch (Exception var0) {
            throw new IllegalStateException((Throwable)var0);
        }
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static String a(Locale locale) {
        try {
            Object[] arrobject = new Object[]{locale};
            return ((Locale)a.invoke((Object)null, arrobject)).getScript();
        }
        catch (InvocationTargetException var4_3) {
            Log.w((String)"ICUCompatIcs", (Throwable)var4_3);
            do {
                return locale.getScript();
                break;
            } while (true);
        }
        catch (IllegalAccessException var2_4) {
            Log.w((String)"ICUCompatIcs", (Throwable)var2_4);
            return locale.getScript();
        }
    }
}

