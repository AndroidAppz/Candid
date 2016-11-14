/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.os.Build
 *  android.os.Build$VERSION
 *  java.lang.Object
 *  java.lang.String
 *  java.util.Locale
 */
import android.os.Build;
import java.util.Locale;

public final class da {
    private static final a a;

    static {
        int n2 = Build.VERSION.SDK_INT;
        a = n2 >= 21 ? new d() : (n2 >= 14 ? new c() : new b());
    }

    public static String a(Locale locale) {
        return a.a(locale);
    }

    static interface a {
        public String a(Locale var1);
    }

    static class b
    implements a {
        b() {
        }

        @Override
        public String a(Locale locale) {
            return null;
        }
    }

    static class c
    implements a {
        c() {
        }

        @Override
        public String a(Locale locale) {
            return dc.a(locale);
        }
    }

    static class d
    implements a {
        d() {
        }

        @Override
        public String a(Locale locale) {
            return db.a(locale);
        }
    }

}

