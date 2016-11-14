/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  java.lang.Object
 */
import android.view.View;

class fk {
    public static void a(View view, int n2) {
        view.setAccessibilityLiveRegion(n2);
    }

    public static boolean a(View view) {
        return view.isLaidOut();
    }

    public static boolean b(View view) {
        return view.isAttachedToWindow();
    }
}

