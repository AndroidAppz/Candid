package defpackage;

import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import rx.internal.schedulers.ScheduledAction;

/* compiled from: ExecutorScheduler */
final class asf$a extends apg$a implements Runnable {
    final Executor a;
    final asn b = new asn();
    final ConcurrentLinkedQueue<ScheduledAction> c = new ConcurrentLinkedQueue();
    final AtomicInteger d = new AtomicInteger();

    public asf$a(Executor executor) {
        this.a = executor;
    }

    public apk a(apq action) {
        if (isUnsubscribed()) {
            return asq.b();
        }
        apk ea = new ScheduledAction(action, this.b);
        this.b.a(ea);
        this.c.offer(ea);
        if (this.d.getAndIncrement() != 0) {
            return ea;
        }
        try {
            this.a.execute(this);
            return ea;
        } catch (Throwable t) {
            this.b.b(ea);
            this.d.decrementAndGet();
            asc.a().b().a(t);
            throw t;
        }
    }

    public void run() {
        do {
            ScheduledAction sa = (ScheduledAction) this.c.poll();
            if (!sa.isUnsubscribed()) {
                sa.run();
            }
        } while (this.d.decrementAndGet() > 0);
    }

    public apk a(apq action, long delayTime, TimeUnit unit) {
        if (delayTime <= 0) {
            return a(action);
        }
        if (isUnsubscribed()) {
            return asq.b();
        }
        ScheduledExecutorService service;
        if (this.a instanceof ScheduledExecutorService) {
            service = this.a;
        } else {
            service = aqk.c();
        }
        aso first = new aso();
        apk mas = new aso();
        mas.a(first);
        this.b.a(mas);
        apk removeMas = asq.a(new asf$a$1(this, mas));
        ScheduledAction ea = new ScheduledAction(new asf$a$2(this, mas, action, removeMas));
        first.a(ea);
        try {
            ea.a(service.schedule(ea, delayTime, unit));
            return removeMas;
        } catch (Throwable t) {
            asc.a().b().a(t);
            throw t;
        }
    }

    public boolean isUnsubscribed() {
        return this.b.isUnsubscribed();
    }

    public void unsubscribe() {
        this.b.unsubscribe();
    }
}
