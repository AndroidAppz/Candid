/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.animation.Animator
 *  android.animation.Animator$AnimatorListener
 *  android.animation.AnimatorListenerAdapter
 *  android.animation.TimeInterpolator
 *  android.animation.ValueAnimator
 *  android.animation.ValueAnimator$AnimatorUpdateListener
 *  android.view.animation.Interpolator
 *  java.lang.Float
 *  java.lang.Integer
 *  java.lang.Object
 */
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.view.animation.Interpolator;

class ad
extends ab.e {
    final ValueAnimator a = new ValueAnimator();

    ad() {
    }

    @Override
    public void a() {
        this.a.start();
    }

    @Override
    public void a(float f2, float f3) {
        this.a.setFloatValues(new float[]{f2, f3});
    }

    @Override
    public void a(int n2) {
        this.a.setDuration((long)n2);
    }

    @Override
    public void a(int n2, int n3) {
        this.a.setIntValues(new int[]{n2, n3});
    }

    @Override
    public void a(final ab.e.a a2) {
        this.a.addListener((Animator.AnimatorListener)new AnimatorListenerAdapter(){

            public void onAnimationCancel(Animator animator) {
                a2.c();
            }

            public void onAnimationEnd(Animator animator) {
                a2.b();
            }

            public void onAnimationStart(Animator animator) {
                a2.a();
            }
        });
    }

    @Override
    public void a(final ab.e.b b2) {
        this.a.addUpdateListener(new ValueAnimator.AnimatorUpdateListener(){

            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                b2.a();
            }
        });
    }

    @Override
    public void a(Interpolator interpolator) {
        this.a.setInterpolator((TimeInterpolator)interpolator);
    }

    @Override
    public boolean b() {
        return this.a.isRunning();
    }

    @Override
    public int c() {
        return (Integer)this.a.getAnimatedValue();
    }

    @Override
    public float d() {
        return ((Float)this.a.getAnimatedValue()).floatValue();
    }

    @Override
    public void e() {
        this.a.cancel();
    }

    @Override
    public float f() {
        return this.a.getAnimatedFraction();
    }

    @Override
    public long g() {
        return this.a.getDuration();
    }

}

