package defpackage;

import android.os.Bundle;

/* compiled from: LikeDialog */
class wl$1 extends wp {
    final /* synthetic */ uc a;
    final /* synthetic */ wl b;

    wl$1(wl this$0, uc callback, uc ucVar) {
        this.b = this$0;
        this.a = ucVar;
        super(callback);
    }

    public void a(ux appCall, Bundle results) {
        this.a.onSuccess(new wl$b(results));
    }
}
