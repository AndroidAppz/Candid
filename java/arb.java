/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  sun.misc.Unsafe
 */
import sun.misc.Unsafe;

abstract class arb<E>
extends ard<E> {
    private static final long e = arv.a(arb.class, "consumerIndex");
    private volatile long consumerIndex;

    public arb(int n2) {
        super(n2);
    }

    protected final long a() {
        return this.consumerIndex;
    }

    protected final boolean b(long l2, long l3) {
        return arv.a.compareAndSwapLong((Object)this, e, l2, l3);
    }
}

