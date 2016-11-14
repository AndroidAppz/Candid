/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  java.lang.Comparable
 *  java.lang.Long
 *  java.lang.Object
 *  java.util.concurrent.PriorityBlockingQueue
 *  java.util.concurrent.TimeUnit
 *  java.util.concurrent.atomic.AtomicInteger
 */
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public final class asi
extends apg {
    private static final asi b = new asi();

    asi() {
    }

    static int a(int n2, int n3) {
        if (n2 < n3) {
            return -1;
        }
        if (n2 == n3) {
            return 0;
        }
        return 1;
    }

    public static asi a() {
        return b;
    }

    @Override
    public apg.a createWorker() {
        return new a();
    }

    static class a
    extends apg.a
    implements apk {
        final AtomicInteger a = new AtomicInteger();
        final PriorityBlockingQueue<b> b = new PriorityBlockingQueue();
        private final asm c = new asm();
        private final AtomicInteger d = new AtomicInteger();

        a() {
        }

        private apk a(apq apq2, long l2) {
            if (this.c.isUnsubscribed()) {
                return asq.b();
            }
            final b b2 = new b(apq2, l2, this.a.incrementAndGet());
            this.b.add((Object)b2);
            if (this.d.getAndIncrement() == 0) {
                do {
                    b b3;
                    if ((b3 = (b)this.b.poll()) == null) continue;
                    b3.a.call();
                } while (this.d.decrementAndGet() > 0);
                return asq.b();
            }
            return asq.a(new apq(){

                @Override
                public void call() {
                    a.this.b.remove((Object)b2);
                }
            });
        }

        @Override
        public apk a(apq apq2) {
            return super.a(apq2, this.a());
        }

        @Override
        public apk a(apq apq2, long l2, TimeUnit timeUnit) {
            long l3 = this.a() + timeUnit.toMillis(l2);
            return super.a(new ash(apq2, (apg.a)this, l3), l3);
        }

        @Override
        public boolean isUnsubscribed() {
            return this.c.isUnsubscribed();
        }

        @Override
        public void unsubscribe() {
            this.c.unsubscribe();
        }

    }

    static final class b
    implements Comparable<b> {
        final apq a;
        final Long b;
        final int c;

        b(apq apq2, Long l2, int n2) {
            this.a = apq2;
            this.b = l2;
            this.c = n2;
        }

        public int a(b b2) {
            int n2 = this.b.compareTo(b2.b);
            if (n2 == 0) {
                n2 = asi.a(this.c, b2.c);
            }
            return n2;
        }

        public /* synthetic */ int compareTo(Object object) {
            return this.a((b)object);
        }
    }

}

