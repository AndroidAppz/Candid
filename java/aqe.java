/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.Throwable
 *  java.util.Queue
 *  java.util.concurrent.atomic.AtomicLong
 *  rx.exceptions.MissingBackpressureException
 *  rx.internal.operators.NotificationLite
 *  rx.schedulers.ImmediateScheduler
 */
import java.util.Queue;
import java.util.concurrent.atomic.AtomicLong;
import rx.exceptions.MissingBackpressureException;
import rx.internal.operators.NotificationLite;
import rx.schedulers.ImmediateScheduler;

public final class aqe<T>
implements apd.b<T, T> {
    private final apg a;
    private final boolean b;

    public aqe(apg apg2, boolean bl2) {
        this.a = apg2;
        this.b = bl2;
    }

    /*
     * Enabled aggressive block sorting
     */
    public apj<? super T> a(apj<? super T> apj2) {
        if (this.a instanceof ImmediateScheduler || this.a instanceof asi) {
            return apj2;
        }
        a<T> a2 = new a<T>(this.a, apj2, this.b);
        a2.a();
        return a2;
    }

    @Override
    public /* synthetic */ Object call(Object object) {
        return this.a((apj)object);
    }

    static final class a<T>
    extends apj<T>
    implements apq {
        final apj<? super T> a;
        final apg.a b;
        final NotificationLite<T> c;
        final boolean d;
        final Queue<Object> e;
        volatile boolean f;
        final AtomicLong g = new AtomicLong();
        final AtomicLong h = new AtomicLong();
        Throwable i;

        public a(apg apg2, apj<? super T> apj2, boolean bl2) {
            this.a = apj2;
            this.b = apg2.createWorker();
            this.d = bl2;
            this.c = NotificationLite.a();
            if (arv.a()) {
                this.e = new aro(aqq.c);
                return;
            }
            this.e = new aqv(aqq.c);
        }

        void a() {
            apj<T> apj2 = this.a;
            apj2.setProducer(new apf(){

                @Override
                public void a(long l2) {
                    if (l2 > 0) {
                        apy.a(a.this.g, l2);
                        a.this.b();
                    }
                }
            });
            apj2.add(this.b);
            apj2.add(this);
        }

        /*
         * Unable to fully structure code
         * Enabled aggressive block sorting
         * Enabled unnecessary exception pruning
         * Enabled aggressive exception aggregation
         * Lifted jumps to return sites
         */
        boolean a(boolean var1_1, boolean var2_4, apj<? super T> var3_3, Queue<Object> var4) {
            if (var3_3.isUnsubscribed()) {
                var4.clear();
                return true;
            }
            if (var1_1 == false) return false;
            if (!this.d) ** GOTO lbl17
            if (var2_4 == false) return false;
            var8_5 = this.i;
            if (var8_5 == null) ** GOTO lbl12
            try {
                var3_3.onError(var8_5);
                return false;
lbl12: // 1 sources:
                var3_3.onCompleted();
                return false;
            }
            finally {
                this.b.unsubscribe();
            }
lbl17: // 1 sources:
            var5_7 = this.i;
            if (var5_7 != null) {
                var4.clear();
                try {
                    var3_3.onError(var5_7);
                    return true;
                }
                finally {
                    this.b.unsubscribe();
                }
            }
            if (var2_4 == false) return false;
            try {
                var3_3.onCompleted();
                return true;
            }
            finally {
                this.b.unsubscribe();
            }
        }

        protected void b() {
            if (this.h.getAndIncrement() == 0) {
                this.b.a(this);
            }
        }

        /*
         * Enabled aggressive block sorting
         * Lifted jumps to return sites
         */
        @Override
        public void call() {
            long l2 = 0;
            long l3 = 1;
            Queue<Object> queue = this.e;
            apj<? super T> apj2 = this.a;
            NotificationLite<T> notificationLite = this.c;
            block0 : do {
                if (this.a(this.f, queue.isEmpty(), apj2, queue)) {
                    return;
                }
                long l4 = this.g.get();
                boolean bl2 = l4 == Long.MAX_VALUE;
                long l5 = 0;
                while (l4 != 0) {
                    boolean bl3 = this.f;
                    Object object = queue.poll();
                    boolean bl4 = object == null;
                    if (this.a(bl3, bl4, apj2, queue)) return;
                    if (bl4) {
                        if (l5 == 0 || bl2) continue block0;
                        this.g.addAndGet(l5);
                        continue block0;
                    }
                    apj2.onNext(notificationLite.c(object));
                    --l4;
                    --l5;
                    ++l2;
                }
            } while ((l3 = this.h.addAndGet(- l3)) != 0);
            if (l2 == 0) return;
            this.request(l2);
        }

        @Override
        public void onCompleted() {
            if (this.isUnsubscribed() || this.f) {
                return;
            }
            this.f = true;
            this.b();
        }

        @Override
        public void onError(Throwable throwable) {
            if (this.isUnsubscribed() || this.f) {
                asc.a().b().a(throwable);
                return;
            }
            this.i = throwable;
            this.f = true;
            this.b();
        }

        @Override
        public void onNext(T t2) {
            if (this.isUnsubscribed() || this.f) {
                return;
            }
            if (!this.e.offer(this.c.a(t2))) {
                this.onError((Throwable)new MissingBackpressureException());
                return;
            }
            this.b();
        }

        @Override
        public void onStart() {
            this.request(aqq.c);
        }

    }

}

