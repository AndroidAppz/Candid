/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.util.Log
 *  java.lang.Class
 *  java.lang.Exception
 *  java.lang.IllegalAccessException
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

class dc {
    private static Method a;
    private static Method b;

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    static {
        Class class_;
        try {
            class_ = Class.forName((String)"libcore.icu.ICU");
            if (class_ == null) return;
        }
        catch (Exception var0_1) {
            a = null;
            b = null;
            Log.w((String)"ICUCompatIcs", (Throwable)var0_1);
            return;
        }
        a = class_.getMethod("getScript", new Class[]{String.class});
        b = class_.getMethod("addLikelySubtags", new Class[]{String.class});
    }

    /*
     * Loose catch block
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    private static String a(String string2) {
        try {
            if (a == null) return null;
            Object[] arrobject = new Object[]{string2};
            return (String)a.invoke((Object)null, arrobject);
        }
        catch (IllegalAccessException var3_3) {
            Log.w((String)"ICUCompatIcs", (Throwable)var3_3);
        }
        return null;
        catch (InvocationTargetException invocationTargetException) {
            Log.w((String)"ICUCompatIcs", (Throwable)invocationTargetException);
            return null;
        }
    }

    public static String a(Locale locale) {
        String string2 = dc.b(locale);
        if (string2 != null) {
            return dc.a(string2);
        }
        return null;
    }

    /*
     * Loose catch block
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    private static String b(Locale locale) {
        String string2 = locale.toString();
        try {
            if (b == null) return string2;
            Object[] arrobject = new Object[]{string2};
            return (String)b.invoke((Object)null, arrobject);
        }
        catch (IllegalAccessException var4_4) {
            Log.w((String)"ICUCompatIcs", (Throwable)var4_4);
        }
        return string2;
        catch (InvocationTargetException invocationTargetException) {
            Log.w((String)"ICUCompatIcs", (Throwable)invocationTargetException);
            return string2;
        }
    }
}

