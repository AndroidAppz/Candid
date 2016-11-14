/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.os.Build
 *  android.os.Build$VERSION
 *  android.view.KeyEvent
 *  java.lang.IllegalArgumentException
 *  java.lang.Object
 *  java.lang.String
 */
import android.os.Build;
import android.view.KeyEvent;

public final class dz {
    static final d a = Build.VERSION.SDK_INT >= 11 ? new c() : new a();

    public static boolean a(KeyEvent keyEvent) {
        return a.b(keyEvent.getMetaState());
    }

    public static boolean a(KeyEvent keyEvent, int n2) {
        return a.a(keyEvent.getMetaState(), n2);
    }

    public static void b(KeyEvent keyEvent) {
        a.a(keyEvent);
    }

    static class a
    implements d {
        a() {
        }

        /*
         * Enabled aggressive block sorting
         */
        private static int a(int n2, int n3, int n4, int n5, int n6) {
            boolean bl2 = true;
            boolean bl3 = (n3 & n4) != 0 ? bl2 : false;
            int n7 = n5 | n6;
            if ((n3 & n7) == 0) return n2;
            if (!bl3) return n2;
            if (bl2) {
                throw new IllegalArgumentException("bad arguments");
            }
            n2 &= ~ n7;
            return n2;
        }

        public int a(int n2) {
            if ((n2 & 192) != 0) {
                n2 |= 1;
            }
            if ((n2 & 48) != 0) {
                n2 |= 2;
            }
            return n2 & 247;
        }

        @Override
        public void a(KeyEvent keyEvent) {
        }

        @Override
        public boolean a(int n2, int n3) {
            if (a.a(a.a(247 & this.a(n2), n3, 1, 64, 128), n3, 2, 16, 32) == n3) {
                return true;
            }
            return false;
        }

        @Override
        public boolean b(int n2) {
            if ((247 & this.a(n2)) == 0) {
                return true;
            }
            return false;
        }
    }

    static class b
    extends a {
        b() {
        }

        @Override
        public void a(KeyEvent keyEvent) {
            ea.a(keyEvent);
        }
    }

    static class c
    extends b {
        c() {
        }

        @Override
        public int a(int n2) {
            return eb.a(n2);
        }

        @Override
        public boolean a(int n2, int n3) {
            return eb.a(n2, n3);
        }

        @Override
        public boolean b(int n2) {
            return eb.b(n2);
        }
    }

    static interface d {
        public void a(KeyEvent var1);

        public boolean a(int var1, int var2);

        public boolean b(int var1);
    }

}

