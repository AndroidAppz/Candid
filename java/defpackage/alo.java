package defpackage;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;

/* compiled from: ExecutorUtils */
public final class alo {
    public static ExecutorService a(String name) {
        ExecutorService executor = Executors.newSingleThreadExecutor(alo.c(name));
        alo.a(name, executor);
        return executor;
    }

    public static ScheduledExecutorService b(String name) {
        ScheduledExecutorService executor = Executors.newSingleThreadScheduledExecutor(alo.c(name));
        alo.a(name, executor);
        return executor;
    }

    public static final ThreadFactory c(String threadNameTemplate) {
        return new alo$1(threadNameTemplate, new AtomicLong(1));
    }

    private static final void a(String serviceName, ExecutorService service) {
        alo.a(serviceName, service, 2, TimeUnit.SECONDS);
    }

    public static final void a(String serviceName, ExecutorService service, long terminationTimeout, TimeUnit timeUnit) {
        Runtime.getRuntime().addShutdownHook(new Thread(new alo$2(serviceName, service, terminationTimeout, timeUnit), "Crashlytics Shutdown Hook for " + serviceName));
    }
}
