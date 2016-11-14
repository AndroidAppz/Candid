package defpackage;

import android.view.View;

/* compiled from: ViewCompatKitKat */
class fk {
    public static void a(View view, int mode) {
        view.setAccessibilityLiveRegion(mode);
    }

    public static boolean a(View view) {
        return view.isLaidOut();
    }

    public static boolean b(View view) {
        return view.isAttachedToWindow();
    }
}
