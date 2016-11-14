/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.UnsupportedOperationException
 *  java.util.AbstractQueue
 *  java.util.Iterator
 *  java.util.concurrent.atomic.AtomicReferenceArray
 */
import java.util.AbstractQueue;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicReferenceArray;

abstract class aqu<E>
extends AbstractQueue<E> {
    protected final AtomicReferenceArray<E> a;
    protected final int b;

    public aqu(int n2) {
        int n3 = arf.a(n2);
        this.b = n3 - 1;
        this.a = new AtomicReferenceArray(n3);
    }

    protected final int a(long l2) {
        return (int)l2 & this.b;
    }

    protected final int a(long l2, int n2) {
        return n2 & (int)l2;
    }

    protected final E a(int n2) {
        return this.a(this.a, n2);
    }

    protected final E a(AtomicReferenceArray<E> atomicReferenceArray, int n2) {
        return (E)atomicReferenceArray.get(n2);
    }

    protected final void a(AtomicReferenceArray<E> atomicReferenceArray, int n2, E e2) {
        atomicReferenceArray.lazySet(n2, e2);
    }

    public void clear() {
        while (this.poll() != null || !this.isEmpty()) {
        }
    }

    public Iterator<E> iterator() {
        throw new UnsupportedOperationException();
    }
}

