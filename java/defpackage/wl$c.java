package defpackage;

import com.facebook.share.internal.LikeContent;

/* compiled from: LikeDialog */
class wl$c extends vd$a {
    final /* synthetic */ wl b;

    private wl$c(wl wlVar) {
        this.b = wlVar;
        super(wlVar);
    }

    public boolean a(LikeContent content, boolean isBestEffort) {
        return content != null && wl.f();
    }

    public ux a(LikeContent content) {
        ux appCall = this.b.d();
        vc.a(appCall, wl.b(content), wl.h());
        return appCall;
    }
}
