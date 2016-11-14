package defpackage;

import com.facebook.share.internal.LikeContent;

/* compiled from: LikeDialog */
class wl$a extends vd$a {
    final /* synthetic */ wl b;

    private wl$a(wl wlVar) {
        this.b = wlVar;
        super(wlVar);
    }

    public boolean a(LikeContent content, boolean isBestEffort) {
        return content != null && wl.e();
    }

    public ux a(LikeContent content) {
        ux appCall = this.b.d();
        vc.a(appCall, new wl$a$1(this, content), wl.h());
        return appCall;
    }
}
