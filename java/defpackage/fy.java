package defpackage;

import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.View;

/* compiled from: ViewPropertyAnimatorCompatKK */
class fy {
    public static void a(View view, gb listener) {
        AnimatorUpdateListener wrapped = null;
        if (listener != null) {
            wrapped = new fy$1(listener, view);
        }
        view.animate().setUpdateListener(wrapped);
    }
}
