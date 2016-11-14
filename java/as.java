/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.TypedArray
 *  android.util.AttributeSet
 *  android.util.Log
 *  android.view.View
 *  android.view.View$MeasureSpec
 *  android.view.ViewGroup
 *  android.view.ViewGroup$LayoutParams
 *  android.view.ViewGroup$MarginLayoutParams
 *  java.lang.Float
 *  java.lang.Object
 *  java.lang.String
 */
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;

public class as {
    private final ViewGroup a;

    public as(ViewGroup viewGroup) {
        this.a = viewGroup;
    }

    /*
     * Enabled aggressive block sorting
     */
    public static a a(Context context, AttributeSet attributeSet) {
        float f2;
        float f3;
        float f4;
        float f5;
        float f6;
        float f7;
        float f8;
        float f9;
        float f10;
        TypedArray typedArray = context.obtainStyledAttributes(attributeSet, at.a.PercentLayout_Layout);
        float f11 = typedArray.getFraction(at.a.PercentLayout_Layout_layout_widthPercent, 1, 1, -1.0f);
        float f12 = f11 FCMPL -1.0f;
        a a2 = null;
        if (f12 != false) {
            if (Log.isLoggable((String)"PercentLayout", (int)2)) {
                Log.v((String)"PercentLayout", (String)("percent width: " + f11));
            }
            a2 = null;
            if (!false) {
                a2 = new a();
            }
            a2.a = f11;
        }
        if ((f7 = typedArray.getFraction(at.a.PercentLayout_Layout_layout_heightPercent, 1, 1, -1.0f)) != -1.0f) {
            if (Log.isLoggable((String)"PercentLayout", (int)2)) {
                Log.v((String)"PercentLayout", (String)("percent height: " + f7));
            }
            if (a2 == null) {
                a2 = new a();
            }
            a2.b = f7;
        }
        if ((f9 = typedArray.getFraction(at.a.PercentLayout_Layout_layout_marginPercent, 1, 1, -1.0f)) != -1.0f) {
            if (Log.isLoggable((String)"PercentLayout", (int)2)) {
                Log.v((String)"PercentLayout", (String)("percent margin: " + f9));
            }
            if (a2 == null) {
                a2 = new a();
            }
            a2.c = f9;
            a2.d = f9;
            a2.e = f9;
            a2.f = f9;
        }
        if ((f4 = typedArray.getFraction(at.a.PercentLayout_Layout_layout_marginLeftPercent, 1, 1, -1.0f)) != -1.0f) {
            if (Log.isLoggable((String)"PercentLayout", (int)2)) {
                Log.v((String)"PercentLayout", (String)("percent left margin: " + f4));
            }
            if (a2 == null) {
                a2 = new a();
            }
            a2.c = f4;
        }
        if ((f5 = typedArray.getFraction(at.a.PercentLayout_Layout_layout_marginTopPercent, 1, 1, -1.0f)) != -1.0f) {
            if (Log.isLoggable((String)"PercentLayout", (int)2)) {
                Log.v((String)"PercentLayout", (String)("percent top margin: " + f5));
            }
            if (a2 == null) {
                a2 = new a();
            }
            a2.d = f5;
        }
        if ((f10 = typedArray.getFraction(at.a.PercentLayout_Layout_layout_marginRightPercent, 1, 1, -1.0f)) != -1.0f) {
            if (Log.isLoggable((String)"PercentLayout", (int)2)) {
                Log.v((String)"PercentLayout", (String)("percent right margin: " + f10));
            }
            if (a2 == null) {
                a2 = new a();
            }
            a2.e = f10;
        }
        if ((f6 = typedArray.getFraction(at.a.PercentLayout_Layout_layout_marginBottomPercent, 1, 1, -1.0f)) != -1.0f) {
            if (Log.isLoggable((String)"PercentLayout", (int)2)) {
                Log.v((String)"PercentLayout", (String)("percent bottom margin: " + f6));
            }
            if (a2 == null) {
                a2 = new a();
            }
            a2.f = f6;
        }
        if ((f2 = typedArray.getFraction(at.a.PercentLayout_Layout_layout_marginStartPercent, 1, 1, -1.0f)) != -1.0f) {
            if (Log.isLoggable((String)"PercentLayout", (int)2)) {
                Log.v((String)"PercentLayout", (String)("percent start margin: " + f2));
            }
            if (a2 == null) {
                a2 = new a();
            }
            a2.g = f2;
        }
        if ((f3 = typedArray.getFraction(at.a.PercentLayout_Layout_layout_marginEndPercent, 1, 1, -1.0f)) != -1.0f) {
            if (Log.isLoggable((String)"PercentLayout", (int)2)) {
                Log.v((String)"PercentLayout", (String)("percent end margin: " + f3));
            }
            if (a2 == null) {
                a2 = new a();
            }
            a2.h = f3;
        }
        if ((f8 = typedArray.getFraction(at.a.PercentLayout_Layout_layout_aspectRatio, 1, 1, -1.0f)) != -1.0f) {
            if (Log.isLoggable((String)"PercentLayout", (int)2)) {
                Log.v((String)"PercentLayout", (String)("aspect ratio: " + f8));
            }
            if (a2 == null) {
                a2 = new a();
            }
            a2.i = f8;
        }
        typedArray.recycle();
        if (Log.isLoggable((String)"PercentLayout", (int)3)) {
            Log.d((String)"PercentLayout", (String)("constructed: " + a2));
        }
        return a2;
    }

    public static void a(ViewGroup.LayoutParams layoutParams, TypedArray typedArray, int n2, int n3) {
        layoutParams.width = typedArray.getLayoutDimension(n2, 0);
        layoutParams.height = typedArray.getLayoutDimension(n3, 0);
    }

    private static boolean a(View view, a a2) {
        if ((-16777216 & fb.k(view)) == 16777216 && a2.a >= 0.0f && a2.j.width == -2) {
            return true;
        }
        return false;
    }

    private static boolean b(View view, a a2) {
        if ((-16777216 & fb.l(view)) == 16777216 && a2.b >= 0.0f && a2.j.height == -2) {
            return true;
        }
        return false;
    }

    /*
     * Enabled aggressive block sorting
     */
    public void a() {
        int n2 = 0;
        int n3 = this.a.getChildCount();
        while (n2 < n3) {
            View view = this.a.getChildAt(n2);
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            if (Log.isLoggable((String)"PercentLayout", (int)3)) {
                Log.d((String)"PercentLayout", (String)("should restore " + (Object)view + " " + (Object)layoutParams));
            }
            if (layoutParams instanceof b) {
                a a2 = ((b)layoutParams).a();
                if (Log.isLoggable((String)"PercentLayout", (int)3)) {
                    Log.d((String)"PercentLayout", (String)("using " + a2));
                }
                if (a2 != null) {
                    if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                        a2.a((ViewGroup.MarginLayoutParams)layoutParams);
                    } else {
                        a2.a(layoutParams);
                    }
                }
            }
            ++n2;
        }
        return;
    }

    /*
     * Enabled aggressive block sorting
     */
    public void a(int n2, int n3) {
        if (Log.isLoggable((String)"PercentLayout", (int)3)) {
            Log.d((String)"PercentLayout", (String)("adjustChildren: " + (Object)this.a + " widthMeasureSpec: " + View.MeasureSpec.toString((int)n2) + " heightMeasureSpec: " + View.MeasureSpec.toString((int)n3)));
        }
        int n4 = View.MeasureSpec.getSize((int)n2);
        int n5 = View.MeasureSpec.getSize((int)n3);
        int n6 = 0;
        int n7 = this.a.getChildCount();
        while (n6 < n7) {
            View view = this.a.getChildAt(n6);
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            if (Log.isLoggable((String)"PercentLayout", (int)3)) {
                Log.d((String)"PercentLayout", (String)("should adjust " + (Object)view + " " + (Object)layoutParams));
            }
            if (layoutParams instanceof b) {
                a a2 = ((b)layoutParams).a();
                if (Log.isLoggable((String)"PercentLayout", (int)3)) {
                    Log.d((String)"PercentLayout", (String)("using " + a2));
                }
                if (a2 != null) {
                    if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                        a2.a(view, (ViewGroup.MarginLayoutParams)layoutParams, n4, n5);
                    } else {
                        a2.a(layoutParams, n4, n5);
                    }
                }
            }
            ++n6;
        }
        return;
    }

    public boolean b() {
        boolean bl2 = false;
        int n2 = this.a.getChildCount();
        for (int i2 = 0; i2 < n2; ++i2) {
            a a2;
            View view = this.a.getChildAt(i2);
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            if (Log.isLoggable((String)"PercentLayout", (int)3)) {
                Log.d((String)"PercentLayout", (String)("should handle measured state too small " + (Object)view + " " + (Object)layoutParams));
            }
            if (!(layoutParams instanceof b) || (a2 = ((b)layoutParams).a()) == null) continue;
            if (as.a(view, a2)) {
                bl2 = true;
                layoutParams.width = -2;
            }
            if (!as.b(view, a2)) continue;
            bl2 = true;
            layoutParams.height = -2;
        }
        if (Log.isLoggable((String)"PercentLayout", (int)3)) {
            Log.d((String)"PercentLayout", (String)("should trigger second measure pass: " + bl2));
        }
        return bl2;
    }

    public static class a {
        public float a = -1.0f;
        public float b = -1.0f;
        public float c = -1.0f;
        public float d = -1.0f;
        public float e = -1.0f;
        public float f = -1.0f;
        public float g = -1.0f;
        public float h = -1.0f;
        public float i;
        final c j = new c(0, 0);

        public void a(View view, ViewGroup.MarginLayoutParams marginLayoutParams, int n2, int n3) {
            this.a((ViewGroup.LayoutParams)marginLayoutParams, n2, n3);
            this.j.leftMargin = marginLayoutParams.leftMargin;
            this.j.topMargin = marginLayoutParams.topMargin;
            this.j.rightMargin = marginLayoutParams.rightMargin;
            this.j.bottomMargin = marginLayoutParams.bottomMargin;
            eh.a(this.j, eh.a(marginLayoutParams));
            eh.b(this.j, eh.b(marginLayoutParams));
            if (this.c >= 0.0f) {
                marginLayoutParams.leftMargin = (int)((float)n2 * this.c);
            }
            if (this.d >= 0.0f) {
                marginLayoutParams.topMargin = (int)((float)n3 * this.d);
            }
            if (this.e >= 0.0f) {
                marginLayoutParams.rightMargin = (int)((float)n2 * this.e);
            }
            if (this.f >= 0.0f) {
                marginLayoutParams.bottomMargin = (int)((float)n3 * this.f);
            }
            float f2 = this.g FCMPL 0.0f;
            boolean bl2 = false;
            if (f2 >= 0) {
                eh.a(marginLayoutParams, (int)((float)n2 * this.g));
                bl2 = true;
            }
            if (this.h >= 0.0f) {
                eh.b(marginLayoutParams, (int)((float)n2 * this.h));
                bl2 = true;
            }
            if (bl2 && view != null) {
                eh.c(marginLayoutParams, fb.h(view));
            }
            if (Log.isLoggable((String)"PercentLayout", (int)3)) {
                Log.d((String)"PercentLayout", (String)("after fillMarginLayoutParams: (" + marginLayoutParams.width + ", " + marginLayoutParams.height + ")"));
            }
        }

        public void a(ViewGroup.LayoutParams layoutParams) {
            if (!this.j.b) {
                layoutParams.width = this.j.width;
            }
            if (!this.j.a) {
                layoutParams.height = this.j.height;
            }
            this.j.b = false;
            this.j.a = false;
        }

        /*
         * Enabled aggressive block sorting
         */
        public void a(ViewGroup.LayoutParams layoutParams, int n2, int n3) {
            this.j.width = layoutParams.width;
            this.j.height = layoutParams.height;
            boolean bl2 = (this.j.b || this.j.width == 0) && this.a < 0.0f;
            boolean bl3 = (this.j.a || this.j.height == 0) && this.b < 0.0f;
            if (this.a >= 0.0f) {
                layoutParams.width = (int)((float)n2 * this.a);
            }
            if (this.b >= 0.0f) {
                layoutParams.height = (int)((float)n3 * this.b);
            }
            if (this.i >= 0.0f) {
                if (bl2) {
                    layoutParams.width = (int)((float)layoutParams.height * this.i);
                    this.j.b = true;
                }
                if (bl3) {
                    layoutParams.height = (int)((float)layoutParams.width / this.i);
                    this.j.a = true;
                }
            }
            if (Log.isLoggable((String)"PercentLayout", (int)3)) {
                Log.d((String)"PercentLayout", (String)("after fillLayoutParams: (" + layoutParams.width + ", " + layoutParams.height + ")"));
            }
        }

        public void a(ViewGroup.MarginLayoutParams marginLayoutParams) {
            this.a((ViewGroup.LayoutParams)marginLayoutParams);
            marginLayoutParams.leftMargin = this.j.leftMargin;
            marginLayoutParams.topMargin = this.j.topMargin;
            marginLayoutParams.rightMargin = this.j.rightMargin;
            marginLayoutParams.bottomMargin = this.j.bottomMargin;
            eh.a(marginLayoutParams, eh.a(this.j));
            eh.b(marginLayoutParams, eh.b(this.j));
        }

        public String toString() {
            Object[] arrobject = new Object[]{Float.valueOf((float)this.a), Float.valueOf((float)this.b), Float.valueOf((float)this.c), Float.valueOf((float)this.d), Float.valueOf((float)this.e), Float.valueOf((float)this.f), Float.valueOf((float)this.g), Float.valueOf((float)this.h)};
            return String.format((String)"PercentLayoutInformation width: %f height %f, margins (%f, %f,  %f, %f, %f, %f)", (Object[])arrobject);
        }
    }

    public static interface b {
        public a a();
    }

    static class c
    extends ViewGroup.MarginLayoutParams {
        private boolean a;
        private boolean b;

        public c(int n2, int n3) {
            super(n2, n3);
        }
    }

}

