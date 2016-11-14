package defpackage;

/* compiled from: OperatorSubscribeOn */
class aqh$1$1 extends apj<T> {
    final /* synthetic */ Thread a;
    final /* synthetic */ aqh$1 b;

    aqh$1$1(aqh$1 aqh_1, apj x0, Thread thread) {
        this.b = aqh_1;
        this.a = thread;
        super(x0);
    }

    public void onNext(T t) {
        this.b.a.onNext(t);
    }

    public void onError(Throwable e) {
        try {
            this.b.a.onError(e);
        } finally {
            this.b.b.unsubscribe();
        }
    }

    public void onCompleted() {
        try {
            this.b.a.onCompleted();
        } finally {
            this.b.b.unsubscribe();
        }
    }

    public void setProducer(apf p) {
        this.b.a.setProducer(new aqh$1$1$1(this, p));
    }
}
