package defpackage;

import android.graphics.drawable.Drawable;
import android.graphics.drawable.TransitionDrawable;

/* compiled from: DrawableCrossFadeViewAnimation */
public class qb<T extends Drawable> implements qc<T> {
    private final qc<T> a;
    private final int b;

    public qb(qc<T> defaultAnimation, int duration) {
        this.a = defaultAnimation;
        this.b = duration;
    }

    public boolean a(T current, qc$a adapter) {
        if (adapter.getCurrentDrawable() != null) {
            TransitionDrawable transitionDrawable = new TransitionDrawable(new Drawable[]{adapter.getCurrentDrawable(), current});
            transitionDrawable.setCrossFadeEnabled(true);
            transitionDrawable.startTransition(this.b);
            adapter.setDrawable(transitionDrawable);
            return true;
        }
        this.a.a(current, adapter);
        return false;
    }
}
