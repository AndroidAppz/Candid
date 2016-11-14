package defpackage;

import android.annotation.TargetApi;
import android.app.Application;
import android.app.Application.ActivityLifecycleCallbacks;
import java.util.HashSet;
import java.util.Set;

/* compiled from: ActivityLifecycleManager */
class akn$a {
    private final Set<ActivityLifecycleCallbacks> a = new HashSet();
    private final Application b;

    akn$a(Application application) {
        this.b = application;
    }

    @TargetApi(14)
    private void a() {
        for (ActivityLifecycleCallbacks callback : this.a) {
            this.b.unregisterActivityLifecycleCallbacks(callback);
        }
    }

    @TargetApi(14)
    private boolean a(akn$b callbacks) {
        if (this.b == null) {
            return false;
        }
        ActivityLifecycleCallbacks callbackWrapper = new akn$a$1(this, callbacks);
        this.b.registerActivityLifecycleCallbacks(callbackWrapper);
        this.a.add(callbackWrapper);
        return true;
    }
}
