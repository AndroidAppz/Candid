package defpackage;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.View;

/* compiled from: ViewPropertyAnimatorCompatKK */
class fy$1 implements AnimatorUpdateListener {
    final /* synthetic */ gb a;
    final /* synthetic */ View b;

    fy$1(gb gbVar, View view) {
        this.a = gbVar;
        this.b = view;
    }

    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        this.a.onAnimationUpdate(this.b);
    }
}
