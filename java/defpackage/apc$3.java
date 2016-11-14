package defpackage;

/* compiled from: Completable */
class apc$3 implements apc$a {
    final /* synthetic */ apg a;
    final /* synthetic */ apc b;

    apc$3(apc apc, apg apg) {
        this.b = apc;
        this.a = apg;
    }

    public /* synthetic */ void call(Object x0) {
        a((apc$b) x0);
    }

    public void a(apc$b s) {
        apg$a w = this.a.createWorker();
        w.a(new apc$3$1(this, s, w));
    }
}
