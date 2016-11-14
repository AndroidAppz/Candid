package defpackage;

import android.animation.ValueAnimator;
import android.graphics.Paint;
import android.view.View;
import android.view.ViewParent;

/* compiled from: ViewCompatHC */
class ff {
    static long a() {
        return ValueAnimator.getFrameDelay();
    }

    public static float a(View view) {
        return view.getAlpha();
    }

    public static void a(View view, int layerType, Paint paint) {
        view.setLayerType(layerType, paint);
    }

    public static int b(View view) {
        return view.getLayerType();
    }

    public static int a(int size, int measureSpec, int childMeasuredState) {
        return View.resolveSizeAndState(size, measureSpec, childMeasuredState);
    }

    public static int c(View view) {
        return view.getMeasuredWidthAndState();
    }

    public static int d(View view) {
        return view.getMeasuredHeightAndState();
    }

    public static int e(View view) {
        return view.getMeasuredState();
    }

    public static float f(View view) {
        return view.getTranslationX();
    }

    public static float g(View view) {
        return view.getTranslationY();
    }

    public static float h(View view) {
        return view.getScaleX();
    }

    public static void a(View view, float value) {
        view.setTranslationX(value);
    }

    public static void b(View view, float value) {
        view.setTranslationY(value);
    }

    public static void c(View view, float value) {
        view.setAlpha(value);
    }

    public static void d(View view, float value) {
        view.setScaleX(value);
    }

    public static void e(View view, float value) {
        view.setScaleY(value);
    }

    public static void i(View view) {
        view.jumpDrawablesToCurrentState();
    }

    public static void a(View view, boolean enabled) {
        view.setSaveFromParentEnabled(enabled);
    }

    public static void b(View view, boolean activated) {
        view.setActivated(activated);
    }

    public static int a(int curState, int newState) {
        return View.combineMeasuredStates(curState, newState);
    }

    static void a(View view, int offset) {
        view.offsetTopAndBottom(offset);
        ff.j(view);
        ViewParent parent = view.getParent();
        if (parent instanceof View) {
            ff.j((View) parent);
        }
    }

    static void b(View view, int offset) {
        view.offsetLeftAndRight(offset);
        ff.j(view);
        ViewParent parent = view.getParent();
        if (parent instanceof View) {
            ff.j((View) parent);
        }
    }

    private static void j(View view) {
        float y = view.getTranslationY();
        view.setTranslationY(1.0f + y);
        view.setTranslationY(y);
    }
}
