package defpackage;

import android.graphics.Paint;
import android.view.View;

/* compiled from: ViewCompatJellybeanMr1 */
class fj {
    public static void a(View view, Paint paint) {
        view.setLayerPaint(paint);
    }

    public static int a(View view) {
        return view.getLayoutDirection();
    }

    public static int b(View view) {
        return view.getPaddingStart();
    }

    public static int c(View view) {
        return view.getPaddingEnd();
    }

    public static void a(View view, int start, int top, int end, int bottom) {
        view.setPaddingRelative(start, top, end, bottom);
    }

    public static int d(View view) {
        return view.getWindowSystemUiVisibility();
    }

    public static boolean e(View view) {
        return view.isPaddingRelative();
    }
}
