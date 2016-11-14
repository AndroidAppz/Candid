/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.annotation.SuppressLint
 *  android.content.Context
 *  android.graphics.Bitmap
 *  android.graphics.Matrix
 *  android.graphics.Matrix$ScaleToFit
 *  android.graphics.RectF
 *  android.graphics.drawable.Drawable
 *  android.util.Log
 *  android.view.GestureDetector
 *  android.view.GestureDetector$OnDoubleTapListener
 *  android.view.GestureDetector$OnGestureListener
 *  android.view.GestureDetector$SimpleOnGestureListener
 *  android.view.MotionEvent
 *  android.view.View
 *  android.view.View$OnLongClickListener
 *  android.view.View$OnTouchListener
 *  android.view.ViewParent
 *  android.view.ViewTreeObserver
 *  android.view.ViewTreeObserver$OnGlobalLayoutListener
 *  android.view.animation.AccelerateDecelerateInterpolator
 *  android.view.animation.Interpolator
 *  android.widget.ImageView
 *  android.widget.ImageView$ScaleType
 *  java.lang.Deprecated
 *  java.lang.Float
 *  java.lang.IllegalArgumentException
 *  java.lang.IllegalStateException
 *  java.lang.Math
 *  java.lang.NoSuchFieldError
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.String
 *  java.lang.System
 *  java.lang.ref.WeakReference
 */
import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Interpolator;
import android.widget.ImageView;
import java.lang.ref.WeakReference;

public class asu
implements View.OnTouchListener,
ViewTreeObserver.OnGlobalLayoutListener,
ast,
asz {
    static final Interpolator a;
    static int c;
    private static final boolean d;
    private int A;
    private b B;
    private int C;
    private float D;
    private boolean E;
    private ImageView.ScaleType F;
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
    private c r;
    private d s;
    private g t;
    private View.OnLongClickListener u;
    private e v;
    private f w;
    private int x;
    private int y;
    private int z;

    static {
        d = Log.isLoggable((String)"PhotoViewAttacher", (int)3);
        a = new AccelerateDecelerateInterpolator();
        c = 1;
    }

    public asu(ImageView imageView) {
        super(imageView, true);
    }

    public asu(ImageView imageView, boolean bl2) {
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
        this.F = ImageView.ScaleType.FIT_CENTER;
        this.j = new WeakReference((Object)imageView);
        imageView.setDrawingCacheEnabled(true);
        imageView.setOnTouchListener((View.OnTouchListener)this);
        ViewTreeObserver viewTreeObserver = imageView.getViewTreeObserver();
        if (viewTreeObserver != null) {
            viewTreeObserver.addOnGlobalLayoutListener((ViewTreeObserver.OnGlobalLayoutListener)this);
        }
        asu.b(imageView);
        if (imageView.isInEditMode()) {
            return;
        }
        this.l = ata.a(imageView.getContext(), (asz)this);
        this.k = new GestureDetector(imageView.getContext(), (GestureDetector.OnGestureListener)new GestureDetector.SimpleOnGestureListener(){

            /*
             * Enabled aggressive block sorting
             */
            public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f2, float f3) {
                if (asu.this.w == null || asu.this.g() > 1.0f || em.c(motionEvent) > asu.c || em.c(motionEvent2) > asu.c) {
                    return false;
                }
                return asu.this.w.a(motionEvent, motionEvent2, f2, f3);
            }

            public void onLongPress(MotionEvent motionEvent) {
                if (asu.this.u != null) {
                    asu.this.u.onLongClick((View)asu.this.c());
                }
            }
        });
        this.k.setOnDoubleTapListener((GestureDetector.OnDoubleTapListener)new ass((asu)this));
        this.D = 0.0f;
        this.b(bl2);
    }

    private float a(Matrix matrix, int n2) {
        matrix.getValues(this.q);
        return this.q[n2];
    }

    private RectF a(Matrix matrix) {
        Drawable drawable;
        ImageView imageView = this.c();
        if (imageView != null && (drawable = imageView.getDrawable()) != null) {
            this.p.set(0.0f, 0.0f, (float)drawable.getIntrinsicWidth(), (float)drawable.getIntrinsicHeight());
            matrix.mapRect(this.p);
            return this.p;
        }
        return null;
    }

    /*
     * Enabled aggressive block sorting
     */
    private void a(Drawable drawable) {
        ImageView imageView = this.c();
        if (imageView == null || drawable == null) {
            return;
        }
        float f2 = super.c(imageView);
        float f3 = super.d(imageView);
        int n2 = drawable.getIntrinsicWidth();
        int n3 = drawable.getIntrinsicHeight();
        this.m.reset();
        float f4 = f2 / (float)n2;
        float f5 = f3 / (float)n3;
        if (this.F == ImageView.ScaleType.CENTER) {
            this.m.postTranslate((f2 - (float)n2) / 2.0f, (f3 - (float)n3) / 2.0f);
        } else if (this.F == ImageView.ScaleType.CENTER_CROP) {
            float f6 = Math.max((float)f4, (float)f5);
            this.m.postScale(f6, f6);
            this.m.postTranslate((f2 - f6 * (float)n2) / 2.0f, (f3 - f6 * (float)n3) / 2.0f);
        } else if (this.F == ImageView.ScaleType.CENTER_INSIDE) {
            float f7 = Math.min((float)1.0f, (float)Math.min((float)f4, (float)f5));
            this.m.postScale(f7, f7);
            this.m.postTranslate((f2 - f7 * (float)n2) / 2.0f, (f3 - f7 * (float)n3) / 2.0f);
        } else {
            RectF rectF = new RectF(0.0f, 0.0f, (float)n2, (float)n3);
            RectF rectF2 = new RectF(0.0f, 0.0f, f2, f3);
            if ((int)this.D % 180 != 0) {
                rectF = new RectF(0.0f, 0.0f, (float)n3, (float)n2);
            }
            switch (.a[this.F.ordinal()]) {
                default: {
                    break;
                }
                case 2: {
                    this.m.setRectToRect(rectF, rectF2, Matrix.ScaleToFit.START);
                    break;
                }
                case 4: {
                    this.m.setRectToRect(rectF, rectF2, Matrix.ScaleToFit.CENTER);
                    break;
                }
                case 3: {
                    this.m.setRectToRect(rectF, rectF2, Matrix.ScaleToFit.END);
                    break;
                }
                case 5: {
                    this.m.setRectToRect(rectF, rectF2, Matrix.ScaleToFit.FILL);
                }
            }
        }
        super.t();
    }

    private static boolean a(ImageView imageView) {
        if (imageView != null && imageView.getDrawable() != null) {
            return true;
        }
        return false;
    }

    private void b(Matrix matrix) {
        ImageView imageView = this.c();
        if (imageView != null) {
            RectF rectF;
            super.r();
            imageView.setImageMatrix(matrix);
            if (this.r != null && (rectF = super.a(matrix)) != null) {
                this.r.a(rectF);
            }
        }
    }

    private static void b(ImageView imageView) {
        if (imageView != null && !(imageView instanceof ast) && !ImageView.ScaleType.MATRIX.equals((Object)imageView.getScaleType())) {
            imageView.setScaleType(ImageView.ScaleType.MATRIX);
        }
    }

    private static boolean b(ImageView.ScaleType scaleType) {
        if (scaleType == null) {
            return false;
        }
        switch (.a[scaleType.ordinal()]) {
            default: {
                return true;
            }
            case 1: 
        }
        throw new IllegalArgumentException(scaleType.name() + " is not supported in PhotoView");
    }

    private int c(ImageView imageView) {
        if (imageView == null) {
            return 0;
        }
        return imageView.getWidth() - imageView.getPaddingLeft() - imageView.getPaddingRight();
    }

    private static void c(float f2, float f3, float f4) {
        if (f2 >= f3) {
            throw new IllegalArgumentException("MinZoom has to be less than MidZoom");
        }
        if (f3 >= f4) {
            throw new IllegalArgumentException("MidZoom has to be less than MaxZoom");
        }
    }

    private int d(ImageView imageView) {
        if (imageView == null) {
            return 0;
        }
        return imageView.getHeight() - imageView.getPaddingTop() - imageView.getPaddingBottom();
    }

    private void p() {
        if (this.B != null) {
            this.B.a();
            this.B = null;
        }
    }

    private void q() {
        if (this.s()) {
            this.b(this.m());
        }
    }

    private void r() {
        ImageView imageView = this.c();
        if (imageView != null && !(imageView instanceof ast) && !ImageView.ScaleType.MATRIX.equals((Object)imageView.getScaleType())) {
            throw new IllegalStateException("The ImageView's ScaleType has been changed since attaching a PhotoViewAttacher");
        }
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    private boolean s() {
        var1_1 = this.c();
        if (var1_1 == null) {
            return false;
        }
        var2_2 = this.a(this.m());
        if (var2_2 == null) return false;
        var3_3 = var2_2.height();
        var4_4 = var2_2.width();
        var5_5 = this.d(var1_1);
        if (var3_3 > (float)var5_5) ** GOTO lbl21
        switch (.a[this.F.ordinal()]) {
            default: {
                var7_6 = ((float)var5_5 - var3_3) / 2.0f - var2_2.top;
                ** GOTO lbl28
            }
            case 2: {
                var7_6 = - var2_2.top;
                ** break;
            }
            case 3: 
        }
        var7_6 = (float)var5_5 - var3_3 - var2_2.top;
        ** break;
lbl20: // 2 sources:
        ** GOTO lbl28
lbl21: // 1 sources:
        if (var2_2.top > 0.0f) {
            var7_6 = - var2_2.top;
        } else {
            var6_9 = var2_2.bottom FCMPG (float)var5_5;
            var7_6 = 0.0f;
            if (var6_9 < 0) {
                var7_6 = (float)var5_5 - var2_2.bottom;
            }
        }
lbl28: // 6 sources:
        if (var4_4 <= (float)(var8_7 = this.c(var1_1))) {
            switch (.a[this.F.ordinal()]) {
                default: {
                    var9_8 = ((float)var8_7 - var4_4) / 2.0f - var2_2.left;
                    break;
                }
                case 2: {
                    var9_8 = - var2_2.left;
                    break;
                }
                case 3: {
                    var9_8 = (float)var8_7 - var4_4 - var2_2.left;
                }
            }
            this.C = 2;
        } else if (var2_2.left > 0.0f) {
            this.C = 0;
            var9_8 = - var2_2.left;
        } else if (var2_2.right < (float)var8_7) {
            var9_8 = (float)var8_7 - var2_2.right;
            this.C = 1;
        } else {
            this.C = -1;
            var9_8 = 0.0f;
        }
        this.o.postTranslate(var9_8, var7_6);
        return true;
    }

    private void t() {
        this.o.reset();
        this.b(this.D);
        this.b(this.m());
        this.s();
    }

    public void a() {
        if (this.j == null) {
            return;
        }
        ImageView imageView = (ImageView)this.j.get();
        if (imageView != null) {
            ViewTreeObserver viewTreeObserver = imageView.getViewTreeObserver();
            if (viewTreeObserver != null && viewTreeObserver.isAlive()) {
                viewTreeObserver.removeGlobalOnLayoutListener((ViewTreeObserver.OnGlobalLayoutListener)this);
            }
            imageView.setOnTouchListener(null);
            this.p();
        }
        if (this.k != null) {
            this.k.setOnDoubleTapListener(null);
        }
        this.r = null;
        this.s = null;
        this.t = null;
        this.j = null;
    }

    public void a(float f2) {
        this.o.setRotate(f2 % 360.0f);
        super.q();
    }

    /*
     * Enabled aggressive block sorting
     */
    @Override
    public void a(float f2, float f3) {
        if (this.l.a()) return;
        if (d) {
            atc atc2 = atb.a();
            Object[] arrobject = new Object[]{Float.valueOf((float)f2), Float.valueOf((float)f3)};
            atc2.a("PhotoViewAttacher", String.format((String)"onDrag: dx: %.2f. dy: %.2f", (Object[])arrobject));
        }
        ImageView imageView = this.c();
        this.o.postTranslate(f2, f3);
        super.q();
        ViewParent viewParent = imageView.getParent();
        if (this.h && !this.l.a() && !this.i) {
            if (this.C != 2 && (this.C != 0 || f2 < 1.0f) && (this.C != 1 || f2 > -1.0f) || viewParent == null) return;
            {
                viewParent.requestDisallowInterceptTouchEvent(false);
                return;
            }
        }
        if (viewParent == null) {
            return;
        }
        viewParent.requestDisallowInterceptTouchEvent(true);
    }

    @Override
    public void a(float f2, float f3, float f4) {
        if (d) {
            atc atc2 = atb.a();
            Object[] arrobject = new Object[]{Float.valueOf((float)f2), Float.valueOf((float)f3), Float.valueOf((float)f4)};
            atc2.a("PhotoViewAttacher", String.format((String)"onScale: scale: %.2f. fX: %.2f. fY: %.2f", (Object[])arrobject));
        }
        if (!(this.g() >= this.g && f2 >= 1.0f || this.g() <= this.e && f2 <= 1.0f)) {
            if (this.v != null) {
                this.v.a(f2, f3, f4);
            }
            this.o.postScale(f2, f2, f3, f4);
            super.q();
        }
    }

    @Override
    public void a(float f2, float f3, float f4, float f5) {
        if (d) {
            atb.a().a("PhotoViewAttacher", "onFling. sX: " + f2 + " sY: " + f3 + " Vx: " + f4 + " Vy: " + f5);
        }
        ImageView imageView = this.c();
        this.B = (asu)this.new b(imageView.getContext());
        this.B.a(super.c(imageView), super.d(imageView), (int)f4, (int)f5);
        imageView.post((Runnable)this.B);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public void a(float f2, float f3, float f4, boolean bl2) {
        ImageView imageView = this.c();
        if (imageView == null) return;
        if (f2 < this.e || f2 > this.g) {
            atb.a().b("PhotoViewAttacher", "Scale must be within the range of minScale and maxScale");
            return;
        }
        if (bl2) {
            imageView.post((Runnable)(asu)this.new a(this.g(), f2, f3, f4));
            return;
        }
        this.o.setScale(f2, f2, f3, f4);
        super.q();
    }

    public void a(float f2, boolean bl2) {
        ImageView imageView = this.c();
        if (imageView != null) {
            this.a(f2, (float)(imageView.getRight() / 2), (float)(imageView.getBottom() / 2), bl2);
        }
    }

    public void a(int n2) {
        if (n2 < 0) {
            n2 = 200;
        }
        this.b = n2;
    }

    public void a(GestureDetector.OnDoubleTapListener onDoubleTapListener) {
        if (onDoubleTapListener != null) {
            this.k.setOnDoubleTapListener(onDoubleTapListener);
            return;
        }
        this.k.setOnDoubleTapListener((GestureDetector.OnDoubleTapListener)new ass((asu)this));
    }

    public void a(View.OnLongClickListener onLongClickListener) {
        this.u = onLongClickListener;
    }

    public void a(ImageView.ScaleType scaleType) {
        if (asu.b(scaleType) && scaleType != this.F) {
            this.F = scaleType;
            this.k();
        }
    }

    public void a(c c2) {
        this.r = c2;
    }

    public void a(d d2) {
        this.s = d2;
    }

    public void a(e e2) {
        this.v = e2;
    }

    public void a(f f2) {
        this.w = f2;
    }

    public void a(g g2) {
        this.t = g2;
    }

    public void a(boolean bl2) {
        this.h = bl2;
    }

    public RectF b() {
        this.s();
        return this.a(this.m());
    }

    public void b(float f2) {
        this.o.postRotate(f2 % 360.0f);
        super.q();
    }

    public void b(float f2, float f3, float f4) {
        asu.c(f2, f3, f4);
        this.e = f2;
        this.f = f3;
        this.g = f4;
    }

    public void b(boolean bl2) {
        this.E = bl2;
        this.k();
    }

    public ImageView c() {
        WeakReference<ImageView> weakReference = this.j;
        ImageView imageView = null;
        if (weakReference != null) {
            imageView = (ImageView)this.j.get();
        }
        if (imageView == null) {
            this.a();
            atb.a().b("PhotoViewAttacher", "ImageView no longer exists. You should not use this PhotoViewAttacher any more.");
        }
        return imageView;
    }

    public void c(float f2) {
        asu.c(f2, this.f, this.g);
        this.e = f2;
    }

    public float d() {
        return this.e;
    }

    public void d(float f2) {
        asu.c(this.e, f2, this.g);
        this.f = f2;
    }

    public float e() {
        return this.f;
    }

    public void e(float f2) {
        asu.c(this.e, this.f, f2);
        this.g = f2;
    }

    public float f() {
        return this.g;
    }

    public void f(float f2) {
        this.a(f2, false);
    }

    public float g() {
        return (float)Math.sqrt((double)((float)Math.pow((double)this.a(this.o, 0), (double)2.0) + (float)Math.pow((double)this.a(this.o, 3), (double)2.0)));
    }

    public ImageView.ScaleType h() {
        return this.F;
    }

    @Deprecated
    public d i() {
        return this.s;
    }

    @Deprecated
    public g j() {
        return this.t;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public void k() {
        ImageView imageView = this.c();
        if (imageView == null) return;
        if (this.E) {
            asu.b(imageView);
            this.a(imageView.getDrawable());
            return;
        }
        this.t();
    }

    public Matrix l() {
        return new Matrix(this.m());
    }

    public Matrix m() {
        this.n.set(this.m);
        this.n.postConcat(this.o);
        return this.n;
    }

    public Bitmap n() {
        ImageView imageView = this.c();
        if (imageView == null) {
            return null;
        }
        return imageView.getDrawingCache();
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public void onGlobalLayout() {
        ImageView imageView = this.c();
        if (imageView == null) return;
        if (this.E) {
            int n2 = imageView.getTop();
            int n3 = imageView.getRight();
            int n4 = imageView.getBottom();
            int n5 = imageView.getLeft();
            if (n2 == this.x && n4 == this.z && n5 == this.A && n3 == this.y) return;
            this.a(imageView.getDrawable());
            this.x = n2;
            this.y = n3;
            this.z = n4;
            this.A = n5;
            return;
        }
        this.a(imageView.getDrawable());
    }

    /*
     * Enabled aggressive block sorting
     */
    @SuppressLint(value={"ClickableViewAccessibility"})
    public boolean onTouch(View view, MotionEvent motionEvent) {
        boolean bl2 = this.E;
        boolean bl3 = false;
        if (!bl2) return bl3;
        boolean bl4 = asu.a((ImageView)view);
        bl3 = false;
        if (!bl4) return bl3;
        ViewParent viewParent = view.getParent();
        int n2 = motionEvent.getAction();
        bl3 = false;
        switch (n2) {
            case 0: {
                if (viewParent != null) {
                    viewParent.requestDisallowInterceptTouchEvent(true);
                } else {
                    atb.a().b("PhotoViewAttacher", "onTouch getParent() returned null");
                }
                super.p();
                bl3 = false;
                break;
            }
            case 1: 
            case 3: {
                float f2 = this.g() FCMPG this.e;
                bl3 = false;
                if (f2 >= 0) break;
                RectF rectF = this.b();
                bl3 = false;
                if (rectF == null) break;
                view.post((Runnable)(asu)this.new a(this.g(), this.e, rectF.centerX(), rectF.centerY()));
                bl3 = true;
            }
        }
        if (this.l != null) {
            boolean bl5 = this.l.a();
            boolean bl6 = this.l.b();
            bl3 = this.l.c(motionEvent);
            boolean bl7 = !bl5 && !this.l.a();
            boolean bl8 = !bl6 && !this.l.b();
            boolean bl9 = bl7 && bl8;
            this.i = bl9;
        }
        if (this.k == null) return bl3;
        if (!this.k.onTouchEvent(motionEvent)) return bl3;
        return true;
    }

    class a
    implements Runnable {
        private final float b;
        private final float c;
        private final long d;
        private final float e;
        private final float f;

        public a(float f2, float f3, float f4, float f5) {
            this.b = f4;
            this.c = f5;
            this.d = System.currentTimeMillis();
            this.e = f2;
            this.f = f3;
        }

        private float a() {
            float f2 = Math.min((float)1.0f, (float)(1.0f * (float)(System.currentTimeMillis() - this.d) / (float)asu.this.b));
            return asu.a.getInterpolation(f2);
        }

        /*
         * Enabled aggressive block sorting
         * Lifted jumps to return sites
         */
        public void run() {
            ImageView imageView = asu.this.c();
            if (imageView == null) {
                return;
            }
            float f2 = this.a();
            float f3 = (this.e + f2 * (this.f - this.e)) / asu.this.g();
            asu.this.a(f3, this.b, this.c);
            if (f2 >= 1.0f) return;
            asr.a((View)imageView, this);
        }
    }

    class b
    implements Runnable {
        private final ath b;
        private int c;
        private int d;

        public b(Context context) {
            this.b = ath.a(context);
        }

        public void a() {
            if (d) {
                atb.a().a("PhotoViewAttacher", "Cancel Fling");
            }
            this.b.a(true);
        }

        /*
         * Enabled aggressive block sorting
         * Lifted jumps to return sites
         */
        public void a(int n2, int n3, int n4, int n5) {
            int n6;
            int n7;
            int n8;
            int n9;
            RectF rectF = asu.this.b();
            if (rectF == null) {
                return;
            }
            int n10 = Math.round((float)(- rectF.left));
            if ((float)n2 < rectF.width()) {
                n6 = 0;
                n9 = Math.round((float)(rectF.width() - (float)n2));
            } else {
                n9 = n10;
                n6 = n10;
            }
            int n11 = Math.round((float)(- rectF.top));
            if ((float)n3 < rectF.height()) {
                n8 = 0;
                n7 = Math.round((float)(rectF.height() - (float)n3));
            } else {
                n7 = n11;
                n8 = n11;
            }
            this.c = n10;
            this.d = n11;
            if (d) {
                atb.a().a("PhotoViewAttacher", "fling. StartX:" + n10 + " StartY:" + n11 + " MaxX:" + n9 + " MaxY:" + n7);
            }
            if (n10 == n9) {
                if (n11 == n7) return;
            }
            this.b.a(n10, n11, n4, n5, n6, n9, n8, n7, 0, 0);
        }

        /*
         * Enabled aggressive block sorting
         */
        public void run() {
            ImageView imageView;
            if (this.b.b() || (imageView = asu.this.c()) == null || !this.b.a()) {
                return;
            }
            int n2 = this.b.c();
            int n3 = this.b.d();
            if (d) {
                atb.a().a("PhotoViewAttacher", "fling run(). CurrentX:" + this.c + " CurrentY:" + this.d + " NewX:" + n2 + " NewY:" + n3);
            }
            asu.this.o.postTranslate((float)(this.c - n2), (float)(this.d - n3));
            asu.this.b(asu.this.m());
            this.c = n2;
            this.d = n3;
            asr.a((View)imageView, this);
        }
    }

    public static interface c {
        public void a(RectF var1);
    }

    public static interface d {
        public void onOutsidePhotoTap();

        public void onPhotoTap(View var1, float var2, float var3);
    }

    public static interface e {
        public void a(float var1, float var2, float var3);
    }

    public static interface f {
        public boolean a(MotionEvent var1, MotionEvent var2, float var3, float var4);
    }

    public static interface g {
        public void a(View var1, float var2, float var3);
    }

}

