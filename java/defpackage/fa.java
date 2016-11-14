package defpackage;

import android.view.VelocityTracker;

/* compiled from: VelocityTrackerCompatHoneycomb */
class fa {
    public static float a(VelocityTracker tracker, int pointerId) {
        return tracker.getXVelocity(pointerId);
    }

    public static float b(VelocityTracker tracker, int pointerId) {
        return tracker.getYVelocity(pointerId);
    }
}
