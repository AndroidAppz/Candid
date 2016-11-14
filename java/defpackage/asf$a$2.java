package defpackage;

import rx.internal.schedulers.ScheduledAction;

/* compiled from: ExecutorScheduler */
class asf$a$2 implements apq {
    final /* synthetic */ aso a;
    final /* synthetic */ apq b;
    final /* synthetic */ apk c;
    final /* synthetic */ asf$a d;

    asf$a$2(asf$a asf_a, aso aso, apq apq, apk apk) {
        this.d = asf_a;
        this.a = aso;
        this.b = apq;
        this.c = apk;
    }

    public void call() {
        if (!this.a.isUnsubscribed()) {
            apk s2 = this.d.a(this.b);
            this.a.a(s2);
            if (s2.getClass() == ScheduledAction.class) {
                ((ScheduledAction) s2).a(this.c);
            }
        }
    }
}
