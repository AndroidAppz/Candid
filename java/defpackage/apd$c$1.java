package defpackage;

/* compiled from: Observable */
class apd$c$1 implements apd$a<T> {
    final /* synthetic */ Throwable a;

    apd$c$1(Throwable th) {
        this.a = th;
    }

    public /* synthetic */ void call(Object x0) {
        a((apj) x0);
    }

    public void a(apj<? super T> observer) {
        observer.onError(this.a);
    }
}
