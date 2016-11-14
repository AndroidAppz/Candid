package defpackage;

import android.os.Bundle;
import com.facebook.FacebookException;

/* compiled from: ShareInternalUtility */
class wr$1 extends wp {
    final /* synthetic */ uc a;

    wr$1(uc callback, uc ucVar) {
        this.a = ucVar;
        super(callback);
    }

    public void a(ux appCall, Bundle results) {
        if (results != null) {
            String gesture = wr.a(results);
            if (gesture == null || "post".equalsIgnoreCase(gesture)) {
                wr.a(this.a, wr.b(results));
            } else if ("cancel".equalsIgnoreCase(gesture)) {
                wr.b(this.a);
            } else {
                wr.a(this.a, new FacebookException("UnknownError"));
            }
        }
    }

    public void a(ux appCall) {
        wr.b(this.a);
    }

    public void a(ux appCall, FacebookException error) {
        wr.a(this.a, error);
    }
}
