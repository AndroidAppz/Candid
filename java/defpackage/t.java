package defpackage;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.support.design.widget.VisibilityAwareImageButton;
import android.view.ViewTreeObserver.OnPreDrawListener;

/* compiled from: FloatingActionButtonImpl */
public abstract class t {
    static final int[] h = new int[]{16842919, 16842910};
    static final int[] i = new int[]{16842908, 16842910};
    static final int[] j = new int[0];
    private final Rect a = new Rect();
    Drawable b;
    Drawable c;
    l d;
    Drawable e;
    float f;
    float g;
    final VisibilityAwareImageButton k;
    final x l;
    private OnPreDrawListener m;

    public abstract float a();

    abstract void a(float f);

    public abstract void a(int i);

    public abstract void a(ColorStateList colorStateList);

    public abstract void a(ColorStateList colorStateList, Mode mode, int i, int i2);

    public abstract void a(Mode mode);

    abstract void a(Rect rect);

    public abstract void a(t$a t_a, boolean z);

    public abstract void a(int[] iArr);

    public abstract void b();

    abstract void b(float f);

    public abstract void b(t$a t_a, boolean z);

    public abstract void c();

    t(VisibilityAwareImageButton view, x shadowViewDelegate) {
        this.k = view;
        this.l = shadowViewDelegate;
    }

    public final void c(float elevation) {
        if (this.f != elevation) {
            this.f = elevation;
            a(elevation);
        }
    }

    public final void d(float translationZ) {
        if (this.g != translationZ) {
            this.g = translationZ;
            b(translationZ);
        }
    }

    public final Drawable f() {
        return this.e;
    }

    public final void g() {
        Rect rect = this.a;
        a(rect);
        b(rect);
        this.l.a(rect.left, rect.top, rect.right, rect.bottom);
    }

    void b(Rect padding) {
    }

    public void h() {
        if (d()) {
            l();
            this.k.getViewTreeObserver().addOnPreDrawListener(this.m);
        }
    }

    public void i() {
        if (this.m != null) {
            this.k.getViewTreeObserver().removeOnPreDrawListener(this.m);
            this.m = null;
        }
    }

    boolean d() {
        return false;
    }

    l a(int borderWidth, ColorStateList backgroundTint) {
        Resources resources = this.k.getResources();
        l borderDrawable = j();
        borderDrawable.a(resources.getColor(g$c.design_fab_stroke_top_outer_color), resources.getColor(g$c.design_fab_stroke_top_inner_color), resources.getColor(g$c.design_fab_stroke_end_inner_color), resources.getColor(g$c.design_fab_stroke_end_outer_color));
        borderDrawable.a((float) borderWidth);
        borderDrawable.a(backgroundTint);
        return borderDrawable;
    }

    l j() {
        return new l();
    }

    void e() {
    }

    private void l() {
        if (this.m == null) {
            this.m = new t$1(this);
        }
    }

    GradientDrawable k() {
        GradientDrawable d = new GradientDrawable();
        d.setShape(1);
        d.setColor(-1);
        return d;
    }
}
