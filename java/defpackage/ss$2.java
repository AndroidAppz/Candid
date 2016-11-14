package defpackage;

import java.util.concurrent.Callable;

/* compiled from: CrashlyticsExecutorServiceWrapper */
class ss$2 implements Callable<T> {
    final /* synthetic */ Callable a;
    final /* synthetic */ ss b;

    ss$2(ss ssVar, Callable callable) {
        this.b = ssVar;
        this.a = callable;
    }

    public T call() throws Exception {
        try {
            return this.a.call();
        } catch (Exception e) {
            akp.h().e("CrashlyticsCore", "Failed to execute task.", e);
            return null;
        }
    }
}
