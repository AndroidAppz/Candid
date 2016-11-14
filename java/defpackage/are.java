package defpackage;

/* compiled from: MpmcArrayQueue */
abstract class are<E> extends arc<E> {
    private static final long e = arv.a(are.class, "producerIndex");
    private volatile long producerIndex;

    public are(int capacity) {
        super(capacity);
    }

    protected final long b() {
        return this.producerIndex;
    }

    protected final boolean c(long expect, long newValue) {
        return arv.a.compareAndSwapLong(this, e, expect, newValue);
    }
}
