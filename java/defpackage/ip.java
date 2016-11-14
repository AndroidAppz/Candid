package defpackage;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ComposeShader;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.RectF;
import android.graphics.Shader.TileMode;

/* compiled from: RoundAndTintBitmap */
public class ip extends nk {
    private float a = 20.0f;

    public ip(Context context) {
        super(context);
    }

    public Bitmap a(lf bitmapPool, Bitmap source, int destWidth, int destHeight) {
        int width = source.getWidth();
        int height = source.getHeight();
        Bitmap bitmap = bitmapPool.a(destWidth, destHeight, Config.ARGB_8888);
        if (bitmap == null) {
            bitmap = Bitmap.createBitmap(destWidth, destHeight, Config.ARGB_8888);
        }
        Canvas canvas = new Canvas(bitmap);
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        int[] colors = new int[]{Color.parseColor("#60000000"), Color.parseColor("#C0000000")};
        BitmapShader bitmapShader = new BitmapShader(source, TileMode.CLAMP, TileMode.CLAMP);
        Matrix bitmapScale = new Matrix();
        float dx = ((float) destWidth) / ((float) width);
        float dy = ((float) destHeight) / ((float) height);
        float scale = Math.max(dx, dy);
        bitmapScale.setScale(scale, scale);
        bitmapScale.postTranslate(dx > dy ? 0.0f : (((float) destWidth) - (((float) width) * dy)) * 0.5f, 0.0f);
        bitmapShader.setLocalMatrix(bitmapScale);
        paint.setShader(new ComposeShader(new LinearGradient(0.0f, 0.0f, 0.0f, (float) destHeight, Color.parseColor("#55000000"), Color.parseColor("#D0000000"), TileMode.CLAMP), bitmapShader, Mode.OVERLAY));
        canvas.drawRoundRect(new RectF(0.0f, 0.0f, (float) destWidth, (float) destHeight), this.a, this.a, paint);
        return bitmap;
    }

    public String a() {
        return "RoundAndTint(radius=" + this.a + ")";
    }
}
