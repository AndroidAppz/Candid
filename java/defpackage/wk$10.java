package defpackage;

import android.os.Bundle;

/* compiled from: LikeActionController */
class wk$10 implements wk$m {
    final /* synthetic */ Bundle a;
    final /* synthetic */ wk b;

    wk$10(wk this$0, Bundle bundle) {
        this.b = this$0;
        this.a = bundle;
    }

    public void a() {
        if (vw.a(this.b.s)) {
            Bundle errorBundle = new Bundle();
            errorBundle.putString("com.facebook.platform.status.ERROR_DESCRIPTION", "Invalid Object Id");
            wk.c(this.b, "com.facebook.sdk.LikeActionController.DID_ERROR", errorBundle);
            return;
        }
        uf requestBatch = new uf();
        wk$k likeRequest = new wk$k(this.b, this.b.s, this.b.l);
        likeRequest.a(requestBatch);
        requestBatch.a(new wk$10$1(this, likeRequest));
        requestBatch.h();
    }
}
