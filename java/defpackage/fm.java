package defpackage;

import android.view.View;

/* compiled from: ViewCompatMarshmallow */
class fm {
    public static void a(View view, int indicators, int mask) {
        view.setScrollIndicators(indicators, mask);
    }

    static void a(View view, int offset) {
        view.offsetTopAndBottom(offset);
    }

    static void b(View view, int offset) {
        view.offsetLeftAndRight(offset);
    }
}
