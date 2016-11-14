/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  java.lang.NullPointerException
 *  java.lang.Object
 *  java.lang.String
 *  sun.misc.Unsafe
 */
import sun.misc.Unsafe;

public final class aro<E>
extends art<E> {
    public aro(int n2) {
        super(n2);
    }

    private long a() {
        return arv.a.getLongVolatile((Object)this, f);
    }

    private long b() {
        return arv.a.getLongVolatile((Object)this, e);
    }

    private void d(long l2) {
        arv.a.putOrderedLong((Object)this, f, l2);
    }

    private void e(long l2) {
        arv.a.putOrderedLong((Object)this, e, l2);
    }

    public boolean isEmpty() {
        if (this.a() == this.b()) {
            return true;
        }
        return false;
    }

    public boolean offer(E e2) {
        if (e2 == null) {
            throw new NullPointerException("null elements not allowed");
        }
        Object[] arrobject = this.c;
        long l2 = this.producerIndex;
        long l3 = this.a(l2);
        if (this.b(arrobject, l3) != null) {
            return false;
        }
        super.d(1 + l2);
        this.b(arrobject, l3, e2);
        return true;
    }

    public E peek() {
        return this.c(this.a(this.consumerIndex));
    }

    public E poll() {
        Object[] arrobject = this.c;
        long l2 = this.consumerIndex;
        long l3 = this.a(l2);
        Object object = this.b(arrobject, l3);
        if (object == null) {
            return null;
        }
        this.e(1 + l2);
        this.b(arrobject, l3, null);
        return (E)object;
    }

    public int size() {
        long l2;
        long l3;
        long l4 = this.b();
        do {
            l2 = l4;
            l3 = this.a();
        } while (l2 != (l4 = this.b()));
        return (int)(l3 - l4);
    }
}

