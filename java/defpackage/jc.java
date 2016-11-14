package defpackage;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;

/* compiled from: Arrow */
public class jc extends Drawable {
    private Paint a = new Paint();
    private float b = 0.0f;
    private int c = 0;
    private int d = 0;
    private int e;

    public int getOpacity() {
        return 1;
    }

    public void draw(Canvas canvas) {
        Rect bounds = getBounds();
        Path triangle = new Path();
        triangle.moveTo((float) bounds.left, (float) bounds.top);
        triangle.lineTo((float) bounds.right, (float) (((bounds.top - bounds.bottom) / 2) + bounds.bottom));
        triangle.lineTo((float) bounds.left, (float) bounds.bottom);
        triangle.lineTo((float) bounds.left, (float) bounds.top);
        this.a.setColor(this.d);
        this.a.setStyle(Style.FILL);
        canvas.drawPath(triangle, this.a);
        this.a.setStyle(Style.STROKE);
        this.a.setColor(this.c);
        this.a.setStrokeWidth(this.b);
        canvas.drawPath(triangle, this.a);
    }

    public void setAlpha(int alpha) {
        this.e = alpha;
    }

    public int getAlpha() {
        return this.e;
    }

    public void a(int color) {
        this.d = color;
    }

    public void setColorFilter(ColorFilter cf) {
    }
}
