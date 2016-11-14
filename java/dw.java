/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.os.Build
 *  android.os.Build$VERSION
 *  android.os.Handler
 *  android.os.Looper
 *  android.os.Message
 *  android.view.GestureDetector
 *  android.view.GestureDetector$OnDoubleTapListener
 *  android.view.GestureDetector$OnGestureListener
 *  android.view.MotionEvent
 *  android.view.VelocityTracker
 *  android.view.ViewConfiguration
 *  java.lang.IllegalArgumentException
 *  java.lang.Math
 *  java.lang.Object
 *  java.lang.RuntimeException
 *  java.lang.String
 */
import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.ViewConfiguration;

public final class dw {
    private final a a;

    public dw(Context context, GestureDetector.OnGestureListener onGestureListener) {
        super(context, onGestureListener, null);
    }

    public dw(Context context, GestureDetector.OnGestureListener onGestureListener, Handler handler) {
        if (Build.VERSION.SDK_INT > 17) {
            this.a = new c(context, onGestureListener, handler);
            return;
        }
        this.a = new b(context, onGestureListener, handler);
    }

    public boolean a(MotionEvent motionEvent) {
        return this.a.a(motionEvent);
    }

    static interface a {
        public boolean a(MotionEvent var1);
    }

    static class b
    implements dw$a {
        private static final int e = ViewConfiguration.getLongPressTimeout();
        private static final int f = ViewConfiguration.getTapTimeout();
        private static final int g = ViewConfiguration.getDoubleTapTimeout();
        private int a;
        private int b;
        private int c;
        private int d;
        private final Handler h;
        private final GestureDetector.OnGestureListener i;
        private GestureDetector.OnDoubleTapListener j;
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

        /*
         * Enabled aggressive block sorting
         */
        public b(Context context, GestureDetector.OnGestureListener onGestureListener, Handler handler) {
            this.h = handler != null ? new a((b)this, handler) : new a((b)this);
            this.i = onGestureListener;
            if (onGestureListener instanceof GestureDetector.OnDoubleTapListener) {
                this.a((GestureDetector.OnDoubleTapListener)onGestureListener);
            }
            super.a(context);
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

        private void a(Context context) {
            if (context == null) {
                throw new IllegalArgumentException("Context must not be null");
            }
            if (this.i == null) {
                throw new IllegalArgumentException("OnGestureListener must not be null");
            }
            this.w = true;
            ViewConfiguration viewConfiguration = ViewConfiguration.get((Context)context);
            int n2 = viewConfiguration.getScaledTouchSlop();
            int n3 = viewConfiguration.getScaledDoubleTapSlop();
            this.c = viewConfiguration.getScaledMinimumFlingVelocity();
            this.d = viewConfiguration.getScaledMaximumFlingVelocity();
            this.a = n2 * n2;
            this.b = n3 * n3;
        }

        /*
         * Enabled aggressive block sorting
         */
        private boolean a(MotionEvent motionEvent, MotionEvent motionEvent2, MotionEvent motionEvent3) {
            int n2;
            int n3;
            if (!this.o || motionEvent3.getEventTime() - motionEvent2.getEventTime() > (long)g || (n3 = (int)motionEvent.getX() - (int)motionEvent3.getX()) * n3 + (n2 = (int)motionEvent.getY() - (int)motionEvent3.getY()) * n2 >= this.b) {
                return false;
            }
            return true;
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

        private void c() {
            this.h.removeMessages(3);
            this.l = false;
            this.m = true;
            this.i.onLongPress(this.p);
        }

        public void a(GestureDetector.OnDoubleTapListener onDoubleTapListener) {
            this.j = onDoubleTapListener;
        }

        /*
         * Unable to fully structure code
         * Enabled aggressive block sorting
         * Lifted jumps to return sites
         */
        @Override
        public boolean a(MotionEvent var1) {
            var2_2 = var1.getAction();
            if (this.x == null) {
                this.x = VelocityTracker.obtain();
            }
            this.x.addMovement(var1);
            var3_3 = (var2_2 & 255) == 6;
            var4_4 = var3_3 != false ? em.b(var1) : -1;
            var5_5 = 0.0f;
            var6_6 = 0.0f;
            var7_7 = em.c(var1);
            for (var8_8 = 0; var8_8 < var7_7; ++var8_8) {
                if (var4_4 == var8_8) continue;
                var5_5 += em.c(var1, var8_8);
                var6_6 += em.d(var1, var8_8);
            }
            var9_9 = var3_3 != false ? var7_7 - 1 : var7_7;
            var10_10 = var5_5 / (float)var9_9;
            var11_11 = var6_6 / (float)var9_9;
            var12_12 = var2_2 & 255;
            var13_13 = false;
            switch (var12_12) {
                default: {
                    return var13_13;
                }
                case 5: {
                    this.s = var10_10;
                    this.u = var10_10;
                    this.t = var11_11;
                    this.v = var11_11;
                    super.b();
                    return false;
                }
                case 6: {
                    this.s = var10_10;
                    this.u = var10_10;
                    this.t = var11_11;
                    this.v = var11_11;
                    this.x.computeCurrentVelocity(1000, (float)this.d);
                    var37_14 = em.b(var1);
                    var38_15 = em.b(var1, var37_14);
                    var39_16 = ez.a(this.x, var38_15);
                    var40_17 = ez.b(this.x, var38_15);
                    var41_18 = 0;
                    do {
                        var42_20 = var41_18;
                        var13_13 = false;
                        if (var42_20 >= var7_7) return var13_13;
                        if (var41_18 != var37_14 && var39_16 * ez.a(this.x, var43_19 = em.b(var1, var41_18)) + var40_17 * ez.b(this.x, var43_19) < 0.0f) {
                            this.x.clear();
                            return false;
                        }
                        ++var41_18;
                    } while (true);
                }
                case 0: {
                    var31_21 = this.j;
                    var32_22 = false;
                    if (var31_21 != null) {
                        var35_23 = this.h.hasMessages(3);
                        if (var35_23) {
                            this.h.removeMessages(3);
                        }
                        if (this.p != null && this.q != null && var35_23 && super.a(this.p, this.q, var1)) {
                            this.r = true;
                            var32_22 = false | this.j.onDoubleTap(this.p) | this.j.onDoubleTapEvent(var1);
                        } else {
                            this.h.sendEmptyMessageDelayed(3, (long)b.g);
                            var32_22 = false;
                        }
                    }
                    this.s = var10_10;
                    this.u = var10_10;
                    this.t = var11_11;
                    this.v = var11_11;
                    if (this.p != null) {
                        this.p.recycle();
                    }
                    this.p = MotionEvent.obtain((MotionEvent)var1);
                    this.n = true;
                    this.o = true;
                    this.k = true;
                    this.m = false;
                    this.l = false;
                    if (this.w) {
                        this.h.removeMessages(2);
                        this.h.sendEmptyMessageAtTime(2, this.p.getDownTime() + (long)b.f + (long)b.e);
                    }
                    this.h.sendEmptyMessageAtTime(1, this.p.getDownTime() + (long)b.f);
                    return var32_22 | this.i.onDown(var1);
                }
                case 2: {
                    var22_24 = this.m;
                    var13_13 = false;
                    if (var22_24 != false) return var13_13;
                    var23_25 = this.s - var10_10;
                    var24_26 = this.t - var11_11;
                    if (this.r) {
                        return false | this.j.onDoubleTapEvent(var1);
                    }
                    if (this.n) {
                        var27_27 = (int)(var10_10 - this.u);
                        var28_28 = (int)(var11_11 - this.v);
                        var29_29 = var27_27 * var27_27 + var28_28 * var28_28;
                        var30_30 = this.a;
                        var13_13 = false;
                        if (var29_29 > var30_30) {
                            var13_13 = this.i.onScroll(this.p, var1, var23_25, var24_26);
                            this.s = var10_10;
                            this.t = var11_11;
                            this.n = false;
                            this.h.removeMessages(3);
                            this.h.removeMessages(1);
                            this.h.removeMessages(2);
                        }
                        if (var29_29 <= this.a) return var13_13;
                        this.o = false;
                        return var13_13;
                    }
                    if (Math.abs((float)var23_25) < 1.0f) {
                        var26_31 = Math.abs((float)var24_26) FCMPL 1.0f;
                        var13_13 = false;
                        if (var26_31 < 0) return var13_13;
                    }
                    var25_32 = this.i.onScroll(this.p, var1, var23_25, var24_26);
                    this.s = var10_10;
                    this.t = var11_11;
                    return var25_32;
                }
                case 1: {
                    this.k = false;
                    var14_33 = MotionEvent.obtain((MotionEvent)var1);
                    if (!this.r) ** GOTO lbl119
                    var19_34 = false | this.j.onDoubleTapEvent(var1);
                    ** GOTO lbl139
lbl119: // 1 sources:
                    if (!this.m) ** GOTO lbl124
                    this.h.removeMessages(3);
                    this.m = false;
                    var19_34 = false;
                    ** GOTO lbl139
lbl124: // 1 sources:
                    if (!this.n) ** GOTO lbl129
                    var19_34 = this.i.onSingleTapUp(var1);
                    if (this.l && this.j != null) {
                        this.j.onSingleTapConfirmed(var1);
                    }
                    ** GOTO lbl139
lbl129: // 1 sources:
                    var15_35 = this.x;
                    var16_36 = em.b(var1, 0);
                    var15_35.computeCurrentVelocity(1000, (float)this.d);
                    var17_37 = ez.b(var15_35, var16_36);
                    var18_38 = ez.a(var15_35, var16_36);
                    if (Math.abs((float)var17_37) > (float)this.c) ** GOTO lbl-1000
                    var20_39 = Math.abs((float)var18_38) FCMPL (float)this.c;
                    var19_34 = false;
                    if (var20_39 > 0) lbl-1000: // 2 sources:
                    {
                        var19_34 = this.i.onFling(this.p, var1, var18_38, var17_37);
                    }
lbl139: // 6 sources:
                    if (this.q != null) {
                        this.q.recycle();
                    }
                    this.q = var14_33;
                    if (this.x != null) {
                        this.x.recycle();
                        this.x = null;
                    }
                    this.r = false;
                    this.l = false;
                    this.h.removeMessages(1);
                    this.h.removeMessages(2);
                    return var19_34;
                }
                case 3: 
            }
            super.a();
            return false;
        }

        class a
        extends Handler {
            final /* synthetic */ b a;

            a(b b2) {
                this.a = b2;
            }

            a(b b2, Handler handler) {
                this.a = b2;
                super(handler.getLooper());
            }

            /*
             * Enabled aggressive block sorting
             */
            public void handleMessage(Message message) {
                switch (message.what) {
                    default: {
                        throw new RuntimeException("Unknown message " + (Object)message);
                    }
                    case 1: {
                        this.a.i.onShowPress(this.a.p);
                        return;
                    }
                    case 2: {
                        this.a.c();
                        return;
                    }
                    case 3: {
                        if (this.a.j == null) return;
                        if (!this.a.k) {
                            this.a.j.onSingleTapConfirmed(this.a.p);
                            return;
                        } else {
                            break;
                        }
                    }
                }
                this.a.l = true;
            }
        }

    }

    static class c
    implements a {
        private final GestureDetector a;

        public c(Context context, GestureDetector.OnGestureListener onGestureListener, Handler handler) {
            this.a = new GestureDetector(context, onGestureListener, handler);
        }

        @Override
        public boolean a(MotionEvent motionEvent) {
            return this.a.onTouchEvent(motionEvent);
        }
    }

}

