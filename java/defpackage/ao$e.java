package defpackage;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.Region.Op;

/* compiled from: VectorDrawableCompat */
class ao$e {
    private static final Matrix j = new Matrix();
    float a;
    float b;
    float c;
    float d;
    int e;
    String f;
    final dh<String, Object> g;
    private final Path h;
    private final Path i;
    private final Matrix k;
    private Paint l;
    private Paint m;
    private PathMeasure n;
    private int o;
    private final ao$c p;

    public ao$e() {
        this.k = new Matrix();
        this.a = 0.0f;
        this.b = 0.0f;
        this.c = 0.0f;
        this.d = 0.0f;
        this.e = 255;
        this.f = null;
        this.g = new dh();
        this.p = new ao$c();
        this.h = new Path();
        this.i = new Path();
    }

    public void a(int alpha) {
        this.e = alpha;
    }

    public int a() {
        return this.e;
    }

    public void a(float alpha) {
        a((int) (255.0f * alpha));
    }

    public float b() {
        return ((float) a()) / 255.0f;
    }

    public ao$e(ao$e copy) {
        this.k = new Matrix();
        this.a = 0.0f;
        this.b = 0.0f;
        this.c = 0.0f;
        this.d = 0.0f;
        this.e = 255;
        this.f = null;
        this.g = new dh();
        this.p = new ao$c(copy.p, this.g);
        this.h = new Path(copy.h);
        this.i = new Path(copy.i);
        this.a = copy.a;
        this.b = copy.b;
        this.c = copy.c;
        this.d = copy.d;
        this.o = copy.o;
        this.e = copy.e;
        this.f = copy.f;
        if (copy.f != null) {
            this.g.put(copy.f, this);
        }
    }

    private void a(ao$c currentGroup, Matrix currentMatrix, Canvas canvas, int w, int h, ColorFilter filter) {
        currentGroup.b.set(currentMatrix);
        currentGroup.b.preConcat(currentGroup.j);
        for (int i = 0; i < currentGroup.a.size(); i++) {
            ao$c child = currentGroup.a.get(i);
            if (child instanceof ao$c) {
                a(child, currentGroup.b, canvas, w, h, filter);
            } else if (child instanceof ao$d) {
                a(currentGroup, (ao$d) child, canvas, w, h, filter);
            }
        }
    }

    public void a(Canvas canvas, int w, int h, ColorFilter filter) {
        a(this.p, j, canvas, w, h, filter);
    }

    private void a(ao$c vGroup, ao$d vPath, Canvas canvas, int w, int h, ColorFilter filter) {
        float scaleX = ((float) w) / this.c;
        float scaleY = ((float) h) / this.d;
        float minScale = Math.min(scaleX, scaleY);
        Matrix groupStackedMatrix = vGroup.b;
        this.k.set(groupStackedMatrix);
        this.k.postScale(scaleX, scaleY);
        float matrixScale = a(groupStackedMatrix);
        if (matrixScale != 0.0f) {
            vPath.a(this.h);
            Path path = this.h;
            this.i.reset();
            if (vPath.a()) {
                this.i.addPath(path, this.k);
                canvas.clipPath(this.i, Op.REPLACE);
                return;
            }
            ao$b fullPath = (ao$b) vPath;
            if (!(fullPath.g == 0.0f && fullPath.h == 1.0f)) {
                float start = (fullPath.g + fullPath.i) % 1.0f;
                float end = (fullPath.h + fullPath.i) % 1.0f;
                if (this.n == null) {
                    this.n = new PathMeasure();
                }
                this.n.setPath(this.h, false);
                float len = this.n.getLength();
                start *= len;
                end *= len;
                path.reset();
                if (start > end) {
                    this.n.getSegment(start, len, path, true);
                    this.n.getSegment(0.0f, end, path, true);
                } else {
                    this.n.getSegment(start, end, path, true);
                }
                path.rLineTo(0.0f, 0.0f);
            }
            this.i.addPath(path, this.k);
            if (fullPath.c != 0) {
                if (this.m == null) {
                    this.m = new Paint();
                    this.m.setStyle(Style.FILL);
                    this.m.setAntiAlias(true);
                }
                Paint fillPaint = this.m;
                fillPaint.setColor(ao.b(fullPath.c, fullPath.f));
                fillPaint.setColorFilter(filter);
                canvas.drawPath(this.i, fillPaint);
            }
            if (fullPath.a != 0) {
                if (this.l == null) {
                    this.l = new Paint();
                    this.l.setStyle(Style.STROKE);
                    this.l.setAntiAlias(true);
                }
                Paint strokePaint = this.l;
                if (fullPath.k != null) {
                    strokePaint.setStrokeJoin(fullPath.k);
                }
                if (fullPath.j != null) {
                    strokePaint.setStrokeCap(fullPath.j);
                }
                strokePaint.setStrokeMiter(fullPath.l);
                strokePaint.setColor(ao.b(fullPath.a, fullPath.d));
                strokePaint.setColorFilter(filter);
                strokePaint.setStrokeWidth(fullPath.b * (minScale * matrixScale));
                canvas.drawPath(this.i, strokePaint);
            }
        }
    }

    private static float a(float v1x, float v1y, float v2x, float v2y) {
        return (v1x * v2y) - (v1y * v2x);
    }

    private float a(Matrix groupStackedMatrix) {
        float[] unitVectors = new float[]{0.0f, 1.0f, 1.0f, 0.0f};
        groupStackedMatrix.mapVectors(unitVectors);
        float scaleX = (float) Math.hypot((double) unitVectors[0], (double) unitVectors[1]);
        float scaleY = (float) Math.hypot((double) unitVectors[2], (double) unitVectors[3]);
        float crossProduct = ao$e.a(unitVectors[0], unitVectors[1], unitVectors[2], unitVectors[3]);
        float maxScale = Math.max(scaleX, scaleY);
        if (maxScale > 0.0f) {
            return Math.abs(crossProduct) / maxScale;
        }
        return 0.0f;
    }
}
