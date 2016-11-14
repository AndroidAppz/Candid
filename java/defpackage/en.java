package defpackage;

import android.view.MotionEvent;

/* compiled from: MotionEventCompatEclair */
class en {
    public static int a(MotionEvent event, int pointerId) {
        return event.findPointerIndex(pointerId);
    }

    public static int b(MotionEvent event, int pointerIndex) {
        return event.getPointerId(pointerIndex);
    }

    public static float c(MotionEvent event, int pointerIndex) {
        return event.getX(pointerIndex);
    }

    public static float d(MotionEvent event, int pointerIndex) {
        return event.getY(pointerIndex);
    }

    public static int a(MotionEvent event) {
        return event.getPointerCount();
    }
}
