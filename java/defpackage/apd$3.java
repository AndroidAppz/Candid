package defpackage;

import rx.exceptions.OnErrorNotImplementedException;

/* compiled from: Observable */
class apd$3 extends apj<T> {
    final /* synthetic */ apr a;
    final /* synthetic */ apd b;

    apd$3(apd apd, apr apr) {
        this.b = apd;
        this.a = apr;
    }

    public final void onCompleted() {
    }

    public final void onError(Throwable e) {
        throw new OnErrorNotImplementedException(e);
    }

    public final void onNext(T args) {
        this.a.call(args);
    }
}
