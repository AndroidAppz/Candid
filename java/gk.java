/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.graphics.Rect
 *  android.view.View
 *  android.view.accessibility.AccessibilityNodeInfo
 *  java.lang.CharSequence
 *  java.lang.Object
 */
import android.graphics.Rect;
import android.view.View;
import android.view.accessibility.AccessibilityNodeInfo;

class gk {
    public static Object a() {
        return AccessibilityNodeInfo.obtain();
    }

    public static Object a(View view) {
        return AccessibilityNodeInfo.obtain((View)view);
    }

    public static Object a(Object object) {
        return AccessibilityNodeInfo.obtain((AccessibilityNodeInfo)((AccessibilityNodeInfo)object));
    }

    public static void a(Object object, int n2) {
        ((AccessibilityNodeInfo)object).addAction(n2);
    }

    public static void a(Object object, Rect rect) {
        ((AccessibilityNodeInfo)object).getBoundsInParent(rect);
    }

    public static void a(Object object, View view) {
        ((AccessibilityNodeInfo)object).addChild(view);
    }

    public static void a(Object object, CharSequence charSequence) {
        ((AccessibilityNodeInfo)object).setClassName(charSequence);
    }

    public static void a(Object object, boolean bl2) {
        ((AccessibilityNodeInfo)object).setClickable(bl2);
    }

    public static int b(Object object) {
        return ((AccessibilityNodeInfo)object).getActions();
    }

    public static void b(Object object, Rect rect) {
        ((AccessibilityNodeInfo)object).getBoundsInScreen(rect);
    }

    public static void b(Object object, View view) {
        ((AccessibilityNodeInfo)object).setParent(view);
    }

    public static void b(Object object, CharSequence charSequence) {
        ((AccessibilityNodeInfo)object).setContentDescription(charSequence);
    }

    public static void b(Object object, boolean bl2) {
        ((AccessibilityNodeInfo)object).setEnabled(bl2);
    }

    public static CharSequence c(Object object) {
        return ((AccessibilityNodeInfo)object).getClassName();
    }

    public static void c(Object object, Rect rect) {
        ((AccessibilityNodeInfo)object).setBoundsInParent(rect);
    }

    public static void c(Object object, View view) {
        ((AccessibilityNodeInfo)object).setSource(view);
    }

    public static void c(Object object, CharSequence charSequence) {
        ((AccessibilityNodeInfo)object).setPackageName(charSequence);
    }

    public static void c(Object object, boolean bl2) {
        ((AccessibilityNodeInfo)object).setFocusable(bl2);
    }

    public static CharSequence d(Object object) {
        return ((AccessibilityNodeInfo)object).getContentDescription();
    }

    public static void d(Object object, Rect rect) {
        ((AccessibilityNodeInfo)object).setBoundsInScreen(rect);
    }

    public static void d(Object object, CharSequence charSequence) {
        ((AccessibilityNodeInfo)object).setText(charSequence);
    }

    public static void d(Object object, boolean bl2) {
        ((AccessibilityNodeInfo)object).setFocused(bl2);
    }

    public static CharSequence e(Object object) {
        return ((AccessibilityNodeInfo)object).getPackageName();
    }

    public static void e(Object object, boolean bl2) {
        ((AccessibilityNodeInfo)object).setLongClickable(bl2);
    }

    public static CharSequence f(Object object) {
        return ((AccessibilityNodeInfo)object).getText();
    }

    public static void f(Object object, boolean bl2) {
        ((AccessibilityNodeInfo)object).setScrollable(bl2);
    }

    public static void g(Object object, boolean bl2) {
        ((AccessibilityNodeInfo)object).setSelected(bl2);
    }

    public static boolean g(Object object) {
        return ((AccessibilityNodeInfo)object).isCheckable();
    }

    public static boolean h(Object object) {
        return ((AccessibilityNodeInfo)object).isChecked();
    }

    public static boolean i(Object object) {
        return ((AccessibilityNodeInfo)object).isClickable();
    }

    public static boolean j(Object object) {
        return ((AccessibilityNodeInfo)object).isEnabled();
    }

    public static boolean k(Object object) {
        return ((AccessibilityNodeInfo)object).isFocusable();
    }

    public static boolean l(Object object) {
        return ((AccessibilityNodeInfo)object).isFocused();
    }

    public static boolean m(Object object) {
        return ((AccessibilityNodeInfo)object).isLongClickable();
    }

    public static boolean n(Object object) {
        return ((AccessibilityNodeInfo)object).isPassword();
    }

    public static boolean o(Object object) {
        return ((AccessibilityNodeInfo)object).isScrollable();
    }

    public static boolean p(Object object) {
        return ((AccessibilityNodeInfo)object).isSelected();
    }

    public static void q(Object object) {
        ((AccessibilityNodeInfo)object).recycle();
    }
}

