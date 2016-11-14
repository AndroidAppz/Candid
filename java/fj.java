/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.graphics.Paint
 *  android.view.View
 *  java.lang.Object
 */
import android.graphics.Paint;
import android.view.View;

class fj {
    public static int a(View view) {
        return view.getLayoutDirection();
    }

    public static void a(View view, int n2, int n3, int n4, int n5) {
        view.setPaddingRelative(n2, n3, n4, n5);
    }

    public static void a(View view, Paint paint) {
        view.setLayerPaint(paint);
    }

    public static int b(View view) {
        return view.getPaddingStart();
    }

    public static int c(View view) {
        return view.getPaddingEnd();
    }

    public static int d(View view) {
        return view.getWindowSystemUiVisibility();
    }

    public static boolean e(View view) {
        return view.isPaddingRelative();
    }
}

