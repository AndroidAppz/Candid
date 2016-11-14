package defpackage;

import android.view.animation.Animation;
import android.view.animation.Transformation;

/* compiled from: FloatingActionButtonEclairMr1 */
abstract class r$a extends Animation {
    final /* synthetic */ r a;
    private float b;
    private float c;

    protected abstract float a();

    private r$a(r rVar) {
        this.a = rVar;
    }

    public void reset() {
        super.reset();
        this.b = this.a.a.a();
        this.c = a() - this.b;
    }

    protected void applyTransformation(float interpolatedTime, Transformation t) {
        this.a.a.b(this.b + (this.c * interpolatedTime));
    }
}
