package defpackage;

import rx.internal.producers.SingleDelayedProducer;

/* compiled from: Single */
class aph$1$1 extends api<T> {
    final /* synthetic */ SingleDelayedProducer a;
    final /* synthetic */ apj b;
    final /* synthetic */ aph$1 c;

    aph$1$1(aph$1 aph_1, SingleDelayedProducer singleDelayedProducer, apj apj) {
        this.c = aph_1;
        this.a = singleDelayedProducer;
        this.b = apj;
    }

    public void a(T value) {
        this.a.a(value);
    }

    public void a(Throwable error) {
        this.b.onError(error);
    }
}
