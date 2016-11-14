package com.becandid.thirdparty.nocropper;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.view.View.MeasureSpec;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;

public class CropperView extends FrameLayout {
    public static double a = 1.1d;
    private CropperImageView b;
    private CropperGridView c;

    class a implements com.becandid.thirdparty.nocropper.CropperImageView.a {
        final /* synthetic */ CropperView a;

        private a(CropperView cropperView) {
            this.a = cropperView;
        }

        public void a() {
            this.a.c.setShowGrid(true);
        }

        public void b() {
            this.a.c.setShowGrid(false);
        }
    }

    public CropperView(Context context) {
        super(context);
        a(context, null);
    }

    public CropperView(Context context, AttributeSet attrs) {
        super(context, attrs);
        a(context, attrs);
    }

    public CropperView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        a(context, attrs);
    }

    @TargetApi(21)
    public CropperView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        a(context, attrs);
    }

    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int orientation = getContext().getResources().getConfiguration().orientation;
        if (orientation == 1 || orientation == 0) {
            int width = MeasureSpec.getSize(widthMeasureSpec);
            setMeasuredDimension(width, MeasureSpec.makeMeasureSpec((int) ((((double) width) * a) + 0.5d), 1073741824));
            return;
        }
        int height = MeasureSpec.getSize(heightMeasureSpec);
        setMeasuredDimension(MeasureSpec.makeMeasureSpec(height, 1073741824), height);
    }

    private void a(Context context, AttributeSet attrs) {
        this.b = new CropperImageView(context, attrs);
        this.c = new CropperGridView(context, attrs);
        LayoutParams params = new LayoutParams(-1, 0);
        if (context.getResources().getConfiguration().orientation == 2) {
            params.width = 0;
            params.height = -1;
        }
        addView(this.b, 0, params);
        addView(this.c, 1, params);
        this.b.setGestureCallback(new a());
    }

    public void setImageBitmap(Bitmap bm) {
        this.b.setImageBitmap(bm);
    }

    public void setMaxZoom(float zoom) {
        this.b.setMaxZoom(zoom);
    }

    public Bitmap getCroppedBitmap() {
        return this.b.getCroppedBitmap();
    }

    public void setPreScaling(boolean doPreScaling) {
        this.b.setDoPreScaling(doPreScaling);
    }

    public float getMaxZoom() {
        return this.b.getMaxZoom();
    }

    public float getMinZoom() {
        return this.b.getMinZoom();
    }

    public void setMinZoom(float mMInZoom) {
        this.b.setMinZoom(mMInZoom);
    }

    public void setDebug(boolean status) {
        this.b.setDEBUG(status);
    }

    public int getPaddingColor() {
        return this.b.getPaddingColor();
    }

    public void setPaddingColor(int paddingColor) {
        this.b.setPaddingColor(paddingColor);
    }

    public int getCropperWidth() {
        return this.b != null ? this.b.getWidth() : 0;
    }

    public void setMakeSquare(boolean mAddPaddingToMakeSquare) {
        this.b.setMakeSquare(mAddPaddingToMakeSquare);
    }
}
