package defpackage;

/* compiled from: SleepingAction */
public class ash implements apq {
    private final apq a;
    private final apg$a b;
    private final long c;

    public ash(apq underlying, apg$a scheduler, long execTime) {
        this.a = underlying;
        this.b = scheduler;
        this.c = execTime;
    }

    public void call() {
        if (!this.b.isUnsubscribed()) {
            if (this.c > this.b.a()) {
                long delay = this.c - this.b.a();
                if (delay > 0) {
                    try {
                        Thread.sleep(delay);
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                        throw new RuntimeException(e);
                    }
                }
            }
            if (!this.b.isUnsubscribed()) {
                this.a.call();
            }
        }
    }
}
