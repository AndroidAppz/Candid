package defpackage;

import io.fabric.sdk.android.services.common.CommonUtils;
import java.io.File;

/* compiled from: CrashlyticsUncaughtExceptionHandler */
final class sw$c implements Runnable {
    private final sr a;
    private final File b;

    public sw$c(sr crashlyticsCore, File fileToSend) {
        this.a = crashlyticsCore;
        this.b = fileToSend;
    }

    public void run() {
        if (CommonUtils.n(this.a.E())) {
            akp.h().a("CrashlyticsCore", "Attempting to send crash report at time of crash...");
            sy call = this.a.a(ans.a().b());
            if (call != null) {
                new tk(call).a(new tm(this.b, sw.f));
            }
        }
    }
}
