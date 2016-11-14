package defpackage;

/* compiled from: OperatorOnErrorResumeNextViaFunction */
public final class aqg<T> implements apd$b<T, T> {
    final apu<Throwable, ? extends apd<? extends T>> a;

    public /* synthetic */ Object call(Object x0) {
        return a((apj) x0);
    }

    public static <T> aqg<T> a(apu<Throwable, ? extends T> resumeFunction) {
        return new aqg(new aqg$1(resumeFunction));
    }

    public aqg(apu<Throwable, ? extends apd<? extends T>> f) {
        this.a = f;
    }

    public apj<? super T> a(apj<? super T> child) {
        aqi pa = new aqi();
        asp ssub = new asp();
        apj<T> parent = new aqg$2(this, child, pa, ssub);
        ssub.a(parent);
        child.add(ssub);
        child.setProducer(pa);
        return parent;
    }
}
