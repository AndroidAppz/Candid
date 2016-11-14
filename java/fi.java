/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 *  android.view.View
 *  android.view.ViewParent
 *  java.lang.Object
 *  java.lang.Runnable
 */
import android.os.Bundle;
import android.view.View;
import android.view.ViewParent;

class fi {
    public static void a(View view, int n2) {
        view.setImportantForAccessibility(n2);
    }

    public static void a(View view, int n2, int n3, int n4, int n5) {
        view.postInvalidate(n2, n3, n4, n5);
    }

    public static void a(View view, Runnable runnable) {
        view.postOnAnimation(runnable);
    }

    public static void a(View view, Runnable runnable, long l2) {
        view.postOnAnimationDelayed(runnable, l2);
    }

    public static boolean a(View view) {
        return view.hasTransientState();
    }

    public static boolean a(View view, int n2, Bundle bundle) {
        return view.performAccessibilityAction(n2, bundle);
    }

    public static void b(View view) {
        view.postInvalidateOnAnimation();
    }

    public static int c(View view) {
        return view.getImportantForAccessibility();
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

