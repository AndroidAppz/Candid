package defpackage;

/* compiled from: CrashlyticsExecutorServiceWrapper */
class ss$1 implements Runnable {
    final /* synthetic */ Runnable a;
    final /* synthetic */ ss b;

    ss$1(ss ssVar, Runnable runnable) {
        this.b = ssVar;
        this.a = runnable;
    }

    public void run() {
        try {
            this.a.run();
        } catch (Exception e) {
            akp.h().e("CrashlyticsCore", "Failed to execute task.", e);
        }
    }
}
