package defpackage;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: ModernAsyncTask */
class bo$1 implements ThreadFactory {
    private final AtomicInteger a = new AtomicInteger(1);

    bo$1() {
    }

    public Thread newThread(Runnable r) {
        return new Thread(r, "ModernAsyncTask #" + this.a.getAndIncrement());
    }
}
