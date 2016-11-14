package defpackage;

import com.facebook.AccessToken;
import com.facebook.FacebookRequestError;
import com.facebook.GraphRequest;
import com.facebook.HttpMethod;
import com.facebook.LoggingBehavior;

/* compiled from: LikeActionController */
class wk$l extends wk$a {
    final /* synthetic */ wk e;
    private String f;

    wk$l(wk wkVar, String unlikeToken) {
        this.e = wkVar;
        super(wkVar, null, null);
        this.f = unlikeToken;
        a(new GraphRequest(AccessToken.a(), unlikeToken, null, HttpMethod.DELETE));
    }

    protected void a(ug response) {
    }

    protected void a(FacebookRequestError error) {
        vp.a(LoggingBehavior.REQUESTS, wk.a, "Error unliking object with unlike token '%s' : %s", this.f, error);
        this.e.a("publish_unlike", error);
    }
}
