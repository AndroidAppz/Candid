package defpackage;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.support.design.widget.VisibilityAwareImageButton;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

/* compiled from: FloatingActionButtonEclairMr1 */
public class r extends t {
    w a;
    private int m;
    private z n = new z();
    private boolean o;

    public r(VisibilityAwareImageButton view, x shadowViewDelegate) {
        super(view, shadowViewDelegate);
        this.m = view.getResources().getInteger(17694720);
        this.n.a((View) view);
        this.n.a(h, a(new r$b()));
        this.n.a(i, a(new r$b()));
        this.n.a(j, a(new r$c(this, null)));
    }

    void a(ColorStateList backgroundTint, Mode backgroundTintMode, int rippleColor, int borderWidth) {
        Drawable[] layers;
        this.b = bv.f(k());
        bv.a(this.b, backgroundTint);
        if (backgroundTintMode != null) {
            bv.a(this.b, backgroundTintMode);
        }
        this.c = bv.f(k());
        bv.a(this.c, r.b(rippleColor));
        if (borderWidth > 0) {
            this.d = a(borderWidth, backgroundTint);
            layers = new Drawable[]{this.d, this.b, this.c};
        } else {
            this.d = null;
            layers = new Drawable[]{this.b, this.c};
        }
        this.e = new LayerDrawable(layers);
        this.a = new w(this.k.getResources(), this.e, this.l.a(), this.f, this.f + this.g);
        this.a.a(false);
        this.l.a(this.a);
    }

    void a(ColorStateList tint) {
        if (this.b != null) {
            bv.a(this.b, tint);
        }
        if (this.d != null) {
            this.d.a(tint);
        }
    }

    void a(Mode tintMode) {
        if (this.b != null) {
            bv.a(this.b, tintMode);
        }
    }

    void a(int rippleColor) {
        if (this.c != null) {
            bv.a(this.c, r.b(rippleColor));
        }
    }

    float a() {
        return this.f;
    }

    void a(float elevation) {
        if (this.a != null) {
            this.a.a(elevation, this.g + elevation);
            g();
        }
    }

    void b(float translationZ) {
        if (this.a != null) {
            this.a.c(this.f + translationZ);
            g();
        }
    }

    void a(int[] state) {
        this.n.a(state);
    }

    void b() {
        this.n.b();
    }

    void a(t$a listener, boolean fromUser) {
        if (!this.o && this.k.getVisibility() == 0) {
            Animation anim = AnimationUtils.loadAnimation(this.k.getContext(), g$a.design_fab_out);
            anim.setInterpolator(k.c);
            anim.setDuration(200);
            anim.setAnimationListener(new r$1(this, fromUser, listener));
            this.k.startAnimation(anim);
        } else if (listener != null) {
            listener.b();
        }
    }

    void b(t$a listener, boolean fromUser) {
        if (this.k.getVisibility() != 0 || this.o) {
            this.k.clearAnimation();
            this.k.a(0, fromUser);
            Animation anim = AnimationUtils.loadAnimation(this.k.getContext(), g$a.design_fab_in);
            anim.setDuration(200);
            anim.setInterpolator(k.d);
            anim.setAnimationListener(new r$2(this, listener));
            this.k.startAnimation(anim);
        } else if (listener != null) {
            listener.a();
        }
    }

    void c() {
    }

    void a(Rect rect) {
        this.a.getPadding(rect);
    }

    private Animation a(Animation animation) {
        animation.setInterpolator(k.b);
        animation.setDuration((long) this.m);
        return animation;
    }

    private static ColorStateList b(int selectedColor) {
        states = new int[3][];
        int[] colors = new int[3];
        states[0] = i;
        colors[0] = selectedColor;
        int i = 0 + 1;
        states[i] = h;
        colors[i] = selectedColor;
        i++;
        states[i] = new int[0];
        colors[i] = 0;
        i++;
        return new ColorStateList(states, colors);
    }
}
