package defpackage;

/* compiled from: OperatorOnErrorResumeNextViaFunction */
class aqg$2$1 extends apj<T> {
    final /* synthetic */ aqg$2 a;

    aqg$2$1(aqg$2 aqg_2) {
        this.a = aqg_2;
    }

    public void onNext(T t) {
        this.a.b.onNext(t);
    }

    public void onError(Throwable e) {
        this.a.b.onError(e);
    }

    public void onCompleted() {
        this.a.b.onCompleted();
    }

    public void setProducer(apf producer) {
        this.a.c.a(producer);
    }
}
