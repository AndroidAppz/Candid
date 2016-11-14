/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  sun.misc.Unsafe
 */
import sun.misc.Unsafe;

abstract class arm<E>
extends ari<E> {
    protected static final long e = arv.a(arm.class, "producerIndex");
    private volatile long producerIndex;

    public arm(int n2) {
        super(n2);
    }

    protected final long b() {
        return this.producerIndex;
    }

    protected final void d(long l2) {
        arv.a.putOrderedLong((Object)this, e, l2);
    }
}

