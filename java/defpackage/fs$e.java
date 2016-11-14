package defpackage;

import android.view.View;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;

/* compiled from: ViewParentCompat */
class fs$e implements fs$b {
    fs$e() {
    }

    public boolean a(ViewParent parent, View child, AccessibilityEvent event) {
        if (child == null) {
            return false;
        }
        ((AccessibilityManager) child.getContext().getSystemService("accessibility")).sendAccessibilityEvent(event);
        return true;
    }

    public boolean a(ViewParent parent, View child, View target, int nestedScrollAxes) {
        if (parent instanceof es) {
            return ((es) parent).onStartNestedScroll(child, target, nestedScrollAxes);
        }
        return false;
    }

    public void b(ViewParent parent, View child, View target, int nestedScrollAxes) {
        if (parent instanceof es) {
            ((es) parent).onNestedScrollAccepted(child, target, nestedScrollAxes);
        }
    }

    public void a(ViewParent parent, View target) {
        if (parent instanceof es) {
            ((es) parent).onStopNestedScroll(target);
        }
    }

    public void a(ViewParent parent, View target, int dxConsumed, int dyConsumed, int dxUnconsumed, int dyUnconsumed) {
        if (parent instanceof es) {
            ((es) parent).onNestedScroll(target, dxConsumed, dyConsumed, dxUnconsumed, dyUnconsumed);
        }
    }

    public void a(ViewParent parent, View target, int dx, int dy, int[] consumed) {
        if (parent instanceof es) {
            ((es) parent).onNestedPreScroll(target, dx, dy, consumed);
        }
    }

    public boolean a(ViewParent parent, View target, float velocityX, float velocityY, boolean consumed) {
        if (parent instanceof es) {
            return ((es) parent).onNestedFling(target, velocityX, velocityY, consumed);
        }
        return false;
    }

    public boolean a(ViewParent parent, View target, float velocityX, float velocityY) {
        if (parent instanceof es) {
            return ((es) parent).onNestedPreFling(target, velocityX, velocityY);
        }
        return false;
    }
}
