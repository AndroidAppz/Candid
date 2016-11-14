package defpackage;

import android.graphics.Bitmap;
import android.graphics.Canvas;

/* compiled from: BitmapUtils */
public class ji {
    public static Bitmap a(Bitmap bmp, int color) {
        if (bmp == null) {
            return null;
        }
        int biggerParam = Math.max(bmp.getWidth(), bmp.getHeight());
        Bitmap bitmap = Bitmap.createBitmap(biggerParam, biggerParam, bmp.getConfig());
        Canvas canvas = new Canvas(bitmap);
        canvas.drawColor(color);
        canvas.drawBitmap(bmp, (float) (bmp.getWidth() > bmp.getHeight() ? 0 : (bmp.getHeight() - bmp.getWidth()) / 2), (float) (bmp.getHeight() > bmp.getWidth() ? 0 : (bmp.getWidth() - bmp.getHeight()) / 2), null);
        return bitmap;
    }
}
