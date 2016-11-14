/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.String
 *  java.lang.Thread
 *  java.util.concurrent.BlockingQueue
 *  java.util.concurrent.Executor
 *  java.util.concurrent.LinkedBlockingQueue
 *  java.util.concurrent.ThreadFactory
 *  java.util.concurrent.ThreadPoolExecutor
 *  java.util.concurrent.TimeUnit
 *  java.util.concurrent.atomic.AtomicInteger
 */
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

abstract class bo<Params, Progress, Result> {
    public static final Executor a;
    private static final ThreadFactory b;
    private static final BlockingQueue<Runnable> c;
    private static volatile Executor d;

    static {
        b = new ThreadFactory(){
            private final AtomicInteger a = new AtomicInteger(1);

            public Thread newThread(Runnable runnable) {
                return new Thread(runnable, "ModernAsyncTask #" + this.a.getAndIncrement());
            }
        };
        c = new LinkedBlockingQueue(10);
        d = bo.a = new ThreadPoolExecutor(5, 128, 1, TimeUnit.SECONDS, c, b);
    }

}

