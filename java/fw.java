/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.animation.Animator
 *  android.animation.Animator$AnimatorListener
 *  android.animation.AnimatorListenerAdapter
 *  android.animation.TimeInterpolator
 *  android.view.View
 *  android.view.ViewPropertyAnimator
 *  android.view.animation.Interpolator
 *  java.lang.Object
 */
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.TimeInterpolator;
import android.view.View;
import android.view.ViewPropertyAnimator;
import android.view.animation.Interpolator;

class fw {
    public static long a(View view) {
        return view.animate().getDuration();
    }

    public static void a(View view, float f2) {
        view.animate().alpha(f2);
    }

    public static void a(View view, long l2) {
        view.animate().setDuration(l2);
    }

    public static void a(View view, Interpolator interpolator) {
        view.animate().setInterpolator((TimeInterpolator)interpolator);
    }

    public static void a(final View view, final fz fz2) {
        if (fz2 != null) {
            view.animate().setListener((Animator.AnimatorListener)new AnimatorListenerAdapter(){

                public void onAnimationCancel(Animator animator) {
                    fz2.onAnimationCancel(view);
                }

                public void onAnimationEnd(Animator animator) {
                    fz2.onAnimationEnd(view);
                }

                public void onAnimationStart(Animator animator) {
                    fz2.onAnimationStart(view);
                }
            });
            return;
        }
        view.animate().setListener(null);
    }

    public static void b(View view) {
        view.animate().cancel();
    }

    public static void b(View view, float f2) {
        view.animate().translationX(f2);
    }

    public static void b(View view, long l2) {
        view.animate().setStartDelay(l2);
    }

    public static void c(View view) {
        view.animate().start();
    }

    public static void c(View view, float f2) {
        view.animate().translationY(f2);
    }

}

