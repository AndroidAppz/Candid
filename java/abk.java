/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.Thread
 *  java.util.concurrent.Executors
 *  java.util.concurrent.ThreadFactory
 *  java.util.concurrent.atomic.AtomicInteger
 */
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

public class abk
implements ThreadFactory {
    private final String a;
    private final int b;
    private final AtomicInteger c;
    private final ThreadFactory d;

    public abk(String string2) {
        super(string2, 0);
    }

    public abk(String string2, int n2) {
        this.c = new AtomicInteger();
        this.d = Executors.defaultThreadFactory();
        this.a = xr.a(string2, (Object)"Name must not be null");
        this.b = n2;
    }

    public Thread newThread(Runnable runnable) {
        Thread thread = this.d.newThread((Runnable)new abl(runnable, this.b));
        String string2 = this.a;
        int n2 = this.c.getAndIncrement();
        thread.setName(new StringBuilder(13 + String.valueOf((Object)string2).length()).append(string2).append("[").append(n2).append("]").toString());
        return thread;
    }
}

