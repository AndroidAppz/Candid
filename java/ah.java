/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.os.Build
 *  android.os.Build$VERSION
 *  android.view.View
 *  java.lang.Object
 */
import android.os.Build;
import android.view.View;

public class ah {
    static final ab.d a = new ab.d(){

        /*
         * Enabled force condition propagation
         * Lifted jumps to return sites
         */
        @Override
        public ab a() {
            void var1_2;
            if (Build.VERSION.SDK_INT >= 12) {
                ad ad2 = new ad();
                do {
                    return new ab((ab.e)var1_2);
                    break;
                } while (true);
            }
            ac ac2 = new ac();
            return new ab((ab.e)var1_2);
        }
    };
    private static final a b = Build.VERSION.SDK_INT >= 21 ? new c(null) : new b(null);

    public static ab a() {
        return a.a();
    }

    public static void a(View view) {
        b.a(view);
    }

    static interface a {
        public void a(View var1);
    }

    static class b
    implements a {
        private b() {
        }

        /* synthetic */ b( var1) {
        }

        @Override
        public void a(View view) {
        }
    }

    static class c
    implements a {
        private c() {
        }

        /* synthetic */ c( var1) {
        }

        @Override
        public void a(View view) {
            ai.a(view);
        }
    }

}

