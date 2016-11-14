/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  java.lang.IllegalArgumentException
 *  java.lang.Long
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.Throwable
 *  java.util.concurrent.ConcurrentLinkedQueue
 *  java.util.concurrent.atomic.AtomicBoolean
 *  java.util.concurrent.atomic.AtomicLong
 *  rx.exceptions.MissingBackpressureException
 *  rx.internal.operators.NotificationLite
 *  rx.internal.util.BackpressureDrainManager
 *  rx.internal.util.BackpressureDrainManager$a
 */
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import rx.exceptions.MissingBackpressureException;
import rx.internal.operators.NotificationLite;
import rx.internal.util.BackpressureDrainManager;

public class aqf<T>
implements apd.b<T, T> {
    private final Long a;
    private final apq b;

    aqf() {
        this.a = null;
        this.b = null;
    }

    public aqf(long l2) {
        super(l2, null);
    }

    public aqf(long l2, apq apq2) {
        if (l2 <= 0) {
            throw new IllegalArgumentException("Buffer capacity must be > 0");
        }
        this.a = l2;
        this.b = apq2;
    }

    public apj<? super T> a(apj<? super T> apj2) {
        a<T> a2 = new a<T>(apj2, this.a, this.b);
        apj2.add(a2);
        apj2.setProducer(a2.c());
        return a2;
    }

    @Override
    public /* synthetic */ Object call(Object object) {
        return this.a((apj)object);
    }

    static final class a<T>
    extends apj<T>
    implements BackpressureDrainManager.a {
        private final ConcurrentLinkedQueue<Object> a = new ConcurrentLinkedQueue();
        private final Long b;
        private final AtomicLong c;
        private final apj<? super T> d;
        private final AtomicBoolean e = new AtomicBoolean(false);
        private final BackpressureDrainManager f;
        private final NotificationLite<T> g = NotificationLite.a();
        private final apq h;

        /*
         * Enabled aggressive block sorting
         */
        public a(apj<? super T> apj2, Long l2, apq apq2) {
            this.d = apj2;
            this.b = l2;
            AtomicLong atomicLong = l2 != null ? new AtomicLong(l2.longValue()) : null;
            this.c = atomicLong;
            this.h = apq2;
            this.f = new BackpressureDrainManager((BackpressureDrainManager.a)this);
        }

        /*
         * Enabled force condition propagation
         * Lifted jumps to return sites
         */
        private boolean d() {
            long l2;
            if (this.c == null) {
                return true;
            }
            do {
                if ((l2 = this.c.get()) > 0) continue;
                if (!this.e.compareAndSet(false, true)) return false;
                this.unsubscribe();
                this.d.onError((Throwable)new MissingBackpressureException("Overflowed buffer of " + (Object)this.b));
                if (this.h == null) return false;
                try {
                    this.h.call();
                }
                catch (Throwable throwable) {
                    app.a(throwable);
                    this.f.a(throwable);
                    return false;
                }
                return false;
            } while (!this.c.compareAndSet(l2, l2 - 1));
            return true;
        }

        public Object a() {
            return this.a.peek();
        }

        public void a(Throwable throwable) {
            if (throwable != null) {
                this.d.onError(throwable);
                return;
            }
            this.d.onCompleted();
        }

        public boolean a(Object object) {
            return this.g.a(this.d, object);
        }

        public Object b() {
            Object object = this.a.poll();
            if (this.c != null && object != null) {
                this.c.incrementAndGet();
            }
            return object;
        }

        protected apf c() {
            return this.f;
        }

        @Override
        public void onCompleted() {
            if (!this.e.get()) {
                this.f.a();
            }
        }

        @Override
        public void onError(Throwable throwable) {
            if (!this.e.get()) {
                this.f.a(throwable);
            }
        }

        @Override
        public void onNext(T t2) {
            if (!super.d()) {
                return;
            }
            this.a.offer(this.g.a(t2));
            this.f.b();
        }

        @Override
        public void onStart() {
            this.request(Long.MAX_VALUE);
        }
    }

}

