package defpackage;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.view.View;

/* compiled from: HoneycombMr1AnimatorCompatProvider */
class az$b implements ba {
    final Animator a;

    public az$b(Animator wrapped) {
        this.a = wrapped;
    }

    public void a(View view) {
        this.a.setTarget(view);
    }

    public void a(av listener) {
        this.a.addListener(new az$a(listener, this));
    }

    public void a(long duration) {
        this.a.setDuration(duration);
    }

    public void a() {
        this.a.start();
    }

    public void b() {
        this.a.cancel();
    }

    public void a(ax animatorUpdateListener) {
        if (this.a instanceof ValueAnimator) {
            ((ValueAnimator) this.a).addUpdateListener(new az$b$1(this, animatorUpdateListener));
        }
    }

    public float c() {
        return ((ValueAnimator) this.a).getAnimatedFraction();
    }
}
