package defpackage;

import android.os.Build.VERSION;
import android.view.View;

/* compiled from: ViewPropertyAnimatorCompat */
class fv$b$a implements fz {
    fv a;
    boolean b;

    fv$b$a(fv vpa) {
        this.a = vpa;
    }

    public void onAnimationStart(View view) {
        this.b = false;
        if (this.a.e >= 0) {
            fb.a(view, 2, null);
        }
        if (this.a.c != null) {
            Runnable startAction = this.a.c;
            this.a.c = null;
            startAction.run();
        }
        fz listenerTag = view.getTag(2113929216);
        fz listener = null;
        if (listenerTag instanceof fz) {
            listener = listenerTag;
        }
        if (listener != null) {
            listener.onAnimationStart(view);
        }
    }

    public void onAnimationEnd(View view) {
        if (this.a.e >= 0) {
            fb.a(view, this.a.e, null);
            this.a.e = -1;
        }
        if (VERSION.SDK_INT >= 16 || !this.b) {
            if (this.a.d != null) {
                Runnable endAction = this.a.d;
                this.a.d = null;
                endAction.run();
            }
            fz listenerTag = view.getTag(2113929216);
            fz listener = null;
            if (listenerTag instanceof fz) {
                listener = listenerTag;
            }
            if (listener != null) {
                listener.onAnimationEnd(view);
            }
            this.b = true;
        }
    }

    public void onAnimationCancel(View view) {
        fz listenerTag = view.getTag(2113929216);
        fz listener = null;
        if (listenerTag instanceof fz) {
            listener = listenerTag;
        }
        if (listener != null) {
            listener.onAnimationCancel(view);
        }
    }
}
