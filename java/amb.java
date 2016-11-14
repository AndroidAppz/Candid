/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.annotation.TargetApi
 *  io.fabric.sdk.android.services.concurrency.DependencyPriorityBlockingQueue
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.Runtime
 *  java.lang.String
 *  java.lang.Thread
 *  java.lang.Throwable
 *  java.util.concurrent.BlockingQueue
 *  java.util.concurrent.Callable
 *  java.util.concurrent.RunnableFuture
 *  java.util.concurrent.ThreadFactory
 *  java.util.concurrent.ThreadPoolExecutor
 *  java.util.concurrent.TimeUnit
 */
import android.annotation.TargetApi;
import io.fabric.sdk.android.services.concurrency.DependencyPriorityBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.RunnableFuture;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class amb
extends ThreadPoolExecutor {
    private static final int a = Runtime.getRuntime().availableProcessors();
    private static final int b = 1 + a;
    private static final int c = 1 + 2 * a;

    <T extends Runnable,  extends alu,  extends alz> amb(int n2, int n3, long l2, TimeUnit timeUnit, DependencyPriorityBlockingQueue<T> dependencyPriorityBlockingQueue, ThreadFactory threadFactory) {
        super(n2, n3, l2, timeUnit, dependencyPriorityBlockingQueue, threadFactory);
        this.prestartAllCoreThreads();
    }

    public static amb a() {
        return amb.a(b, c);
    }

    public static <T extends Runnable,  extends alu,  extends alz> amb a(int n2, int n3) {
        return new amb(n2, n3, 1, TimeUnit.SECONDS, new DependencyPriorityBlockingQueue(), new a(10));
    }

    protected void afterExecute(Runnable runnable, Throwable throwable) {
        amc amc2 = (amc)runnable;
        amc2.b(true);
        amc2.a(throwable);
        this.b().d();
        super.afterExecute(runnable, throwable);
    }

    public DependencyPriorityBlockingQueue b() {
        return (DependencyPriorityBlockingQueue)super.getQueue();
    }

    @TargetApi(value=9)
    public void execute(Runnable runnable) {
        if (ama.a((Object)runnable)) {
            super.execute(runnable);
            return;
        }
        super.execute(this.newTaskFor(runnable, null));
    }

    public /* synthetic */ BlockingQueue getQueue() {
        return this.b();
    }

    protected <T> RunnableFuture<T> newTaskFor(Runnable runnable, T t2) {
        return new aly<T>(runnable, t2);
    }

    protected <T> RunnableFuture<T> newTaskFor(Callable<T> callable) {
        return new aly<T>(callable);
    }

    public static final class a
    implements ThreadFactory {
        private final int a;

        public a(int n2) {
            this.a = n2;
        }

        public Thread newThread(Runnable runnable) {
            Thread thread = new Thread(runnable);
            thread.setPriority(this.a);
            thread.setName("Queue");
            return thread;
        }
    }

}

