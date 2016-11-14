/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  java.lang.Class
 *  java.lang.Integer
 *  java.lang.Math
 *  java.lang.NullPointerException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.UnsupportedOperationException
 *  java.util.Collection
 *  java.util.Iterator
 *  java.util.Queue
 *  java.util.concurrent.atomic.AtomicLongFieldUpdater
 *  java.util.concurrent.atomic.AtomicReferenceArray
 */
import java.util.Collection;
import java.util.Iterator;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceArray;

public final class aqw<T>
implements Queue<T> {
    static final int a = Integer.getInteger((String)"jctools.spsc.max.lookahead.step", (int)4096);
    static final AtomicLongFieldUpdater<aqw> c = AtomicLongFieldUpdater.newUpdater((Class)aqw.class, (String)"b");
    static final AtomicLongFieldUpdater<aqw> k = AtomicLongFieldUpdater.newUpdater((Class)aqw.class, (String)"j");
    private static final Object l = new Object();
    protected volatile long b;
    protected int d;
    protected long e;
    protected int f;
    protected AtomicReferenceArray<Object> g;
    protected int h;
    protected AtomicReferenceArray<Object> i;
    protected volatile long j;

    public aqw(int n2) {
        AtomicReferenceArray atomicReferenceArray;
        int n3 = arf.a(Math.max((int)8, (int)n2));
        int n4 = n3 - 1;
        this.g = atomicReferenceArray = new AtomicReferenceArray(n3 + 1);
        this.f = n4;
        super.a(n3);
        this.i = atomicReferenceArray;
        this.h = n4;
        this.e = n4 - 1;
        super.a(0);
    }

    private static int a(long l2, int n2) {
        return aqw.b(n2 & (int)l2);
    }

    private long a() {
        return this.b;
    }

    private static <E> Object a(AtomicReferenceArray<Object> atomicReferenceArray, int n2) {
        return atomicReferenceArray.get(n2);
    }

    private T a(AtomicReferenceArray<Object> atomicReferenceArray, long l2, int n2) {
        this.i = atomicReferenceArray;
        int n3 = aqw.a(l2, n2);
        Object object = aqw.a(atomicReferenceArray, n3);
        if (object == null) {
            return null;
        }
        super.b(1 + l2);
        aqw.a(atomicReferenceArray, n3, null);
        return (T)object;
    }

    private AtomicReferenceArray<Object> a(AtomicReferenceArray<Object> atomicReferenceArray) {
        return (AtomicReferenceArray)aqw.a(atomicReferenceArray, aqw.b(-1 + atomicReferenceArray.length()));
    }

    private void a(int n2) {
        this.d = Math.min((int)(n2 / 4), (int)a);
    }

    private void a(long l2) {
        c.lazySet((Object)this, l2);
    }

    private static void a(AtomicReferenceArray<Object> atomicReferenceArray, int n2, Object object) {
        atomicReferenceArray.lazySet(n2, object);
    }

    private void a(AtomicReferenceArray<Object> atomicReferenceArray, long l2, int n2, T t2, long l3) {
        AtomicReferenceArray atomicReferenceArray2;
        this.g = atomicReferenceArray2 = new AtomicReferenceArray(atomicReferenceArray.length());
        this.e = l2 + l3 - 1;
        this.a(l2 + 1);
        aqw.a(atomicReferenceArray2, n2, t2);
        this.a(atomicReferenceArray, atomicReferenceArray2);
        aqw.a(atomicReferenceArray, n2, l);
    }

    private void a(AtomicReferenceArray<Object> atomicReferenceArray, AtomicReferenceArray<Object> atomicReferenceArray2) {
        aqw.a(atomicReferenceArray, aqw.b(-1 + atomicReferenceArray.length()), atomicReferenceArray2);
    }

    private boolean a(AtomicReferenceArray<Object> atomicReferenceArray, T t2, long l2, int n2) {
        super.a(1 + l2);
        aqw.a(atomicReferenceArray, n2, t2);
        return true;
    }

    private static int b(int n2) {
        return n2;
    }

    private long b() {
        return this.j;
    }

    private T b(AtomicReferenceArray<Object> atomicReferenceArray, long l2, int n2) {
        this.i = atomicReferenceArray;
        return (T)aqw.a(atomicReferenceArray, aqw.a(l2, n2));
    }

    private void b(long l2) {
        k.lazySet((Object)this, l2);
    }

    private long c() {
        return this.b;
    }

    private long d() {
        return this.j;
    }

    public boolean add(T t2) {
        throw new UnsupportedOperationException();
    }

    public boolean addAll(Collection<? extends T> collection) {
        throw new UnsupportedOperationException();
    }

    public void clear() {
        while (this.poll() != null || !this.isEmpty()) {
        }
    }

    public boolean contains(Object object) {
        throw new UnsupportedOperationException();
    }

    public boolean containsAll(Collection<?> collection) {
        throw new UnsupportedOperationException();
    }

    public T element() {
        throw new UnsupportedOperationException();
    }

    public boolean isEmpty() {
        if (this.a() == this.b()) {
            return true;
        }
        return false;
    }

    public final Iterator<T> iterator() {
        throw new UnsupportedOperationException();
    }

    public final boolean offer(T t2) {
        if (t2 == null) {
            throw new NullPointerException();
        }
        AtomicReferenceArray<Object> atomicReferenceArray = this.g;
        long l2 = super.c();
        int n2 = this.f;
        int n3 = aqw.a(l2, n2);
        if (l2 < this.e) {
            return super.a(atomicReferenceArray, t2, l2, n3);
        }
        int n4 = this.d;
        if (aqw.a(atomicReferenceArray, aqw.a(l2 + (long)n4, n2)) == null) {
            this.e = l2 + (long)n4 - 1;
            return super.a(atomicReferenceArray, t2, l2, n3);
        }
        if (aqw.a(atomicReferenceArray, aqw.a(1 + l2, n2)) != null) {
            return super.a(atomicReferenceArray, t2, l2, n3);
        }
        super.a(atomicReferenceArray, l2, n3, t2, n2);
        return true;
    }

    public final T peek() {
        int n2;
        AtomicReferenceArray<Object> atomicReferenceArray = this.i;
        long l2 = this.d();
        Object object = aqw.a(atomicReferenceArray, aqw.a(l2, n2 = this.h));
        if (object == l) {
            object = this.b(this.a(atomicReferenceArray), l2, n2);
        }
        return (T)object;
    }

    /*
     * Enabled aggressive block sorting
     */
    public final T poll() {
        int n2;
        AtomicReferenceArray<Object> atomicReferenceArray = this.i;
        long l2 = this.d();
        int n3 = aqw.a(l2, n2 = this.h);
        Object object = aqw.a(atomicReferenceArray, n3);
        boolean bl2 = object == l;
        if (object == null) return this.a(this.a(atomicReferenceArray), l2, n2);
        if (!bl2) {
            this.b(1 + l2);
            aqw.a(atomicReferenceArray, n3, null);
            return (T)object;
        }
        if (bl2) {
            return this.a(this.a(atomicReferenceArray), l2, n2);
        }
        return null;
    }

    public T remove() {
        throw new UnsupportedOperationException();
    }

    public boolean remove(Object object) {
        throw new UnsupportedOperationException();
    }

    public boolean removeAll(Collection<?> collection) {
        throw new UnsupportedOperationException();
    }

    public boolean retainAll(Collection<?> collection) {
        throw new UnsupportedOperationException();
    }

    public final int size() {
        long l2;
        long l3;
        long l4 = this.b();
        do {
            l2 = l4;
            l3 = this.a();
        } while (l2 != (l4 = this.b()));
        return (int)(l3 - l4);
    }

    public Object[] toArray() {
        throw new UnsupportedOperationException();
    }

    public <E> E[] toArray(E[] arrE) {
        throw new UnsupportedOperationException();
    }
}

