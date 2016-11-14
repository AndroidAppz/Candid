package defpackage;

import android.os.Bundle;
import android.view.View;
import android.view.ViewParent;

/* compiled from: ViewCompatJB */
class fi {
    public static boolean a(View view) {
        return view.hasTransientState();
    }

    public static void b(View view) {
        view.postInvalidateOnAnimation();
    }

    public static void a(View view, int left, int top, int right, int bottom) {
        view.postInvalidate(left, top, right, bottom);
    }

    public static void a(View view, Runnable action) {
        view.postOnAnimation(action);
    }

    public static void a(View view, Runnable action, long delayMillis) {
        view.postOnAnimationDelayed(action, delayMillis);
    }

    public static int c(View view) {
        return view.getImportantForAccessibility();
    }

    public static void a(View view, int mode) {
        view.setImportantForAccessibility(mode);
    }

    public static boolean a(View view, int action, Bundle arguments) {
        return view.performAccessibilityAction(action, arguments);
    }

    public static ViewParent d(View view) {
        return view.getParentForAccessibility();
    }

    public static int e(View view) {
        return view.getMinimumWidth();
    }

    public static int f(View view) {
        return view.getMinimumHeight();
    }

    public static void g(View view) {
        view.requestFitSystemWindows();
    }

    public static boolean h(View view) {
        return view.getFitsSystemWindows();
    }

    public static boolean i(View view) {
        return view.hasOverlappingRendering();
    }
}
