package defpackage;

import java.util.concurrent.TimeUnit;

/* compiled from: Scheduler */
class apg$a$1 implements apq {
    long a;
    long b = this.d;
    long c = this.e;
    final /* synthetic */ long d;
    final /* synthetic */ long e;
    final /* synthetic */ aso f;
    final /* synthetic */ apq g;
    final /* synthetic */ long h;
    final /* synthetic */ apg$a i;

    apg$a$1(apg$a apg_a, long j, long j2, aso aso, apq apq, long j3) {
        this.i = apg_a;
        this.d = j;
        this.e = j2;
        this.f = aso;
        this.g = apq;
        this.h = j3;
    }

    public void call() {
        if (!this.f.isUnsubscribed()) {
            long nextTick;
            this.g.call();
            long nowNanos = TimeUnit.MILLISECONDS.toNanos(this.i.a());
            long j;
            long j2;
            if (apg.a + nowNanos < this.b || nowNanos >= (this.b + this.h) + apg.a) {
                nextTick = nowNanos + this.h;
                j = this.h;
                j2 = this.a + 1;
                this.a = j2;
                this.c = nextTick - (j * j2);
            } else {
                j = this.c;
                j2 = this.a + 1;
                this.a = j2;
                nextTick = j + (j2 * this.h);
            }
            this.b = nowNanos;
            this.f.a(this.i.a(this, nextTick - nowNanos, TimeUnit.NANOSECONDS));
        }
    }
}
