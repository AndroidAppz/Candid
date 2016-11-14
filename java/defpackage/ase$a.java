package defpackage;

import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/* compiled from: CachedThreadScheduler */
final class ase$a {
    private final long a;
    private final ConcurrentLinkedQueue<ase$c> b;
    private final asn c;
    private final ScheduledExecutorService d;
    private final Future<?> e;

    ase$a(long keepAliveTime, TimeUnit unit) {
        this.a = unit != null ? unit.toNanos(keepAliveTime) : 0;
        this.b = new ConcurrentLinkedQueue();
        this.c = new asn();
        ScheduledExecutorService evictor = null;
        Future<?> task = null;
        if (unit != null) {
            evictor = Executors.newScheduledThreadPool(1, ase.c);
            aql.b(evictor);
            task = evictor.scheduleWithFixedDelay(new ase$a$1(this), this.a, this.a, TimeUnit.NANOSECONDS);
        }
        this.d = evictor;
        this.e = task;
    }

    ase$c a() {
        if (this.c.isUnsubscribed()) {
            return ase.d;
        }
        while (!this.b.isEmpty()) {
            ase$c threadWorker = (ase$c) this.b.poll();
            if (threadWorker != null) {
                return threadWorker;
            }
        }
        apk w = new ase$c(ase.b);
        this.c.a(w);
        return w;
    }

    void a(ase$c threadWorker) {
        threadWorker.a(c() + this.a);
        this.b.offer(threadWorker);
    }

    void b() {
        if (!this.b.isEmpty()) {
            long currentTimestamp = c();
            Iterator i$ = this.b.iterator();
            while (i$.hasNext()) {
                ase$c threadWorker = (ase$c) i$.next();
                if (threadWorker.c() > currentTimestamp) {
                    return;
                }
                if (this.b.remove(threadWorker)) {
                    this.c.b(threadWorker);
                }
            }
        }
    }

    long c() {
        return System.nanoTime();
    }

    void d() {
        try {
            if (this.e != null) {
                this.e.cancel(true);
            }
            if (this.d != null) {
                this.d.shutdownNow();
            }
            this.c.unsubscribe();
        } catch (Throwable th) {
            this.c.unsubscribe();
        }
    }
}
