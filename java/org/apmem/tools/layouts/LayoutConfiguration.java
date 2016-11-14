package org.apmem.tools.layouts;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import defpackage.aoz$a;

class LayoutConfiguration {
    private int a = 0;
    private boolean b = false;
    private float c = 0.0f;
    private int d = 51;
    private int e = 0;

    public LayoutConfiguration(Context context, AttributeSet attributeSet) {
        TypedArray a = context.obtainStyledAttributes(attributeSet, aoz$a.FlowLayout);
        try {
            a(a.getInteger(aoz$a.FlowLayout_android_orientation, 0));
            a(a.getBoolean(aoz$a.FlowLayout_debugDraw, false));
            a(a.getFloat(aoz$a.FlowLayout_weightDefault, 0.0f));
            b(a.getInteger(aoz$a.FlowLayout_android_gravity, 0));
            c(a.getInteger(aoz$a.FlowLayout_layoutDirection, 0));
        } finally {
            a.recycle();
        }
    }

    public int a() {
        return this.a;
    }

    public void a(int orientation) {
        if (orientation == 1) {
            this.a = orientation;
        } else {
            this.a = 0;
        }
    }

    public boolean b() {
        return this.b;
    }

    public void a(boolean debugDraw) {
        this.b = debugDraw;
    }

    public float c() {
        return this.c;
    }

    public void a(float weightDefault) {
        this.c = Math.max(0.0f, weightDefault);
    }

    public int d() {
        return this.d;
    }

    public void b(int gravity) {
        this.d = gravity;
    }

    public int e() {
        return this.e;
    }

    public void c(int layoutDirection) {
        if (layoutDirection == 1) {
            this.e = layoutDirection;
        } else {
            this.e = 0;
        }
    }
}
