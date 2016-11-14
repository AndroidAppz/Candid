package defpackage;

/* compiled from: OperatorDoOnEach */
public class aqb<T> implements apd$b<T, T> {
    final ape<? super T> a;

    public /* synthetic */ Object call(Object x0) {
        return a((apj) x0);
    }

    public aqb(ape<? super T> doOnEachObserver) {
        this.a = doOnEachObserver;
    }

    public apj<? super T> a(apj<? super T> observer) {
        return new aqb$1(this, observer, observer);
    }
}
