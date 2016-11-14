package defpackage;

/* compiled from: ViewAnimationFactory */
public class qg<R> implements qd<R> {
    private final qf$a a;
    private qc<R> b;

    qg(qf$a animationFactory) {
        this.a = animationFactory;
    }

    public qc<R> a(boolean isFromMemoryCache, boolean isFirstResource) {
        if (isFromMemoryCache || !isFirstResource) {
            return qe.b();
        }
        if (this.b == null) {
            this.b = new qf(this.a);
        }
        return this.b;
    }
}
