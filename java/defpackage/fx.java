package defpackage;

import android.view.View;

/* compiled from: ViewPropertyAnimatorCompatJB */
class fx {
    public static void a(View view, fz listener) {
        if (listener != null) {
            view.animate().setListener(new fx$1(listener, view));
        } else {
            view.animate().setListener(null);
        }
    }
}
