package defpackage;

import android.view.ViewGroup.MarginLayoutParams;

/* compiled from: MarginLayoutParamsCompatJellybeanMr1 */
class ei {
    public static int a(MarginLayoutParams lp) {
        return lp.getMarginStart();
    }

    public static int b(MarginLayoutParams lp) {
        return lp.getMarginEnd();
    }

    public static void a(MarginLayoutParams lp, int marginStart) {
        lp.setMarginStart(marginStart);
    }

    public static void b(MarginLayoutParams lp, int marginEnd) {
        lp.setMarginEnd(marginEnd);
    }

    public static void c(MarginLayoutParams lp, int layoutDirection) {
        lp.resolveLayoutDirection(layoutDirection);
    }
}
