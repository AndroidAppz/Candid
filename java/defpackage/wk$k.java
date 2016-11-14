package defpackage;

import android.os.Bundle;
import com.facebook.AccessToken;
import com.facebook.FacebookRequestError;
import com.facebook.GraphRequest;
import com.facebook.HttpMethod;
import com.facebook.LoggingBehavior;
import com.facebook.share.widget.LikeView.ObjectType;

/* compiled from: LikeActionController */
class wk$k extends wk$a {
    String e;
    final /* synthetic */ wk f;

    wk$k(wk wkVar, String objectId, ObjectType objectType) {
        this.f = wkVar;
        super(wkVar, objectId, objectType);
        Bundle likeRequestParams = new Bundle();
        likeRequestParams.putString("object", objectId);
        a(new GraphRequest(AccessToken.a(), "me/og.likes", likeRequestParams, HttpMethod.POST));
    }

    protected void a(ug response) {
        this.e = vw.a(response.b(), "id");
    }

    protected void a(FacebookRequestError error) {
        if (error.b() == 3501) {
            this.c = null;
            return;
        }
        vp.a(LoggingBehavior.REQUESTS, wk.a, "Error liking object '%s' with type '%s' : %s", this.a, this.b, error);
        this.f.a("publish_like", error);
    }
}
