package defpackage;

import android.view.View;
import android.view.animation.Interpolator;
import java.util.WeakHashMap;

/* compiled from: ViewPropertyAnimatorCompat */
class fv$a implements fv$g {
    WeakHashMap<View, Runnable> a = null;

    fv$a() {
    }

    public void a(fv vpa, View view, long value) {
    }

    public void a(fv vpa, View view, float value) {
        e(vpa, view);
    }

    public void b(fv vpa, View view, float value) {
        e(vpa, view);
    }

    public void c(fv vpa, View view, float value) {
        e(vpa, view);
    }

    public long a(fv vpa, View view) {
        return 0;
    }

    public void a(fv vpa, View view, Interpolator value) {
    }

    public void b(fv vpa, View view, long value) {
    }

    public void b(fv vpa, View view) {
        e(vpa, view);
    }

    public void c(fv vpa, View view) {
        a(view);
        d(vpa, view);
    }

    public void a(fv vpa, View view, fz listener) {
        view.setTag(2113929216, listener);
    }

    public void a(fv vpa, View view, gb listener) {
    }

    private void d(fv vpa, View view) {
        fz listenerTag = view.getTag(2113929216);
        fz listener = null;
        if (listenerTag instanceof fz) {
            listener = listenerTag;
        }
        Runnable startAction = vpa.c;
        Runnable endAction = vpa.d;
        vpa.c = null;
        vpa.d = null;
        if (startAction != null) {
            startAction.run();
        }
        if (listener != null) {
            listener.onAnimationStart(view);
            listener.onAnimationEnd(view);
        }
        if (endAction != null) {
            endAction.run();
        }
        if (this.a != null) {
            this.a.remove(view);
        }
    }

    private void a(View view) {
        if (this.a != null) {
            Runnable starter = (Runnable) this.a.get(view);
            if (starter != null) {
                view.removeCallbacks(starter);
            }
        }
    }

    private void e(fv vpa, View view) {
        Runnable runnable = null;
        if (this.a != null) {
            runnable = (Runnable) this.a.get(view);
        }
        if (runnable == null) {
            runnable = new fv$a$a(this, vpa, view, null);
            if (this.a == null) {
                this.a = new WeakHashMap();
            }
            this.a.put(view, runnable);
        }
        view.removeCallbacks(runnable);
        view.post(runnable);
    }
}
