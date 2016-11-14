package defpackage;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.atomic.AtomicReference;
import rx.internal.util.RxThreadFactory;

/* compiled from: GenericScheduledExecutorService */
public final class aqk implements aqm {
    public static final aqk a = new aqk();
    private static final RxThreadFactory b = new RxThreadFactory("RxScheduledExecutorPool-");
    private static final ScheduledExecutorService c = Executors.newScheduledThreadPool(0);
    private final AtomicReference<ScheduledExecutorService> d = new AtomicReference(c);

    static {
        c.shutdownNow();
    }

    private aqk() {
        a();
    }

    public void a() {
        int count = Runtime.getRuntime().availableProcessors();
        if (count > 4) {
            count /= 2;
        }
        if (count > 8) {
            count = 8;
        }
        ScheduledExecutorService exec = Executors.newScheduledThreadPool(count, b);
        if (!this.d.compareAndSet(c, exec)) {
            exec.shutdownNow();
        } else if (!aql.b(exec) && (exec instanceof ScheduledThreadPoolExecutor)) {
            aql.a((ScheduledThreadPoolExecutor) exec);
        }
    }

    public void b() {
        ScheduledExecutorService exec;
        do {
            exec = (ScheduledExecutorService) this.d.get();
            if (exec == c) {
                return;
            }
        } while (!this.d.compareAndSet(exec, c));
        aql.a(exec);
        exec.shutdownNow();
    }

    public static ScheduledExecutorService c() {
        return (ScheduledExecutorService) a.d.get();
    }
}
