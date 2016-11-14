package defpackage;

import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;

/* compiled from: StateListAnimator */
class z$1 implements AnimationListener {
    final /* synthetic */ z a;

    z$1(z zVar) {
        this.a = zVar;
    }

    public void onAnimationEnd(Animation animation) {
        if (this.a.c == animation) {
            this.a.c = null;
        }
    }

    public void onAnimationStart(Animation animation) {
    }

    public void onAnimationRepeat(Animation animation) {
    }
}
