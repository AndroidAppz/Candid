package defpackage;

import rx.internal.producers.SingleDelayedProducer;

/* compiled from: Single */
class aph$1 implements apd$a<T> {
    final /* synthetic */ aph$a a;
    final /* synthetic */ aph b;

    aph$1(aph aph, aph$a aph_a) {
        this.b = aph;
        this.a = aph_a;
    }

    public /* synthetic */ void call(Object x0) {
        a((apj) x0);
    }

    public void a(apj<? super T> child) {
        SingleDelayedProducer<T> producer = new SingleDelayedProducer(child);
        child.setProducer(producer);
        api<T> ss = new aph$1$1(this, producer, child);
        child.add(ss);
        this.a.call(ss);
    }
}
