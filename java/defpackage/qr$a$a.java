package defpackage;

import android.util.Log;
import android.view.ViewTreeObserver.OnPreDrawListener;
import java.lang.ref.WeakReference;

/* compiled from: ViewTarget */
class qr$a$a implements OnPreDrawListener {
    private final WeakReference<qr$a> a;

    public qr$a$a(qr$a sizeDeterminer) {
        this.a = new WeakReference(sizeDeterminer);
    }

    public boolean onPreDraw() {
        if (Log.isLoggable("ViewTarget", 2)) {
            Log.v("ViewTarget", "OnGlobalLayoutListener called listener=" + this);
        }
        qr$a sizeDeterminer = (qr$a) this.a.get();
        if (sizeDeterminer != null) {
            sizeDeterminer.a();
        }
        return true;
    }
}
