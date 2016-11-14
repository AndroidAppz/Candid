package defpackage;

import java.util.concurrent.ThreadFactory;

/* compiled from: CachedThreadScheduler */
final class ase$c extends aql {
    private long c = 0;

    ase$c(ThreadFactory threadFactory) {
        super(threadFactory);
    }

    public long c() {
        return this.c;
    }

    public void a(long expirationTime) {
        this.c = expirationTime;
    }
}
