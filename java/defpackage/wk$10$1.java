package defpackage;

/* compiled from: LikeActionController */
class wk$10$1 implements uf$a {
    final /* synthetic */ wk$k a;
    final /* synthetic */ wk$10 b;

    wk$10$1(wk$10 this$1, wk$k wk_k) {
        this.b = this$1;
        this.a = wk_k;
    }

    public void a(uf batch) {
        this.b.b.v = false;
        if (this.a.a() != null) {
            this.b.b.a(false);
            return;
        }
        this.b.b.r = vw.a(this.a.e, null);
        this.b.b.u = true;
        this.b.b.l().a("fb_like_control_did_like", null, this.b.a);
        this.b.b.e(this.b.a);
    }
}
