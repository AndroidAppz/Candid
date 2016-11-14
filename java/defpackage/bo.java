package defpackage;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* compiled from: ModernAsyncTask */
abstract class bo<Params, Progress, Result> {
    public static final Executor a = new ThreadPoolExecutor(5, 128, 1, TimeUnit.SECONDS, c, b);
    private static final ThreadFactory b = new bo$1();
    private static final BlockingQueue<Runnable> c = new LinkedBlockingQueue(10);
    private static volatile Executor d = a;
}
