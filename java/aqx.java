/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  java.lang.Class
 *  java.lang.IllegalStateException
 *  java.lang.Integer
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.UnsupportedOperationException
 *  java.util.Iterator
 *  sun.misc.Unsafe
 */
import java.util.Iterator;
import sun.misc.Unsafe;

public abstract class aqx<E>
extends aqy<E> {
    protected static final int a = Integer.getInteger((String)"sparse.shift", (int)0);
    private static final long d;
    private static final int e;
    protected final long b;
    protected final E[] c;

    /*
     * Enabled aggressive block sorting
     */
    static {
        int n2 = arv.a.arrayIndexScale((Class)Object[].class);
        if (4 == n2) {
            e = 2 + a;
        } else {
            if (8 != n2) {
                throw new IllegalStateException("Unknown pointer size");
            }
            e = 3 + a;
        }
        d = arv.a.arrayBaseOffset((Class)Object[].class) + (32 << e - a);
    }

    public aqx(int n2) {
        int n3 = arf.a(n2);
        this.b = n3 - 1;
        this.c = new Object[64 + (n3 << a)];
    }

    protected final long a(long l2) {
        return this.a(l2, this.b);
    }

    protected final long a(long l2, long l3) {
        return d + ((l2 & l3) << e);
    }

    protected final E a(E[] arrE, long l2) {
        return (E)arv.a.getObject(arrE, l2);
    }

    protected final void a(long l2, E e2) {
        this.a(this.c, l2, e2);
    }

    protected final void a(E[] arrE, long l2, E e2) {
        arv.a.putObject(arrE, l2, e2);
    }

    protected final E b(long l2) {
        return this.a(this.c, l2);
    }

    protected final E b(E[] arrE, long l2) {
        return (E)arv.a.getObjectVolatile(arrE, l2);
    }

    protected final void b(E[] arrE, long l2, E e2) {
        arv.a.putOrderedObject(arrE, l2, e2);
    }

    protected final E c(long l2) {
        return this.b(this.c, l2);
    }

    public void clear() {
        while (this.poll() != null || !this.isEmpty()) {
        }
    }

    public Iterator<E> iterator() {
        throw new UnsupportedOperationException();
    }
}

