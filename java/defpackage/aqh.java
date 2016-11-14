package defpackage;

/* compiled from: OperatorSubscribeOn */
public final class aqh<T> implements apd$a<T> {
    final apg a;
    final apd<T> b;

    public /* synthetic */ void call(Object x0) {
        a((apj) x0);
    }

    public aqh(apd<T> source, apg scheduler) {
        this.a = scheduler;
        this.b = source;
    }

    public void a(apj<? super T> subscriber) {
        apg$a inner = this.a.createWorker();
        subscriber.add(inner);
        inner.a(new aqh$1(this, subscriber, inner));
    }
}
