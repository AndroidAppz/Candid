package defpackage;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;

/* compiled from: HoneycombMr1AnimatorCompatProvider */
class az$b$1 implements AnimatorUpdateListener {
    final /* synthetic */ ax a;
    final /* synthetic */ az$b b;

    az$b$1(az$b az_b, ax axVar) {
        this.b = az_b;
        this.a = axVar;
    }

    public void onAnimationUpdate(ValueAnimator animation) {
        this.a.onAnimationUpdate(this.b);
    }
}
