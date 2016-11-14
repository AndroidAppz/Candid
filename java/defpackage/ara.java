package defpackage;

/* compiled from: MpmcArrayQueue */
public class ara<E> extends arb<E> {
    public ara(int capacity) {
        super(Math.max(2, capacity));
    }

    public boolean offer(E e) {
        if (e == null) {
            throw new NullPointerException("Null is not a valid element");
        }
        long capacity = this.b + 1;
        long[] lSequenceBuffer = this.d;
        long cIndex = Long.MAX_VALUE;
        while (true) {
            long currentProducerIndex = b();
            long seqOffset = d(currentProducerIndex);
            long delta = a(lSequenceBuffer, seqOffset) - currentProducerIndex;
            if (delta == 0) {
                if (c(currentProducerIndex, 1 + currentProducerIndex)) {
                    a(a(currentProducerIndex), (Object) e);
                    a(lSequenceBuffer, seqOffset, 1 + currentProducerIndex);
                    return true;
                }
            } else if (delta < 0 && currentProducerIndex - capacity <= cIndex) {
                long j = currentProducerIndex - capacity;
                cIndex = a();
                if (j <= cIndex) {
                    return false;
                }
            }
        }
    }

    public E poll() {
        long[] lSequenceBuffer = this.d;
        long pIndex = -1;
        while (true) {
            long currentConsumerIndex = a();
            long seqOffset = d(currentConsumerIndex);
            long delta = a(lSequenceBuffer, seqOffset) - (1 + currentConsumerIndex);
            if (delta == 0) {
                if (b(currentConsumerIndex, 1 + currentConsumerIndex)) {
                    long offset = a(currentConsumerIndex);
                    E e = b(offset);
                    a(offset, null);
                    a(lSequenceBuffer, seqOffset, (this.b + currentConsumerIndex) + 1);
                    return e;
                }
            } else if (delta < 0 && currentConsumerIndex >= pIndex) {
                pIndex = b();
                if (currentConsumerIndex == pIndex) {
                    return null;
                }
            }
        }
    }

    public E peek() {
        E e;
        long currConsumerIndex;
        do {
            currConsumerIndex = a();
            e = b(a(currConsumerIndex));
            if (e != null) {
                break;
            }
        } while (currConsumerIndex != b());
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
