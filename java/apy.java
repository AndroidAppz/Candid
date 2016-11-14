/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.util.concurrent.atomic.AtomicLong
 */
import java.util.concurrent.atomic.AtomicLong;

public final class apy {
    public static long a(long l2, long l3) {
        long l4 = l2 + l3;
        if (l4 < 0) {
            l4 = Long.MAX_VALUE;
        }
        return l4;
    }

    public static long a(AtomicLong atomicLong, long l2) {
        long l3;
        while (!atomicLong.compareAndSet(l3 = atomicLong.get(), apy.a(l3, l2))) {
        }
        return l3;
    }
}

