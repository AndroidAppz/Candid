package defpackage;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.RectF;
import android.os.Build.VERSION;
import android.util.Log;

/* compiled from: TransformationUtils */
public final class nw {
    public static Bitmap a(Bitmap recycled, Bitmap toCrop, int width, int height) {
        if (toCrop == null) {
            return null;
        }
        if (toCrop.getWidth() == width && toCrop.getHeight() == height) {
            return toCrop;
        }
        float scale;
        Bitmap result;
        float dx = 0.0f;
        float dy = 0.0f;
        Matrix m = new Matrix();
        if (toCrop.getWidth() * height > toCrop.getHeight() * width) {
            scale = ((float) height) / ((float) toCrop.getHeight());
            dx = (((float) width) - (((float) toCrop.getWidth()) * scale)) * 0.5f;
        } else {
            scale = ((float) width) / ((float) toCrop.getWidth());
            dy = (((float) height) - (((float) toCrop.getHeight()) * scale)) * 0.5f;
        }
        m.setScale(scale, scale);
        m.postTranslate((float) ((int) (dx + 0.5f)), (float) ((int) (dy + 0.5f)));
        if (recycled != null) {
            result = recycled;
        } else {
            result = Bitmap.createBitmap(width, height, nw.a(toCrop));
        }
        nw.a(toCrop, result);
        new Canvas(result).drawBitmap(toCrop, m, new Paint(6));
        return result;
    }

    public static Bitmap a(Bitmap toFit, lf pool, int width, int height) {
        if (toFit.getWidth() != width || toFit.getHeight() != height) {
            float minPercentage = Math.min(((float) width) / ((float) toFit.getWidth()), ((float) height) / ((float) toFit.getHeight()));
            int targetWidth = (int) (((float) toFit.getWidth()) * minPercentage);
            int targetHeight = (int) (((float) toFit.getHeight()) * minPercentage);
            if (toFit.getWidth() != targetWidth || toFit.getHeight() != targetHeight) {
                Config config = nw.a(toFit);
                Bitmap toReuse = pool.a(targetWidth, targetHeight, config);
                if (toReuse == null) {
                    toReuse = Bitmap.createBitmap(targetWidth, targetHeight, config);
                }
                nw.a(toFit, toReuse);
                if (Log.isLoggable("TransformationUtils", 2)) {
                    Log.v("TransformationUtils", "request: " + width + "x" + height);
                    Log.v("TransformationUtils", "toFit:   " + toFit.getWidth() + "x" + toFit.getHeight());
                    Log.v("TransformationUtils", "toReuse: " + toReuse.getWidth() + "x" + toReuse.getHeight());
                    Log.v("TransformationUtils", "minPct:   " + minPercentage);
                }
                Canvas canvas = new Canvas(toReuse);
                Matrix matrix = new Matrix();
                matrix.setScale(minPercentage, minPercentage);
                canvas.drawBitmap(toFit, matrix, new Paint(6));
                return toReuse;
            } else if (!Log.isLoggable("TransformationUtils", 2)) {
                return toFit;
            } else {
                Log.v("TransformationUtils", "adjusted target size matches input, returning input");
                return toFit;
            }
        } else if (!Log.isLoggable("TransformationUtils", 2)) {
            return toFit;
        } else {
            Log.v("TransformationUtils", "requested target size matches input, returning input");
            return toFit;
        }
    }

    @TargetApi(12)
    public static void a(Bitmap toTransform, Bitmap outBitmap) {
        if (VERSION.SDK_INT >= 12 && outBitmap != null) {
            outBitmap.setHasAlpha(toTransform.hasAlpha());
        }
    }

    public static int a(int exifOrientation) {
        switch (exifOrientation) {
            case um$h.com_facebook_login_view_com_facebook_tooltip_mode /*3*/:
            case um$h.com_facebook_like_view_com_facebook_auxiliary_view_position /*4*/:
                return 180;
            case um$h.com_facebook_like_view_com_facebook_horizontal_alignment /*5*/:
            case um$h.CardView_cardUseCompatPadding /*6*/:
                return 90;
            case um$h.CardView_cardPreventCornerOverlap /*7*/:
            case um$h.CardView_contentPadding /*8*/:
                return 270;
            default:
                return 0;
        }
    }

    public static Bitmap a(Bitmap toOrient, lf pool, int exifOrientation) {
        Matrix matrix = new Matrix();
        nw.a(exifOrientation, matrix);
        if (matrix.isIdentity()) {
            return toOrient;
        }
        RectF newRect = new RectF(0.0f, 0.0f, (float) toOrient.getWidth(), (float) toOrient.getHeight());
        matrix.mapRect(newRect);
        int newWidth = Math.round(newRect.width());
        int newHeight = Math.round(newRect.height());
        Config config = nw.a(toOrient);
        Bitmap result = pool.a(newWidth, newHeight, config);
        if (result == null) {
            result = Bitmap.createBitmap(newWidth, newHeight, config);
        }
        matrix.postTranslate(-newRect.left, -newRect.top);
        new Canvas(result).drawBitmap(toOrient, matrix, new Paint(6));
        return result;
    }

    private static Config a(Bitmap bitmap) {
        return bitmap.getConfig() != null ? bitmap.getConfig() : Config.ARGB_8888;
    }

    static void a(int exifOrientation, Matrix matrix) {
        switch (exifOrientation) {
            case um$h.com_facebook_login_view_com_facebook_logout_text /*2*/:
                matrix.setScale(-1.0f, 1.0f);
                return;
            case um$h.com_facebook_login_view_com_facebook_tooltip_mode /*3*/:
                matrix.setRotate(180.0f);
                return;
            case um$h.com_facebook_like_view_com_facebook_auxiliary_view_position /*4*/:
                matrix.setRotate(180.0f);
                matrix.postScale(-1.0f, 1.0f);
                return;
            case um$h.com_facebook_like_view_com_facebook_horizontal_alignment /*5*/:
                matrix.setRotate(90.0f);
                matrix.postScale(-1.0f, 1.0f);
                return;
            case um$h.CardView_cardUseCompatPadding /*6*/:
                matrix.setRotate(90.0f);
                return;
            case um$h.CardView_cardPreventCornerOverlap /*7*/:
                matrix.setRotate(-90.0f);
                matrix.postScale(-1.0f, 1.0f);
                return;
            case um$h.CardView_contentPadding /*8*/:
                matrix.setRotate(-90.0f);
                return;
            default:
                return;
        }
    }
}
