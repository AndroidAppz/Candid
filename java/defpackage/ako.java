package defpackage;

import android.util.Log;

/* compiled from: DefaultLogger */
public class ako implements akx {
    private int a;

    public ako(int logLevel) {
        this.a = logLevel;
    }

    public ako() {
        this.a = 4;
    }

    public boolean a(String tag, int level) {
        return this.a <= level;
    }

    public void a(String tag, String text, Throwable throwable) {
        if (a(tag, 3)) {
            Log.d(tag, text, throwable);
        }
    }

    public void b(String tag, String text, Throwable throwable) {
        if (a(tag, 2)) {
            Log.v(tag, text, throwable);
        }
    }

    public void c(String tag, String text, Throwable throwable) {
        if (a(tag, 4)) {
            Log.i(tag, text, throwable);
        }
    }

    public void d(String tag, String text, Throwable throwable) {
        if (a(tag, 5)) {
            Log.w(tag, text, throwable);
        }
    }

    public void e(String tag, String text, Throwable throwable) {
        if (a(tag, 6)) {
            Log.e(tag, text, throwable);
        }
    }

    public void a(String tag, String text) {
        a(tag, text, null);
    }

    public void b(String tag, String text) {
        b(tag, text, null);
    }

    public void c(String tag, String text) {
        c(tag, text, null);
    }

    public void d(String tag, String text) {
        d(tag, text, null);
    }

    public void e(String tag, String text) {
        e(tag, text, null);
    }

    public void a(int priority, String tag, String msg) {
        a(priority, tag, msg, false);
    }

    public void a(int priority, String tag, String msg, boolean forceLog) {
        if (forceLog || a(tag, priority)) {
            Log.println(priority, tag, msg);
        }
    }
}
