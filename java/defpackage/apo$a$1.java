package defpackage;

import rx.internal.schedulers.ScheduledAction;

/* compiled from: HandlerScheduler */
class apo$a$1 implements apq {
    final /* synthetic */ ScheduledAction a;
    final /* synthetic */ apo$a b;

    apo$a$1(apo$a apo_a, ScheduledAction scheduledAction) {
        this.b = apo_a;
        this.a = scheduledAction;
    }

    public void call() {
        this.b.a.removeCallbacks(this.a);
    }
}
