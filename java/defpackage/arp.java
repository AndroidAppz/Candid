package defpackage;

/* compiled from: SpscArrayQueue */
abstract class arp<E> extends aqx<E> {
    private static final Integer e = Integer.getInteger("jctools.spsc.max.lookahead.step", 4096);
    protected final int d;

    public arp(int capacity) {
        super(capacity);
        this.d = Math.min(capacity / 4, e.intValue());
    }
}
