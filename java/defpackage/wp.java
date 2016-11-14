package defpackage;

import android.os.Bundle;
import com.facebook.FacebookException;

/* compiled from: ResultProcessor */
public abstract class wp {
    private uc a;

    public abstract void a(ux uxVar, Bundle bundle);

    public wp(uc callback) {
        this.a = callback;
    }

    public void a(ux appCall) {
        if (this.a != null) {
            this.a.onCancel();
        }
    }

    public void a(ux appCall, FacebookException error) {
        if (this.a != null) {
            this.a.onError(error);
        }
    }
}
