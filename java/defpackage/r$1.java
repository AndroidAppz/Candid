package defpackage;

import android.view.animation.Animation;

/* compiled from: FloatingActionButtonEclairMr1 */
class r$1 extends k$a {
    final /* synthetic */ boolean a;
    final /* synthetic */ t$a b;
    final /* synthetic */ r c;

    r$1(r rVar, boolean z, t$a t_a) {
        this.c = rVar;
        this.a = z;
        this.b = t_a;
    }

    public void onAnimationStart(Animation animation) {
        this.c.o = true;
    }

    public void onAnimationEnd(Animation animation) {
        this.c.o = false;
        this.c.k.a(8, this.a);
        if (this.b != null) {
            this.b.b();
        }
    }
}
