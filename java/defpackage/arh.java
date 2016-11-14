package defpackage;

/* compiled from: SpmcArrayQueue */
abstract class arh<E> extends arj<E> {
    protected static final long d = arv.a(arh.class, "consumerIndex");
    private volatile long consumerIndex;

    public arh(int capacity) {
        super(capacity);
    }

    protected final long a() {
        return this.consumerIndex;
    }

    protected final boolean b(long expect, long newValue) {
        return arv.a.compareAndSwapLong(this, d, expect, newValue);
    }
}
