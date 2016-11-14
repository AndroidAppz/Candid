package defpackage;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;

/* compiled from: FloatingActionButtonIcs */
class s$2 extends AnimatorListenerAdapter {
    final /* synthetic */ boolean a;
    final /* synthetic */ t$a b;
    final /* synthetic */ s c;

    s$2(s sVar, boolean z, t$a t_a) {
        this.c = sVar;
        this.a = z;
        this.b = t_a;
    }

    public void onAnimationStart(Animator animation) {
        this.c.k.a(0, this.a);
    }

    public void onAnimationEnd(Animator animation) {
        if (this.b != null) {
            this.b.a();
        }
    }
}
