package defpackage;

/* compiled from: OperatorSubscribeOn */
class aqh$1$1$1 implements apf {
    final /* synthetic */ apf a;
    final /* synthetic */ aqh$1$1 b;

    aqh$1$1$1(aqh$1$1 aqh_1_1, apf apf) {
        this.b = aqh_1_1;
        this.a = apf;
    }

    public void a(long n) {
        if (this.b.a == Thread.currentThread()) {
            this.a.a(n);
        } else {
            this.b.b.b.a(new aqh$1$1$1$1(this, n));
        }
    }
}
