package defpackage;

/* compiled from: MpmcArrayQueue */
abstract class arb<E> extends ard<E> {
    private static final long e = arv.a(arb.class, "consumerIndex");
    private volatile long consumerIndex;

    public arb(int capacity) {
        super(capacity);
    }

    protected final long a() {
        return this.consumerIndex;
    }

    protected final boolean b(long expect, long newValue) {
        return arv.a.compareAndSwapLong(this, e, expect, newValue);
    }
}
