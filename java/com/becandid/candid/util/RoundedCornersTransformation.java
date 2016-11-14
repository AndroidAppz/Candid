package com.becandid.candid.util;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Shader.TileMode;
import android.util.Log;
import defpackage.ha$a;
import defpackage.jp;
import defpackage.kj;
import defpackage.lb;
import defpackage.lf;
import defpackage.nj;
import defpackage.um$h;

public class RoundedCornersTransformation implements kj<Bitmap> {
    private lf a;
    private int b;
    private int c;
    private int d;
    private CornerType e;

    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] a = new int[CornerType.values().length];

        static {
            try {
                a[CornerType.ALL.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                a[CornerType.TOP_LEFT.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                a[CornerType.TOP_RIGHT.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                a[CornerType.BOTTOM_LEFT.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                a[CornerType.BOTTOM_RIGHT.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
            try {
                a[CornerType.TOP.ordinal()] = 6;
            } catch (NoSuchFieldError e6) {
            }
            try {
                a[CornerType.BOTTOM.ordinal()] = 7;
            } catch (NoSuchFieldError e7) {
            }
            try {
                a[CornerType.LEFT.ordinal()] = 8;
            } catch (NoSuchFieldError e8) {
            }
            try {
                a[CornerType.RIGHT.ordinal()] = 9;
            } catch (NoSuchFieldError e9) {
            }
            try {
                a[CornerType.OTHER_TOP_LEFT.ordinal()] = 10;
            } catch (NoSuchFieldError e10) {
            }
            try {
                a[CornerType.OTHER_TOP_RIGHT.ordinal()] = 11;
            } catch (NoSuchFieldError e11) {
            }
            try {
                a[CornerType.OTHER_BOTTOM_LEFT.ordinal()] = 12;
            } catch (NoSuchFieldError e12) {
            }
            try {
                a[CornerType.OTHER_BOTTOM_RIGHT.ordinal()] = 13;
            } catch (NoSuchFieldError e13) {
            }
            try {
                a[CornerType.DIAGONAL_FROM_TOP_LEFT.ordinal()] = 14;
            } catch (NoSuchFieldError e14) {
            }
            try {
                a[CornerType.DIAGONAL_FROM_TOP_RIGHT.ordinal()] = 15;
            } catch (NoSuchFieldError e15) {
            }
        }
    }

    public enum CornerType {
        ALL,
        TOP_LEFT,
        TOP_RIGHT,
        BOTTOM_LEFT,
        BOTTOM_RIGHT,
        TOP,
        BOTTOM,
        LEFT,
        RIGHT,
        OTHER_TOP_LEFT,
        OTHER_TOP_RIGHT,
        OTHER_BOTTOM_LEFT,
        OTHER_BOTTOM_RIGHT,
        DIAGONAL_FROM_TOP_LEFT,
        DIAGONAL_FROM_TOP_RIGHT
    }

    public RoundedCornersTransformation(Context context, int radius, int margin) {
        this(context, radius, margin, CornerType.ALL);
    }

    public RoundedCornersTransformation(Context context, int radius, int margin, CornerType cornerType) {
        this(jp.a(context).a(), radius, margin, cornerType);
    }

    public RoundedCornersTransformation(lf pool, int radius, int margin, CornerType cornerType) {
        this.a = pool;
        this.b = radius;
        this.c = this.b * 2;
        this.d = margin;
        this.e = cornerType;
    }

    public lb<Bitmap> a(lb<Bitmap> resource, int outWidth, int outHeight) {
        return a((Bitmap) resource.b(), outWidth, outHeight);
    }

    public lb<Bitmap> a(Bitmap source, int outWidth, int outHeight) {
        int width = source.getWidth();
        int height = source.getHeight();
        Bitmap bitmap = this.a.a(outWidth, outHeight, Config.ARGB_8888);
        if (bitmap != null || outHeight <= 0 || outWidth <= 0) {
            bitmap.eraseColor(0);
        } else {
            bitmap = Bitmap.createBitmap(outWidth, outHeight, Config.ARGB_8888);
        }
        Canvas canvas = new Canvas(bitmap);
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        BitmapShader bitmapShader = new BitmapShader(source, TileMode.CLAMP, TileMode.CLAMP);
        Matrix bitmapScale = new Matrix();
        float dx = ((float) outWidth) / ((float) width);
        float dy = ((float) outHeight) / ((float) height);
        float scale = Math.max(dx, dy);
        bitmapScale.setScale(scale, scale);
        bitmapScale.postTranslate(dx > dy ? 0.0f : (((float) outWidth) - (((float) width) * dy)) * 0.5f, 0.0f);
        bitmapShader.setLocalMatrix(bitmapScale);
        paint.setShader(bitmapShader);
        a(canvas, paint, (float) outWidth, (float) outHeight);
        return nj.a(bitmap, this.a);
    }

    private void a(Canvas canvas, Paint paint, float width, float height) {
        Log.d("RCT", "Draw round bitmap with size: " + width + "x" + height);
        float right = width - ((float) this.d);
        float bottom = height - ((float) this.d);
        switch (AnonymousClass1.a[this.e.ordinal()]) {
            case um$h.com_facebook_profile_picture_view_com_facebook_is_cropped /*1*/:
                canvas.drawRoundRect(new RectF((float) this.d, (float) this.d, right, bottom), (float) this.b, (float) this.b, paint);
                return;
            case um$h.com_facebook_login_view_com_facebook_logout_text /*2*/:
                b(canvas, paint, right, bottom);
                return;
            case um$h.com_facebook_login_view_com_facebook_tooltip_mode /*3*/:
                c(canvas, paint, right, bottom);
                return;
            case um$h.com_facebook_like_view_com_facebook_auxiliary_view_position /*4*/:
                d(canvas, paint, right, bottom);
                return;
            case um$h.com_facebook_like_view_com_facebook_horizontal_alignment /*5*/:
                e(canvas, paint, right, bottom);
                return;
            case um$h.CardView_cardUseCompatPadding /*6*/:
                f(canvas, paint, right, bottom);
                return;
            case um$h.CardView_cardPreventCornerOverlap /*7*/:
                g(canvas, paint, right, bottom);
                return;
            case um$h.CardView_contentPadding /*8*/:
                h(canvas, paint, right, bottom);
                return;
            case um$h.CardView_contentPaddingLeft /*9*/:
                i(canvas, paint, right, bottom);
                return;
            case um$h.CardView_contentPaddingRight /*10*/:
                j(canvas, paint, right, bottom);
                return;
            case um$h.CardView_contentPaddingTop /*11*/:
                k(canvas, paint, right, bottom);
                return;
            case um$h.CardView_contentPaddingBottom /*12*/:
                l(canvas, paint, right, bottom);
                return;
            case ha$a.Toolbar_titleMarginStart /*13*/:
                m(canvas, paint, right, bottom);
                return;
            case ha$a.Toolbar_titleMarginEnd /*14*/:
                n(canvas, paint, right, bottom);
                return;
            case ha$a.Toolbar_titleMarginTop /*15*/:
                o(canvas, paint, right, bottom);
                return;
            default:
                canvas.drawRoundRect(new RectF((float) this.d, (float) this.d, right, bottom), (float) this.b, (float) this.b, paint);
                return;
        }
    }

    private void b(Canvas canvas, Paint paint, float right, float bottom) {
        canvas.drawRoundRect(new RectF((float) this.d, (float) this.d, (float) (this.d + this.c), (float) (this.d + this.c)), (float) this.b, (float) this.b, paint);
        canvas.drawRect(new RectF((float) this.d, (float) (this.d + this.b), (float) (this.d + this.b), bottom), paint);
        canvas.drawRect(new RectF((float) (this.d + this.b), (float) this.d, right, bottom), paint);
    }

    private void c(Canvas canvas, Paint paint, float right, float bottom) {
        canvas.drawRoundRect(new RectF(right - ((float) this.c), (float) this.d, right, (float) (this.d + this.c)), (float) this.b, (float) this.b, paint);
        canvas.drawRect(new RectF((float) this.d, (float) this.d, right - ((float) this.b), bottom), paint);
        canvas.drawRect(new RectF(right - ((float) this.b), (float) (this.d + this.b), right, bottom), paint);
    }

    private void d(Canvas canvas, Paint paint, float right, float bottom) {
        canvas.drawRoundRect(new RectF((float) this.d, bottom - ((float) this.c), (float) (this.d + this.c), bottom), (float) this.b, (float) this.b, paint);
        canvas.drawRect(new RectF((float) this.d, (float) this.d, (float) (this.d + this.c), bottom - ((float) this.b)), paint);
        canvas.drawRect(new RectF((float) (this.d + this.b), (float) this.d, right, bottom), paint);
    }

    private void e(Canvas canvas, Paint paint, float right, float bottom) {
        canvas.drawRoundRect(new RectF(right - ((float) this.c), bottom - ((float) this.c), right, bottom), (float) this.b, (float) this.b, paint);
        canvas.drawRect(new RectF((float) this.d, (float) this.d, right - ((float) this.b), bottom), paint);
        canvas.drawRect(new RectF(right - ((float) this.b), (float) this.d, right, bottom - ((float) this.b)), paint);
    }

    private void f(Canvas canvas, Paint paint, float right, float bottom) {
        canvas.drawRoundRect(new RectF((float) this.d, (float) this.d, right, (float) (this.d + this.c)), (float) this.b, (float) this.b, paint);
        canvas.drawRect(new RectF((float) this.d, (float) (this.d + this.b), right, bottom), paint);
    }

    private void g(Canvas canvas, Paint paint, float right, float bottom) {
        canvas.drawRoundRect(new RectF((float) this.d, bottom - ((float) this.c), right, bottom), (float) this.b, (float) this.b, paint);
        canvas.drawRect(new RectF((float) this.d, (float) this.d, right, bottom - ((float) this.b)), paint);
    }

    private void h(Canvas canvas, Paint paint, float right, float bottom) {
        canvas.drawRoundRect(new RectF((float) this.d, (float) this.d, (float) (this.d + this.c), bottom), (float) this.b, (float) this.b, paint);
        canvas.drawRect(new RectF((float) (this.d + this.b), (float) this.d, right, bottom), paint);
    }

    private void i(Canvas canvas, Paint paint, float right, float bottom) {
        canvas.drawRoundRect(new RectF(right - ((float) this.c), (float) this.d, right, bottom), (float) this.b, (float) this.b, paint);
        canvas.drawRect(new RectF((float) this.d, (float) this.d, right - ((float) this.b), bottom), paint);
    }

    private void j(Canvas canvas, Paint paint, float right, float bottom) {
        canvas.drawRoundRect(new RectF((float) this.d, bottom - ((float) this.c), right, bottom), (float) this.b, (float) this.b, paint);
        canvas.drawRoundRect(new RectF(right - ((float) this.c), (float) this.d, right, bottom), (float) this.b, (float) this.b, paint);
        canvas.drawRect(new RectF((float) this.d, (float) this.d, right - ((float) this.b), bottom - ((float) this.b)), paint);
    }

    private void k(Canvas canvas, Paint paint, float right, float bottom) {
        canvas.drawRoundRect(new RectF((float) this.d, (float) this.d, (float) (this.d + this.c), bottom), (float) this.b, (float) this.b, paint);
        canvas.drawRoundRect(new RectF((float) this.d, bottom - ((float) this.c), right, bottom), (float) this.b, (float) this.b, paint);
        canvas.drawRect(new RectF((float) (this.d + this.b), (float) this.d, right, bottom - ((float) this.b)), paint);
    }

    private void l(Canvas canvas, Paint paint, float right, float bottom) {
        canvas.drawRoundRect(new RectF((float) this.d, (float) this.d, right, (float) (this.d + this.c)), (float) this.b, (float) this.b, paint);
        canvas.drawRoundRect(new RectF(right - ((float) this.c), (float) this.d, right, bottom), (float) this.b, (float) this.b, paint);
        canvas.drawRect(new RectF((float) this.d, (float) (this.d + this.b), right - ((float) this.b), bottom), paint);
    }

    private void m(Canvas canvas, Paint paint, float right, float bottom) {
        canvas.drawRoundRect(new RectF((float) this.d, (float) this.d, right, (float) (this.d + this.c)), (float) this.b, (float) this.b, paint);
        canvas.drawRoundRect(new RectF((float) this.d, (float) this.d, (float) (this.d + this.c), bottom), (float) this.b, (float) this.b, paint);
        canvas.drawRect(new RectF((float) (this.d + this.b), (float) (this.d + this.b), right, bottom), paint);
    }

    private void n(Canvas canvas, Paint paint, float right, float bottom) {
        canvas.drawRoundRect(new RectF((float) this.d, (float) this.d, (float) (this.d + this.c), (float) (this.d + this.c)), (float) this.b, (float) this.b, paint);
        canvas.drawRoundRect(new RectF(right - ((float) this.c), bottom - ((float) this.c), right, bottom), (float) this.b, (float) this.b, paint);
        canvas.drawRect(new RectF((float) this.d, (float) (this.d + this.b), right - ((float) this.c), bottom), paint);
        canvas.drawRect(new RectF((float) (this.d + this.c), (float) this.d, right, bottom - ((float) this.b)), paint);
    }

    private void o(Canvas canvas, Paint paint, float right, float bottom) {
        canvas.drawRoundRect(new RectF(right - ((float) this.c), (float) this.d, right, (float) (this.d + this.c)), (float) this.b, (float) this.b, paint);
        canvas.drawRoundRect(new RectF((float) this.d, bottom - ((float) this.c), (float) (this.d + this.c), bottom), (float) this.b, (float) this.b, paint);
        canvas.drawRect(new RectF((float) this.d, (float) this.d, right - ((float) this.b), bottom - ((float) this.b)), paint);
        canvas.drawRect(new RectF((float) (this.d + this.b), (float) (this.d + this.b), right, bottom), paint);
    }

    public String a() {
        return "RoundedTransformation(radius=" + this.b + ", margin=" + this.d + ", diameter=" + this.c + ", cornerType=" + this.e.name() + ")";
    }
}
