/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.os.Build
 *  android.os.Build$VERSION
 *  java.lang.Character
 *  java.lang.Object
 *  java.lang.String
 *  java.util.Locale
 */
import android.os.Build;
import java.util.Locale;

public final class df {
    public static final Locale a;
    private static final a b;
    private static String c;
    private static String d;

    /*
     * Enabled aggressive block sorting
     */
    static {
        b = Build.VERSION.SDK_INT >= 17 ? new b(null) : new a(null);
        a = new Locale("", "");
        c = "Arab";
        d = "Hebr";
    }

    public static int a(Locale locale) {
        return b.a(locale);
    }

    static class a {
        private a() {
        }

        /* synthetic */ a( var1) {
        }

        private static int b(Locale locale) {
            switch (Character.getDirectionality((char)locale.getDisplayName(locale).charAt(0))) {
                default: {
                    return 0;
                }
                case 1: 
                case 2: 
            }
            return 1;
        }

        public int a(Locale locale) {
            if (locale != null && !locale.equals((Object)df.a)) {
                String string2 = da.a(locale);
                if (string2 == null) {
                    return a.b(locale);
                }
                if (string2.equalsIgnoreCase(c) || string2.equalsIgnoreCase(d)) {
                    return 1;
                }
            }
            return 0;
        }
    }

    static class b
    extends a {
        private b() {
            super(null);
        }

        /* synthetic */ b( var1) {
        }

        @Override
        public int a(Locale locale) {
            return dg.a(locale);
        }
    }

}

