/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  java.lang.InterruptedException
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.Runtime
 *  java.lang.String
 *  java.lang.Thread
 *  java.util.List
 *  java.util.Locale
 *  java.util.concurrent.ExecutorService
 *  java.util.concurrent.Executors
 *  java.util.concurrent.ScheduledExecutorService
 *  java.util.concurrent.ThreadFactory
 *  java.util.concurrent.TimeUnit
 *  java.util.concurrent.atomic.AtomicLong
 */
import java.util.List;
import java.util.Locale;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;

public final class alo {
    public static ExecutorService a(String string2) {
        ExecutorService executorService = Executors.newSingleThreadExecutor((ThreadFactory)alo.c(string2));
        alo.a(string2, executorService);
        return executorService;
    }

    private static final void a(String string2, ExecutorService executorService) {
        alo.a(string2, executorService, 2, TimeUnit.SECONDS);
    }

    public static final void a(final String string2, final ExecutorService executorService, final long l2, final TimeUnit timeUnit) {
        Runtime.getRuntime().addShutdownHook(new Thread((Runnable)new alk(){

            @Override
            public void a() {
                try {
                    akp.h().a("Fabric", "Executing shutdown hook for " + string2);
                    executorService.shutdown();
                    if (!executorService.awaitTermination(l2, timeUnit)) {
                        akp.h().a("Fabric", string2 + " did not shut down in the" + " allocated time. Requesting immediate shutdown.");
                        executorService.shutdownNow();
                    }
                    return;
                }
                catch (InterruptedException var1_1) {
                    akx akx2 = akp.h();
                    Locale locale = Locale.US;
                    Object[] arrobject = new Object[]{string2};
                    akx2.a("Fabric", String.format((Locale)locale, (String)"Interrupted while waiting for %s to shut down. Requesting immediate shutdown.", (Object[])arrobject));
                    executorService.shutdownNow();
                    return;
                }
            }
        }, "Crashlytics Shutdown Hook for " + string2));
    }

    public static ScheduledExecutorService b(String string2) {
        ScheduledExecutorService scheduledExecutorService = Executors.newSingleThreadScheduledExecutor((ThreadFactory)alo.c(string2));
        alo.a(string2, (ExecutorService)scheduledExecutorService);
        return scheduledExecutorService;
    }

    public static final ThreadFactory c(final String string2) {
        return new ThreadFactory(new AtomicLong(1)){
            final /* synthetic */ AtomicLong b;

            public Thread newThread(final Runnable runnable) {
                Thread thread = Executors.defaultThreadFactory().newThread((Runnable)new alk(){

                    @Override
                    public void a() {
                        runnable.run();
                    }
                });
                thread.setName(string2 + this.b.getAndIncrement());
                return thread;
            }

        };
    }

}

