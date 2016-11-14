package defpackage;

import com.facebook.GraphRequest.b;

/* compiled from: Utility */
class vw$2 implements b {
    final /* synthetic */ vw$c a;
    final /* synthetic */ String b;

    vw$2(vw$c vw_c, String str) {
        this.a = vw_c;
        this.b = str;
    }

    public void onCompleted(ug response) {
        if (response.a() != null) {
            this.a.a(response.a().g());
            return;
        }
        vt.a(this.b, response.b());
        this.a.a(response.b());
    }
}
