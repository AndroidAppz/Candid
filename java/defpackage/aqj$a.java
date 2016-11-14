package defpackage;

import java.util.concurrent.TimeUnit;

/* compiled from: EventLoopsScheduler */
class aqj$a extends apg$a {
    private final aqr a = new aqr();
    private final asn b = new asn();
    private final aqr c = new aqr(this.a, this.b);
    private final aqj$c d;

    aqj$a(aqj$c poolWorker) {
        this.d = poolWorker;
    }

    public void unsubscribe() {
        this.c.unsubscribe();
    }

    public boolean isUnsubscribed() {
        return this.c.isUnsubscribed();
    }

    public apk a(apq action) {
        if (isUnsubscribed()) {
            return asq.b();
        }
        return this.d.a(action, 0, null, this.a);
    }

    public apk a(apq action, long delayTime, TimeUnit unit) {
        if (isUnsubscribed()) {
            return asq.b();
        }
        return this.d.a(action, delayTime, unit, this.b);
    }
}
