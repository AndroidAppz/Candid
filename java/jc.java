/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.graphics.Canvas
 *  android.graphics.ColorFilter
 *  android.graphics.Paint
 *  android.graphics.Paint$Style
 *  android.graphics.Path
 *  android.graphics.Rect
 *  android.graphics.drawable.Drawable
 */
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;

public class jc
extends Drawable {
    private Paint a = new Paint();
    private float b = 0.0f;
    private int c = 0;
    private int d = 0;
    private int e;

    public void a(int n2) {
        this.d = n2;
    }

    public void draw(Canvas canvas) {
        Rect rect = this.getBounds();
        Path path = new Path();
        path.moveTo((float)rect.left, (float)rect.top);
        path.lineTo((float)rect.right, (float)((rect.top - rect.bottom) / 2 + rect.bottom));
        path.lineTo((float)rect.left, (float)rect.bottom);
        path.lineTo((float)rect.left, (float)rect.top);
        this.a.setColor(this.d);
        this.a.setStyle(Paint.Style.FILL);
        canvas.drawPath(path, this.a);
        this.a.setStyle(Paint.Style.STROKE);
        this.a.setColor(this.c);
        this.a.setStrokeWidth(this.b);
        canvas.drawPath(path, this.a);
    }

    public int getAlpha() {
        return this.e;
    }

    public int getOpacity() {
        return 1;
    }

    public void setAlpha(int n2) {
        this.e = n2;
    }

    public void setColorFilter(ColorFilter colorFilter) {
    }
}

