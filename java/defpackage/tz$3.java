package defpackage;

import com.facebook.GraphRequest.b;
import org.json.JSONObject;

/* compiled from: AccessTokenManager */
class tz$3 implements b {
    final /* synthetic */ tz$a a;
    final /* synthetic */ tz b;

    tz$3(tz this$0, tz$a tz_a) {
        this.b = this$0;
        this.a = tz_a;
    }

    public void onCompleted(ug response) {
        JSONObject data = response.b();
        if (data != null) {
            this.a.a = data.optString("access_token");
            this.a.b = data.optInt("expires_at");
        }
    }
}
