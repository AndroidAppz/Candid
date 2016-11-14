/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  java.lang.Long
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.System
 *  java.util.concurrent.TimeUnit
 */
import java.util.concurrent.TimeUnit;

public abstract class apg {
    static final long a = TimeUnit.MINUTES.toNanos(Long.getLong((String)"rx.scheduler.drift-tolerance", (long)15).longValue());

    public abstract a createWorker();

    public long now() {
        return System.currentTimeMillis();
    }

    public static abstract class a
    implements apk {
        public long a() {
            return System.currentTimeMillis();
        }

        public abstract apk a(apq var1);

        public apk a(final apq apq2, long l2, long l3, TimeUnit timeUnit) {
            final long l4 = timeUnit.toNanos(l3);
            final long l5 = TimeUnit.MILLISECONDS.toNanos(this.a());
            final long l6 = l5 + timeUnit.toNanos(l2);
            final aso aso2 = new aso();
            apq apq3 = new apq(){
                long a;
                long b;
                long c;

                /*
                 * Enabled aggressive block sorting
                 */
                @Override
                public void call() {
                    if (!aso2.isUnsubscribed()) {
                        long l2;
                        apq2.call();
                        long l3 = TimeUnit.MILLISECONDS.toNanos(a.this.a());
                        if (l3 + apg.a < this.b || l3 >= this.b + l4 + apg.a) {
                            long l42;
                            l2 = l3 + l4;
                            long l52 = l4;
                            this.a = l42 = 1 + this.a;
                            this.c = l2 - l52 * l42;
                        } else {
                            long l62;
                            long l7 = this.c;
                            this.a = l62 = 1 + this.a;
                            l2 = l7 + l62 * l4;
                        }
                        this.b = l3;
                        long l8 = l2 - l3;
                        aso2.a(a.this.a(this, l8, TimeUnit.NANOSECONDS));
                    }
                }
            };
            aso aso3 = new aso();
            aso2.a(aso3);
            aso3.a(this.a(apq3, l2, timeUnit));
            return aso2;
        }

        public abstract apk a(apq var1, long var2, TimeUnit var4);

    }

}

