/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.Runtime
 *  java.lang.String
 *  java.util.List
 *  java.util.concurrent.Executors
 *  java.util.concurrent.ScheduledExecutorService
 *  java.util.concurrent.ScheduledThreadPoolExecutor
 *  java.util.concurrent.ThreadFactory
 *  java.util.concurrent.atomic.AtomicReference
 *  rx.internal.util.RxThreadFactory
 */
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicReference;
import rx.internal.util.RxThreadFactory;

public final class aqk
implements aqm {
    public static final aqk a;
    private static final RxThreadFactory b;
    private static final ScheduledExecutorService c;
    private final AtomicReference<ScheduledExecutorService> d = new AtomicReference((Object)c);

    static {
        b = new RxThreadFactory("RxScheduledExecutorPool-");
        c = Executors.newScheduledThreadPool((int)0);
        c.shutdownNow();
        a = new aqk();
    }

    private aqk() {
        this.a();
    }

    public static ScheduledExecutorService c() {
        return (ScheduledExecutorService)aqk.a.d.get();
    }

    public void a() {
        ScheduledExecutorService scheduledExecutorService;
        int n2 = Runtime.getRuntime().availableProcessors();
        if (n2 > 4) {
            n2 /= 2;
        }
        if (n2 > 8) {
            n2 = 8;
        }
        if (this.d.compareAndSet((Object)c, (Object)(scheduledExecutorService = Executors.newScheduledThreadPool((int)n2, (ThreadFactory)b)))) {
            if (!aql.b(scheduledExecutorService) && scheduledExecutorService instanceof ScheduledThreadPoolExecutor) {
                aql.a((ScheduledThreadPoolExecutor)scheduledExecutorService);
            }
            return;
        }
        scheduledExecutorService.shutdownNow();
    }

    @Override
    public void b() {
        ScheduledExecutorService scheduledExecutorService;
        do {
            if ((scheduledExecutorService = (ScheduledExecutorService)this.d.get()) != c) continue;
            return;
        } while (!this.d.compareAndSet((Object)scheduledExecutorService, (Object)c));
        aql.a(scheduledExecutorService);
        scheduledExecutorService.shutdownNow();
    }
}

