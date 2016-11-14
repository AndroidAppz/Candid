package uk.co.senab.photoview;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.util.AttributeSet;
import android.view.GestureDetector.OnDoubleTapListener;
import android.view.View.OnLongClickListener;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import defpackage.ast;
import defpackage.asu;
import defpackage.asu$c;
import defpackage.asu$d;
import defpackage.asu$e;
import defpackage.asu$f;
import defpackage.asu$g;

public class PhotoView extends ImageView implements ast {
    private asu a;
    private ScaleType b;

    public PhotoView(Context context) {
        this(context, null);
    }

    public PhotoView(Context context, AttributeSet attr) {
        this(context, attr, 0);
    }

    public PhotoView(Context context, AttributeSet attr, int defStyle) {
        super(context, attr, defStyle);
        super.setScaleType(ScaleType.MATRIX);
        a();
    }

    protected void a() {
        if (this.a == null || this.a.c() == null) {
            this.a = new asu(this);
        }
        if (this.b != null) {
            setScaleType(this.b);
            this.b = null;
        }
    }

    public void setPhotoViewRotation(float rotationDegree) {
        this.a.a(rotationDegree);
    }

    public void setRotationTo(float rotationDegree) {
        this.a.a(rotationDegree);
    }

    public void setRotationBy(float rotationDegree) {
        this.a.b(rotationDegree);
    }

    public RectF getDisplayRect() {
        return this.a.b();
    }

    public Matrix getDisplayMatrix() {
        return this.a.l();
    }

    @Deprecated
    public float getMinScale() {
        return getMinimumScale();
    }

    public float getMinimumScale() {
        return this.a.d();
    }

    @Deprecated
    public float getMidScale() {
        return getMediumScale();
    }

    public float getMediumScale() {
        return this.a.e();
    }

    @Deprecated
    public float getMaxScale() {
        return getMaximumScale();
    }

    public float getMaximumScale() {
        return this.a.f();
    }

    public float getScale() {
        return this.a.g();
    }

    public ScaleType getScaleType() {
        return this.a.h();
    }

    public void setAllowParentInterceptOnEdge(boolean allow) {
        this.a.a(allow);
    }

    @Deprecated
    public void setMinScale(float minScale) {
        setMinimumScale(minScale);
    }

    public void setMinimumScale(float minimumScale) {
        this.a.c(minimumScale);
    }

    @Deprecated
    public void setMidScale(float midScale) {
        setMediumScale(midScale);
    }

    public void setMediumScale(float mediumScale) {
        this.a.d(mediumScale);
    }

    @Deprecated
    public void setMaxScale(float maxScale) {
        setMaximumScale(maxScale);
    }

    public void setMaximumScale(float maximumScale) {
        this.a.e(maximumScale);
    }

    public void setScaleLevels(float minimumScale, float mediumScale, float maximumScale) {
        this.a.b(minimumScale, mediumScale, maximumScale);
    }

    public void setImageDrawable(Drawable drawable) {
        super.setImageDrawable(drawable);
        if (this.a != null) {
            this.a.k();
        }
    }

    public void setImageResource(int resId) {
        super.setImageResource(resId);
        if (this.a != null) {
            this.a.k();
        }
    }

    public void setImageURI(Uri uri) {
        super.setImageURI(uri);
        if (this.a != null) {
            this.a.k();
        }
    }

    public void setOnMatrixChangeListener(asu$c listener) {
        this.a.a(listener);
    }

    public void setOnLongClickListener(OnLongClickListener l) {
        this.a.a(l);
    }

    public void setOnPhotoTapListener(asu$d listener) {
        this.a.a(listener);
    }

    @Deprecated
    public asu$d getOnPhotoTapListener() {
        return this.a.i();
    }

    public void setOnViewTapListener(asu$g listener) {
        this.a.a(listener);
    }

    @Deprecated
    public asu$g getOnViewTapListener() {
        return this.a.j();
    }

    public void setScale(float scale) {
        this.a.f(scale);
    }

    public void setScale(float scale, boolean animate) {
        this.a.a(scale, animate);
    }

    public void setScale(float scale, float focalX, float focalY, boolean animate) {
        this.a.a(scale, focalX, focalY, animate);
    }

    public void setScaleType(ScaleType scaleType) {
        if (this.a != null) {
            this.a.a(scaleType);
        } else {
            this.b = scaleType;
        }
    }

    public void setZoomable(boolean zoomable) {
        this.a.b(zoomable);
    }

    public Bitmap getVisibleRectangleBitmap() {
        return this.a.n();
    }

    public void setZoomTransitionDuration(int milliseconds) {
        this.a.a(milliseconds);
    }

    public ast getIPhotoViewImplementation() {
        return this.a;
    }

    public void setOnDoubleTapListener(OnDoubleTapListener newOnDoubleTapListener) {
        this.a.a(newOnDoubleTapListener);
    }

    public void setOnScaleChangeListener(asu$e onScaleChangeListener) {
        this.a.a(onScaleChangeListener);
    }

    public void setOnSingleFlingListener(asu$f onSingleFlingListener) {
        this.a.a(onSingleFlingListener);
    }

    protected void onDetachedFromWindow() {
        this.a.a();
        super.onDetachedFromWindow();
    }

    protected void onAttachedToWindow() {
        a();
        super.onAttachedToWindow();
    }
}
