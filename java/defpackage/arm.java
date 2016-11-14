package defpackage;

/* compiled from: SpmcArrayQueue */
abstract class arm<E> extends ari<E> {
    protected static final long e = arv.a(arm.class, "producerIndex");
    private volatile long producerIndex;

    protected final long b() {
        return this.producerIndex;
    }

    protected final void d(long v) {
        arv.a.putOrderedLong(this, e, v);
    }

    public arm(int capacity) {
        super(capacity);
    }
}
