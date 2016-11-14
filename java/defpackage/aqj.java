package defpackage;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import rx.internal.util.RxThreadFactory;

/* compiled from: EventLoopsScheduler */
public class aqj extends apg implements aqm {
    static final RxThreadFactory b = new RxThreadFactory("RxComputationThreadPool-");
    static final int c;
    static final aqj$c d = new aqj$c(new RxThreadFactory("RxComputationShutdown-"));
    static final aqj$b e = new aqj$b(0);
    final AtomicReference<aqj$b> f = new AtomicReference(e);

    static {
        int max;
        int maxThreads = Integer.getInteger("rx.scheduler.max-computation-threads", 0).intValue();
        int ncpu = Runtime.getRuntime().availableProcessors();
        if (maxThreads <= 0 || maxThreads > ncpu) {
            max = ncpu;
        } else {
            max = maxThreads;
        }
        c = max;
        d.unsubscribe();
    }

    public aqj() {
        a();
    }

    public apg$a createWorker() {
        return new aqj$a(((aqj$b) this.f.get()).a());
    }

    public void a() {
        aqj$b update = new aqj$b(c);
        if (!this.f.compareAndSet(e, update)) {
            update.b();
        }
    }

    public void b() {
        aqj$b curr;
        do {
            curr = (aqj$b) this.f.get();
            if (curr == e) {
                return;
            }
        } while (!this.f.compareAndSet(curr, e));
        curr.b();
    }

    public apk a(apq action) {
        return ((aqj$b) this.f.get()).a().b(action, -1, TimeUnit.NANOSECONDS);
    }
}
