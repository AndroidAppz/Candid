package defpackage;

import android.content.Context;
import android.os.Bundle;
import com.facebook.AccessToken;
import com.facebook.FacebookException;

/* compiled from: WebDialog */
public class vy$a {
    private Context a;
    private String b;
    private String c;
    private int d;
    private vy$c e;
    private Bundle f;
    private AccessToken g;

    public vy$a(Context context, String action, Bundle parameters) {
        this.g = AccessToken.a();
        if (this.g == null) {
            String applicationId = vw.a(context);
            if (applicationId != null) {
                this.b = applicationId;
            } else {
                throw new FacebookException("Attempted to create a builder without a valid access token or a valid default Application ID.");
            }
        }
        a(context, action, parameters);
    }

    public vy$a(Context context, String applicationId, String action, Bundle parameters) {
        if (applicationId == null) {
            applicationId = vw.a(context);
        }
        vx.a(applicationId, "applicationId");
        this.b = applicationId;
        a(context, action, parameters);
    }

    public vy$a a(vy$c listener) {
        this.e = listener;
        return this;
    }

    public vy a() {
        if (this.g != null) {
            this.f.putString("app_id", this.g.h());
            this.f.putString("access_token", this.g.b());
        } else {
            this.f.putString("app_id", this.b);
        }
        return new vy(this.a, this.c, this.f, this.d, this.e);
    }

    public String b() {
        return this.b;
    }

    public Context c() {
        return this.a;
    }

    public int d() {
        return this.d;
    }

    public Bundle e() {
        return this.f;
    }

    public vy$c f() {
        return this.e;
    }

    private void a(Context context, String action, Bundle parameters) {
        this.a = context;
        this.c = action;
        if (parameters != null) {
            this.f = parameters;
        } else {
            this.f = new Bundle();
        }
    }
}
