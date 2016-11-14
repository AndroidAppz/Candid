package defpackage;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;

/* compiled from: ValueAnimatorCompatImplHoneycombMr1 */
class ad$2 extends AnimatorListenerAdapter {
    final /* synthetic */ ab$e$a a;
    final /* synthetic */ ad b;

    ad$2(ad adVar, ab$e$a ab_e_a) {
        this.b = adVar;
        this.a = ab_e_a;
    }

    public void onAnimationStart(Animator animator) {
        this.a.a();
    }

    public void onAnimationEnd(Animator animator) {
        this.a.b();
    }

    public void onAnimationCancel(Animator animator) {
        this.a.c();
    }
}
