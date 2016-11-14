package defpackage;

/* compiled from: OperatorMap */
public final class aqd<T, R> implements apd$b<R, T> {
    final apu<? super T, ? extends R> a;

    public /* synthetic */ Object call(Object x0) {
        return a((apj) x0);
    }

    public aqd(apu<? super T, ? extends R> transformer) {
        this.a = transformer;
    }

    public apj<? super T> a(apj<? super R> o) {
        return new aqd$1(this, o, o);
    }
}
