package defpackage;

import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;

/* compiled from: AnimationUtils */
public class k {
    public static final Interpolator a = new LinearInterpolator();
    public static final Interpolator b = new gx();
    public static final Interpolator c = new gw();
    public static final Interpolator d = new gy();
    public static final Interpolator e = new DecelerateInterpolator();

    static float a(float startValue, float endValue, float fraction) {
        return ((endValue - startValue) * fraction) + startValue;
    }

    public static int a(int startValue, int endValue, float fraction) {
        return Math.round(((float) (endValue - startValue)) * fraction) + startValue;
    }
}
