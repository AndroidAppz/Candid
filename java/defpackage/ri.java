package defpackage;

import android.app.Activity;
import android.os.Bundle;
import com.crashlytics.android.answers.SessionEvent.Type;
import rx;

/* compiled from: AnswersLifecycleCallbacks */
class ri extends akn$b {
    private final rx a;
    private final rl b;

    public ri(rx analyticsManager, rl backgroundManager) {
        this.a = analyticsManager;
        this.b = backgroundManager;
    }

    public void a(Activity activity, Bundle bundle) {
    }

    public void a(Activity activity) {
        this.a.a(activity, Type.a);
    }

    public void b(Activity activity) {
        this.a.a(activity, Type.b);
        this.b.a();
    }

    public void c(Activity activity) {
        this.a.a(activity, Type.c);
        this.b.b();
    }

    public void d(Activity activity) {
        this.a.a(activity, Type.d);
    }

    public void b(Activity activity, Bundle bundle) {
    }

    public void e(Activity activity) {
    }
}
