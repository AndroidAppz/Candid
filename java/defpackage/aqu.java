package defpackage;

import java.util.AbstractQueue;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicReferenceArray;

/* compiled from: AtomicReferenceArrayQueue */
abstract class aqu<E> extends AbstractQueue<E> {
    protected final AtomicReferenceArray<E> a;
    protected final int b;

    public aqu(int capacity) {
        int actualCapacity = arf.a(capacity);
        this.b = actualCapacity - 1;
        this.a = new AtomicReferenceArray(actualCapacity);
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

    protected final int a(long index, int mask) {
        return ((int) index) & mask;
    }

    protected final int a(long index) {
        return ((int) index) & this.b;
    }

    protected final E a(AtomicReferenceArray<E> buffer, int offset) {
        return buffer.get(offset);
    }

    protected final void a(AtomicReferenceArray<E> buffer, int offset, E value) {
        buffer.lazySet(offset, value);
    }

    protected final E a(int offset) {
        return a(this.a, offset);
    }
}
