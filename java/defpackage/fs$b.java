package defpackage;

import android.view.View;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;

/* compiled from: ViewParentCompat */
interface fs$b {
    void a(ViewParent viewParent, View view);

    void a(ViewParent viewParent, View view, int i, int i2, int i3, int i4);

    void a(ViewParent viewParent, View view, int i, int i2, int[] iArr);

    boolean a(ViewParent viewParent, View view, float f, float f2);

    boolean a(ViewParent viewParent, View view, float f, float f2, boolean z);

    boolean a(ViewParent viewParent, View view, View view2, int i);

    boolean a(ViewParent viewParent, View view, AccessibilityEvent accessibilityEvent);

    void b(ViewParent viewParent, View view, View view2, int i);
}
