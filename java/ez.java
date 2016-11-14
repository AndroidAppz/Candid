/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.os.Build
 *  android.os.Build$VERSION
 *  android.view.VelocityTracker
 *  java.lang.Object
 */
import android.os.Build;
import android.view.VelocityTracker;

public final class ez {
    static final c a = Build.VERSION.SDK_INT >= 11 ? new b() : new a();

    public static float a(VelocityTracker velocityTracker, int n2) {
        return a.a(velocityTracker, n2);
    }

    public static float b(VelocityTracker velocityTracker, int n2) {
        return a.b(velocityTracker, n2);
    }

    static class a
    implements c {
        a() {
        }

        @Override
        public float a(VelocityTracker velocityTracker, int n2) {
            return velocityTracker.getXVelocity();
        }

        @Override
        public float b(VelocityTracker velocityTracker, int n2) {
            return velocityTracker.getYVelocity();
        }
    }

    static class b
    implements c {
        b() {
        }

        @Override
        public float a(VelocityTracker velocityTracker, int n2) {
            return fa.a(velocityTracker, n2);
        }

        @Override
        public float b(VelocityTracker velocityTracker, int n2) {
            return fa.b(velocityTracker, n2);
        }
    }

    static interface c {
        public float a(VelocityTracker var1, int var2);

        public float b(VelocityTracker var1, int var2);
    }

}

