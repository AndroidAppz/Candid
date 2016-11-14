/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  sun.misc.Unsafe
 */
import sun.misc.Unsafe;

abstract class are<E>
extends arc<E> {
    private static final long e = arv.a(are.class, "producerIndex");
    private volatile long producerIndex;

    public are(int n2) {
        super(n2);
    }

    protected final long b() {
        return this.producerIndex;
    }

    protected final boolean c(long l2, long l3) {
        return arv.a.compareAndSwapLong((Object)this, e, l2, l3);
    }
}

