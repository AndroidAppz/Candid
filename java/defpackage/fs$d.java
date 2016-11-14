package defpackage;

import android.view.View;
import android.view.ViewParent;

/* compiled from: ViewParentCompat */
class fs$d extends fs$c {
    fs$d() {
    }

    public boolean a(ViewParent parent, View child, View target, int nestedScrollAxes) {
        return fu.a(parent, child, target, nestedScrollAxes);
    }

    public void b(ViewParent parent, View child, View target, int nestedScrollAxes) {
        fu.b(parent, child, target, nestedScrollAxes);
    }

    public void a(ViewParent parent, View target) {
        fu.a(parent, target);
    }

    public void a(ViewParent parent, View target, int dxConsumed, int dyConsumed, int dxUnconsumed, int dyUnconsumed) {
        fu.a(parent, target, dxConsumed, dyConsumed, dxUnconsumed, dyUnconsumed);
    }

    public void a(ViewParent parent, View target, int dx, int dy, int[] consumed) {
        fu.a(parent, target, dx, dy, consumed);
    }

    public boolean a(ViewParent parent, View target, float velocityX, float velocityY, boolean consumed) {
        return fu.a(parent, target, velocityX, velocityY, consumed);
    }

    public boolean a(ViewParent parent, View target, float velocityX, float velocityY) {
        return fu.a(parent, target, velocityX, velocityY);
    }
}
