package defpackage;

/* compiled from: OperatorMap */
class aqd$1 extends apj<T> {
    final /* synthetic */ apj a;
    final /* synthetic */ aqd b;

    aqd$1(aqd aqd, apj x0, apj apj) {
        this.b = aqd;
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
        try {
            this.a.onNext(this.b.a.call(t));
        } catch (Throwable e) {
            app.a(e, this, t);
        }
    }
}
