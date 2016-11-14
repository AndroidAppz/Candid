package defpackage;

import android.view.animation.Animation;

/* compiled from: FloatingActionButtonEclairMr1 */
class r$2 extends k$a {
    final /* synthetic */ t$a a;
    final /* synthetic */ r b;

    r$2(r rVar, t$a t_a) {
        this.b = rVar;
        this.a = t_a;
    }

    public void onAnimationEnd(Animation animation) {
        if (this.a != null) {
            this.a.a();
        }
    }
}
