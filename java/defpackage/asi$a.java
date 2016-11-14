package defpackage;

import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: TrampolineScheduler */
class asi$a extends apg$a implements apk {
    final AtomicInteger a = new AtomicInteger();
    final PriorityBlockingQueue<asi$b> b = new PriorityBlockingQueue();
    private final asm c = new asm();
    private final AtomicInteger d = new AtomicInteger();

    asi$a() {
    }

    public apk a(apq action) {
        return a(action, a());
    }

    public apk a(apq action, long delayTime, TimeUnit unit) {
        long execTime = a() + unit.toMillis(delayTime);
        return a(new ash(action, this, execTime), execTime);
    }

    private apk a(apq action, long execTime) {
        if (this.c.isUnsubscribed()) {
            return asq.b();
        }
        asi$b timedAction = new asi$b(action, Long.valueOf(execTime), this.a.incrementAndGet());
        this.b.add(timedAction);
        if (this.d.getAndIncrement() != 0) {
            return asq.a(new asi$a$1(this, timedAction));
        }
        do {
            asi$b polled = (asi$b) this.b.poll();
            if (polled != null) {
                polled.a.call();
            }
        } while (this.d.decrementAndGet() > 0);
        return asq.b();
    }

    public void unsubscribe() {
        this.c.unsubscribe();
    }

    public boolean isUnsubscribed() {
        return this.c.isUnsubscribed();
    }
}
