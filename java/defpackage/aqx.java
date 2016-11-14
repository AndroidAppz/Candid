package defpackage;

import java.util.Iterator;

/* compiled from: ConcurrentCircularArrayQueue */
public abstract class aqx<E> extends aqy<E> {
    protected static final int a = Integer.getInteger("sparse.shift", 0).intValue();
    private static final long d = ((long) (arv.a.arrayBaseOffset(Object[].class) + (32 << (e - a))));
    private static final int e;
    protected final long b;
    protected final E[] c;

    static {
        int scale = arv.a.arrayIndexScale(Object[].class);
        if (4 == scale) {
            e = a + 2;
        } else if (8 == scale) {
            e = a + 3;
        } else {
            throw new IllegalStateException("Unknown pointer size");
        }
    }

    public aqx(int capacity) {
        int actualCapacity = arf.a(capacity);
        this.b = (long) (actualCapacity - 1);
        this.c = new Object[((actualCapacity << a) + 64)];
    }

    protected final long a(long index) {
        return a(index, this.b);
    }

    protected final long a(long index, long mask) {
        return d + ((index & mask) << e);
    }

    protected final void a(long offset, E e) {
        a(this.c, offset, e);
    }

    protected final void a(E[] buffer, long offset, E e) {
        arv.a.putObject(buffer, offset, e);
    }

    protected final void b(E[] buffer, long offset, E e) {
        arv.a.putOrderedObject(buffer, offset, e);
    }

    protected final E b(long offset) {
        return a(this.c, offset);
    }

    protected final E a(E[] buffer, long offset) {
        return arv.a.getObject(buffer, offset);
    }

    protected final E c(long offset) {
        return b(this.c, offset);
    }

    protected final E b(E[] buffer, long offset) {
        return arv.a.getObjectVolatile(buffer, offset);
    }

    public Iterator<E> iterator() {
        throw new UnsupportedOperationException();
    }

    public void clear() {
        while (true) {
            if (poll() == null && isEmpty()) {
                return;
            }
        }
    }
}
