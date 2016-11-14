package defpackage;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

/* compiled from: SnackbarManager */
public class y {
    private static y a;
    private final Object b = new Object();
    private final Handler c = new Handler(Looper.getMainLooper(), new y$1(this));
    private y$b d;
    private y$b e;

    public static y a() {
        if (a == null) {
            a = new y();
        }
        return a;
    }

    private y() {
    }

    public void a(y$a callback, int event) {
        synchronized (this.b) {
            if (f(callback)) {
                a(this.d, event);
            } else if (g(callback)) {
                a(this.e, event);
            }
        }
    }

    public void a(y$a callback) {
        synchronized (this.b) {
            if (f(callback)) {
                this.d = null;
                if (this.e != null) {
                    b();
                }
            }
        }
    }

    public void b(y$a callback) {
        synchronized (this.b) {
            if (f(callback)) {
                a(this.d);
            }
        }
    }

    public void c(y$a callback) {
        synchronized (this.b) {
            if (f(callback)) {
                this.c.removeCallbacksAndMessages(this.d);
            }
        }
    }

    public void d(y$a callback) {
        synchronized (this.b) {
            if (f(callback)) {
                a(this.d);
            }
        }
    }

    public boolean e(y$a callback) {
        boolean z;
        synchronized (this.b) {
            z = f(callback) || g(callback);
        }
        return z;
    }

    private void b() {
        if (this.e != null) {
            this.d = this.e;
            this.e = null;
            y$a callback = (y$a) this.d.a.get();
            if (callback != null) {
                callback.a();
            } else {
                this.d = null;
            }
        }
    }

    private boolean a(y$b record, int event) {
        y$a callback = (y$a) record.a.get();
        if (callback == null) {
            return false;
        }
        this.c.removeCallbacksAndMessages(record);
        callback.a(event);
        return true;
    }

    private boolean f(y$a callback) {
        return this.d != null && this.d.a(callback);
    }

    private boolean g(y$a callback) {
        return this.e != null && this.e.a(callback);
    }

    private void a(y$b r) {
        if (r.b != -2) {
            int durationMs = 2750;
            if (r.b > 0) {
                durationMs = r.b;
            } else if (r.b == -1) {
                durationMs = 1500;
            }
            this.c.removeCallbacksAndMessages(r);
            this.c.sendMessageDelayed(Message.obtain(this.c, 0, r), (long) durationMs);
        }
    }

    private void b(y$b record) {
        synchronized (this.b) {
            if (this.d == record || this.e == record) {
                a(record, 2);
            }
        }
    }
}
