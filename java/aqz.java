/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  java.lang.Class
 *  java.lang.IllegalStateException
 *  java.lang.Object
 *  java.lang.String
 *  sun.misc.Unsafe
 */
import sun.misc.Unsafe;

public abstract class aqz<E>
extends aqx<E> {
    private static final long e;
    private static final int f;
    protected final long[] d;

    static {
        if (8 == arv.a.arrayIndexScale((Class)long[].class)) {
            f = 3 + a;
            e = arv.a.arrayBaseOffset((Class)long[].class) + (32 << f - a);
            return;
        }
        throw new IllegalStateException("Unexpected long[] element size");
    }

    public aqz(int n2) {
        super(n2);
        int n3 = (int)(1 + this.b);
        this.d = new long[64 + (n3 << a)];
        for (long i2 = 0; i2 < (long)n3; ++i2) {
            this.a(this.d, this.d(i2), i2);
        }
    }

    protected final long a(long[] arrl, long l2) {
        return arv.a.getLongVolatile((Object)arrl, l2);
    }

    protected final void a(long[] arrl, long l2, long l3) {
        arv.a.putOrderedLong((Object)arrl, l2, l3);
    }

    protected final long d(long l2) {
        return e + ((l2 & this.b) << f);
    }
}

