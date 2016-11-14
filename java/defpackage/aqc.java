package defpackage;

/* compiled from: OperatorFilter */
public final class aqc<T> implements apd$b<T, T> {
    final apu<? super T, Boolean> a;

    public /* synthetic */ Object call(Object x0) {
        return a((apj) x0);
    }

    public aqc(apu<? super T, Boolean> predicate) {
        this.a = predicate;
    }

    public apj<? super T> a(apj<? super T> child) {
        return new aqc$1(this, child, child);
    }
}
