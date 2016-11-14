package defpackage;

import android.os.Build.VERSION;
import java.util.Locale;

/* compiled from: ICUCompat */
public final class da {
    private static final da$a a;

    static {
        int version = VERSION.SDK_INT;
        if (version >= 21) {
            a = new da$d();
        } else if (version >= 14) {
            a = new da$c();
        } else {
            a = new da$b();
        }
    }

    public static String a(Locale locale) {
        return a.a(locale);
    }
}
