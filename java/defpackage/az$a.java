package defpackage;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;

/* compiled from: HoneycombMr1AnimatorCompatProvider */
class az$a implements AnimatorListener {
    final av a;
    final ba b;

    public az$a(av wrapped, ba valueAnimatorCompat) {
        this.a = wrapped;
        this.b = valueAnimatorCompat;
    }

    public void onAnimationStart(Animator animation) {
        this.a.onAnimationStart(this.b);
    }

    public void onAnimationEnd(Animator animation) {
        this.a.onAnimationEnd(this.b);
    }

    public void onAnimationCancel(Animator animation) {
        this.a.onAnimationCancel(this.b);
    }

    public void onAnimationRepeat(Animator animation) {
        this.a.onAnimationRepeat(this.b);
    }
}
