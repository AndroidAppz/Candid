package defpackage;

import java.util.Iterator;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReferenceArray;

/* compiled from: SpscAtomicArrayQueue */
public final class aqv<E> extends aqu<E> {
    private static final Integer g = Integer.getInteger("jctools.spsc.max.lookahead.step", 4096);
    final AtomicLong c = new AtomicLong();
    protected long d;
    final AtomicLong e = new AtomicLong();
    final int f;

    public /* bridge */ /* synthetic */ void clear() {
        super.clear();
    }

    public /* bridge */ /* synthetic */ Iterator iterator() {
        return super.iterator();
    }

    public aqv(int capacity) {
        super(capacity);
        this.f = Math.min(capacity / 4, g.intValue());
    }

    public boolean offer(E e) {
        if (e == null) {
            throw new NullPointerException("Null is not a valid element");
        }
        AtomicReferenceArray<E> buffer = this.a;
        int mask = this.b;
        long index = this.c.get();
        int offset = a(index, mask);
        if (index >= this.d) {
            int step = this.f;
            if (a((AtomicReferenceArray) buffer, a(((long) step) + index, mask)) == null) {
                this.d = ((long) step) + index;
            } else if (a((AtomicReferenceArray) buffer, offset) != null) {
                return false;
            }
        }
        b(1 + index);
        a(buffer, offset, e);
        return true;
    }

    public E poll() {
        long index = this.e.get();
        int offset = a(index);
        AtomicReferenceArray<E> lElementBuffer = this.a;
        E e = a((AtomicReferenceArray) lElementBuffer, offset);
        if (e == null) {
            return null;
        }
        c(1 + index);
        a(lElementBuffer, offset, null);
        return e;
    }

    public E peek() {
        return a(a(this.e.get()));
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
        return b() == a();
    }

    private void b(long newIndex) {
        this.c.lazySet(newIndex);
    }

    private void c(long newIndex) {
        this.e.lazySet(newIndex);
    }

    private long a() {
        return this.e.get();
    }

    private long b() {
        return this.c.get();
    }
}
