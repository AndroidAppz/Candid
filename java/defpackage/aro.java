package defpackage;

/* compiled from: SpscArrayQueue */
public final class aro<E> extends art<E> {
    public aro(int capacity) {
        super(capacity);
    }

    public boolean offer(E e) {
        if (e == null) {
            throw new NullPointerException("null elements not allowed");
        }
        E[] lElementBuffer = this.c;
        long index = this.producerIndex;
        long offset = a(index);
        if (b(lElementBuffer, offset) != null) {
            return false;
        }
        d(1 + index);
        b(lElementBuffer, offset, e);
        return true;
    }

    public E poll() {
        long index = this.consumerIndex;
        long offset = a(index);
        E[] lElementBuffer = this.c;
        E e = b(lElementBuffer, offset);
        if (e == null) {
            return null;
        }
        e(1 + index);
        b(lElementBuffer, offset, null);
        return e;
    }

    public E peek() {
        return c(a(this.consumerIndex));
    }

    public int size() {
        long currentProducerIndex;
        long after = b();
        long before;
        do {
            before = after;
            currentProducerIndex = a();
            after = b();
        } while (before != after);
        return (int) (currentProducerIndex - after);
    }

    public boolean isEmpty() {
        return a() == b();
    }

    private void d(long v) {
        arv.a.putOrderedLong(this, f, v);
    }

    private void e(long v) {
        arv.a.putOrderedLong(this, e, v);
    }

    private long a() {
        return arv.a.getLongVolatile(this, f);
    }

    private long b() {
        return arv.a.getLongVolatile(this, e);
    }
}
