package defpackage;

/* compiled from: OnSubscribeTimerOnce */
class aqa$1 implements apq {
    final /* synthetic */ apj a;
    final /* synthetic */ aqa b;

    aqa$1(aqa aqa, apj apj) {
        this.b = aqa;
        this.a = apj;
    }

    public void call() {
        try {
            this.a.onNext(Long.valueOf(0));
            this.a.onCompleted();
        } catch (Throwable t) {
            app.a(t, this.a);
        }
    }
}
