package defpackage;

import android.content.Context;
import com.facebook.AccessToken;

/* compiled from: LikeActionController */
class wk$8 extends ua {
    wk$8() {
    }

    protected void a(AccessToken oldAccessToken, AccessToken currentAccessToken) {
        Context appContext = ud.f();
        if (currentAccessToken == null) {
            wk.i = (wk.i + 1) % 1000;
            appContext.getSharedPreferences("com.facebook.LikeActionController.CONTROLLER_STORE_KEY", 0).edit().putInt("OBJECT_SUFFIX", wk.i).apply();
            wk.c.clear();
            wk.b.a();
        }
        wk.d(null, "com.facebook.sdk.LikeActionController.DID_RESET");
    }
}
