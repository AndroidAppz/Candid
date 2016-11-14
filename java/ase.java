/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  java.lang.Class
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.String
 *  java.lang.System
 *  java.util.Iterator
 *  java.util.List
 *  java.util.concurrent.ConcurrentLinkedQueue
 *  java.util.concurrent.Executors
 *  java.util.concurrent.Future
 *  java.util.concurrent.ScheduledExecutorService
 *  java.util.concurrent.ScheduledFuture
 *  java.util.concurrent.ThreadFactory
 *  java.util.concurrent.TimeUnit
 *  java.util.concurrent.atomic.AtomicIntegerFieldUpdater
 *  java.util.concurrent.atomic.AtomicReference
 *  rx.internal.schedulers.ScheduledAction
 *  rx.internal.util.RxThreadFactory
 */
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReference;
import rx.internal.schedulers.ScheduledAction;
import rx.internal.util.RxThreadFactory;

public final class ase
extends apg
implements aqm {
    static final RxThreadFactory b = new RxThreadFactory("RxCachedThreadScheduler-");
    static final RxThreadFactory c = new RxThreadFactory("RxCachedWorkerPoolEvictor-");
    static final c d;
    static final a f;
    private static final TimeUnit g;
    final AtomicReference<a> e = new AtomicReference((Object)f);

    static {
        g = TimeUnit.SECONDS;
        d = new c((ThreadFactory)new RxThreadFactory("RxCachedThreadSchedulerShutdown-"));
        d.unsubscribe();
        f = new a(0, null);
        f.d();
    }

    public ase() {
        this.a();
    }

    public void a() {
        a a2 = new a(60, g);
        if (!this.e.compareAndSet((Object)f, (Object)a2)) {
            a2.d();
        }
    }

    @Override
    public void b() {
        a a2;
        do {
            if ((a2 = (a)this.e.get()) != f) continue;
            return;
        } while (!this.e.compareAndSet((Object)a2, (Object)f));
        a2.d();
    }

    @Override
    public apg.a createWorker() {
        return new b((a)this.e.get());
    }

    static final class a {
        private final long a;
        private final ConcurrentLinkedQueue<c> b;
        private final asn c;
        private final ScheduledExecutorService d;
        private final Future<?> e;

        /*
         * Enabled aggressive block sorting
         */
        a(long l2, TimeUnit timeUnit) {
            long l3 = timeUnit != null ? timeUnit.toNanos(l2) : 0;
            this.a = l3;
            this.b = new ConcurrentLinkedQueue();
            this.c = new asn();
            ScheduledExecutorService scheduledExecutorService = null;
            ScheduledFuture scheduledFuture = null;
            if (timeUnit != null) {
                scheduledExecutorService = Executors.newScheduledThreadPool((int)1, (ThreadFactory)ase.c);
                aql.b(scheduledExecutorService);
                scheduledFuture = scheduledExecutorService.scheduleWithFixedDelay(new Runnable(){

                    public void run() {
                        a.this.b();
                    }
                }, this.a, this.a, TimeUnit.NANOSECONDS);
            }
            this.d = scheduledExecutorService;
            this.e = scheduledFuture;
        }

        c a() {
            if (this.c.isUnsubscribed()) {
                return ase.d;
            }
            while (!this.b.isEmpty()) {
                c c2 = (c)this.b.poll();
                if (c2 == null) continue;
                return c2;
            }
            c c3 = new c((ThreadFactory)ase.b);
            this.c.a(c3);
            return c3;
        }

        void a(c c2) {
            c2.a(this.c() + this.a);
            this.b.offer((Object)c2);
        }

        void b() {
            if (!this.b.isEmpty()) {
                c c2;
                long l2 = this.c();
                Iterator iterator = this.b.iterator();
                while (iterator.hasNext() && (c2 = (c)iterator.next()).c() <= l2) {
                    if (!this.b.remove((Object)c2)) continue;
                    this.c.b(c2);
                }
            }
        }

        long c() {
            return System.nanoTime();
        }

        void d() {
            try {
                if (this.e != null) {
                    this.e.cancel(true);
                }
                if (this.d != null) {
                    this.d.shutdownNow();
                }
                return;
            }
            finally {
                this.c.unsubscribe();
            }
        }

    }

    static final class b
    extends apg.a {
        static final AtomicIntegerFieldUpdater<b> b = AtomicIntegerFieldUpdater.newUpdater((Class)b.class, (String)"a");
        volatile int a;
        private final asn c = new asn();
        private final a d;
        private final c e;

        b(a a2) {
            this.d = a2;
            this.e = a2.a();
        }

        @Override
        public apk a(apq apq2) {
            return this.a(apq2, 0, null);
        }

        @Override
        public apk a(apq apq2, long l2, TimeUnit timeUnit) {
            if (this.c.isUnsubscribed()) {
                return asq.b();
            }
            ScheduledAction scheduledAction = this.e.b(apq2, l2, timeUnit);
            this.c.a((apk)scheduledAction);
            scheduledAction.a(this.c);
            return scheduledAction;
        }

        @Override
        public boolean isUnsubscribed() {
            return this.c.isUnsubscribed();
        }

        @Override
        public void unsubscribe() {
            if (b.compareAndSet((Object)this, 0, 1)) {
                this.d.a(this.e);
            }
            this.c.unsubscribe();
        }
    }

    static final class c
    extends aql {
        private long c = 0;

        c(ThreadFactory threadFactory) {
            super(threadFactory);
        }

        public void a(long l2) {
            this.c = l2;
        }

        public long c() {
            return this.c;
        }
    }

}

