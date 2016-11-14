package defpackage;

import android.os.Build.VERSION;
import android.view.MotionEvent;

/* compiled from: MotionEventCompat */
public final class em {
    static final em$e a;

    static {
        if (VERSION.SDK_INT >= 12) {
            a = new em$d();
        } else if (VERSION.SDK_INT >= 9) {
            a = new em$c();
        } else if (VERSION.SDK_INT >= 5) {
            a = new em$b();
        } else {
            a = new em$a();
        }
    }

    public static int a(MotionEvent event) {
        return event.getAction() & 255;
    }

    public static int b(MotionEvent event) {
        return (event.getAction() & 65280) >> 8;
    }

    public static int a(MotionEvent event, int pointerId) {
        return a.a(event, pointerId);
    }

    public static int b(MotionEvent event, int pointerIndex) {
        return a.b(event, pointerIndex);
    }

    public static float c(MotionEvent event, int pointerIndex) {
        return a.c(event, pointerIndex);
    }

    public static float d(MotionEvent event, int pointerIndex) {
        return a.d(event, pointerIndex);
    }

    public static int c(MotionEvent event) {
        return a.a(event);
    }

    public static int d(MotionEvent event) {
        return a.b(event);
    }

    public static float e(MotionEvent event, int axis) {
        return a.e(event, axis);
    }
}
