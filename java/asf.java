/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  java.lang.Class
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.Throwable
 *  java.util.concurrent.ConcurrentLinkedQueue
 *  java.util.concurrent.Executor
 *  java.util.concurrent.Future
 *  java.util.concurrent.RejectedExecutionException
 *  java.util.concurrent.ScheduledExecutorService
 *  java.util.concurrent.ScheduledFuture
 *  java.util.concurrent.TimeUnit
 *  java.util.concurrent.atomic.AtomicInteger
 *  rx.internal.schedulers.ScheduledAction
 */
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.Future;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import rx.internal.schedulers.ScheduledAction;

public final class asf
extends apg {
    final Executor b;

    public asf(Executor executor) {
        this.b = executor;
    }

    @Override
    public apg.a createWorker() {
        return new a(this.b);
    }

    static final class a
    extends apg.a
    implements Runnable {
        final Executor a;
        final asn b;
        final ConcurrentLinkedQueue<ScheduledAction> c;
        final AtomicInteger d;

        public a(Executor executor) {
            this.a = executor;
            this.c = new ConcurrentLinkedQueue();
            this.d = new AtomicInteger();
            this.b = new asn();
        }

        /*
         * Enabled force condition propagation
         * Lifted jumps to return sites
         */
        @Override
        public apk a(apq apq2) {
            if (this.isUnsubscribed()) {
                return asq.b();
            }
            apk apk2 = new ScheduledAction(apq2, this.b);
            this.b.a(apk2);
            this.c.offer((Object)apk2);
            if (this.d.getAndIncrement() != 0) return apk2;
            try {
                this.a.execute((Runnable)this);
                return apk2;
            }
            catch (RejectedExecutionException var4_3) {
                this.b.b(apk2);
                this.d.decrementAndGet();
                asc.a().b().a((Throwable)var4_3);
                throw var4_3;
            }
        }

        /*
         * Enabled aggressive block sorting
         * Enabled unnecessary exception pruning
         * Enabled aggressive exception aggregation
         */
        @Override
        public apk a(final apq apq2, long l2, TimeUnit timeUnit) {
            if (l2 <= 0) {
                return this.a(apq2);
            }
            if (this.isUnsubscribed()) {
                return asq.b();
            }
            ScheduledExecutorService scheduledExecutorService = this.a instanceof ScheduledExecutorService ? (ScheduledExecutorService)this.a : aqk.c();
            aso aso2 = new aso();
            final aso aso3 = new aso();
            aso3.a(aso2);
            this.b.a(aso3);
            final apk apk2 = asq.a(new apq(){

                @Override
                public void call() {
                    a.this.b.b(aso3);
                }
            });
            ScheduledAction scheduledAction = new ScheduledAction(new apq(){

                /*
                 * Enabled aggressive block sorting
                 * Lifted jumps to return sites
                 */
                @Override
                public void call() {
                    if (aso3.isUnsubscribed()) {
                        return;
                    }
                    apk apk22 = a.this.a(apq2);
                    aso3.a(apk22);
                    if (apk22.getClass() != ScheduledAction.class) return;
                    ((ScheduledAction)apk22).a(apk2);
                }
            });
            aso2.a((apk)scheduledAction);
            try {
                scheduledAction.a((Future)scheduledExecutorService.schedule((Runnable)scheduledAction, l2, timeUnit));
                return apk2;
            }
            catch (RejectedExecutionException var10_9) {
                asc.a().b().a((Throwable)var10_9);
                throw var10_9;
            }
        }

        @Override
        public boolean isUnsubscribed() {
            return this.b.isUnsubscribed();
        }

        public void run() {
            do {
                ScheduledAction scheduledAction;
                if ((scheduledAction = (ScheduledAction)this.c.poll()).isUnsubscribed()) continue;
                scheduledAction.run();
            } while (this.d.decrementAndGet() > 0);
        }

        @Override
        public void unsubscribe() {
            this.b.unsubscribe();
        }

    }

}

