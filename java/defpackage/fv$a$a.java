package defpackage;

import android.view.View;
import java.lang.ref.WeakReference;

/* compiled from: ViewPropertyAnimatorCompat */
class fv$a$a implements Runnable {
    WeakReference<View> a;
    fv b;
    final /* synthetic */ fv$a c;

    private fv$a$a(fv$a fv_a, fv vpa, View view) {
        this.c = fv_a;
        this.a = new WeakReference(view);
        this.b = vpa;
    }

    public void run() {
        View view = (View) this.a.get();
        if (view != null) {
            this.c.d(this.b, view);
        }
    }
}
