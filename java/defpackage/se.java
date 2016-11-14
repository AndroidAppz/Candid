package defpackage;

import android.annotation.TargetApi;
import java.util.concurrent.ExecutorService;

@TargetApi(14)
/* compiled from: ActivityLifecycleCheckForUpdatesController */
class se extends sd {
    private final akn$b a = new se$1(this);
    private final ExecutorService b;

    public se(akn lifecycleManager, ExecutorService executorService) {
        this.b = executorService;
        lifecycleManager.a(this.a);
    }
}
