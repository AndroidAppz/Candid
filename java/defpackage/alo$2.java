package defpackage;

import java.util.Locale;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;

/* compiled from: ExecutorUtils */
class alo$2 extends alk {
    final /* synthetic */ String a;
    final /* synthetic */ ExecutorService b;
    final /* synthetic */ long c;
    final /* synthetic */ TimeUnit d;

    alo$2(String str, ExecutorService executorService, long j, TimeUnit timeUnit) {
        this.a = str;
        this.b = executorService;
        this.c = j;
        this.d = timeUnit;
    }

    public void a() {
        try {
            akp.h().a("Fabric", "Executing shutdown hook for " + this.a);
            this.b.shutdown();
            if (!this.b.awaitTermination(this.c, this.d)) {
                akp.h().a("Fabric", this.a + " did not shut down in the" + " allocated time. Requesting immediate shutdown.");
                this.b.shutdownNow();
            }
        } catch (InterruptedException e) {
            akp.h().a("Fabric", String.format(Locale.US, "Interrupted while waiting for %s to shut down. Requesting immediate shutdown.", new Object[]{this.a}));
            this.b.shutdownNow();
        }
    }
}
