package defpackage;

/* compiled from: ConcurrentSequencedCircularArrayQueue */
public abstract class aqz<E> extends aqx<E> {
    private static final long e = ((long) (arv.a.arrayBaseOffset(long[].class) + (32 << (f - a))));
    private static final int f = (a + 3);
    protected final long[] d;

    static {
        if (8 == arv.a.arrayIndexScale(long[].class)) {
            return;
        }
        throw new IllegalStateException("Unexpected long[] element size");
    }

    public aqz(int capacity) {
        super(capacity);
        int actualCapacity = (int) (this.b + 1);
        this.d = new long[((actualCapacity << a) + 64)];
        for (long i = 0; i < ((long) actualCapacity); i++) {
            a(this.d, d(i), i);
        }
    }

    protected final long d(long index) {
        return e + ((this.b & index) << f);
    }

    protected final void a(long[] buffer, long offset, long e) {
        arv.a.putOrderedLong(buffer, offset, e);
    }

    protected final long a(long[] buffer, long offset) {
        return arv.a.getLongVolatile(buffer, offset);
    }
}
