package defpackage;

import android.util.Log;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Locale;

/* compiled from: ICUCompatIcs */
class dc {
    private static Method a;
    private static Method b;

    static {
        try {
            Class<?> clazz = Class.forName("libcore.icu.ICU");
            if (clazz != null) {
                a = clazz.getMethod("getScript", new Class[]{String.class});
                b = clazz.getMethod("addLikelySubtags", new Class[]{String.class});
            }
        } catch (Exception e) {
            a = null;
            b = null;
            Log.w("ICUCompatIcs", e);
        }
    }

    public static String a(Locale locale) {
        String localeWithSubtags = dc.b(locale);
        if (localeWithSubtags != null) {
            return dc.a(localeWithSubtags);
        }
        return null;
    }

    private static String a(String localeStr) {
        try {
            if (a != null) {
                return (String) a.invoke(null, new Object[]{localeStr});
            }
        } catch (IllegalAccessException e) {
            Log.w("ICUCompatIcs", e);
        } catch (InvocationTargetException e2) {
            Log.w("ICUCompatIcs", e2);
        }
        return null;
    }

    private static String b(Locale locale) {
        String localeStr = locale.toString();
        try {
            if (b != null) {
                return (String) b.invoke(null, new Object[]{localeStr});
            }
        } catch (IllegalAccessException e) {
            Log.w("ICUCompatIcs", e);
        } catch (InvocationTargetException e2) {
            Log.w("ICUCompatIcs", e2);
        }
        return localeStr;
    }
}
