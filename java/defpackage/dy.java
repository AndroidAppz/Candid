package defpackage;

import android.graphics.Rect;
import android.view.Gravity;

/* compiled from: GravityCompatJellybeanMr1 */
class dy {
    public static int a(int gravity, int layoutDirection) {
        return Gravity.getAbsoluteGravity(gravity, layoutDirection);
    }

    public static void a(int gravity, int w, int h, Rect container, Rect outRect, int layoutDirection) {
        Gravity.apply(gravity, w, h, container, outRect, layoutDirection);
    }
}
