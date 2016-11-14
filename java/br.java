/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.content.SharedPreferences
 *  android.content.SharedPreferences$Editor
 *  android.os.Build
 *  android.os.Build$VERSION
 *  java.lang.Object
 */
import android.content.SharedPreferences;
import android.os.Build;

public final class br {

    public static final class br$a {
        private static br$a a;
        private final c b;

        private br$a() {
            if (Build.VERSION.SDK_INT >= 9) {
                this.b = new a(null);
                return;
            }
            this.b = new b(null);
        }

        public static br$a a() {
            if (a == null) {
                a = new br$a();
            }
            return a;
        }

        public void a(SharedPreferences.Editor editor) {
            this.b.a(editor);
        }

        static class a
        implements c {
            private a() {
            }

            /* synthetic */ a( var1) {
            }

            @Override
            public void a(SharedPreferences.Editor editor) {
                bi.a(editor);
            }
        }

        static class b
        implements c {
            private b() {
            }

            /* synthetic */ b( var1) {
            }

            @Override
            public void a(SharedPreferences.Editor editor) {
                editor.commit();
            }
        }

        static interface c {
            public void a(SharedPreferences.Editor var1);
        }

    }

}

