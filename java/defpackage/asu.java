package defpackage;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.Matrix.ScaleToFit;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.GestureDetector;
import android.view.GestureDetector.OnDoubleTapListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnLongClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Interpolator;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import java.lang.ref.WeakReference;

/* compiled from: PhotoViewAttacher */
public class asu implements OnTouchListener, OnGlobalLayoutListener, ast, asz {
    static final Interpolator a = new AccelerateDecelerateInterpolator();
    static int c = 1;
    private static final boolean d = Log.isLoggable("PhotoViewAttacher", 3);
    private int A;
    private asu$b B;
    private int C;
    private float D;
    private boolean E;
    private ScaleType F;
    int b;
    private float e;
    private float f;
    private float g;
    private boolean h;
    private boolean i;
    private WeakReference<ImageView> j;
    private GestureDetector k;
    private asy l;
    private final Matrix m;
    private final Matrix n;
    private final Matrix o;
    private final RectF p;
    private final float[] q;
    private asu$c r;
    private asu$d s;
    private asu$g t;
    private OnLongClickListener u;
    private asu$e v;
    private asu$f w;
    private int x;
    private int y;
    private int z;

    private static void c(float minZoom, float midZoom, float maxZoom) {
        if (minZoom >= midZoom) {
            throw new IllegalArgumentException("MinZoom has to be less than MidZoom");
        } else if (midZoom >= maxZoom) {
            throw new IllegalArgumentException("MidZoom has to be less than MaxZoom");
        }
    }

    private static boolean a(ImageView imageView) {
        return (imageView == null || imageView.getDrawable() == null) ? false : true;
    }

    private static boolean b(ScaleType scaleType) {
        if (scaleType == null) {
            return false;
        }
        switch (asu$2.a[scaleType.ordinal()]) {
            case um$h.com_facebook_profile_picture_view_com_facebook_is_cropped /*1*/:
                throw new IllegalArgumentException(scaleType.name() + " is not supported in PhotoView");
            default:
                return true;
        }
    }

    private static void b(ImageView imageView) {
        if (imageView != null && !(imageView instanceof ast) && !ScaleType.MATRIX.equals(imageView.getScaleType())) {
            imageView.setScaleType(ScaleType.MATRIX);
        }
    }

    public asu(ImageView imageView) {
        this(imageView, true);
    }

    public asu(ImageView imageView, boolean zoomable) {
        this.b = 200;
        this.e = 1.0f;
        this.f = 1.75f;
        this.g = 3.0f;
        this.h = true;
        this.i = false;
        this.m = new Matrix();
        this.n = new Matrix();
        this.o = new Matrix();
        this.p = new RectF();
        this.q = new float[9];
        this.C = 2;
        this.F = ScaleType.FIT_CENTER;
        this.j = new WeakReference(imageView);
        imageView.setDrawingCacheEnabled(true);
        imageView.setOnTouchListener(this);
        ViewTreeObserver observer = imageView.getViewTreeObserver();
        if (observer != null) {
            observer.addOnGlobalLayoutListener(this);
        }
        asu.b(imageView);
        if (!imageView.isInEditMode()) {
            this.l = ata.a(imageView.getContext(), this);
            this.k = new GestureDetector(imageView.getContext(), new asu$1(this));
            this.k.setOnDoubleTapListener(new ass(this));
            this.D = 0.0f;
            b(zoomable);
        }
    }

    public void a(OnDoubleTapListener newOnDoubleTapListener) {
        if (newOnDoubleTapListener != null) {
            this.k.setOnDoubleTapListener(newOnDoubleTapListener);
        } else {
            this.k.setOnDoubleTapListener(new ass(this));
        }
    }

    public void a(asu$e onScaleChangeListener) {
        this.v = onScaleChangeListener;
    }

    public void a(asu$f onSingleFlingListener) {
        this.w = onSingleFlingListener;
    }

    public void a() {
        if (this.j != null) {
            ImageView imageView = (ImageView) this.j.get();
            if (imageView != null) {
                ViewTreeObserver observer = imageView.getViewTreeObserver();
                if (observer != null && observer.isAlive()) {
                    observer.removeGlobalOnLayoutListener(this);
                }
                imageView.setOnTouchListener(null);
                p();
            }
            if (this.k != null) {
                this.k.setOnDoubleTapListener(null);
            }
            this.r = null;
            this.s = null;
            this.t = null;
            this.j = null;
        }
    }

    public RectF b() {
        s();
        return a(m());
    }

    public void a(float degrees) {
        this.o.setRotate(degrees % 360.0f);
        q();
    }

    public void b(float degrees) {
        this.o.postRotate(degrees % 360.0f);
        q();
    }

    public ImageView c() {
        ImageView imageView = null;
        if (this.j != null) {
            imageView = (ImageView) this.j.get();
        }
        if (imageView == null) {
            a();
            atb.a().b("PhotoViewAttacher", "ImageView no longer exists. You should not use this PhotoViewAttacher any more.");
        }
        return imageView;
    }

    public float d() {
        return this.e;
    }

    public float e() {
        return this.f;
    }

    public float f() {
        return this.g;
    }

    public float g() {
        return (float) Math.sqrt((double) (((float) Math.pow((double) a(this.o, 0), 2.0d)) + ((float) Math.pow((double) a(this.o, 3), 2.0d))));
    }

    public ScaleType h() {
        return this.F;
    }

    public void a(float dx, float dy) {
        if (!this.l.a()) {
            if (d) {
                atb.a().a("PhotoViewAttacher", String.format("onDrag: dx: %.2f. dy: %.2f", new Object[]{Float.valueOf(dx), Float.valueOf(dy)}));
            }
            ImageView imageView = c();
            this.o.postTranslate(dx, dy);
            q();
            ViewParent parent = imageView.getParent();
            if (!this.h || this.l.a() || this.i) {
                if (parent != null) {
                    parent.requestDisallowInterceptTouchEvent(true);
                }
            } else if ((this.C == 2 || ((this.C == 0 && dx >= 1.0f) || (this.C == 1 && dx <= -1.0f))) && parent != null) {
                parent.requestDisallowInterceptTouchEvent(false);
            }
        }
    }

    public void a(float startX, float startY, float velocityX, float velocityY) {
        if (d) {
            atb.a().a("PhotoViewAttacher", "onFling. sX: " + startX + " sY: " + startY + " Vx: " + velocityX + " Vy: " + velocityY);
        }
        ImageView imageView = c();
        this.B = new asu$b(this, imageView.getContext());
        this.B.a(c(imageView), d(imageView), (int) velocityX, (int) velocityY);
        imageView.post(this.B);
    }

    public void onGlobalLayout() {
        ImageView imageView = c();
        if (imageView == null) {
            return;
        }
        if (this.E) {
            int top = imageView.getTop();
            int right = imageView.getRight();
            int bottom = imageView.getBottom();
            int left = imageView.getLeft();
            if (top != this.x || bottom != this.z || left != this.A || right != this.y) {
                a(imageView.getDrawable());
                this.x = top;
                this.y = right;
                this.z = bottom;
                this.A = left;
                return;
            }
            return;
        }
        a(imageView.getDrawable());
    }

    public void a(float scaleFactor, float focusX, float focusY) {
        if (d) {
            atb.a().a("PhotoViewAttacher", String.format("onScale: scale: %.2f. fX: %.2f. fY: %.2f", new Object[]{Float.valueOf(scaleFactor), Float.valueOf(focusX), Float.valueOf(focusY)}));
        }
        if (g() >= this.g && scaleFactor >= 1.0f) {
            return;
        }
        if (g() > this.e || scaleFactor > 1.0f) {
            if (this.v != null) {
                this.v.a(scaleFactor, focusX, focusY);
            }
            this.o.postScale(scaleFactor, scaleFactor, focusX, focusY);
            q();
        }
    }

    @SuppressLint({"ClickableViewAccessibility"})
    public boolean onTouch(View v, MotionEvent ev) {
        boolean handled = false;
        if (!this.E || !asu.a((ImageView) v)) {
            return false;
        }
        ViewParent parent = v.getParent();
        switch (ev.getAction()) {
            case zu.GOOGLE_PLAY_SERVICES_VERSION_CODE /*?: ONE_ARG  (wrap: int
  0x0001: INVOKE  (r0_0 int) =  zu.zzqZ():int type: STATIC)*/:
                if (parent != null) {
                    parent.requestDisallowInterceptTouchEvent(true);
                } else {
                    atb.a().b("PhotoViewAttacher", "onTouch getParent() returned null");
                }
                p();
                break;
            case um$h.com_facebook_profile_picture_view_com_facebook_is_cropped /*1*/:
            case um$h.com_facebook_login_view_com_facebook_tooltip_mode /*3*/:
                if (g() < this.e) {
                    RectF rect = b();
                    if (rect != null) {
                        v.post(new asu$a(this, g(), this.e, rect.centerX(), rect.centerY()));
                        handled = true;
                        break;
                    }
                }
                break;
        }
        if (this.l != null) {
            boolean wasScaling = this.l.a();
            boolean wasDragging = this.l.b();
            handled = this.l.c(ev);
            boolean didntScale = (wasScaling || this.l.a()) ? false : true;
            boolean didntDrag = (wasDragging || this.l.b()) ? false : true;
            boolean z = didntScale && didntDrag;
            this.i = z;
        }
        if (this.k == null || !this.k.onTouchEvent(ev)) {
            return handled;
        }
        return true;
    }

    public void a(boolean allow) {
        this.h = allow;
    }

    public void c(float minimumScale) {
        asu.c(minimumScale, this.f, this.g);
        this.e = minimumScale;
    }

    public void d(float mediumScale) {
        asu.c(this.e, mediumScale, this.g);
        this.f = mediumScale;
    }

    public void e(float maximumScale) {
        asu.c(this.e, this.f, maximumScale);
        this.g = maximumScale;
    }

    public void b(float minimumScale, float mediumScale, float maximumScale) {
        asu.c(minimumScale, mediumScale, maximumScale);
        this.e = minimumScale;
        this.f = mediumScale;
        this.g = maximumScale;
    }

    public void a(OnLongClickListener listener) {
        this.u = listener;
    }

    public void a(asu$c listener) {
        this.r = listener;
    }

    public void a(asu$d listener) {
        this.s = listener;
    }

    @Deprecated
    public asu$d i() {
        return this.s;
    }

    public void a(asu$g listener) {
        this.t = listener;
    }

    @Deprecated
    public asu$g j() {
        return this.t;
    }

    public void f(float scale) {
        a(scale, false);
    }

    public void a(float scale, boolean animate) {
        ImageView imageView = c();
        if (imageView != null) {
            a(scale, (float) (imageView.getRight() / 2), (float) (imageView.getBottom() / 2), animate);
        }
    }

    public void a(float scale, float focalX, float focalY, boolean animate) {
        ImageView imageView = c();
        if (imageView == null) {
            return;
        }
        if (scale < this.e || scale > this.g) {
            atb.a().b("PhotoViewAttacher", "Scale must be within the range of minScale and maxScale");
        } else if (animate) {
            imageView.post(new asu$a(this, g(), scale, focalX, focalY));
        } else {
            this.o.setScale(scale, scale, focalX, focalY);
            q();
        }
    }

    public void a(ScaleType scaleType) {
        if (asu.b(scaleType) && scaleType != this.F) {
            this.F = scaleType;
            k();
        }
    }

    public void b(boolean zoomable) {
        this.E = zoomable;
        k();
    }

    public void k() {
        ImageView imageView = c();
        if (imageView == null) {
            return;
        }
        if (this.E) {
            asu.b(imageView);
            a(imageView.getDrawable());
            return;
        }
        t();
    }

    public Matrix l() {
        return new Matrix(m());
    }

    public Matrix m() {
        this.n.set(this.m);
        this.n.postConcat(this.o);
        return this.n;
    }

    private void p() {
        if (this.B != null) {
            this.B.a();
            this.B = null;
        }
    }

    private void q() {
        if (s()) {
            b(m());
        }
    }

    private void r() {
        ImageView imageView = c();
        if (imageView != null && !(imageView instanceof ast) && !ScaleType.MATRIX.equals(imageView.getScaleType())) {
            throw new IllegalStateException("The ImageView's ScaleType has been changed since attaching a PhotoViewAttacher");
        }
    }

    private boolean s() {
        ImageView imageView = c();
        if (imageView == null) {
            return false;
        }
        RectF rect = a(m());
        if (rect == null) {
            return false;
        }
        float height = rect.height();
        float width = rect.width();
        float deltaX = 0.0f;
        float deltaY = 0.0f;
        int viewHeight = d(imageView);
        if (height <= ((float) viewHeight)) {
            switch (asu$2.a[this.F.ordinal()]) {
                case um$h.com_facebook_login_view_com_facebook_logout_text /*2*/:
                    deltaY = -rect.top;
                    break;
                case um$h.com_facebook_login_view_com_facebook_tooltip_mode /*3*/:
                    deltaY = (((float) viewHeight) - height) - rect.top;
                    break;
                default:
                    deltaY = ((((float) viewHeight) - height) / 2.0f) - rect.top;
                    break;
            }
        } else if (rect.top > 0.0f) {
            deltaY = -rect.top;
        } else if (rect.bottom < ((float) viewHeight)) {
            deltaY = ((float) viewHeight) - rect.bottom;
        }
        int viewWidth = c(imageView);
        if (width <= ((float) viewWidth)) {
            switch (asu$2.a[this.F.ordinal()]) {
                case um$h.com_facebook_login_view_com_facebook_logout_text /*2*/:
                    deltaX = -rect.left;
                    break;
                case um$h.com_facebook_login_view_com_facebook_tooltip_mode /*3*/:
                    deltaX = (((float) viewWidth) - width) - rect.left;
                    break;
                default:
                    deltaX = ((((float) viewWidth) - width) / 2.0f) - rect.left;
                    break;
            }
            this.C = 2;
        } else if (rect.left > 0.0f) {
            this.C = 0;
            deltaX = -rect.left;
        } else if (rect.right < ((float) viewWidth)) {
            deltaX = ((float) viewWidth) - rect.right;
            this.C = 1;
        } else {
            this.C = -1;
        }
        this.o.postTranslate(deltaX, deltaY);
        return true;
    }

    private RectF a(Matrix matrix) {
        ImageView imageView = c();
        if (imageView != null) {
            Drawable d = imageView.getDrawable();
            if (d != null) {
                this.p.set(0.0f, 0.0f, (float) d.getIntrinsicWidth(), (float) d.getIntrinsicHeight());
                matrix.mapRect(this.p);
                return this.p;
            }
        }
        return null;
    }

    public Bitmap n() {
        ImageView imageView = c();
        return imageView == null ? null : imageView.getDrawingCache();
    }

    public void a(int milliseconds) {
        if (milliseconds < 0) {
            milliseconds = 200;
        }
        this.b = milliseconds;
    }

    private float a(Matrix matrix, int whichValue) {
        matrix.getValues(this.q);
        return this.q[whichValue];
    }

    private void t() {
        this.o.reset();
        b(this.D);
        b(m());
        s();
    }

    private void b(Matrix matrix) {
        ImageView imageView = c();
        if (imageView != null) {
            r();
            imageView.setImageMatrix(matrix);
            if (this.r != null) {
                RectF displayRect = a(matrix);
                if (displayRect != null) {
                    this.r.a(displayRect);
                }
            }
        }
    }

    private void a(Drawable d) {
        ImageView imageView = c();
        if (imageView != null && d != null) {
            float viewWidth = (float) c(imageView);
            float viewHeight = (float) d(imageView);
            int drawableWidth = d.getIntrinsicWidth();
            int drawableHeight = d.getIntrinsicHeight();
            this.m.reset();
            float widthScale = viewWidth / ((float) drawableWidth);
            float heightScale = viewHeight / ((float) drawableHeight);
            if (this.F != ScaleType.CENTER) {
                float scale;
                if (this.F != ScaleType.CENTER_CROP) {
                    if (this.F != ScaleType.CENTER_INSIDE) {
                        RectF mTempSrc = new RectF(0.0f, 0.0f, (float) drawableWidth, (float) drawableHeight);
                        RectF mTempDst = new RectF(0.0f, 0.0f, viewWidth, viewHeight);
                        if (((int) this.D) % 180 != 0) {
                            mTempSrc = new RectF(0.0f, 0.0f, (float) drawableHeight, (float) drawableWidth);
                        }
                        switch (asu$2.a[this.F.ordinal()]) {
                            case um$h.com_facebook_login_view_com_facebook_logout_text /*2*/:
                                this.m.setRectToRect(mTempSrc, mTempDst, ScaleToFit.START);
                                break;
                            case um$h.com_facebook_login_view_com_facebook_tooltip_mode /*3*/:
                                this.m.setRectToRect(mTempSrc, mTempDst, ScaleToFit.END);
                                break;
                            case um$h.com_facebook_like_view_com_facebook_auxiliary_view_position /*4*/:
                                this.m.setRectToRect(mTempSrc, mTempDst, ScaleToFit.CENTER);
                                break;
                            case um$h.com_facebook_like_view_com_facebook_horizontal_alignment /*5*/:
                                this.m.setRectToRect(mTempSrc, mTempDst, ScaleToFit.FILL);
                                break;
                            default:
                                break;
                        }
                    }
                    scale = Math.min(1.0f, Math.min(widthScale, heightScale));
                    this.m.postScale(scale, scale);
                    this.m.postTranslate((viewWidth - (((float) drawableWidth) * scale)) / 2.0f, (viewHeight - (((float) drawableHeight) * scale)) / 2.0f);
                } else {
                    scale = Math.max(widthScale, heightScale);
                    this.m.postScale(scale, scale);
                    this.m.postTranslate((viewWidth - (((float) drawableWidth) * scale)) / 2.0f, (viewHeight - (((float) drawableHeight) * scale)) / 2.0f);
                }
            } else {
                this.m.postTranslate((viewWidth - ((float) drawableWidth)) / 2.0f, (viewHeight - ((float) drawableHeight)) / 2.0f);
            }
            t();
        }
    }

    private int c(ImageView imageView) {
        if (imageView == null) {
            return 0;
        }
        return (imageView.getWidth() - imageView.getPaddingLeft()) - imageView.getPaddingRight();
    }

    private int d(ImageView imageView) {
        if (imageView == null) {
            return 0;
        }
        return (imageView.getHeight() - imageView.getPaddingTop()) - imageView.getPaddingBottom();
    }
}
