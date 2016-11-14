package defpackage;

import android.os.Bundle;
import com.facebook.AccessToken;
import com.facebook.FacebookRequestError;
import com.facebook.GraphRequest;
import com.facebook.HttpMethod;
import com.facebook.LoggingBehavior;
import com.facebook.share.widget.LikeView.ObjectType;
import org.json.JSONObject;

/* compiled from: LikeActionController */
class wk$g extends wk$a {
    String e;
    boolean f;
    final /* synthetic */ wk g;

    wk$g(wk wkVar, String objectId, ObjectType objectType) {
        this.g = wkVar;
        super(wkVar, objectId, objectType);
        Bundle pageIdRequestParams = new Bundle();
        pageIdRequestParams.putString("fields", "id");
        pageIdRequestParams.putString("ids", objectId);
        a(new GraphRequest(AccessToken.a(), "", pageIdRequestParams, HttpMethod.GET));
    }

    protected void a(ug response) {
        JSONObject results = vw.b(response.b(), this.a);
        if (results != null) {
            this.e = results.optString("id");
            this.f = !vw.a(this.e);
        }
    }

    protected void a(FacebookRequestError error) {
        vp.a(LoggingBehavior.REQUESTS, wk.a, "Error getting the FB id for object '%s' with type '%s' : %s", this.a, this.b, error);
    }
}
