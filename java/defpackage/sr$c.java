package defpackage;

import java.util.concurrent.CountDownLatch;

/* compiled from: CrashlyticsCore */
class sr$c {
    private boolean a;
    private final CountDownLatch b;

    private sr$c() {
        this.a = false;
        this.b = new CountDownLatch(1);
    }

    void a(boolean optIn) {
        this.a = optIn;
        this.b.countDown();
    }

    boolean a() {
        return this.a;
    }

    void b() {
        try {
            this.b.await();
        } catch (InterruptedException e) {
        }
    }
}
