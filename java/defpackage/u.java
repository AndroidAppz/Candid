package defpackage;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.animation.StateListAnimator;
import android.annotation.TargetApi;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.RippleDrawable;
import android.support.design.widget.VisibilityAwareImageButton;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;

@TargetApi(21)
/* compiled from: FloatingActionButtonLollipop */
public class u extends s {
    private final Interpolator m;
    private InsetDrawable n;

    public u(VisibilityAwareImageButton view, x shadowViewDelegate) {
        super(view, shadowViewDelegate);
        this.m = view.isInEditMode() ? null : AnimationUtils.loadInterpolator(this.k.getContext(), 17563661);
    }

    void a(ColorStateList backgroundTint, Mode backgroundTintMode, int rippleColor, int borderWidth) {
        Drawable rippleContent;
        this.b = bv.f(k());
        bv.a(this.b, backgroundTint);
        if (backgroundTintMode != null) {
            bv.a(this.b, backgroundTintMode);
        }
        if (borderWidth > 0) {
            this.d = a(borderWidth, backgroundTint);
            rippleContent = new LayerDrawable(new Drawable[]{this.d, this.b});
        } else {
            this.d = null;
            rippleContent = this.b;
        }
        this.c = new RippleDrawable(ColorStateList.valueOf(rippleColor), rippleContent, null);
        this.e = this.c;
        this.l.a(this.c);
    }

    void a(int rippleColor) {
        if (this.c instanceof RippleDrawable) {
            ((RippleDrawable) this.c).setColor(ColorStateList.valueOf(rippleColor));
        } else {
            super.a(rippleColor);
        }
    }

    public void a(float elevation) {
        this.k.setElevation(elevation);
        if (this.l.b()) {
            g();
        }
    }

    void b(float translationZ) {
        StateListAnimator stateListAnimator = new StateListAnimator();
        stateListAnimator.addState(h, a(ObjectAnimator.ofFloat(this.k, "translationZ", new float[]{translationZ})));
        stateListAnimator.addState(i, a(ObjectAnimator.ofFloat(this.k, "translationZ", new float[]{translationZ})));
        stateListAnimator.addState(j, a(ObjectAnimator.ofFloat(this.k, "translationZ", new float[]{0.0f})));
        this.k.setStateListAnimator(stateListAnimator);
        if (this.l.b()) {
            g();
        }
    }

    public float a() {
        return this.k.getElevation();
    }

    void c() {
        g();
    }

    void b(Rect padding) {
        if (this.l.b()) {
            this.n = new InsetDrawable(this.c, padding.left, padding.top, padding.right, padding.bottom);
            this.l.a(this.n);
            return;
        }
        this.l.a(this.c);
    }

    void a(int[] state) {
    }

    void b() {
    }

    boolean d() {
        return false;
    }

    private Animator a(Animator animator) {
        animator.setInterpolator(this.m);
        return animator;
    }

    l j() {
        return new m();
    }

    void a(Rect rect) {
        if (this.l.b()) {
            float radius = this.l.a();
            float maxShadowSize = a() + this.g;
            int hPadding = (int) Math.ceil((double) w.b(maxShadowSize, radius, false));
            int vPadding = (int) Math.ceil((double) w.a(maxShadowSize, radius, false));
            rect.set(hPadding, vPadding, hPadding, vPadding);
            return;
        }
        rect.set(0, 0, 0, 0);
    }
}
