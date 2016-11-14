package defpackage;

import android.view.View;

/* compiled from: ViewAnimation */
public class qf<R> implements qc<R> {
    private final qf$a a;

    qf(qf$a animationFactory) {
        this.a = animationFactory;
    }

    public boolean a(R r, qc$a adapter) {
        View view = adapter.getView();
        if (view != null) {
            view.clearAnimation();
            view.startAnimation(this.a.a());
        }
        return false;
    }
}
