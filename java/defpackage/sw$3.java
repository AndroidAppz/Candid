package defpackage;

import java.util.concurrent.Callable;

/* compiled from: CrashlyticsUncaughtExceptionHandler */
class sw$3 implements Callable<Boolean> {
    final /* synthetic */ sw a;

    sw$3(sw swVar) {
        this.a = swVar;
    }

    public /* synthetic */ Object call() throws Exception {
        return a();
    }

    public Boolean a() throws Exception {
        if (this.a.k.get()) {
            akp.h().a("CrashlyticsCore", "Skipping session finalization because a crash has already occurred.");
            return Boolean.FALSE;
        }
        akp.h().a("CrashlyticsCore", "Finalizing previously open sessions.");
        tv crashEventData = this.a.n.v();
        if (crashEventData != null) {
            this.a.a(crashEventData);
        }
        this.a.a(true);
        akp.h().a("CrashlyticsCore", "Closed all previously open sessions");
        return Boolean.TRUE;
    }
}
