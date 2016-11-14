package defpackage;

import java.util.concurrent.TimeUnit;

/* compiled from: Scheduler */
public abstract class apg$a implements apk {
    public abstract apk a(apq apq);

    public abstract apk a(apq apq, long j, TimeUnit timeUnit);

    public apk a(apq action, long initialDelay, long period, TimeUnit unit) {
        long periodInNanos = unit.toNanos(period);
        long firstNowNanos = TimeUnit.MILLISECONDS.toNanos(a());
        long firstStartInNanos = firstNowNanos + unit.toNanos(initialDelay);
        aso mas = new aso();
        apq recursiveAction = new apg$a$1(this, firstNowNanos, firstStartInNanos, mas, action, periodInNanos);
        aso s = new aso();
        mas.a(s);
        s.a(a(recursiveAction, initialDelay, unit));
        return mas;
    }

    public long a() {
        return System.currentTimeMillis();
    }
}
