package defpackage;

import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.os.Build.VERSION;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.view.View;
import android.view.animation.Interpolator;

/* compiled from: CollapsingTextHelper */
public final class n {
    private static final boolean a = (VERSION.SDK_INT < 18);
    private static final Paint b = null;
    private boolean A;
    private Bitmap B;
    private Paint C;
    private float D;
    private float E;
    private float F;
    private float G;
    private boolean H;
    private final TextPaint I;
    private Interpolator J;
    private Interpolator K;
    private float L;
    private float M;
    private float N;
    private int O;
    private float P;
    private float Q;
    private float R;
    private int S;
    private final View c;
    private boolean d;
    private float e;
    private final Rect f;
    private final Rect g;
    private final RectF h;
    private int i = 16;
    private int j = 16;
    private float k = 15.0f;
    private float l = 15.0f;
    private int m;
    private int n;
    private float o;
    private float p;
    private float q;
    private float r;
    private float s;
    private float t;
    private Typeface u;
    private Typeface v;
    private Typeface w;
    private CharSequence x;
    private CharSequence y;
    private boolean z;

    static {
        if (b != null) {
            b.setAntiAlias(true);
            b.setColor(-65281);
        }
    }

    public n(View view) {
        this.c = view;
        this.I = new TextPaint(129);
        this.g = new Rect();
        this.f = new Rect();
        this.h = new RectF();
    }

    public void a(Interpolator interpolator) {
        this.K = interpolator;
        h();
    }

    public void b(Interpolator interpolator) {
        this.J = interpolator;
        h();
    }

    public void a(float textSize) {
        if (this.k != textSize) {
            this.k = textSize;
            h();
        }
    }

    public void a(int textColor) {
        if (this.n != textColor) {
            this.n = textColor;
            h();
        }
    }

    public void b(int textColor) {
        if (this.m != textColor) {
            this.m = textColor;
            h();
        }
    }

    public void a(int left, int top, int right, int bottom) {
        if (!n.a(this.f, left, top, right, bottom)) {
            this.f.set(left, top, right, bottom);
            this.H = true;
            a();
        }
    }

    public void b(int left, int top, int right, int bottom) {
        if (!n.a(this.g, left, top, right, bottom)) {
            this.g.set(left, top, right, bottom);
            this.H = true;
            a();
        }
    }

    void a() {
        boolean z = this.g.width() > 0 && this.g.height() > 0 && this.f.width() > 0 && this.f.height() > 0;
        this.d = z;
    }

    public void c(int gravity) {
        if (this.i != gravity) {
            this.i = gravity;
            h();
        }
    }

    public int b() {
        return this.i;
    }

    public void d(int gravity) {
        if (this.j != gravity) {
            this.j = gravity;
            h();
        }
    }

    public int c() {
        return this.j;
    }

    public void e(int resId) {
        TypedArray a = this.c.getContext().obtainStyledAttributes(resId, g$i.TextAppearance);
        if (a.hasValue(g$i.TextAppearance_android_textColor)) {
            this.n = a.getColor(g$i.TextAppearance_android_textColor, this.n);
        }
        if (a.hasValue(g$i.TextAppearance_android_textSize)) {
            this.l = (float) a.getDimensionPixelSize(g$i.TextAppearance_android_textSize, (int) this.l);
        }
        this.O = a.getInt(g$i.TextAppearance_android_shadowColor, 0);
        this.M = a.getFloat(g$i.TextAppearance_android_shadowDx, 0.0f);
        this.N = a.getFloat(g$i.TextAppearance_android_shadowDy, 0.0f);
        this.L = a.getFloat(g$i.TextAppearance_android_shadowRadius, 0.0f);
        a.recycle();
        if (VERSION.SDK_INT >= 16) {
            this.u = g(resId);
        }
        h();
    }

    public void f(int resId) {
        TypedArray a = this.c.getContext().obtainStyledAttributes(resId, g$i.TextAppearance);
        if (a.hasValue(g$i.TextAppearance_android_textColor)) {
            this.m = a.getColor(g$i.TextAppearance_android_textColor, this.m);
        }
        if (a.hasValue(g$i.TextAppearance_android_textSize)) {
            this.k = (float) a.getDimensionPixelSize(g$i.TextAppearance_android_textSize, (int) this.k);
        }
        this.S = a.getInt(g$i.TextAppearance_android_shadowColor, 0);
        this.Q = a.getFloat(g$i.TextAppearance_android_shadowDx, 0.0f);
        this.R = a.getFloat(g$i.TextAppearance_android_shadowDy, 0.0f);
        this.P = a.getFloat(g$i.TextAppearance_android_shadowRadius, 0.0f);
        a.recycle();
        if (VERSION.SDK_INT >= 16) {
            this.v = g(resId);
        }
        h();
    }

    private Typeface g(int resId) {
        TypedArray a = this.c.getContext().obtainStyledAttributes(resId, new int[]{16843692});
        try {
            String family = a.getString(0);
            if (family != null) {
                Typeface create = Typeface.create(family, 0);
                return create;
            }
            a.recycle();
            return null;
        } finally {
            a.recycle();
        }
    }

    public void a(Typeface typeface) {
        if (this.u != typeface) {
            this.u = typeface;
            h();
        }
    }

    public void b(Typeface typeface) {
        if (this.v != typeface) {
            this.v = typeface;
            h();
        }
    }

    public void c(Typeface typeface) {
        this.v = typeface;
        this.u = typeface;
        h();
    }

    public Typeface d() {
        return this.u != null ? this.u : Typeface.DEFAULT;
    }

    public Typeface e() {
        return this.v != null ? this.v : Typeface.DEFAULT;
    }

    public void b(float fraction) {
        fraction = v.a(fraction, 0.0f, 1.0f);
        if (fraction != this.e) {
            this.e = fraction;
            k();
        }
    }

    public float f() {
        return this.e;
    }

    public float g() {
        return this.l;
    }

    private void k() {
        c(this.e);
    }

    private void c(float fraction) {
        d(fraction);
        this.s = n.a(this.q, this.r, fraction, this.J);
        this.t = n.a(this.o, this.p, fraction, this.J);
        e(n.a(this.k, this.l, fraction, this.K));
        if (this.n != this.m) {
            this.I.setColor(n.a(this.m, this.n, fraction));
        } else {
            this.I.setColor(this.n);
        }
        this.I.setShadowLayer(n.a(this.P, this.L, fraction, null), n.a(this.Q, this.M, fraction, null), n.a(this.R, this.N, fraction, null), n.a(this.S, this.O, fraction));
        fb.d(this.c);
    }

    private void l() {
        float width;
        int i;
        int i2 = 1;
        float currentTextSize = this.G;
        f(this.l);
        if (this.y != null) {
            width = this.I.measureText(this.y, 0, this.y.length());
        } else {
            width = 0.0f;
        }
        int i3 = this.j;
        if (this.z) {
            i = 1;
        } else {
            i = 0;
        }
        int collapsedAbsGravity = dx.a(i3, i);
        switch (collapsedAbsGravity & 112) {
            case ha$a.AppCompatTheme_homeAsUpIndicator /*48*/:
                this.p = ((float) this.g.top) - this.I.ascent();
                break;
            case ha$a.AppCompatTheme_panelMenuListTheme /*80*/:
                this.p = (float) this.g.bottom;
                break;
            default:
                this.p = ((float) this.g.centerY()) + (((this.I.descent() - this.I.ascent()) / 2.0f) - this.I.descent());
                break;
        }
        switch (collapsedAbsGravity & 8388615) {
            case um$h.com_facebook_profile_picture_view_com_facebook_is_cropped /*1*/:
                this.r = ((float) this.g.centerX()) - (width / 2.0f);
                break;
            case um$h.com_facebook_like_view_com_facebook_horizontal_alignment /*5*/:
                this.r = ((float) this.g.right) - width;
                break;
            default:
                this.r = (float) this.g.left;
                break;
        }
        f(this.k);
        if (this.y != null) {
            width = this.I.measureText(this.y, 0, this.y.length());
        } else {
            width = 0.0f;
        }
        int i4 = this.i;
        if (!this.z) {
            i2 = 0;
        }
        int expandedAbsGravity = dx.a(i4, i2);
        switch (expandedAbsGravity & 112) {
            case ha$a.AppCompatTheme_homeAsUpIndicator /*48*/:
                this.o = ((float) this.f.top) - this.I.ascent();
                break;
            case ha$a.AppCompatTheme_panelMenuListTheme /*80*/:
                this.o = (float) this.f.bottom;
                break;
            default:
                this.o = ((float) this.f.centerY()) + (((this.I.descent() - this.I.ascent()) / 2.0f) - this.I.descent());
                break;
        }
        switch (expandedAbsGravity & 8388615) {
            case um$h.com_facebook_profile_picture_view_com_facebook_is_cropped /*1*/:
                this.q = ((float) this.f.centerX()) - (width / 2.0f);
                break;
            case um$h.com_facebook_like_view_com_facebook_horizontal_alignment /*5*/:
                this.q = ((float) this.f.right) - width;
                break;
            default:
                this.q = (float) this.f.left;
                break;
        }
        n();
        e(currentTextSize);
    }

    private void d(float fraction) {
        this.h.left = n.a((float) this.f.left, (float) this.g.left, fraction, this.J);
        this.h.top = n.a(this.o, this.p, fraction, this.J);
        this.h.right = n.a((float) this.f.right, (float) this.g.right, fraction, this.J);
        this.h.bottom = n.a((float) this.f.bottom, (float) this.g.bottom, fraction, this.J);
    }

    public void a(Canvas canvas) {
        int saveCount = canvas.save();
        if (this.y != null && this.d) {
            boolean drawTexture;
            float ascent;
            float x = this.s;
            float y = this.t;
            if (!this.A || this.B == null) {
                drawTexture = false;
            } else {
                drawTexture = true;
            }
            float descent;
            if (drawTexture) {
                ascent = this.D * this.F;
                descent = this.E * this.F;
            } else {
                ascent = this.I.ascent() * this.F;
                descent = this.I.descent() * this.F;
            }
            if (drawTexture) {
                y += ascent;
            }
            if (this.F != 1.0f) {
                canvas.scale(this.F, this.F, x, y);
            }
            if (drawTexture) {
                canvas.drawBitmap(this.B, x, y, this.C);
            } else {
                canvas.drawText(this.y, 0, this.y.length(), x, y, this.I);
            }
        }
        canvas.restoreToCount(saveCount);
    }

    private boolean b(CharSequence text) {
        boolean defaultIsRtl = true;
        if (fb.h(this.c) != 1) {
            defaultIsRtl = false;
        }
        return (defaultIsRtl ? de.d : de.c).a(text, 0, text.length());
    }

    private void e(float textSize) {
        f(textSize);
        boolean z = a && this.F != 1.0f;
        this.A = z;
        if (this.A) {
            m();
        }
        fb.d(this.c);
    }

    private void f(float textSize) {
        boolean z = true;
        if (this.x != null) {
            float availableWidth;
            float newTextSize;
            boolean updateDrawText = false;
            if (n.a(textSize, this.l)) {
                availableWidth = (float) this.g.width();
                newTextSize = this.l;
                this.F = 1.0f;
                if (this.w != this.u) {
                    this.w = this.u;
                    updateDrawText = true;
                }
            } else {
                availableWidth = (float) this.f.width();
                newTextSize = this.k;
                if (this.w != this.v) {
                    this.w = this.v;
                    updateDrawText = true;
                }
                if (n.a(textSize, this.k)) {
                    this.F = 1.0f;
                } else {
                    this.F = textSize / this.k;
                }
            }
            if (availableWidth > 0.0f) {
                if (this.G != newTextSize || this.H || updateDrawText) {
                    updateDrawText = true;
                } else {
                    updateDrawText = false;
                }
                this.G = newTextSize;
                this.H = false;
            }
            if (this.y == null || updateDrawText) {
                this.I.setTextSize(this.G);
                this.I.setTypeface(this.w);
                TextPaint textPaint = this.I;
                if (this.F == 1.0f) {
                    z = false;
                }
                textPaint.setLinearText(z);
                CharSequence title = TextUtils.ellipsize(this.x, this.I, availableWidth, TruncateAt.END);
                if (!TextUtils.equals(title, this.y)) {
                    this.y = title;
                    this.z = b(this.y);
                }
            }
        }
    }

    private void m() {
        if (this.B == null && !this.f.isEmpty() && !TextUtils.isEmpty(this.y)) {
            c(0.0f);
            this.D = this.I.ascent();
            this.E = this.I.descent();
            int w = Math.round(this.I.measureText(this.y, 0, this.y.length()));
            int h = Math.round(this.E - this.D);
            if (w > 0 && h > 0) {
                this.B = Bitmap.createBitmap(w, h, Config.ARGB_8888);
                new Canvas(this.B).drawText(this.y, 0, this.y.length(), 0.0f, ((float) h) - this.I.descent(), this.I);
                if (this.C == null) {
                    this.C = new Paint(3);
                }
            }
        }
    }

    public void h() {
        if (this.c.getHeight() > 0 && this.c.getWidth() > 0) {
            l();
            k();
        }
    }

    public void a(CharSequence text) {
        if (text == null || !text.equals(this.x)) {
            this.x = text;
            this.y = null;
            n();
            h();
        }
    }

    public CharSequence i() {
        return this.x;
    }

    private void n() {
        if (this.B != null) {
            this.B.recycle();
            this.B = null;
        }
    }

    private static boolean a(float value, float targetValue) {
        return Math.abs(value - targetValue) < 0.001f;
    }

    public int j() {
        return this.n;
    }

    private static int a(int color1, int color2, float ratio) {
        float inverseRatio = 1.0f - ratio;
        return Color.argb((int) ((((float) Color.alpha(color1)) * inverseRatio) + (((float) Color.alpha(color2)) * ratio)), (int) ((((float) Color.red(color1)) * inverseRatio) + (((float) Color.red(color2)) * ratio)), (int) ((((float) Color.green(color1)) * inverseRatio) + (((float) Color.green(color2)) * ratio)), (int) ((((float) Color.blue(color1)) * inverseRatio) + (((float) Color.blue(color2)) * ratio)));
    }

    private static float a(float startValue, float endValue, float fraction, Interpolator interpolator) {
        if (interpolator != null) {
            fraction = interpolator.getInterpolation(fraction);
        }
        return k.a(startValue, endValue, fraction);
    }

    private static boolean a(Rect r, int left, int top, int right, int bottom) {
        return r.left == left && r.top == top && r.right == right && r.bottom == bottom;
    }
}
