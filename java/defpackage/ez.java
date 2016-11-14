package defpackage;

import android.os.Build.VERSION;
import android.view.VelocityTracker;

/* compiled from: VelocityTrackerCompat */
public final class ez {
    static final ez$c a;

    static {
        if (VERSION.SDK_INT >= 11) {
            a = new ez$b();
        } else {
            a = new ez$a();
        }
    }

    public static float a(VelocityTracker tracker, int pointerId) {
        return a.a(tracker, pointerId);
    }

    public static float b(VelocityTracker tracker, int pointerId) {
        return a.b(tracker, pointerId);
    }
}
