package com.facebook.share.internal;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.RectF;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.TextView;
import defpackage.um$a;
import defpackage.um$b;
import defpackage.um$h;

public class LikeBoxCountView extends FrameLayout {
    private TextView a;
    private LikeBoxCountViewCaretPosition b = LikeBoxCountViewCaretPosition.LEFT;
    private float c;
    private float d;
    private float e;
    private Paint f;
    private int g;
    private int h;

    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] a = new int[LikeBoxCountViewCaretPosition.values().length];

        static {
            try {
                a[LikeBoxCountViewCaretPosition.LEFT.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                a[LikeBoxCountViewCaretPosition.TOP.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                a[LikeBoxCountViewCaretPosition.RIGHT.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                a[LikeBoxCountViewCaretPosition.BOTTOM.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
        }
    }

    public enum LikeBoxCountViewCaretPosition {
        LEFT,
        TOP,
        RIGHT,
        BOTTOM
    }

    public LikeBoxCountView(Context context) {
        super(context);
        a(context);
    }

    public void setText(String text) {
        this.a.setText(text);
    }

    public void setCaretPosition(LikeBoxCountViewCaretPosition caretPosition) {
        this.b = caretPosition;
        switch (AnonymousClass1.a[caretPosition.ordinal()]) {
            case um$h.com_facebook_profile_picture_view_com_facebook_is_cropped /*1*/:
                a(this.h, 0, 0, 0);
                return;
            case um$h.com_facebook_login_view_com_facebook_logout_text /*2*/:
                a(0, this.h, 0, 0);
                return;
            case um$h.com_facebook_login_view_com_facebook_tooltip_mode /*3*/:
                a(0, 0, this.h, 0);
                return;
            case um$h.com_facebook_like_view_com_facebook_auxiliary_view_position /*4*/:
                a(0, 0, 0, this.h);
                return;
            default:
                return;
        }
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int top = getPaddingTop();
        int left = getPaddingLeft();
        int right = getWidth() - getPaddingRight();
        int bottom = getHeight() - getPaddingBottom();
        switch (AnonymousClass1.a[this.b.ordinal()]) {
            case um$h.com_facebook_profile_picture_view_com_facebook_is_cropped /*1*/:
                left = (int) (((float) left) + this.c);
                break;
            case um$h.com_facebook_login_view_com_facebook_logout_text /*2*/:
                top = (int) (((float) top) + this.c);
                break;
            case um$h.com_facebook_login_view_com_facebook_tooltip_mode /*3*/:
                right = (int) (((float) right) - this.c);
                break;
            case um$h.com_facebook_like_view_com_facebook_auxiliary_view_position /*4*/:
                bottom = (int) (((float) bottom) - this.c);
                break;
        }
        a(canvas, (float) left, (float) top, (float) right, (float) bottom);
    }

    private void a(Context context) {
        setWillNotDraw(false);
        this.c = getResources().getDimension(um$b.com_facebook_likeboxcountview_caret_height);
        this.d = getResources().getDimension(um$b.com_facebook_likeboxcountview_caret_width);
        this.e = getResources().getDimension(um$b.com_facebook_likeboxcountview_border_radius);
        this.f = new Paint();
        this.f.setColor(getResources().getColor(um$a.com_facebook_likeboxcountview_border_color));
        this.f.setStrokeWidth(getResources().getDimension(um$b.com_facebook_likeboxcountview_border_width));
        this.f.setStyle(Style.STROKE);
        b(context);
        addView(this.a);
        setCaretPosition(this.b);
    }

    private void b(Context context) {
        this.a = new TextView(context);
        this.a.setLayoutParams(new LayoutParams(-1, -1));
        this.a.setGravity(17);
        this.a.setTextSize(0, getResources().getDimension(um$b.com_facebook_likeboxcountview_text_size));
        this.a.setTextColor(getResources().getColor(um$a.com_facebook_likeboxcountview_text_color));
        this.g = getResources().getDimensionPixelSize(um$b.com_facebook_likeboxcountview_text_padding);
        this.h = getResources().getDimensionPixelSize(um$b.com_facebook_likeboxcountview_caret_height);
    }

    private void a(int left, int top, int right, int bottom) {
        this.a.setPadding(this.g + left, this.g + top, this.g + right, this.g + bottom);
    }

    private void a(Canvas canvas, float left, float top, float right, float bottom) {
        Path borderPath = new Path();
        float ovalSize = 2.0f * this.e;
        borderPath.addArc(new RectF(left, top, left + ovalSize, top + ovalSize), -180.0f, 90.0f);
        if (this.b == LikeBoxCountViewCaretPosition.TOP) {
            borderPath.lineTo((((right - left) - this.d) / 2.0f) + left, top);
            borderPath.lineTo(((right - left) / 2.0f) + left, top - this.c);
            borderPath.lineTo((((right - left) + this.d) / 2.0f) + left, top);
        }
        borderPath.lineTo(right - this.e, top);
        borderPath.addArc(new RectF(right - ovalSize, top, right, top + ovalSize), -90.0f, 90.0f);
        if (this.b == LikeBoxCountViewCaretPosition.RIGHT) {
            borderPath.lineTo(right, (((bottom - top) - this.d) / 2.0f) + top);
            borderPath.lineTo(this.c + right, ((bottom - top) / 2.0f) + top);
            borderPath.lineTo(right, (((bottom - top) + this.d) / 2.0f) + top);
        }
        borderPath.lineTo(right, bottom - this.e);
        borderPath.addArc(new RectF(right - ovalSize, bottom - ovalSize, right, bottom), 0.0f, 90.0f);
        if (this.b == LikeBoxCountViewCaretPosition.BOTTOM) {
            borderPath.lineTo((((right - left) + this.d) / 2.0f) + left, bottom);
            borderPath.lineTo(((right - left) / 2.0f) + left, this.c + bottom);
            borderPath.lineTo((((right - left) - this.d) / 2.0f) + left, bottom);
        }
        borderPath.lineTo(this.e + left, bottom);
        borderPath.addArc(new RectF(left, bottom - ovalSize, left + ovalSize, bottom), 90.0f, 90.0f);
        if (this.b == LikeBoxCountViewCaretPosition.LEFT) {
            borderPath.lineTo(left, (((bottom - top) + this.d) / 2.0f) + top);
            borderPath.lineTo(left - this.c, ((bottom - top) / 2.0f) + top);
            borderPath.lineTo(left, (((bottom - top) - this.d) / 2.0f) + top);
        }
        borderPath.lineTo(left, this.e + top);
        canvas.drawPath(borderPath, this.f);
    }
}
