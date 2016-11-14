package defpackage;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;

/* compiled from: ValueAnimatorCompatImplHoneycombMr1 */
class ad$1 implements AnimatorUpdateListener {
    final /* synthetic */ ab$e$b a;
    final /* synthetic */ ad b;

    ad$1(ad adVar, ab$e$b ab_e_b) {
        this.b = adVar;
        this.a = ab_e_b;
    }

    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        this.a.a();
    }
}
