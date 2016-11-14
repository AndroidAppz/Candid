package defpackage;

import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import rx.exceptions.MissingBackpressureException;
import rx.internal.operators.NotificationLite;
import rx.internal.util.BackpressureDrainManager;
import rx.internal.util.BackpressureDrainManager.a;

/* compiled from: OperatorOnBackpressureBuffer */
final class aqf$a<T> extends apj<T> implements a {
    private final ConcurrentLinkedQueue<Object> a = new ConcurrentLinkedQueue();
    private final Long b;
    private final AtomicLong c;
    private final apj<? super T> d;
    private final AtomicBoolean e = new AtomicBoolean(false);
    private final BackpressureDrainManager f;
    private final NotificationLite<T> g = NotificationLite.a();
    private final apq h;

    public aqf$a(apj<? super T> child, Long capacity, apq onOverflow) {
        this.d = child;
        this.b = capacity;
        this.c = capacity != null ? new AtomicLong(capacity.longValue()) : null;
        this.h = onOverflow;
        this.f = new BackpressureDrainManager(this);
    }

    public void onStart() {
        request(Long.MAX_VALUE);
    }

    public void onCompleted() {
        if (!this.e.get()) {
            this.f.a();
        }
    }

    public void onError(Throwable e) {
        if (!this.e.get()) {
            this.f.a(e);
        }
    }

    public void onNext(T t) {
        if (d()) {
            this.a.offer(this.g.a(t));
            this.f.b();
        }
    }

    public boolean a(Object value) {
        return this.g.a(this.d, value);
    }

    public void a(Throwable exception) {
        if (exception != null) {
            this.d.onError(exception);
        } else {
            this.d.onCompleted();
        }
    }

    public Object a() {
        return this.a.peek();
    }

    public Object b() {
        Object value = this.a.poll();
        if (!(this.c == null || value == null)) {
            this.c.incrementAndGet();
        }
        return value;
    }

    private boolean d() {
        if (this.c == null) {
            return true;
        }
        long currCapacity;
        do {
            currCapacity = this.c.get();
            if (currCapacity <= 0) {
                if (this.e.compareAndSet(false, true)) {
                    unsubscribe();
                    this.d.onError(new MissingBackpressureException("Overflowed buffer of " + this.b));
                    if (this.h != null) {
                        try {
                            this.h.call();
                        } catch (Throwable e) {
                            app.a(e);
                            this.f.a(e);
                            return false;
                        }
                    }
                }
                return false;
            }
        } while (!this.c.compareAndSet(currCapacity, currCapacity - 1));
        return true;
    }

    protected apf c() {
        return this.f;
    }
}
