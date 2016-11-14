package defpackage;

import com.facebook.FacebookRequestError;
import com.facebook.LoggingBehavior;

/* compiled from: LikeActionController */
class wk$3 implements uf$a {
    final /* synthetic */ wk$e a;
    final /* synthetic */ wk$g b;
    final /* synthetic */ wk$m c;
    final /* synthetic */ wk d;

    wk$3(wk this$0, wk$e wk_e, wk$g wk_g, wk$m wk_m) {
        this.d = this$0;
        this.a = wk_e;
        this.b = wk_g;
        this.c = wk_m;
    }

    public void a(uf batch) {
        this.d.s = this.a.e;
        if (vw.a(this.d.s)) {
            this.d.s = this.b.e;
            this.d.t = this.b.f;
        }
        if (vw.a(this.d.s)) {
            FacebookRequestError a;
            vp.a(LoggingBehavior.DEVELOPER_ERRORS, wk.a, "Unable to verify the FB id for '%s'. Verify that it is a valid FB object or page", this.d.k);
            wk wkVar = this.d;
            String str = "get_verified_id";
            if (this.b.a() != null) {
                a = this.b.a();
            } else {
                a = this.a.a();
            }
            wkVar.a(str, a);
        }
        if (this.c != null) {
            this.c.a();
        }
    }
}
