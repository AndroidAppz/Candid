package defpackage;

import com.facebook.appevents.AccessTokenAppIdPair;

/* compiled from: AppEventQueue */
class uq$5 implements Runnable {
    final /* synthetic */ AccessTokenAppIdPair a;
    final /* synthetic */ ut b;

    uq$5(AccessTokenAppIdPair accessTokenAppIdPair, ut utVar) {
        this.a = accessTokenAppIdPair;
        this.b = utVar;
    }

    public void run() {
        ur.a(this.a, this.b);
    }
}
