package defpackage;

/* compiled from: SpmcArrayQueue */
public final class arg<E> extends ark<E> {
    public arg(int capacity) {
        super(capacity);
    }

    public boolean offer(E e) {
        if (e == null) {
            throw new NullPointerException("Null is not a valid element");
        }
        E[] lb = this.c;
        long lMask = this.b;
        long currProducerIndex = b();
        long offset = a(currProducerIndex);
        if (b(lb, offset) == null) {
            a(lb, offset, e);
            d(1 + currProducerIndex);
        } else if (currProducerIndex - a() > lMask) {
            return false;
        } else {
            do {
            } while (b(lb, offset) != null);
        }
        a(lb, offset, e);
        d(1 + currProducerIndex);
        return true;
    }

    public E poll() {
        long currentConsumerIndex;
        long currProducerIndexCache = c();
        do {
            currentConsumerIndex = a();
            if (currentConsumerIndex >= currProducerIndexCache) {
                long currProducerIndex = b();
                if (currentConsumerIndex >= currProducerIndex) {
                    return null;
                }
                e(currProducerIndex);
            }
        } while (!b(currentConsumerIndex, 1 + currentConsumerIndex));
        long offset = a(currentConsumerIndex);
        E[] lb = this.c;
        E e = a((Object[]) lb, offset);
        b(lb, offset, null);
        return e;
    }

    public E peek() {
        E e;
        long currProducerIndexCache = c();
        do {
            long currentConsumerIndex = a();
            if (currentConsumerIndex >= currProducerIndexCache) {
                long currProducerIndex = b();
                if (currentConsumerIndex >= currProducerIndex) {
                    return null;
                }
                e(currProducerIndex);
            }
            e = c(a(currentConsumerIndex));
        } while (e == null);
        return e;
    }

    public int size() {
        long currentProducerIndex;
        long after = a();
        long before;
        do {
            before = after;
            currentProducerIndex = b();
            after = a();
        } while (before != after);
        return (int) (currentProducerIndex - after);
    }

    public boolean isEmpty() {
        return a() == b();
    }
}
