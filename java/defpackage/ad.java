package defpackage;

import android.animation.ValueAnimator;
import android.view.animation.Interpolator;

/* compiled from: ValueAnimatorCompatImplHoneycombMr1 */
class ad extends ab$e {
    final ValueAnimator a = new ValueAnimator();

    ad() {
    }

    public void a() {
        this.a.start();
    }

    public boolean b() {
        return this.a.isRunning();
    }

    public void a(Interpolator interpolator) {
        this.a.setInterpolator(interpolator);
    }

    public void a(ab$e$b updateListener) {
        this.a.addUpdateListener(new ad$1(this, updateListener));
    }

    public void a(ab$e$a listener) {
        this.a.addListener(new ad$2(this, listener));
    }

    public void a(int from, int to) {
        this.a.setIntValues(new int[]{from, to});
    }

    public int c() {
        return ((Integer) this.a.getAnimatedValue()).intValue();
    }

    public void a(float from, float to) {
        this.a.setFloatValues(new float[]{from, to});
    }

    public float d() {
        return ((Float) this.a.getAnimatedValue()).floatValue();
    }

    public void a(int duration) {
        this.a.setDuration((long) duration);
    }

    public void e() {
        this.a.cancel();
    }

    public float f() {
        return this.a.getAnimatedFraction();
    }

    public long g() {
        return this.a.getDuration();
    }
}
