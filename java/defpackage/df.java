package defpackage;

import android.os.Build.VERSION;
import java.util.Locale;

/* compiled from: TextUtilsCompat */
public final class df {
    public static final Locale a = new Locale("", "");
    private static final df$a b;
    private static String c = "Arab";
    private static String d = "Hebr";

    static {
        if (VERSION.SDK_INT >= 17) {
            b = new df$b(null);
        } else {
            b = new df$a(null);
        }
    }

    public static int a(Locale locale) {
        return b.a(locale);
    }
}
