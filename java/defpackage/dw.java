package defpackage;

import android.content.Context;
import android.os.Build.VERSION;
import android.os.Handler;
import android.view.GestureDetector.OnGestureListener;
import android.view.MotionEvent;

/* compiled from: GestureDetectorCompat */
public final class dw {
    private final dw$a a;

    public dw(Context context, OnGestureListener listener) {
        this(context, listener, null);
    }

    public dw(Context context, OnGestureListener listener, Handler handler) {
        if (VERSION.SDK_INT > 17) {
            this.a = new dw$c(context, listener, handler);
        } else {
            this.a = new dw$b(context, listener, handler);
        }
    }

    public boolean a(MotionEvent event) {
        return this.a.a(event);
    }
}
