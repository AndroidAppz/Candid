package defpackage;

import android.content.Context;
import android.os.Handler;
import android.view.GestureDetector;
import android.view.GestureDetector.OnGestureListener;
import android.view.MotionEvent;

/* compiled from: GestureDetectorCompat */
class dw$c implements dw$a {
    private final GestureDetector a;

    public dw$c(Context context, OnGestureListener listener, Handler handler) {
        this.a = new GestureDetector(context, listener, handler);
    }

    public boolean a(MotionEvent ev) {
        return this.a.onTouchEvent(ev);
    }
}
