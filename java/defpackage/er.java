package defpackage;

import android.view.View;
import android.view.ViewParent;

/* compiled from: NestedScrollingChildHelper */
public class er {
    private final View a;
    private ViewParent b;
    private boolean c;
    private int[] d;

    public er(View view) {
        this.a = view;
    }

    public void a(boolean enabled) {
        if (this.c) {
            fb.F(this.a);
        }
        this.c = enabled;
    }

    public boolean a() {
        return this.c;
    }

    public boolean b() {
        return this.b != null;
    }

    public boolean a(int axes) {
        if (b()) {
            return true;
        }
        if (a()) {
            View child = this.a;
            for (ViewParent p = this.a.getParent(); p != null; p = p.getParent()) {
                if (fs.a(p, child, this.a, axes)) {
                    this.b = p;
                    fs.b(p, child, this.a, axes);
                    return true;
                }
                if (p instanceof View) {
                    child = (View) p;
                }
            }
        }
        return false;
    }

    public void c() {
        if (this.b != null) {
            fs.a(this.b, this.a);
            this.b = null;
        }
    }

    public boolean a(int dxConsumed, int dyConsumed, int dxUnconsumed, int dyUnconsumed, int[] offsetInWindow) {
        if (a() && this.b != null) {
            if (dxConsumed != 0 || dyConsumed != 0 || dxUnconsumed != 0 || dyUnconsumed != 0) {
                int startX = 0;
                int startY = 0;
                if (offsetInWindow != null) {
                    this.a.getLocationInWindow(offsetInWindow);
                    startX = offsetInWindow[0];
                    startY = offsetInWindow[1];
                }
                fs.a(this.b, this.a, dxConsumed, dyConsumed, dxUnconsumed, dyUnconsumed);
                if (offsetInWindow != null) {
                    this.a.getLocationInWindow(offsetInWindow);
                    offsetInWindow[0] = offsetInWindow[0] - startX;
                    offsetInWindow[1] = offsetInWindow[1] - startY;
                }
                return true;
            } else if (offsetInWindow != null) {
                offsetInWindow[0] = 0;
                offsetInWindow[1] = 0;
            }
        }
        return false;
    }

    public boolean a(int dx, int dy, int[] consumed, int[] offsetInWindow) {
        if (!a() || this.b == null) {
            return false;
        }
        if (dx != 0 || dy != 0) {
            int startX = 0;
            int startY = 0;
            if (offsetInWindow != null) {
                this.a.getLocationInWindow(offsetInWindow);
                startX = offsetInWindow[0];
                startY = offsetInWindow[1];
            }
            if (consumed == null) {
                if (this.d == null) {
                    this.d = new int[2];
                }
                consumed = this.d;
            }
            consumed[0] = 0;
            consumed[1] = 0;
            fs.a(this.b, this.a, dx, dy, consumed);
            if (offsetInWindow != null) {
                this.a.getLocationInWindow(offsetInWindow);
                offsetInWindow[0] = offsetInWindow[0] - startX;
                offsetInWindow[1] = offsetInWindow[1] - startY;
            }
            if (consumed[0] == 0 && consumed[1] == 0) {
                return false;
            }
            return true;
        } else if (offsetInWindow == null) {
            return false;
        } else {
            offsetInWindow[0] = 0;
            offsetInWindow[1] = 0;
            return false;
        }
    }

    public boolean a(float velocityX, float velocityY, boolean consumed) {
        if (!a() || this.b == null) {
            return false;
        }
        return fs.a(this.b, this.a, velocityX, velocityY, consumed);
    }

    public boolean a(float velocityX, float velocityY) {
        if (!a() || this.b == null) {
            return false;
        }
        return fs.a(this.b, this.a, velocityX, velocityY);
    }
}
