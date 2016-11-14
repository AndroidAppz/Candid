package defpackage;

import java.util.concurrent.Callable;

/* compiled from: CrashlyticsUncaughtExceptionHandler */
class sw$2 implements Callable<Void> {
    final /* synthetic */ sw a;

    sw$2(sw swVar) {
        this.a = swVar;
    }

    public /* synthetic */ Object call() throws Exception {
        return a();
    }

    public Void a() throws Exception {
        this.a.l();
        return null;
    }
}
