package defpackage;

/* compiled from: Subscribers */
class ary$1 extends apj<T> {
    final /* synthetic */ apj a;

    ary$1(apj x0, apj apj) {
        this.a = apj;
        super(x0);
    }

    public void onCompleted() {
        this.a.onCompleted();
    }

    public void onError(Throwable e) {
        this.a.onError(e);
    }

    public void onNext(T t) {
        this.a.onNext(t);
    }
}
