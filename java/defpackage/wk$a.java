package defpackage;

import com.facebook.FacebookRequestError;
import com.facebook.GraphRequest;
import com.facebook.LoggingBehavior;
import com.facebook.share.widget.LikeView.ObjectType;

/* compiled from: LikeActionController */
abstract class wk$a implements wk$n {
    protected String a;
    protected ObjectType b;
    protected FacebookRequestError c;
    final /* synthetic */ wk d;
    private GraphRequest e;

    protected abstract void a(ug ugVar);

    protected wk$a(wk wkVar, String objectId, ObjectType objectType) {
        this.d = wkVar;
        this.a = objectId;
        this.b = objectType;
    }

    public void a(uf batch) {
        batch.a(this.e);
    }

    public FacebookRequestError a() {
        return this.c;
    }

    protected void a(GraphRequest request) {
        this.e = request;
        request.a("v2.6");
        request.a(new wk$a$1(this));
    }

    protected void a(FacebookRequestError error) {
        vp.a(LoggingBehavior.REQUESTS, wk.a, "Error running request for object '%s' with type '%s' : %s", this.a, this.b, error);
    }
}
