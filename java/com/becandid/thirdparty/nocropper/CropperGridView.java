package com.becandid.thirdparty.nocropper;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import defpackage.ha$a;

public class CropperGridView extends View {
    private long a = 1500;
    private Paint b;
    private int c = 268435455;
    private int d = 200;
    private int e = 3;
    private boolean f = false;
    private Handler g;
    private Path h;
    private Runnable i = new Runnable(this) {
        final /* synthetic */ CropperGridView a;

        {
            this.a = this$0;
        }

        public void run() {
            this.a.f = false;
            this.a.invalidate();
        }
    };

    public CropperGridView(Context context) {
        super(context);
        a(context, null);
    }

    public CropperGridView(Context context, AttributeSet attrs) {
        super(context);
        a(context, attrs);
    }

    public CropperGridView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context);
        a(context, attrs);
    }

    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int orientation = getContext().getResources().getConfiguration().orientation;
        if (orientation == 1 || orientation == 0) {
            int width = MeasureSpec.getSize(widthMeasureSpec);
            setMeasuredDimension(width, MeasureSpec.makeMeasureSpec((int) ((((double) width) * CropperView.a) + 0.5d), 1073741824));
            return;
        }
        int height = MeasureSpec.getSize(heightMeasureSpec);
        setMeasuredDimension(MeasureSpec.makeMeasureSpec(height, 1073741824), height);
    }

    private void a(Context context, AttributeSet attrs) {
        if (attrs != null) {
            TypedArray mTypedArray = context.obtainStyledAttributes(attrs, ha$a.CropperView);
            this.c = mTypedArray.getColor(0, this.c);
            float alpha = 255.0f * mTypedArray.getFloat(2, 1.0f);
            if (alpha < 0.0f) {
                alpha = 0.0f;
            } else if (alpha > 255.0f) {
                alpha = 255.0f;
            }
            this.d = (int) alpha;
            this.e = mTypedArray.getDimensionPixelOffset(1, this.e);
            mTypedArray.recycle();
        }
        this.b = new Paint();
        this.b.setColor(this.c);
        this.b.setAntiAlias(true);
        this.b.setStyle(Style.STROKE);
        this.b.setStrokeCap(Cap.ROUND);
        this.b.setStrokeWidth((float) this.e);
        this.b.setAlpha(this.d);
        this.h = new Path();
        this.g = new Handler();
        if (isInEditMode()) {
            this.f = true;
        }
    }

    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.f) {
            int width = canvas.getWidth();
            int height = canvas.getHeight();
            this.h.reset();
            this.h.moveTo((float) (width / 3), 0.0f);
            this.h.lineTo((float) (width / 3), (float) height);
            this.h.moveTo((float) ((width * 2) / 3), 0.0f);
            this.h.lineTo((float) ((width * 2) / 3), (float) height);
            this.h.moveTo(0.0f, (float) (height / 3));
            this.h.lineTo((float) width, (float) (height / 3));
            this.h.moveTo(0.0f, (float) ((height * 2) / 3));
            this.h.lineTo((float) width, (float) ((height * 2) / 3));
            canvas.drawPath(this.h, this.b);
        }
    }

    public void setShowGrid(boolean showGrid) {
        if (this.f != showGrid) {
            this.f = showGrid;
            if (this.f) {
                this.g.removeCallbacks(this.i);
                invalidate();
                return;
            }
            this.g.postDelayed(this.i, this.a);
        }
    }
}
