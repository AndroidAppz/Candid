/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.annotation.TargetApi
 *  android.app.Activity
 *  android.app.Application
 *  android.app.Application$ActivityLifecycleCallbacks
 *  android.content.Context
 *  android.os.Build
 *  android.os.Build$VERSION
 *  android.os.Bundle
 *  java.lang.Object
 *  java.util.HashSet
 *  java.util.Set
 */
import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import java.util.HashSet;
import java.util.Set;

public class akn {
    private final Application a;
    private a b;

    public akn(Context context) {
        this.a = (Application)context.getApplicationContext();
        if (Build.VERSION.SDK_INT >= 14) {
            this.b = new a(this.a);
        }
    }

    public void a() {
        if (this.b != null) {
            this.b.a();
        }
    }

    public boolean a(b b2) {
        if (this.b != null && this.b.a(b2)) {
            return true;
        }
        return false;
    }

    static class a {
        private final Set<Application.ActivityLifecycleCallbacks> a = new HashSet();
        private final Application b;

        a(Application application) {
            this.b = application;
        }

        @TargetApi(value=14)
        private void a() {
            for (Application.ActivityLifecycleCallbacks activityLifecycleCallbacks : this.a) {
                this.b.unregisterActivityLifecycleCallbacks(activityLifecycleCallbacks);
            }
        }

        @TargetApi(value=14)
        private boolean a(final b b2) {
            if (this.b != null) {
                Application.ActivityLifecycleCallbacks activityLifecycleCallbacks = new Application.ActivityLifecycleCallbacks(){

                    public void onActivityCreated(Activity activity, Bundle bundle) {
                        b2.a(activity, bundle);
                    }

                    public void onActivityDestroyed(Activity activity) {
                        b2.e(activity);
                    }

                    public void onActivityPaused(Activity activity) {
                        b2.c(activity);
                    }

                    public void onActivityResumed(Activity activity) {
                        b2.b(activity);
                    }

                    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
                        b2.b(activity, bundle);
                    }

                    public void onActivityStarted(Activity activity) {
                        b2.a(activity);
                    }

                    public void onActivityStopped(Activity activity) {
                        b2.d(activity);
                    }
                };
                this.b.registerActivityLifecycleCallbacks(activityLifecycleCallbacks);
                this.a.add((Object)activityLifecycleCallbacks);
                return true;
            }
            return false;
        }

    }

    public static abstract class b {
        public void a(Activity activity) {
        }

        public void a(Activity activity, Bundle bundle) {
        }

        public void b(Activity activity) {
        }

        public void b(Activity activity, Bundle bundle) {
        }

        public void c(Activity activity) {
        }

        public void d(Activity activity) {
        }

        public void e(Activity activity) {
        }
    }

}

