package defpackage;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

/* compiled from: CachedThreadScheduler */
final class ase$b extends apg$a {
    static final AtomicIntegerFieldUpdater<ase$b> b = AtomicIntegerFieldUpdater.newUpdater(ase$b.class, "a");
    volatile int a;
    private final asn c = new asn();
    private final ase$a d;
    private final ase$c e;

    ase$b(ase$a pool) {
        this.d = pool;
        this.e = pool.a();
    }

    public void unsubscribe() {
        if (b.compareAndSet(this, 0, 1)) {
            this.d.a(this.e);
        }
        this.c.unsubscribe();
    }

    public boolean isUnsubscribed() {
        return this.c.isUnsubscribed();
    }

    public apk a(apq action) {
        return a(action, 0, null);
    }

    public apk a(apq action, long delayTime, TimeUnit unit) {
        if (this.c.isUnsubscribed()) {
            return asq.b();
        }
        apk s = this.e.b(action, delayTime, unit);
        this.c.a(s);
        s.a(this.c);
        return s;
    }
}
