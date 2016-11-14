package com.becandid.thirdparty.nocropper;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.GestureDetector;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.ScaleGestureDetector.SimpleOnScaleGestureListener;
import android.view.View.MeasureSpec;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import defpackage.ha$a;
import defpackage.ji;
import defpackage.um$h;

public class CropperImageView extends ImageView {
    protected GestureDetector a;
    protected ScaleGestureDetector b;
    public boolean c;
    private float[] d;
    private b e;
    private c f;
    private float g;
    private float h;
    private float i;
    private float j;
    private float k;
    private boolean l;
    private boolean m;
    private Bitmap n;
    private boolean o;
    private float p;
    private boolean q;
    private a r;
    private boolean s;
    private boolean t;
    private int u;

    public interface a {
        void a();

        void b();
    }

    class b extends SimpleOnGestureListener {
        final /* synthetic */ CropperImageView a;

        private b(CropperImageView cropperImageView) {
            this.a = cropperImageView;
        }

        public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
            if (e1 != null && e2 != null && e1.getPointerCount() <= 1 && e2.getPointerCount() <= 1) {
                this.a.a(e1, e2, distanceX, distanceY);
            }
            return false;
        }
    }

    class c extends SimpleOnScaleGestureListener {
        protected boolean a;
        final /* synthetic */ CropperImageView b;

        private c(CropperImageView cropperImageView) {
            this.b = cropperImageView;
            this.a = false;
        }

        public boolean onScale(ScaleGestureDetector detector) {
            Matrix matrix = this.b.getImageMatrix();
            this.b.j = detector.getFocusX();
            this.b.k = detector.getFocusY();
            matrix.postScale(detector.getScaleFactor(), detector.getScaleFactor(), detector.getFocusX(), detector.getFocusY());
            this.b.setImageMatrix(matrix);
            this.b.invalidate();
            return true;
        }
    }

    public CropperImageView(Context context) {
        super(context);
        this.d = new float[9];
        this.l = false;
        this.m = true;
        this.o = false;
        this.q = false;
        this.s = true;
        this.t = false;
        this.u = Color.rgb(246, 246, 246);
        this.c = false;
        a(context, null);
    }

    public CropperImageView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.d = new float[9];
        this.l = false;
        this.m = true;
        this.o = false;
        this.q = false;
        this.s = true;
        this.t = false;
        this.u = Color.rgb(246, 246, 246);
        this.c = false;
        a(context, attrs);
    }

    public CropperImageView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.d = new float[9];
        this.l = false;
        this.m = true;
        this.o = false;
        this.q = false;
        this.s = true;
        this.t = false;
        this.u = Color.rgb(246, 246, 246);
        this.c = false;
        a(context, attrs);
    }

    public void setDEBUG(boolean DEBUG) {
        this.c = DEBUG;
    }

    private void a(Context context, AttributeSet attrs) {
        if (attrs != null) {
            TypedArray mTypedArray = context.obtainStyledAttributes(attrs, ha$a.CropperView);
            this.u = mTypedArray.getColor(3, this.u);
            this.q = mTypedArray.getBoolean(4, false);
        }
        this.e = new b();
        this.a = new GestureDetector(context, this.e, null, true);
        this.f = new c();
        this.b = new ScaleGestureDetector(context, this.f);
        setScaleType(ScaleType.MATRIX);
    }

    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int orientation = getContext().getResources().getConfiguration().orientation;
        if (orientation == 1 || orientation == 0) {
            setMeasuredDimension(widthMeasureSpec, MeasureSpec.makeMeasureSpec((int) ((((double) MeasureSpec.getSize(widthMeasureSpec)) * CropperView.a) + 0.5d), 1073741824));
            return;
        }
        int height = MeasureSpec.getSize(heightMeasureSpec);
        setMeasuredDimension(MeasureSpec.makeMeasureSpec(height, 1073741824), height);
    }

    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
        if (this.c) {
            Log.i("CropperImageView", "onLayout: " + changed + " [" + left + ", " + top + ", " + right + ", " + bottom + "]");
        }
        if ((changed || this.m) && this.m) {
            Drawable drawable = getDrawable();
            if (drawable != null) {
                this.g = ((float) (bottom - top)) / ((float) Math.max(drawable.getIntrinsicHeight(), drawable.getIntrinsicWidth()));
                this.i = ((float) (bottom - top)) / ((float) Math.min(drawable.getIntrinsicHeight(), drawable.getIntrinsicWidth()));
                a(drawable, bottom - top);
                this.m = false;
            } else if (this.c) {
                Log.e("CropperImageView", "drawable is null");
            }
        }
    }

    public boolean onTouchEvent(MotionEvent event) {
        if (this.t) {
            return true;
        }
        if (event.getActionMasked() == 0 && this.r != null) {
            this.r.a();
        }
        this.b.onTouchEvent(event);
        if (!this.b.isInProgress()) {
            this.a.onTouchEvent(event);
        }
        switch (event.getAction()) {
            case um$h.com_facebook_profile_picture_view_com_facebook_is_cropped /*1*/:
                if (this.r != null) {
                    this.r.b();
                }
                return a(event);
            default:
                return true;
        }
    }

    public void setImageBitmap(Bitmap bm) {
        this.m = true;
        if (bm == null) {
            this.n = null;
            super.setImageBitmap(null);
            return;
        }
        if (bm.getHeight() > 1280 || bm.getWidth() > 1280) {
            Log.w("CropperImageView", "Bitmap size greater than 1280. This might cause memory issues");
        }
        this.n = bm;
        if (this.o) {
            this.p = ((float) Math.max(bm.getWidth(), bm.getHeight())) / ((float) getWidth());
            super.setImageBitmap(Bitmap.createScaledBitmap(bm, (int) (((float) bm.getWidth()) / this.p), (int) (((float) bm.getHeight()) / this.p), false));
        } else {
            this.p = 1.0f;
            super.setImageBitmap(bm);
        }
        requestLayout();
    }

    private void a(Drawable drawable, int frameDimen) {
        if (drawable == null) {
            if (this.c) {
                Log.e("CropperImageView", "Drawable is null. I can't fit anything");
            }
        } else if (frameDimen != 0) {
            int width = drawable.getIntrinsicWidth();
            int height = drawable.getIntrinsicHeight();
            if (this.c) {
                Log.i("CropperImageView", "drawable size: (" + width + " ," + height + ")");
            }
            float scaleFactor = ((float) Math.min(width, height)) / ((float) frameDimen);
            Matrix matrix = new Matrix();
            matrix.setScale(1.0f / scaleFactor, 1.0f / scaleFactor);
            matrix.postTranslate((((float) frameDimen) - (((float) width) / scaleFactor)) / 2.0f, (((float) frameDimen) - (((float) height) / scaleFactor)) / 2.0f);
            setImageMatrix(matrix);
        } else if (this.c) {
            Log.e("CropperImageView", "Frame Dimension is 0. I'm quite boggled by it.");
        }
    }

    public boolean a(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
        Matrix matrix = getImageMatrix();
        matrix.postTranslate(-distanceX, -distanceY);
        setImageMatrix(matrix);
        invalidate();
        return true;
    }

    private boolean a(MotionEvent event) {
        Drawable drawable = getDrawable();
        if (drawable == null) {
            return false;
        }
        Matrix matrix = getImageMatrix();
        float tx = a(matrix, 2);
        float ty = a(matrix, 5);
        float scaleX = a(matrix, 0);
        float scaleY = a(matrix, 4);
        if (this.c) {
            Log.i("CropperImageView", "onUp: " + tx + " " + ty);
            Log.i("CropperImageView", "scale: " + scaleX);
            Log.i("CropperImageView", "min, max, base zoom: " + this.g + ", " + this.h + ", " + this.i);
            Log.i("CropperImageView", "imageview size: " + getWidth() + " " + getHeight());
            Log.i("CropperImageView", "drawable size: " + drawable.getIntrinsicWidth() + " " + drawable.getIntrinsicHeight());
            Log.i("CropperImageView", "scaled drawable size: " + (((float) drawable.getIntrinsicWidth()) * scaleX) + " " + (((float) drawable.getIntrinsicHeight()) * scaleY));
        }
        if (scaleX <= this.g) {
            if (this.c) {
                Log.i("CropperImageView", "set scale: " + this.g);
            }
            float xx = ((float) (getWidth() / 2)) - ((this.g * ((float) drawable.getIntrinsicWidth())) / 2.0f);
            float yy = ((float) (getHeight() / 2)) - ((this.g * ((float) drawable.getIntrinsicHeight())) / 2.0f);
            if (a()) {
                a(tx, xx, ty, yy, scaleX, this.g);
            } else {
                matrix.reset();
                matrix.setScale(this.g, this.g);
                matrix.postTranslate(xx, yy);
                setImageMatrix(matrix);
                invalidate();
                if (this.c) {
                    Log.i("CropperImageView", "scale after invalidate: " + a(matrix));
                }
            }
            return true;
        } else if (scaleX < this.i) {
            float yTranslate;
            float xTranslate;
            int h = drawable.getIntrinsicHeight();
            int w = drawable.getIntrinsicWidth();
            if (h <= w) {
                yTranslate = ((float) (getHeight() / 2)) - ((((float) h) * scaleX) / 2.0f);
                if (tx >= 0.0f) {
                    xTranslate = 0.0f;
                } else {
                    float xDiff = ((float) getWidth()) - (((float) drawable.getIntrinsicWidth()) * scaleX);
                    xTranslate = tx < xDiff ? xDiff : tx;
                }
            } else {
                xTranslate = ((float) (getWidth() / 2)) - ((((float) w) * scaleX) / 2.0f);
                if (ty >= 0.0f) {
                    yTranslate = 0.0f;
                } else {
                    float yDiff = ((float) getHeight()) - (((float) drawable.getIntrinsicHeight()) * scaleY);
                    yTranslate = ty < yDiff ? yDiff : ty;
                }
            }
            if (a()) {
                matrix.reset();
                matrix.postScale(scaleX, scaleX);
                matrix.postTranslate(tx, ty);
                setImageMatrix(matrix);
                a(xTranslate - tx, yTranslate - ty);
            } else {
                matrix.reset();
                matrix.postScale(scaleX, scaleX);
                matrix.postTranslate(xTranslate, yTranslate);
                setImageMatrix(matrix);
                invalidate();
            }
            return true;
        } else if (!this.l || scaleX <= this.h) {
            if (this.c) {
                Log.i("CropperImageView", "adjust to sides");
            }
            b();
            return true;
        } else {
            if (this.c) {
                Log.i("CropperImageView", "set to max zoom");
                Log.i("CropperImageView", "isMaxZoomSet: " + this.l);
            }
            if (a()) {
                c();
            } else {
                matrix.postScale(this.h / scaleX, this.h / scaleX, this.j, this.k);
                setImageMatrix(matrix);
                invalidate();
                b();
            }
            return true;
        }
    }

    private boolean b() {
        boolean changeRequired = false;
        Drawable drawable = getDrawable();
        if (drawable == null) {
            return 0;
        }
        Matrix matrix = getImageMatrix();
        float sx = a(matrix, 2);
        float sy = a(matrix, 5);
        float tx = a(matrix, 2);
        float ty = a(matrix, 5);
        float scaleX = a(matrix, 0);
        float scaleY = a(matrix, 4);
        if (tx > 0.0f) {
            tx = -tx;
            changeRequired = true;
        } else {
            float xDiff = ((float) getWidth()) - (((float) drawable.getIntrinsicWidth()) * scaleX);
            if (tx < xDiff) {
                tx = xDiff - tx;
                changeRequired = true;
            } else {
                tx = 0.0f;
            }
        }
        if (ty > 0.0f) {
            ty = -ty;
            changeRequired = true;
        } else {
            float yDiff = ((float) getHeight()) - (((float) drawable.getIntrinsicHeight()) * scaleY);
            if (ty < yDiff) {
                ty = yDiff - ty;
                changeRequired = true;
            } else {
                ty = 0.0f;
            }
        }
        if (changeRequired) {
            if (a()) {
                a(tx, ty);
            } else {
                matrix.postTranslate(tx, ty);
                setImageMatrix(matrix);
                invalidate();
            }
        }
        return changeRequired;
    }

    private float a(Matrix matrix, int whichValue) {
        matrix.getValues(this.d);
        return this.d[whichValue];
    }

    private float a(Matrix matrix) {
        return a(matrix, 0);
    }

    public void setDoPreScaling(boolean doPreScaling) {
        this.o = doPreScaling;
    }

    public float getMaxZoom() {
        return this.h;
    }

    public void setMaxZoom(float mMaxZoom) {
        if (mMaxZoom <= 0.0f) {
            Log.e("CropperImageView", "Max zoom must be greater than 0");
            return;
        }
        this.h = mMaxZoom;
        this.l = true;
    }

    public float getMinZoom() {
        return this.g;
    }

    public void setMinZoom(float mMInZoom) {
        if (mMInZoom <= 0.0f) {
            Log.e("CropperImageView", "Min zoom must be greater than 0");
        } else {
            this.g = mMInZoom;
        }
    }

    public Bitmap getCroppedBitmap() {
        if (this.n == null) {
            Log.e("CropperImageView", "original image is not available");
            return null;
        }
        Matrix matrix = getImageMatrix();
        if (this.o) {
            matrix.postScale(1.0f / this.p, 1.0f / this.p);
        }
        float xTrans = a(matrix, 2);
        float yTrans = a(matrix, 5);
        float scale = a(matrix, 0);
        if (this.c) {
            Log.i("CropperImageView", "xTrans: " + xTrans + ", yTrans: " + yTrans + " , scale: " + scale);
        }
        if (this.c) {
            Log.i("CropperImageView", "old bitmap: " + this.n.getWidth() + " " + this.n.getHeight());
        }
        if (xTrans <= 0.0f || yTrans <= 0.0f || scale > this.g) {
            float cropY = (-yTrans) / scale;
            float Y = ((float) getHeight()) / scale;
            float cropX = (-xTrans) / scale;
            float X = ((float) getWidth()) / scale;
            if (this.c) {
                Log.i("CropperImageView", "cropY: " + cropY);
                Log.i("CropperImageView", "Y: " + Y);
                Log.i("CropperImageView", "cropX: " + cropX);
                Log.i("CropperImageView", "X: " + X);
            }
            if (cropY + Y > ((float) this.n.getHeight())) {
                cropY = ((float) this.n.getHeight()) - Y;
                if (this.c) {
                    Log.i("CropperImageView", "readjust cropY to: " + cropY);
                }
            } else if (cropY < 0.0f) {
                cropY = 0.0f;
                if (this.c) {
                    Log.i("CropperImageView", "readjust cropY to: " + 0.0f);
                }
            }
            if (cropX + X > ((float) this.n.getWidth())) {
                cropX = ((float) this.n.getWidth()) - X;
                if (this.c) {
                    Log.i("CropperImageView", "readjust cropX to: " + cropX);
                }
            } else if (cropX < 0.0f) {
                cropX = 0.0f;
                if (this.c) {
                    Log.i("CropperImageView", "readjust cropX to: " + 0.0f);
                }
            }
            Bitmap bitmap;
            if (this.n.getHeight() <= this.n.getWidth()) {
                if (yTrans >= 0.0f) {
                    bitmap = Bitmap.createBitmap(this.n, (int) cropX, 0, (int) X, this.n.getHeight(), null, true);
                    if (this.q) {
                        bitmap = ji.a(bitmap, this.u);
                    }
                } else {
                    bitmap = Bitmap.createBitmap(this.n, (int) cropX, (int) cropY, (int) X, (int) Y, null, true);
                }
                if (!this.c) {
                    return bitmap;
                }
                Log.i("CropperImageView", "width should be: " + this.n.getWidth());
                Log.i("CropperImageView", "crop bitmap: " + bitmap.getWidth() + " " + bitmap.getHeight());
                return bitmap;
            } else if (xTrans < 0.0f) {
                return Bitmap.createBitmap(this.n, (int) cropX, (int) cropY, (int) X, (int) Y, null, true);
            } else {
                bitmap = Bitmap.createBitmap(this.n, 0, (int) cropY, this.n.getWidth(), (int) Y, null, true);
                if (this.q) {
                    return ji.a(bitmap, this.u);
                }
                return bitmap;
            }
        } else if (this.q) {
            return ji.a(this.n, this.u);
        } else {
            return this.n;
        }
    }

    public boolean a() {
        return this.s;
    }

    public void setShowAnimation(boolean showAnimation) {
        this.s = showAnimation;
    }

    public int getPaddingColor() {
        return this.u;
    }

    public void setPaddingColor(int mPaintColor) {
        this.u = mPaintColor;
    }

    public void setMakeSquare(boolean mAddPaddingToMakeSquare) {
        this.q = mAddPaddingToMakeSquare;
    }

    public void setGestureCallback(a mGestureCallback) {
        this.r = mGestureCallback;
    }

    private void a(float xStart, float xEnd, float yStart, float yEnd, float scaleStart, float scaleEnd) {
        ValueAnimator animator = ValueAnimator.ofInt(new int[]{0, 20});
        final float f = scaleEnd;
        final float f2 = scaleStart;
        final float f3 = xEnd;
        final float f4 = xStart;
        final float f5 = yEnd;
        final float f6 = yStart;
        animator.addUpdateListener(new AnimatorUpdateListener(this) {
            final /* synthetic */ CropperImageView g;

            public void onAnimationUpdate(ValueAnimator animation) {
                Matrix matrix = this.g.getImageMatrix();
                matrix.reset();
                Integer value = (Integer) animation.getAnimatedValue();
                matrix.postScale((((f - f2) * ((float) value.intValue())) / 20.0f) + f2, (((f - f2) * ((float) value.intValue())) / 20.0f) + f2);
                matrix.postTranslate((((f3 - f4) * ((float) value.intValue())) / 20.0f) + f4, (((f5 - f6) * ((float) value.intValue())) / 20.0f) + f6);
                this.g.setImageMatrix(matrix);
                this.g.invalidate();
            }
        });
        animator.addListener(new AnimatorListener(this) {
            final /* synthetic */ CropperImageView a;

            {
                this.a = this$0;
            }

            public void onAnimationStart(Animator animation) {
                this.a.t = true;
            }

            public void onAnimationEnd(Animator animation) {
                this.a.t = false;
            }

            public void onAnimationCancel(Animator animation) {
                this.a.t = false;
            }

            public void onAnimationRepeat(Animator animation) {
                this.a.t = true;
            }
        });
        animator.start();
    }

    private void a(final float xDiff, final float yDiff) {
        ValueAnimator animator = ValueAnimator.ofInt(new int[]{0, 20});
        animator.addUpdateListener(new AnimatorUpdateListener(this) {
            final /* synthetic */ CropperImageView c;

            public void onAnimationUpdate(ValueAnimator animation) {
                Matrix matrix = this.c.getImageMatrix();
                matrix.postTranslate(xDiff / 20.0f, yDiff / 20.0f);
                this.c.setImageMatrix(matrix);
                this.c.invalidate();
            }
        });
        animator.addListener(new AnimatorListener(this) {
            final /* synthetic */ CropperImageView a;

            {
                this.a = this$0;
            }

            public void onAnimationStart(Animator animation) {
                this.a.t = true;
            }

            public void onAnimationEnd(Animator animation) {
                this.a.t = false;
            }

            public void onAnimationCancel(Animator animation) {
                this.a.t = false;
            }

            public void onAnimationRepeat(Animator animation) {
                this.a.t = true;
            }
        });
        animator.start();
    }

    private void c() {
        final float scale = a(getImageMatrix());
        ValueAnimator animator = ValueAnimator.ofInt(new int[]{0, 20});
        animator.addUpdateListener(new AnimatorUpdateListener(this) {
            final /* synthetic */ CropperImageView b;

            public void onAnimationUpdate(ValueAnimator animation) {
                Matrix matrix = this.b.getImageMatrix();
                if (this.b.a(matrix) > this.b.h) {
                    double expScale = Math.pow((double) (this.b.h / scale), 0.05000000074505806d);
                    matrix.postScale((float) expScale, (float) expScale, this.b.j, this.b.k);
                    this.b.setImageMatrix(matrix);
                    this.b.invalidate();
                }
            }
        });
        animator.addListener(new AnimatorListener(this) {
            final /* synthetic */ CropperImageView a;

            {
                this.a = this$0;
            }

            public void onAnimationStart(Animator animation) {
                this.a.t = true;
            }

            public void onAnimationEnd(Animator animation) {
                this.a.t = false;
                this.a.b();
            }

            public void onAnimationCancel(Animator animation) {
                this.a.t = false;
            }

            public void onAnimationRepeat(Animator animation) {
                this.a.t = true;
            }
        });
        animator.start();
    }
}
