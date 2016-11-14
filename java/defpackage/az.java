package defpackage;

import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.view.View;

/* compiled from: HoneycombMr1AnimatorCompatProvider */
class az implements aw {
    private TimeInterpolator a;

    az() {
    }

    public ba a() {
        return new az$b(ValueAnimator.ofFloat(new float[]{0.0f, 1.0f}));
    }

    public void a(View view) {
        if (this.a == null) {
            this.a = new ValueAnimator().getInterpolator();
        }
        view.animate().setInterpolator(this.a);
    }
}
