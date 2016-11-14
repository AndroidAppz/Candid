package defpackage;

/* compiled from: Observable */
class apd$1 implements ape<T> {
    final /* synthetic */ apr a;
    final /* synthetic */ apd b;

    apd$1(apd apd, apr apr) {
        this.b = apd;
        this.a = apr;
    }

    public final void onCompleted() {
    }

    public final void onError(Throwable e) {
        this.a.call(e);
    }

    public final void onNext(T t) {
    }
}
