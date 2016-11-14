package defpackage;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;

/* compiled from: ViewPropertyAnimatorCompatJB */
class fx$1 extends AnimatorListenerAdapter {
    final /* synthetic */ fz a;
    final /* synthetic */ View b;

    fx$1(fz fzVar, View view) {
        this.a = fzVar;
        this.b = view;
    }

    public void onAnimationCancel(Animator animation) {
        this.a.onAnimationCancel(this.b);
    }

    public void onAnimationEnd(Animator animation) {
        this.a.onAnimationEnd(this.b);
    }

    public void onAnimationStart(Animator animation) {
        this.a.onAnimationStart(this.b);
    }
}
