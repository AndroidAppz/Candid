/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.annotation.TargetApi
 *  android.app.Activity
 *  android.app.Application
 *  android.app.Application$ActivityLifecycleCallbacks
 *  android.content.ComponentCallbacks
 *  android.content.ComponentCallbacks2
 *  android.content.res.Configuration
 *  android.os.Bundle
 *  java.lang.Object
 *  java.util.concurrent.atomic.AtomicBoolean
 */
import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Application;
import android.content.ComponentCallbacks;
import android.content.ComponentCallbacks2;
import android.content.res.Configuration;
import android.os.Bundle;
import java.util.concurrent.atomic.AtomicBoolean;

@TargetApi(value=14)
public class aai
implements Application.ActivityLifecycleCallbacks,
ComponentCallbacks2 {
    private static final aai a = new aai();
    private final AtomicBoolean b = new AtomicBoolean();
    private boolean c;

    private aai() {
    }

    public static void a(Application application) {
        application.registerActivityLifecycleCallbacks((Application.ActivityLifecycleCallbacks)a);
        application.registerComponentCallbacks((ComponentCallbacks)a);
        aai.a.c = true;
    }

    public void onActivityCreated(Activity activity, Bundle bundle) {
        if (this.b.compareAndSet(true, false)) {
            ahn.a(false);
        }
    }

    public void onActivityDestroyed(Activity activity) {
    }

    public void onActivityPaused(Activity activity) {
    }

    public void onActivityResumed(Activity activity) {
        if (this.b.compareAndSet(true, false)) {
            ahn.a(false);
        }
    }

    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    public void onActivityStarted(Activity activity) {
    }

    public void onActivityStopped(Activity activity) {
    }

    public void onConfigurationChanged(Configuration configuration) {
    }

    public void onLowMemory() {
    }

    public void onTrimMemory(int n2) {
        if (n2 == 20 && this.b.compareAndSet(false, true)) {
            ahn.a(true);
        }
    }
}

