package defpackage;

import android.view.View;
import android.view.animation.Interpolator;

/* compiled from: ViewPropertyAnimatorCompatICS */
class fw {
    public static void a(View view, long value) {
        view.animate().setDuration(value);
    }

    public static void a(View view, float value) {
        view.animate().alpha(value);
    }

    public static void b(View view, float value) {
        view.animate().translationX(value);
    }

    public static void c(View view, float value) {
        view.animate().translationY(value);
    }

    public static long a(View view) {
        return view.animate().getDuration();
    }

    public static void a(View view, Interpolator value) {
        view.animate().setInterpolator(value);
    }

    public static void b(View view, long value) {
        view.animate().setStartDelay(value);
    }

    public static void b(View view) {
        view.animate().cancel();
    }

    public static void c(View view) {
        view.animate().start();
    }

    public static void a(View view, fz listener) {
        if (listener != null) {
            view.animate().setListener(new fw$1(listener, view));
        } else {
            view.animate().setListener(null);
        }
    }
}
