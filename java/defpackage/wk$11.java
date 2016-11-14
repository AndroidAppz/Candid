package defpackage;

import android.os.Bundle;

/* compiled from: LikeActionController */
class wk$11 implements uf$a {
    final /* synthetic */ wk$l a;
    final /* synthetic */ Bundle b;
    final /* synthetic */ wk c;

    wk$11(wk this$0, wk$l wk_l, Bundle bundle) {
        this.c = this$0;
        this.a = wk_l;
        this.b = bundle;
    }

    public void a(uf batch) {
        this.c.v = false;
        if (this.a.a() != null) {
            this.c.a(true);
            return;
        }
        this.c.r = null;
        this.c.u = false;
        this.c.l().a("fb_like_control_did_unlike", null, this.b);
        this.c.e(this.b);
    }
}
