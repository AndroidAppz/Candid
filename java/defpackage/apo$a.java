package defpackage;

import android.os.Handler;
import java.util.concurrent.TimeUnit;
import rx.internal.schedulers.ScheduledAction;

/* compiled from: HandlerScheduler */
class apo$a extends apg$a {
    private final Handler a;
    private final asn b = new asn();

    apo$a(Handler handler) {
        this.a = handler;
    }

    public void unsubscribe() {
        this.b.unsubscribe();
    }

    public boolean isUnsubscribed() {
        return this.b.isUnsubscribed();
    }

    public apk a(apq action, long delayTime, TimeUnit unit) {
        if (this.b.isUnsubscribed()) {
            return asq.b();
        }
        apk scheduledAction = new ScheduledAction(apl.a().b().a(action));
        scheduledAction.a(this.b);
        this.b.a(scheduledAction);
        this.a.postDelayed(scheduledAction, unit.toMillis(delayTime));
        scheduledAction.a(asq.a(new apo$a$1(this, scheduledAction)));
        return scheduledAction;
    }

    public apk a(apq action) {
        return a(action, 0, TimeUnit.MILLISECONDS);
    }
}
