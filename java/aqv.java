/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  java.lang.Integer
 *  java.lang.Math
 *  java.lang.NullPointerException
 *  java.lang.Object
 *  java.lang.String
 *  java.util.Iterator
 *  java.util.concurrent.atomic.AtomicLong
 *  java.util.concurrent.atomic.AtomicReferenceArray
 */
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReferenceArray;

public final class aqv<E>
extends aqu<E> {
    private static final Integer g = Integer.getInteger((String)"jctools.spsc.max.lookahead.step", (int)4096);
    final AtomicLong c = new AtomicLong();
    protected long d;
    final AtomicLong e = new AtomicLong();
    final int f;

    public aqv(int n2) {
        super(n2);
        this.f = Math.min((int)(n2 / 4), (int)g);
    }

    private long a() {
        return this.e.get();
    }

    private long b() {
        return this.c.get();
    }

    private void b(long l2) {
        this.c.lazySet(l2);
    }

    private void c(long l2) {
        this.e.lazySet(l2);
    }

    public boolean isEmpty() {
        if (this.b() == this.a()) {
            return true;
        }
        return false;
    }

    /*
     * Enabled aggressive block sorting
     */
    public boolean offer(E e2) {
        if (e2 == null) {
            throw new NullPointerException("Null is not a valid element");
        }
        AtomicReferenceArray atomicReferenceArray = this.a;
        int n2 = this.b;
        long l2 = this.c.get();
        int n3 = this.a(l2, n2);
        if (l2 >= this.d) {
            int n4 = this.f;
            if (this.a(atomicReferenceArray, this.a(l2 + (long)n4, n2)) == null) {
                this.d = l2 + (long)n4;
            } else if (this.a(atomicReferenceArray, n3) != null) {
                return false;
            }
        }
        super.b(1 + l2);
        this.a(atomicReferenceArray, n3, e2);
        return true;
    }

    public E peek() {
        return this.a(this.a(this.e.get()));
    }

    public E poll() {
        AtomicReferenceArray atomicReferenceArray = this.a;
        long l2 = this.e.get();
        int n2 = this.a(l2);
        Object e2 = this.a(atomicReferenceArray, n2);
        if (e2 == null) {
            return null;
        }
        this.c(1 + l2);
        this.a(atomicReferenceArray, n2, null);
        return e2;
    }

    public int size() {
        long l2;
        long l3;
        long l4 = this.a();
        do {
            l2 = l4;
            l3 = this.b();
        } while (l2 != (l4 = this.a()));
        return (int)(l3 - l4);
    }
}

