package defpackage;

import android.view.VelocityTracker;

/* compiled from: VelocityTrackerCompat */
class ez$a implements ez$c {
    ez$a() {
    }

    public float a(VelocityTracker tracker, int pointerId) {
        return tracker.getXVelocity();
    }

    public float b(VelocityTracker tracker, int pointerId) {
        return tracker.getYVelocity();
    }
}
