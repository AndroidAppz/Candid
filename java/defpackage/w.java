package defpackage;

import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.Path.FillType;
import android.graphics.RadialGradient;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader.TileMode;
import android.graphics.drawable.Drawable;
import android.support.v7.graphics.drawable.DrawableWrapper;

/* compiled from: ShadowDrawableWrapper */
class w extends DrawableWrapper {
    static final double a = Math.cos(Math.toRadians(45.0d));
    final Paint b;
    final Paint c;
    final RectF d;
    float e;
    Path f;
    float g;
    float h;
    float i;
    float j;
    private boolean k = true;
    private final int l;
    private final int m;
    private final int n;
    private boolean o = true;
    private float p;
    private boolean q = false;

    public w(Resources resources, Drawable content, float radius, float shadowSize, float maxShadowSize) {
        super(content);
        this.l = resources.getColor(g$c.design_fab_shadow_start_color);
        this.m = resources.getColor(g$c.design_fab_shadow_mid_color);
        this.n = resources.getColor(g$c.design_fab_shadow_end_color);
        this.b = new Paint(5);
        this.b.setStyle(Style.FILL);
        this.e = (float) Math.round(radius);
        this.d = new RectF();
        this.c = new Paint(this.b);
        this.c.setAntiAlias(false);
        a(shadowSize, maxShadowSize);
    }

    private static int d(float value) {
        int i = Math.round(value);
        return i % 2 == 1 ? i - 1 : i;
    }

    public void a(boolean addPaddingForCorners) {
        this.o = addPaddingForCorners;
        invalidateSelf();
    }

    public void setAlpha(int alpha) {
        super.setAlpha(alpha);
        this.b.setAlpha(alpha);
        this.c.setAlpha(alpha);
    }

    protected void onBoundsChange(Rect bounds) {
        this.k = true;
    }

    void a(float shadowSize, float maxShadowSize) {
        if (shadowSize < 0.0f || maxShadowSize < 0.0f) {
            throw new IllegalArgumentException("invalid shadow size");
        }
        shadowSize = (float) w.d(shadowSize);
        maxShadowSize = (float) w.d(maxShadowSize);
        if (shadowSize > maxShadowSize) {
            shadowSize = maxShadowSize;
            if (!this.q) {
                this.q = true;
            }
        }
        if (this.j != shadowSize || this.h != maxShadowSize) {
            this.j = shadowSize;
            this.h = maxShadowSize;
            this.i = (float) Math.round(1.5f * shadowSize);
            this.g = maxShadowSize;
            this.k = true;
            invalidateSelf();
        }
    }

    public boolean getPadding(Rect padding) {
        int vOffset = (int) Math.ceil((double) w.a(this.h, this.e, this.o));
        int hOffset = (int) Math.ceil((double) w.b(this.h, this.e, this.o));
        padding.set(hOffset, vOffset, hOffset, vOffset);
        return true;
    }

    public static float a(float maxShadowSize, float cornerRadius, boolean addPaddingForCorners) {
        if (addPaddingForCorners) {
            return (float) (((double) (1.5f * maxShadowSize)) + ((1.0d - a) * ((double) cornerRadius)));
        }
        return 1.5f * maxShadowSize;
    }

    public static float b(float maxShadowSize, float cornerRadius, boolean addPaddingForCorners) {
        if (addPaddingForCorners) {
            return (float) (((double) maxShadowSize) + ((1.0d - a) * ((double) cornerRadius)));
        }
        return maxShadowSize;
    }

    public int getOpacity() {
        return -3;
    }

    public void draw(Canvas canvas) {
        if (this.k) {
            a(getBounds());
            this.k = false;
        }
        a(canvas);
        super.draw(canvas);
    }

    final void a(float rotation) {
        if (this.p != rotation) {
            this.p = rotation;
            invalidateSelf();
        }
    }

    private void a(Canvas canvas) {
        int rotateSaved = canvas.save();
        canvas.rotate(this.p, this.d.centerX(), this.d.centerY());
        float edgeShadowTop = (-this.e) - this.i;
        float shadowOffset = this.e;
        boolean drawHorizontalEdges = this.d.width() - (2.0f * shadowOffset) > 0.0f;
        boolean drawVerticalEdges = this.d.height() - (2.0f * shadowOffset) > 0.0f;
        float shadowScaleHorizontal = shadowOffset / (shadowOffset + (this.j - (this.j * 0.5f)));
        float shadowScaleTop = shadowOffset / (shadowOffset + (this.j - (this.j * 0.25f)));
        float shadowScaleBottom = shadowOffset / (shadowOffset + (this.j - (this.j * 1.0f)));
        int saved = canvas.save();
        canvas.translate(this.d.left + shadowOffset, this.d.top + shadowOffset);
        canvas.scale(shadowScaleHorizontal, shadowScaleTop);
        canvas.drawPath(this.f, this.b);
        if (drawHorizontalEdges) {
            canvas.scale(1.0f / shadowScaleHorizontal, 1.0f);
            canvas.drawRect(0.0f, edgeShadowTop, this.d.width() - (2.0f * shadowOffset), -this.e, this.c);
        }
        canvas.restoreToCount(saved);
        saved = canvas.save();
        canvas.translate(this.d.right - shadowOffset, this.d.bottom - shadowOffset);
        canvas.scale(shadowScaleHorizontal, shadowScaleBottom);
        canvas.rotate(180.0f);
        canvas.drawPath(this.f, this.b);
        if (drawHorizontalEdges) {
            canvas.scale(1.0f / shadowScaleHorizontal, 1.0f);
            canvas.drawRect(0.0f, edgeShadowTop, this.d.width() - (2.0f * shadowOffset), this.i + (-this.e), this.c);
        }
        canvas.restoreToCount(saved);
        saved = canvas.save();
        canvas.translate(this.d.left + shadowOffset, this.d.bottom - shadowOffset);
        canvas.scale(shadowScaleHorizontal, shadowScaleBottom);
        canvas.rotate(270.0f);
        canvas.drawPath(this.f, this.b);
        if (drawVerticalEdges) {
            canvas.scale(1.0f / shadowScaleBottom, 1.0f);
            canvas.drawRect(0.0f, edgeShadowTop, this.d.height() - (2.0f * shadowOffset), -this.e, this.c);
        }
        canvas.restoreToCount(saved);
        saved = canvas.save();
        canvas.translate(this.d.right - shadowOffset, this.d.top + shadowOffset);
        canvas.scale(shadowScaleHorizontal, shadowScaleTop);
        canvas.rotate(90.0f);
        canvas.drawPath(this.f, this.b);
        if (drawVerticalEdges) {
            canvas.scale(1.0f / shadowScaleTop, 1.0f);
            canvas.drawRect(0.0f, edgeShadowTop, this.d.height() - (2.0f * shadowOffset), -this.e, this.c);
        }
        canvas.restoreToCount(saved);
        canvas.restoreToCount(rotateSaved);
    }

    private void b() {
        RectF innerBounds = new RectF(-this.e, -this.e, this.e, this.e);
        RectF outerBounds = new RectF(innerBounds);
        outerBounds.inset(-this.i, -this.i);
        if (this.f == null) {
            this.f = new Path();
        } else {
            this.f.reset();
        }
        this.f.setFillType(FillType.EVEN_ODD);
        this.f.moveTo(-this.e, 0.0f);
        this.f.rLineTo(-this.i, 0.0f);
        this.f.arcTo(outerBounds, 180.0f, 90.0f, false);
        this.f.arcTo(innerBounds, 270.0f, -90.0f, false);
        this.f.close();
        float shadowRadius = -outerBounds.top;
        if (shadowRadius > 0.0f) {
            float startRatio = this.e / shadowRadius;
            float midRatio = startRatio + ((1.0f - startRatio) / 2.0f);
            this.b.setShader(new RadialGradient(0.0f, 0.0f, shadowRadius, new int[]{0, this.l, this.m, this.n}, new float[]{0.0f, startRatio, midRatio, 1.0f}, TileMode.CLAMP));
        }
        this.c.setShader(new LinearGradient(0.0f, innerBounds.top, 0.0f, outerBounds.top, new int[]{this.l, this.m, this.n}, new float[]{0.0f, 0.5f, 1.0f}, TileMode.CLAMP));
        this.c.setAntiAlias(false);
    }

    private void a(Rect bounds) {
        float verticalOffset = this.h * 1.5f;
        this.d.set(((float) bounds.left) + this.h, ((float) bounds.top) + verticalOffset, ((float) bounds.right) - this.h, ((float) bounds.bottom) - verticalOffset);
        getWrappedDrawable().setBounds((int) this.d.left, (int) this.d.top, (int) this.d.right, (int) this.d.bottom);
        b();
    }

    public void b(float size) {
        a(size, this.h);
    }

    public void c(float size) {
        a(this.j, size);
    }

    public float a() {
        return this.j;
    }
}
