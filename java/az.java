/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.animation.Animator
 *  android.animation.Animator$AnimatorListener
 *  android.animation.TimeInterpolator
 *  android.animation.ValueAnimator
 *  android.animation.ValueAnimator$AnimatorUpdateListener
 *  android.view.View
 *  android.view.ViewPropertyAnimator
 *  java.lang.Object
 */
import android.animation.Animator;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.view.View;
import android.view.ViewPropertyAnimator;

class az
implements aw {
    private TimeInterpolator a;

    az() {
    }

    @Override
    public ba a() {
        return new b((Animator)ValueAnimator.ofFloat((float[])new float[]{0.0f, 1.0f}));
    }

    @Override
    public void a(View view) {
        if (this.a == null) {
            this.a = new ValueAnimator().getInterpolator();
        }
        view.animate().setInterpolator(this.a);
    }

    static class a
    implements Animator.AnimatorListener {
        final av a;
        final ba b;

        public a(av av2, ba ba2) {
            this.a = av2;
            this.b = ba2;
        }

        public void onAnimationCancel(Animator animator) {
            this.a.onAnimationCancel(this.b);
        }

        public void onAnimationEnd(Animator animator) {
            this.a.onAnimationEnd(this.b);
        }

        public void onAnimationRepeat(Animator animator) {
            this.a.onAnimationRepeat(this.b);
        }

        public void onAnimationStart(Animator animator) {
            this.a.onAnimationStart(this.b);
        }
    }

    static class b
    implements ba {
        final Animator a;

        public b(Animator animator) {
            this.a = animator;
        }

        @Override
        public void a() {
            this.a.start();
        }

        @Override
        public void a(long l2) {
            this.a.setDuration(l2);
        }

        @Override
        public void a(View view) {
            this.a.setTarget((Object)view);
        }

        @Override
        public void a(av av2) {
            this.a.addListener((Animator.AnimatorListener)new a(av2, (ba)this));
        }

        @Override
        public void a(final ax ax2) {
            if (this.a instanceof ValueAnimator) {
                ((ValueAnimator)this.a).addUpdateListener(new ValueAnimator.AnimatorUpdateListener(){

                    public void onAnimationUpdate(ValueAnimator valueAnimator) {
                        ax2.onAnimationUpdate(b.this);
                    }
                });
            }
        }

        @Override
        public void b() {
            this.a.cancel();
        }

        @Override
        public float c() {
            return ((ValueAnimator)this.a).getAnimatedFraction();
        }

    }

}

