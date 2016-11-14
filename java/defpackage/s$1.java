package defpackage;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;

/* compiled from: FloatingActionButtonIcs */
class s$1 extends AnimatorListenerAdapter {
    final /* synthetic */ boolean a;
    final /* synthetic */ t$a b;
    final /* synthetic */ s c;
    private boolean d;

    s$1(s sVar, boolean z, t$a t_a) {
        this.c = sVar;
        this.a = z;
        this.b = t_a;
    }

    public void onAnimationStart(Animator animation) {
        this.c.m = true;
        this.d = false;
        this.c.k.a(0, this.a);
    }

    public void onAnimationCancel(Animator animation) {
        this.c.m = false;
        this.d = true;
    }

    public void onAnimationEnd(Animator animation) {
        this.c.m = false;
        if (!this.d) {
            this.c.k.a(8, this.a);
            if (this.b != null) {
                this.b.b();
            }
        }
    }
}
