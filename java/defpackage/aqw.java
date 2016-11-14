package defpackage;

import java.util.Collection;
import java.util.Iterator;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceArray;

/* compiled from: SpscUnboundedAtomicArrayQueue */
public final class aqw<T> implements Queue<T> {
    static final int a = Integer.getInteger("jctools.spsc.max.lookahead.step", 4096).intValue();
    static final AtomicLongFieldUpdater<aqw> c = AtomicLongFieldUpdater.newUpdater(aqw.class, "b");
    static final AtomicLongFieldUpdater<aqw> k = AtomicLongFieldUpdater.newUpdater(aqw.class, "j");
    private static final Object l = new Object();
    protected volatile long b;
    protected int d;
    protected long e;
    protected int f;
    protected AtomicReferenceArray<Object> g;
    protected int h;
    protected AtomicReferenceArray<Object> i;
    protected volatile long j;

    public aqw(int bufferSize) {
        int p2capacity = arf.a(Math.max(8, bufferSize));
        int mask = p2capacity - 1;
        AtomicReferenceArray<Object> buffer = new AtomicReferenceArray(p2capacity + 1);
        this.g = buffer;
        this.f = mask;
        a(p2capacity);
        this.i = buffer;
        this.h = mask;
        this.e = (long) (mask - 1);
        a(0);
    }

    public final boolean offer(T e) {
        if (e == null) {
            throw new NullPointerException();
        }
        AtomicReferenceArray buffer = this.g;
        long index = c();
        int mask = this.f;
        int offset = aqw.a(index, mask);
        if (index < this.e) {
            return a(buffer, e, index, offset);
        }
        int lookAheadStep = this.d;
        if (aqw.a(buffer, aqw.a(((long) lookAheadStep) + index, mask)) == null) {
            this.e = (((long) lookAheadStep) + index) - 1;
            return a(buffer, e, index, offset);
        } else if (aqw.a(buffer, aqw.a(1 + index, mask)) != null) {
            return a(buffer, e, index, offset);
        } else {
            a(buffer, index, offset, e, (long) mask);
            return true;
        }
    }

    private boolean a(AtomicReferenceArray<Object> buffer, T e, long index, int offset) {
        a(1 + index);
        aqw.a((AtomicReferenceArray) buffer, offset, (Object) e);
        return true;
    }

    private void a(AtomicReferenceArray<Object> oldBuffer, long currIndex, int offset, T e, long mask) {
        AtomicReferenceArray newBuffer = new AtomicReferenceArray(oldBuffer.length());
        this.g = newBuffer;
        this.e = (currIndex + mask) - 1;
        a(currIndex + 1);
        aqw.a(newBuffer, offset, (Object) e);
        a((AtomicReferenceArray) oldBuffer, newBuffer);
        aqw.a((AtomicReferenceArray) oldBuffer, offset, l);
    }

    private void a(AtomicReferenceArray<Object> curr, AtomicReferenceArray<Object> next) {
        aqw.a((AtomicReferenceArray) curr, aqw.b(curr.length() - 1), (Object) next);
    }

    private AtomicReferenceArray<Object> a(AtomicReferenceArray<Object> curr) {
        return (AtomicReferenceArray) aqw.a((AtomicReferenceArray) curr, aqw.b(curr.length() - 1));
    }

    public final T poll() {
        AtomicReferenceArray buffer = this.i;
        long index = d();
        int mask = this.h;
        int offset = aqw.a(index, mask);
        Object e = aqw.a(buffer, offset);
        boolean isNextBuffer = e == l;
        if (e == null || isNextBuffer) {
            return isNextBuffer ? a(a(buffer), index, mask) : null;
        } else {
            b(1 + index);
            aqw.a(buffer, offset, null);
            return e;
        }
    }

    private T a(AtomicReferenceArray<Object> nextBuffer, long index, int mask) {
        this.i = nextBuffer;
        int offsetInNew = aqw.a(index, mask);
        T n = aqw.a((AtomicReferenceArray) nextBuffer, offsetInNew);
        if (n == null) {
            return null;
        }
        b(1 + index);
        aqw.a((AtomicReferenceArray) nextBuffer, offsetInNew, null);
        return n;
    }

    public final T peek() {
        AtomicReferenceArray buffer = this.i;
        long index = d();
        int mask = this.h;
        Object e = aqw.a(buffer, aqw.a(index, mask));
        if (e == l) {
            return b(a(buffer), index, mask);
        }
        return e;
    }

    public void clear() {
        while (true) {
            if (poll() == null && isEmpty()) {
                return;
            }
        }
    }

    private T b(AtomicReferenceArray<Object> nextBuffer, long index, int mask) {
        this.i = nextBuffer;
        return aqw.a((AtomicReferenceArray) nextBuffer, aqw.a(index, mask));
    }

    public final int size() {
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

    private void a(int capacity) {
        this.d = Math.min(capacity / 4, a);
    }

    private long a() {
        return this.b;
    }

    private long b() {
        return this.j;
    }

    private long c() {
        return this.b;
    }

    private long d() {
        return this.j;
    }

    private void a(long v) {
        c.lazySet(this, v);
    }

    private void b(long v) {
        k.lazySet(this, v);
    }

    private static int a(long index, int mask) {
        return aqw.b(((int) index) & mask);
    }

    private static int b(int index) {
        return index;
    }

    private static void a(AtomicReferenceArray<Object> buffer, int offset, Object e) {
        buffer.lazySet(offset, e);
    }

    private static <E> Object a(AtomicReferenceArray<Object> buffer, int offset) {
        return buffer.get(offset);
    }

    public final Iterator<T> iterator() {
        throw new UnsupportedOperationException();
    }

    public boolean contains(Object o) {
        throw new UnsupportedOperationException();
    }

    public Object[] toArray() {
        throw new UnsupportedOperationException();
    }

    public <E> E[] toArray(E[] eArr) {
        throw new UnsupportedOperationException();
    }

    public boolean remove(Object o) {
        throw new UnsupportedOperationException();
    }

    public boolean containsAll(Collection<?> collection) {
        throw new UnsupportedOperationException();
    }

    public boolean addAll(Collection<? extends T> collection) {
        throw new UnsupportedOperationException();
    }

    public boolean removeAll(Collection<?> collection) {
        throw new UnsupportedOperationException();
    }

    public boolean retainAll(Collection<?> collection) {
        throw new UnsupportedOperationException();
    }

    public boolean add(T t) {
        throw new UnsupportedOperationException();
    }

    public T remove() {
        throw new UnsupportedOperationException();
    }

    public T element() {
        throw new UnsupportedOperationException();
    }
}
