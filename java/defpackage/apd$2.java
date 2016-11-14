package defpackage;

/* compiled from: Observable */
class apd$2 implements apd$a<R> {
    final /* synthetic */ apd$b a;
    final /* synthetic */ apd b;

    apd$2(apd apd, apd$b apd_b) {
        this.b = apd;
        this.a = apd_b;
    }

    public /* synthetic */ void call(Object x0) {
        a((apj) x0);
    }

    public void a(apj<? super R> o) {
        apj<? super T> st;
        try {
            st = (apj) apd.b.a(this.a).call(o);
            st.onStart();
            this.b.a.call(st);
        } catch (Throwable e) {
            app.a(e);
            o.onError(e);
        }
    }
}
