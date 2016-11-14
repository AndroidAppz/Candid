/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.animation.Animator
 *  android.animation.Animator$AnimatorListener
 *  android.animation.AnimatorListenerAdapter
 *  android.view.View
 *  android.view.ViewPropertyAnimator
 *  java.lang.Object
 */
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import android.view.ViewPropertyAnimator;

class fx {
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

}

