package defpackage;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import rx.internal.util.RxThreadFactory;

/* compiled from: CachedThreadScheduler */
public final class ase extends apg implements aqm {
    static final RxThreadFactory b = new RxThreadFactory("RxCachedThreadScheduler-");
    static final RxThreadFactory c = new RxThreadFactory("RxCachedWorkerPoolEvictor-");
    static final ase$c d = new ase$c(new RxThreadFactory("RxCachedThreadSchedulerShutdown-"));
    static final ase$a f = new ase$a(0, null);
    private static final TimeUnit g = TimeUnit.SECONDS;
    final AtomicReference<ase$a> e = new AtomicReference(f);

    static {
        d.unsubscribe();
        f.d();
    }

    public ase() {
        a();
    }

    public void a() {
        ase$a update = new ase$a(60, g);
        if (!this.e.compareAndSet(f, update)) {
            update.d();
        }
    }

    public void b() {
        ase$a curr;
        do {
            curr = (ase$a) this.e.get();
            if (curr == f) {
                return;
            }
        } while (!this.e.compareAndSet(curr, f));
        curr.d();
    }

    public apg$a createWorker() {
        return new ase$b((ase$a) this.e.get());
    }
}
