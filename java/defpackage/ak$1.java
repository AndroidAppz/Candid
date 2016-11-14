package defpackage;

import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.Callback;

/* compiled from: AnimatedVectorDrawableCompat */
class ak$1 implements Callback {
    final /* synthetic */ ak a;

    ak$1(ak akVar) {
        this.a = akVar;
    }

    public void invalidateDrawable(Drawable who) {
        this.a.invalidateSelf();
    }

    public void scheduleDrawable(Drawable who, Runnable what, long when) {
        this.a.scheduleSelf(what, when);
    }

    public void unscheduleDrawable(Drawable who, Runnable what) {
        this.a.unscheduleSelf(what);
    }
}
