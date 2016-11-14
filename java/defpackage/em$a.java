package defpackage;

import android.view.MotionEvent;

/* compiled from: MotionEventCompat */
class em$a implements em$e {
    em$a() {
    }

    public int a(MotionEvent event, int pointerId) {
        if (pointerId == 0) {
            return 0;
        }
        return -1;
    }

    public int b(MotionEvent event, int pointerIndex) {
        if (pointerIndex == 0) {
            return 0;
        }
        throw new IndexOutOfBoundsException("Pre-Eclair does not support multiple pointers");
    }

    public float c(MotionEvent event, int pointerIndex) {
        if (pointerIndex == 0) {
            return event.getX();
        }
        throw new IndexOutOfBoundsException("Pre-Eclair does not support multiple pointers");
    }

    public float d(MotionEvent event, int pointerIndex) {
        if (pointerIndex == 0) {
            return event.getY();
        }
        throw new IndexOutOfBoundsException("Pre-Eclair does not support multiple pointers");
    }

    public int a(MotionEvent event) {
        return 1;
    }

    public int b(MotionEvent event) {
        return 0;
    }

    public float e(MotionEvent event, int axis) {
        return 0.0f;
    }
}
