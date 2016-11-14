package defpackage;

import java.util.concurrent.TimeUnit;

/* compiled from: OnSubscribeTimerOnce */
public final class aqa implements apd$a<Long> {
    final long a;
    final TimeUnit b;
    final apg c;

    public /* synthetic */ void call(Object x0) {
        a((apj) x0);
    }

    public aqa(long time, TimeUnit unit, apg scheduler) {
        this.a = time;
        this.b = unit;
        this.c = scheduler;
    }

    public void a(apj<? super Long> child) {
        apg$a worker = this.c.createWorker();
        child.add(worker);
        worker.a(new aqa$1(this, child), this.a, this.b);
    }
}
