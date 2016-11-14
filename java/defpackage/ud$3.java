package defpackage;

import android.content.Context;
import com.facebook.AccessToken;
import com.facebook.Profile;
import com.facebook.appevents.AppEventsLogger;
import java.util.concurrent.Callable;

/* compiled from: FacebookSdk */
class ud$3 implements Callable<Void> {
    final /* synthetic */ ud$a a;
    final /* synthetic */ Context b;

    ud$3(ud$a ud_a, Context context) {
        this.a = ud_a;
        this.b = context;
    }

    public /* synthetic */ Object call() throws Exception {
        return a();
    }

    public Void a() throws Exception {
        tz.a().c();
        uj.a().c();
        if (AccessToken.a() != null && Profile.a() == null) {
            Profile.b();
        }
        if (this.a != null) {
            this.a.a();
        }
        AppEventsLogger.a(this.b.getApplicationContext()).b();
        return null;
    }
}
