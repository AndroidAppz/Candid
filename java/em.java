/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.os.Build
 *  android.os.Build$VERSION
 *  android.view.MotionEvent
 *  java.lang.IndexOutOfBoundsException
 *  java.lang.Object
 *  java.lang.String
 */
import android.os.Build;
import android.view.MotionEvent;

public final class em {
    static final e a = Build.VERSION.SDK_INT >= 12 ? new d() : (Build.VERSION.SDK_INT >= 9 ? new c() : (Build.VERSION.SDK_INT >= 5 ? new b() : new a()));

    public static int a(MotionEvent motionEvent) {
        return 255 & motionEvent.getAction();
    }

    public static int a(MotionEvent motionEvent, int n2) {
        return a.a(motionEvent, n2);
    }

    public static int b(MotionEvent motionEvent) {
        return (65280 & motionEvent.getAction()) >> 8;
    }

    public static int b(MotionEvent motionEvent, int n2) {
        return a.b(motionEvent, n2);
    }

    public static float c(MotionEvent motionEvent, int n2) {
        return a.c(motionEvent, n2);
    }

    public static int c(MotionEvent motionEvent) {
        return a.a(motionEvent);
    }

    public static float d(MotionEvent motionEvent, int n2) {
        return a.d(motionEvent, n2);
    }

    public static int d(MotionEvent motionEvent) {
        return a.b(motionEvent);
    }

    public static float e(MotionEvent motionEvent, int n2) {
        return a.e(motionEvent, n2);
    }

    static class a
    implements e {
        a() {
        }

        @Override
        public int a(MotionEvent motionEvent) {
            return 1;
        }

        @Override
        public int a(MotionEvent motionEvent, int n2) {
            if (n2 == 0) {
                return 0;
            }
            return -1;
        }

        @Override
        public int b(MotionEvent motionEvent) {
            return 0;
        }

        @Override
        public int b(MotionEvent motionEvent, int n2) {
            if (n2 == 0) {
                return 0;
            }
            throw new IndexOutOfBoundsException("Pre-Eclair does not support multiple pointers");
        }

        @Override
        public float c(MotionEvent motionEvent, int n2) {
            if (n2 == 0) {
                return motionEvent.getX();
            }
            throw new IndexOutOfBoundsException("Pre-Eclair does not support multiple pointers");
        }

        @Override
        public float d(MotionEvent motionEvent, int n2) {
            if (n2 == 0) {
                return motionEvent.getY();
            }
            throw new IndexOutOfBoundsException("Pre-Eclair does not support multiple pointers");
        }

        @Override
        public float e(MotionEvent motionEvent, int n2) {
            return 0.0f;
        }
    }

    static class b
    extends a {
        b() {
        }

        @Override
        public int a(MotionEvent motionEvent) {
            return en.a(motionEvent);
        }

        @Override
        public int a(MotionEvent motionEvent, int n2) {
            return en.a(motionEvent, n2);
        }

        @Override
        public int b(MotionEvent motionEvent, int n2) {
            return en.b(motionEvent, n2);
        }

        @Override
        public float c(MotionEvent motionEvent, int n2) {
            return en.c(motionEvent, n2);
        }

        @Override
        public float d(MotionEvent motionEvent, int n2) {
            return en.d(motionEvent, n2);
        }
    }

    static class c
    extends b {
        c() {
        }

        @Override
        public int b(MotionEvent motionEvent) {
            return eo.a(motionEvent);
        }
    }

    static class d
    extends c {
        d() {
        }

        @Override
        public float e(MotionEvent motionEvent, int n2) {
            return ep.a(motionEvent, n2);
        }
    }

    static interface e {
        public int a(MotionEvent var1);

        public int a(MotionEvent var1, int var2);

        public int b(MotionEvent var1);

        public int b(MotionEvent var1, int var2);

        public float c(MotionEvent var1, int var2);

        public float d(MotionEvent var1, int var2);

        public float e(MotionEvent var1, int var2);
    }

}

