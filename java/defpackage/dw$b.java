package defpackage;

import android.content.Context;
import android.os.Handler;
import android.view.GestureDetector.OnDoubleTapListener;
import android.view.GestureDetector.OnGestureListener;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.ViewConfiguration;

/* compiled from: GestureDetectorCompat */
class dw$b implements dw$a {
    private static final int e = ViewConfiguration.getLongPressTimeout();
    private static final int f = ViewConfiguration.getTapTimeout();
    private static final int g = ViewConfiguration.getDoubleTapTimeout();
    private int a;
    private int b;
    private int c;
    private int d;
    private final Handler h;
    private final OnGestureListener i;
    private OnDoubleTapListener j;
    private boolean k;
    private boolean l;
    private boolean m;
    private boolean n;
    private boolean o;
    private MotionEvent p;
    private MotionEvent q;
    private boolean r;
    private float s;
    private float t;
    private float u;
    private float v;
    private boolean w;
    private VelocityTracker x;

    public dw$b(Context context, OnGestureListener listener, Handler handler) {
        if (handler != null) {
            this.h = new dw$b$a(this, handler);
        } else {
            this.h = new dw$b$a(this);
        }
        this.i = listener;
        if (listener instanceof OnDoubleTapListener) {
            a((OnDoubleTapListener) listener);
        }
        a(context);
    }

    private void a(Context context) {
        if (context == null) {
            throw new IllegalArgumentException("Context must not be null");
        } else if (this.i == null) {
            throw new IllegalArgumentException("OnGestureListener must not be null");
        } else {
            this.w = true;
            ViewConfiguration configuration = ViewConfiguration.get(context);
            int touchSlop = configuration.getScaledTouchSlop();
            int doubleTapSlop = configuration.getScaledDoubleTapSlop();
            this.c = configuration.getScaledMinimumFlingVelocity();
            this.d = configuration.getScaledMaximumFlingVelocity();
            this.a = touchSlop * touchSlop;
            this.b = doubleTapSlop * doubleTapSlop;
        }
    }

    public void a(OnDoubleTapListener onDoubleTapListener) {
        this.j = onDoubleTapListener;
    }

    public boolean a(MotionEvent ev) {
        int i;
        int div;
        int action = ev.getAction();
        if (this.x == null) {
            this.x = VelocityTracker.obtain();
        }
        this.x.addMovement(ev);
        boolean pointerUp = (action & 255) == 6;
        int skipIndex = pointerUp ? em.b(ev) : -1;
        float sumX = 0.0f;
        float sumY = 0.0f;
        int count = em.c(ev);
        for (i = 0; i < count; i++) {
            if (skipIndex != i) {
                sumX += em.c(ev, i);
                sumY += em.d(ev, i);
            }
        }
        if (pointerUp) {
            div = count - 1;
        } else {
            div = count;
        }
        float focusX = sumX / ((float) div);
        float focusY = sumY / ((float) div);
        boolean handled = false;
        switch (action & 255) {
            case zu.GOOGLE_PLAY_SERVICES_VERSION_CODE /*?: ONE_ARG  (wrap: int
  0x0001: INVOKE  (r0_0 int) =  zu.zzqZ():int type: STATIC)*/:
                if (this.j != null) {
                    boolean hadTapMessage = this.h.hasMessages(3);
                    if (hadTapMessage) {
                        this.h.removeMessages(3);
                    }
                    if (!(this.p == null || this.q == null || !hadTapMessage)) {
                        if (a(this.p, this.q, ev)) {
                            this.r = true;
                            handled = (false | this.j.onDoubleTap(this.p)) | this.j.onDoubleTapEvent(ev);
                        }
                    }
                    this.h.sendEmptyMessageDelayed(3, (long) g);
                }
                this.s = focusX;
                this.u = focusX;
                this.t = focusY;
                this.v = focusY;
                if (this.p != null) {
                    this.p.recycle();
                }
                this.p = MotionEvent.obtain(ev);
                this.n = true;
                this.o = true;
                this.k = true;
                this.m = false;
                this.l = false;
                if (this.w) {
                    this.h.removeMessages(2);
                    this.h.sendEmptyMessageAtTime(2, (this.p.getDownTime() + ((long) f)) + ((long) e));
                }
                this.h.sendEmptyMessageAtTime(1, this.p.getDownTime() + ((long) f));
                return handled | this.i.onDown(ev);
            case um$h.com_facebook_profile_picture_view_com_facebook_is_cropped /*1*/:
                this.k = false;
                MotionEvent currentUpEvent = MotionEvent.obtain(ev);
                if (this.r) {
                    handled = false | this.j.onDoubleTapEvent(ev);
                } else if (this.m) {
                    this.h.removeMessages(3);
                    this.m = false;
                } else if (this.n) {
                    handled = this.i.onSingleTapUp(ev);
                    if (this.l && this.j != null) {
                        this.j.onSingleTapConfirmed(ev);
                    }
                } else {
                    VelocityTracker velocityTracker = this.x;
                    int pointerId = em.b(ev, 0);
                    velocityTracker.computeCurrentVelocity(1000, (float) this.d);
                    float velocityY = ez.b(velocityTracker, pointerId);
                    float velocityX = ez.a(velocityTracker, pointerId);
                    if (Math.abs(velocityY) > ((float) this.c) || Math.abs(velocityX) > ((float) this.c)) {
                        handled = this.i.onFling(this.p, ev, velocityX, velocityY);
                    }
                }
                if (this.q != null) {
                    this.q.recycle();
                }
                this.q = currentUpEvent;
                if (this.x != null) {
                    this.x.recycle();
                    this.x = null;
                }
                this.r = false;
                this.l = false;
                this.h.removeMessages(1);
                this.h.removeMessages(2);
                return handled;
            case um$h.com_facebook_login_view_com_facebook_logout_text /*2*/:
                if (this.m) {
                    return false;
                }
                float scrollX = this.s - focusX;
                float scrollY = this.t - focusY;
                if (this.r) {
                    return false | this.j.onDoubleTapEvent(ev);
                }
                if (this.n) {
                    int deltaX = (int) (focusX - this.u);
                    int deltaY = (int) (focusY - this.v);
                    int distance = (deltaX * deltaX) + (deltaY * deltaY);
                    if (distance > this.a) {
                        handled = this.i.onScroll(this.p, ev, scrollX, scrollY);
                        this.s = focusX;
                        this.t = focusY;
                        this.n = false;
                        this.h.removeMessages(3);
                        this.h.removeMessages(1);
                        this.h.removeMessages(2);
                    }
                    if (distance <= this.a) {
                        return handled;
                    }
                    this.o = false;
                    return handled;
                } else if (Math.abs(scrollX) < 1.0f && Math.abs(scrollY) < 1.0f) {
                    return false;
                } else {
                    handled = this.i.onScroll(this.p, ev, scrollX, scrollY);
                    this.s = focusX;
                    this.t = focusY;
                    return handled;
                }
            case um$h.com_facebook_login_view_com_facebook_tooltip_mode /*3*/:
                a();
                return false;
            case um$h.com_facebook_like_view_com_facebook_horizontal_alignment /*5*/:
                this.s = focusX;
                this.u = focusX;
                this.t = focusY;
                this.v = focusY;
                b();
                return false;
            case um$h.CardView_cardUseCompatPadding /*6*/:
                this.s = focusX;
                this.u = focusX;
                this.t = focusY;
                this.v = focusY;
                this.x.computeCurrentVelocity(1000, (float) this.d);
                int upIndex = em.b(ev);
                int id1 = em.b(ev, upIndex);
                float x1 = ez.a(this.x, id1);
                float y1 = ez.b(this.x, id1);
                for (i = 0; i < count; i++) {
                    if (i != upIndex) {
                        int id2 = em.b(ev, i);
                        if ((x1 * ez.a(this.x, id2)) + (y1 * ez.b(this.x, id2)) < 0.0f) {
                            this.x.clear();
                            return false;
                        }
                    }
                }
                return false;
            default:
                return false;
        }
    }

    private void a() {
        this.h.removeMessages(1);
        this.h.removeMessages(2);
        this.h.removeMessages(3);
        this.x.recycle();
        this.x = null;
        this.r = false;
        this.k = false;
        this.n = false;
        this.o = false;
        this.l = false;
        if (this.m) {
            this.m = false;
        }
    }

    private void b() {
        this.h.removeMessages(1);
        this.h.removeMessages(2);
        this.h.removeMessages(3);
        this.r = false;
        this.n = false;
        this.o = false;
        this.l = false;
        if (this.m) {
            this.m = false;
        }
    }

    private boolean a(MotionEvent firstDown, MotionEvent firstUp, MotionEvent secondDown) {
        if (!this.o || secondDown.getEventTime() - firstUp.getEventTime() > ((long) g)) {
            return false;
        }
        int deltaX = ((int) firstDown.getX()) - ((int) secondDown.getX());
        int deltaY = ((int) firstDown.getY()) - ((int) secondDown.getY());
        if ((deltaX * deltaX) + (deltaY * deltaY) < this.b) {
            return true;
        }
        return false;
    }

    private void c() {
        this.h.removeMessages(3);
        this.l = false;
        this.m = true;
        this.i.onLongPress(this.p);
    }
}
