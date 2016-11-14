package defpackage;

import android.graphics.Rect;
import android.view.View;
import android.view.accessibility.AccessibilityNodeInfo;

/* compiled from: AccessibilityNodeInfoCompatIcs */
class gk {
    public static Object a() {
        return AccessibilityNodeInfo.obtain();
    }

    public static Object a(View source) {
        return AccessibilityNodeInfo.obtain(source);
    }

    public static Object a(Object info) {
        return AccessibilityNodeInfo.obtain((AccessibilityNodeInfo) info);
    }

    public static void a(Object info, int action) {
        ((AccessibilityNodeInfo) info).addAction(action);
    }

    public static void a(Object info, View child) {
        ((AccessibilityNodeInfo) info).addChild(child);
    }

    public static int b(Object info) {
        return ((AccessibilityNodeInfo) info).getActions();
    }

    public static void a(Object info, Rect outBounds) {
        ((AccessibilityNodeInfo) info).getBoundsInParent(outBounds);
    }

    public static void b(Object info, Rect outBounds) {
        ((AccessibilityNodeInfo) info).getBoundsInScreen(outBounds);
    }

    public static CharSequence c(Object info) {
        return ((AccessibilityNodeInfo) info).getClassName();
    }

    public static CharSequence d(Object info) {
        return ((AccessibilityNodeInfo) info).getContentDescription();
    }

    public static CharSequence e(Object info) {
        return ((AccessibilityNodeInfo) info).getPackageName();
    }

    public static CharSequence f(Object info) {
        return ((AccessibilityNodeInfo) info).getText();
    }

    public static boolean g(Object info) {
        return ((AccessibilityNodeInfo) info).isCheckable();
    }

    public static boolean h(Object info) {
        return ((AccessibilityNodeInfo) info).isChecked();
    }

    public static boolean i(Object info) {
        return ((AccessibilityNodeInfo) info).isClickable();
    }

    public static boolean j(Object info) {
        return ((AccessibilityNodeInfo) info).isEnabled();
    }

    public static boolean k(Object info) {
        return ((AccessibilityNodeInfo) info).isFocusable();
    }

    public static boolean l(Object info) {
        return ((AccessibilityNodeInfo) info).isFocused();
    }

    public static boolean m(Object info) {
        return ((AccessibilityNodeInfo) info).isLongClickable();
    }

    public static boolean n(Object info) {
        return ((AccessibilityNodeInfo) info).isPassword();
    }

    public static boolean o(Object info) {
        return ((AccessibilityNodeInfo) info).isScrollable();
    }

    public static boolean p(Object info) {
        return ((AccessibilityNodeInfo) info).isSelected();
    }

    public static void c(Object info, Rect bounds) {
        ((AccessibilityNodeInfo) info).setBoundsInParent(bounds);
    }

    public static void d(Object info, Rect bounds) {
        ((AccessibilityNodeInfo) info).setBoundsInScreen(bounds);
    }

    public static void a(Object info, CharSequence className) {
        ((AccessibilityNodeInfo) info).setClassName(className);
    }

    public static void a(Object info, boolean clickable) {
        ((AccessibilityNodeInfo) info).setClickable(clickable);
    }

    public static void b(Object info, CharSequence contentDescription) {
        ((AccessibilityNodeInfo) info).setContentDescription(contentDescription);
    }

    public static void b(Object info, boolean enabled) {
        ((AccessibilityNodeInfo) info).setEnabled(enabled);
    }

    public static void c(Object info, boolean focusable) {
        ((AccessibilityNodeInfo) info).setFocusable(focusable);
    }

    public static void d(Object info, boolean focused) {
        ((AccessibilityNodeInfo) info).setFocused(focused);
    }

    public static void e(Object info, boolean longClickable) {
        ((AccessibilityNodeInfo) info).setLongClickable(longClickable);
    }

    public static void c(Object info, CharSequence packageName) {
        ((AccessibilityNodeInfo) info).setPackageName(packageName);
    }

    public static void b(Object info, View parent) {
        ((AccessibilityNodeInfo) info).setParent(parent);
    }

    public static void f(Object info, boolean scrollable) {
        ((AccessibilityNodeInfo) info).setScrollable(scrollable);
    }

    public static void g(Object info, boolean selected) {
        ((AccessibilityNodeInfo) info).setSelected(selected);
    }

    public static void c(Object info, View source) {
        ((AccessibilityNodeInfo) info).setSource(source);
    }

    public static void d(Object info, CharSequence text) {
        ((AccessibilityNodeInfo) info).setText(text);
    }

    public static void q(Object info) {
        ((AccessibilityNodeInfo) info).recycle();
    }
}
