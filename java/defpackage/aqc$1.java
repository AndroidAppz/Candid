package defpackage;

/* compiled from: OperatorFilter */
class aqc$1 extends apj<T> {
    final /* synthetic */ apj a;
    final /* synthetic */ aqc b;

    aqc$1(aqc aqc, apj x0, apj apj) {
        this.b = aqc;
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
            if (((Boolean) this.b.a.call(t)).booleanValue()) {
                this.a.onNext(t);
            } else {
                request(1);
            }
        } catch (Throwable e) {
            app.a(e, this.a, t);
        }
    }
}
