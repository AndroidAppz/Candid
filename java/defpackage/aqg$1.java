package defpackage;

/* compiled from: OperatorOnErrorResumeNextViaFunction */
class aqg$1 implements apu<Throwable, apd<? extends T>> {
    final /* synthetic */ apu a;

    aqg$1(apu apu) {
        this.a = apu;
    }

    public /* synthetic */ Object call(Object x0) {
        return a((Throwable) x0);
    }

    public apd<? extends T> a(Throwable t) {
        return apd.a(this.a.call(t));
    }
}
