/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.animation.ValueAnimator
 *  android.animation.ValueAnimator$AnimatorUpdateListener
 *  android.view.View
 *  android.view.ViewPropertyAnimator
 *  java.lang.Object
 */
import android.animation.ValueAnimator;
import android.view.View;
import android.view.ViewPropertyAnimator;

class fy {
    public static void a(final View view, final gb gb2) {
        ValueAnimator.AnimatorUpdateListener animatorUpdateListener = null;
        if (gb2 != null) {
            animatorUpdateListener = new ValueAnimator.AnimatorUpdateListener(){

                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    gb2.onAnimationUpdate(view);
                }
            };
        }
        view.animate().setUpdateListener(animatorUpdateListener);
    }

}

