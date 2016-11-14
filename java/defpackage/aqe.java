package defpackage;

import rx.schedulers.ImmediateScheduler;

/* compiled from: OperatorObserveOn */
public final class aqe<T> implements apd$b<T, T> {
    private final apg a;
    private final boolean b;

    public /* synthetic */ Object call(Object x0) {
        return a((apj) x0);
    }

    public aqe(apg scheduler, boolean delayError) {
        this.a = scheduler;
        this.b = delayError;
    }

    public apj<? super T> a(apj<? super T> child) {
        if ((this.a instanceof ImmediateScheduler) || (this.a instanceof asi)) {
            return child;
        }
        apj parent = new aqe$a(this.a, child, this.b);
        parent.a();
        return parent;
    }
}
