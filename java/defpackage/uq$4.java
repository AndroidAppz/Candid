package defpackage;

import com.facebook.GraphRequest;
import com.facebook.GraphRequest.b;
import com.facebook.appevents.AccessTokenAppIdPair;

/* compiled from: AppEventQueue */
class uq$4 implements b {
    final /* synthetic */ AccessTokenAppIdPair a;
    final /* synthetic */ GraphRequest b;
    final /* synthetic */ ut c;
    final /* synthetic */ us d;

    uq$4(AccessTokenAppIdPair accessTokenAppIdPair, GraphRequest graphRequest, ut utVar, us usVar) {
        this.a = accessTokenAppIdPair;
        this.b = graphRequest;
        this.c = utVar;
        this.d = usVar;
    }

    public void onCompleted(ug response) {
        uq.b(this.a, this.b, response, this.c, this.d);
    }
}
