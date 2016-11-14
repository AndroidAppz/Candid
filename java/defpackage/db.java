package defpackage;

import android.util.Log;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Locale;

/* compiled from: ICUCompatApi23 */
class db {
    private static Method a;

    static {
        try {
            a = Class.forName("libcore.icu.ICU").getMethod("addLikelySubtags", new Class[]{Locale.class});
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
    }

    public static String a(Locale locale) {
        try {
            return ((Locale) a.invoke(null, new Object[]{locale})).getScript();
        } catch (InvocationTargetException e) {
            Log.w("ICUCompatIcs", e);
            return locale.getScript();
        } catch (IllegalAccessException e2) {
            Log.w("ICUCompatIcs", e2);
            return locale.getScript();
        }
    }
}
