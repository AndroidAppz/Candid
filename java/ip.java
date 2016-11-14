/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.graphics.Bitmap
 *  android.graphics.Bitmap$Config
 *  android.graphics.BitmapShader
 *  android.graphics.Canvas
 *  android.graphics.Color
 *  android.graphics.ComposeShader
 *  android.graphics.LinearGradient
 *  android.graphics.Matrix
 *  android.graphics.Paint
 *  android.graphics.PorterDuff
 *  android.graphics.PorterDuff$Mode
 *  android.graphics.RectF
 *  android.graphics.Shader
 *  android.graphics.Shader$TileMode
 *  java.lang.Math
 *  java.lang.String
 */
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ComposeShader;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.RectF;
import android.graphics.Shader;

public class ip
extends nk {
    private float a = 20.0f;

    public ip(Context context) {
        super(context);
    }

    /*
     * Enabled aggressive block sorting
     */
    @Override
    public Bitmap a(lf lf2, Bitmap bitmap, int n2, int n3) {
        int n4 = bitmap.getWidth();
        int n5 = bitmap.getHeight();
        Bitmap bitmap2 = lf2.a(n2, n3, Bitmap.Config.ARGB_8888);
        if (bitmap2 == null) {
            bitmap2 = Bitmap.createBitmap((int)n2, (int)n3, (Bitmap.Config)Bitmap.Config.ARGB_8888);
        }
        Canvas canvas = new Canvas(bitmap2);
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        int[] arrn = new int[]{Color.parseColor((String)"#60000000"), Color.parseColor((String)"#C0000000")};
        BitmapShader bitmapShader = new BitmapShader(bitmap, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP);
        Matrix matrix = new Matrix();
        float f2 = (float)n2 / (float)n4;
        float f3 = (float)n3 / (float)n5;
        float f4 = Math.max((float)f2, (float)f3);
        matrix.setScale(f4, f4);
        float f5 = f2 > f3 ? 0.0f : 0.5f * ((float)n2 - f3 * (float)n4);
        matrix.postTranslate(f5, 0.0f);
        bitmapShader.setLocalMatrix(matrix);
        paint.setShader((Shader)new ComposeShader((Shader)new LinearGradient(0.0f, 0.0f, 0.0f, (float)n3, Color.parseColor((String)"#55000000"), Color.parseColor((String)"#D0000000"), Shader.TileMode.CLAMP), (Shader)bitmapShader, PorterDuff.Mode.OVERLAY));
        canvas.drawRoundRect(new RectF(0.0f, 0.0f, (float)n2, (float)n3), this.a, this.a, paint);
        return bitmap2;
    }

    @Override
    public String a() {
        return "RoundAndTint(radius=" + this.a + ")";
    }
}

