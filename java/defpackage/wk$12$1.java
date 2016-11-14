package defpackage;

import com.facebook.LoggingBehavior;

/* compiled from: LikeActionController */
class wk$12$1 implements uf$a {
    final /* synthetic */ wk$i a;
    final /* synthetic */ wk$d b;
    final /* synthetic */ wk$12 c;

    wk$12$1(wk$12 this$1, wk$i wk_i, wk$d wk_d) {
        this.c = this$1;
        this.a = wk_i;
        this.b = wk_d;
    }

    public void a(uf batch) {
        if (this.a.a() == null && this.b.a() == null) {
            this.c.a.a(this.a.b(), this.b.e, this.b.f, this.b.g, this.b.h, this.a.c());
            return;
        }
        vp.a(LoggingBehavior.REQUESTS, wk.a, "Unable to refresh like state for id: '%s'", this.c.a.k);
    }
}
