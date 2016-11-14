package defpackage;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;

/* compiled from: PercentLayoutHelper */
public class as {
    private final ViewGroup a;

    public as(ViewGroup host) {
        this.a = host;
    }

    public static void a(LayoutParams params, TypedArray array, int widthAttr, int heightAttr) {
        params.width = array.getLayoutDimension(widthAttr, 0);
        params.height = array.getLayoutDimension(heightAttr, 0);
    }

    public void a(int widthMeasureSpec, int heightMeasureSpec) {
        if (Log.isLoggable("PercentLayout", 3)) {
            Log.d("PercentLayout", "adjustChildren: " + this.a + " widthMeasureSpec: " + MeasureSpec.toString(widthMeasureSpec) + " heightMeasureSpec: " + MeasureSpec.toString(heightMeasureSpec));
        }
        int widthHint = MeasureSpec.getSize(widthMeasureSpec);
        int heightHint = MeasureSpec.getSize(heightMeasureSpec);
        int N = this.a.getChildCount();
        for (int i = 0; i < N; i++) {
            View view = this.a.getChildAt(i);
            LayoutParams params = view.getLayoutParams();
            if (Log.isLoggable("PercentLayout", 3)) {
                Log.d("PercentLayout", "should adjust " + view + " " + params);
            }
            if (params instanceof as$b) {
                as$a info = ((as$b) params).a();
                if (Log.isLoggable("PercentLayout", 3)) {
                    Log.d("PercentLayout", "using " + info);
                }
                if (info != null) {
                    if (params instanceof MarginLayoutParams) {
                        info.a(view, (MarginLayoutParams) params, widthHint, heightHint);
                    } else {
                        info.a(params, widthHint, heightHint);
                    }
                }
            }
        }
    }

    public static as$a a(Context context, AttributeSet attrs) {
        as$a info = null;
        TypedArray array = context.obtainStyledAttributes(attrs, at$a.PercentLayout_Layout);
        float value = array.getFraction(at$a.PercentLayout_Layout_layout_widthPercent, 1, 1, -1.0f);
        if (value != -1.0f) {
            if (Log.isLoggable("PercentLayout", 2)) {
                Log.v("PercentLayout", "percent width: " + value);
            }
            if (null == null) {
                info = new as$a();
            }
            info.a = value;
        }
        value = array.getFraction(at$a.PercentLayout_Layout_layout_heightPercent, 1, 1, -1.0f);
        if (value != -1.0f) {
            if (Log.isLoggable("PercentLayout", 2)) {
                Log.v("PercentLayout", "percent height: " + value);
            }
            if (info == null) {
                info = new as$a();
            }
            info.b = value;
        }
        value = array.getFraction(at$a.PercentLayout_Layout_layout_marginPercent, 1, 1, -1.0f);
        if (value != -1.0f) {
            if (Log.isLoggable("PercentLayout", 2)) {
                Log.v("PercentLayout", "percent margin: " + value);
            }
            if (info == null) {
                info = new as$a();
            }
            info.c = value;
            info.d = value;
            info.e = value;
            info.f = value;
        }
        value = array.getFraction(at$a.PercentLayout_Layout_layout_marginLeftPercent, 1, 1, -1.0f);
        if (value != -1.0f) {
            if (Log.isLoggable("PercentLayout", 2)) {
                Log.v("PercentLayout", "percent left margin: " + value);
            }
            if (info == null) {
                info = new as$a();
            }
            info.c = value;
        }
        value = array.getFraction(at$a.PercentLayout_Layout_layout_marginTopPercent, 1, 1, -1.0f);
        if (value != -1.0f) {
            if (Log.isLoggable("PercentLayout", 2)) {
                Log.v("PercentLayout", "percent top margin: " + value);
            }
            if (info == null) {
                info = new as$a();
            }
            info.d = value;
        }
        value = array.getFraction(at$a.PercentLayout_Layout_layout_marginRightPercent, 1, 1, -1.0f);
        if (value != -1.0f) {
            if (Log.isLoggable("PercentLayout", 2)) {
                Log.v("PercentLayout", "percent right margin: " + value);
            }
            if (info == null) {
                info = new as$a();
            }
            info.e = value;
        }
        value = array.getFraction(at$a.PercentLayout_Layout_layout_marginBottomPercent, 1, 1, -1.0f);
        if (value != -1.0f) {
            if (Log.isLoggable("PercentLayout", 2)) {
                Log.v("PercentLayout", "percent bottom margin: " + value);
            }
            if (info == null) {
                info = new as$a();
            }
            info.f = value;
        }
        value = array.getFraction(at$a.PercentLayout_Layout_layout_marginStartPercent, 1, 1, -1.0f);
        if (value != -1.0f) {
            if (Log.isLoggable("PercentLayout", 2)) {
                Log.v("PercentLayout", "percent start margin: " + value);
            }
            if (info == null) {
                info = new as$a();
            }
            info.g = value;
        }
        value = array.getFraction(at$a.PercentLayout_Layout_layout_marginEndPercent, 1, 1, -1.0f);
        if (value != -1.0f) {
            if (Log.isLoggable("PercentLayout", 2)) {
                Log.v("PercentLayout", "percent end margin: " + value);
            }
            if (info == null) {
                info = new as$a();
            }
            info.h = value;
        }
        value = array.getFraction(at$a.PercentLayout_Layout_layout_aspectRatio, 1, 1, -1.0f);
        if (value != -1.0f) {
            if (Log.isLoggable("PercentLayout", 2)) {
                Log.v("PercentLayout", "aspect ratio: " + value);
            }
            if (info == null) {
                info = new as$a();
            }
            info.i = value;
        }
        array.recycle();
        if (Log.isLoggable("PercentLayout", 3)) {
            Log.d("PercentLayout", "constructed: " + info);
        }
        return info;
    }

    public void a() {
        int N = this.a.getChildCount();
        for (int i = 0; i < N; i++) {
            View view = this.a.getChildAt(i);
            LayoutParams params = view.getLayoutParams();
            if (Log.isLoggable("PercentLayout", 3)) {
                Log.d("PercentLayout", "should restore " + view + " " + params);
            }
            if (params instanceof as$b) {
                as$a info = ((as$b) params).a();
                if (Log.isLoggable("PercentLayout", 3)) {
                    Log.d("PercentLayout", "using " + info);
                }
                if (info != null) {
                    if (params instanceof MarginLayoutParams) {
                        info.a((MarginLayoutParams) params);
                    } else {
                        info.a(params);
                    }
                }
            }
        }
    }

    public boolean b() {
        boolean needsSecondMeasure = false;
        int N = this.a.getChildCount();
        for (int i = 0; i < N; i++) {
            View view = this.a.getChildAt(i);
            LayoutParams params = view.getLayoutParams();
            if (Log.isLoggable("PercentLayout", 3)) {
                Log.d("PercentLayout", "should handle measured state too small " + view + " " + params);
            }
            if (params instanceof as$b) {
                as$a info = ((as$b) params).a();
                if (info != null) {
                    if (as.a(view, info)) {
                        needsSecondMeasure = true;
                        params.width = -2;
                    }
                    if (as.b(view, info)) {
                        needsSecondMeasure = true;
                        params.height = -2;
                    }
                }
            }
        }
        if (Log.isLoggable("PercentLayout", 3)) {
            Log.d("PercentLayout", "should trigger second measure pass: " + needsSecondMeasure);
        }
        return needsSecondMeasure;
    }

    private static boolean a(View view, as$a info) {
        return (fb.k(view) & -16777216) == 16777216 && info.a >= 0.0f && info.j.width == -2;
    }

    private static boolean b(View view, as$a info) {
        return (fb.l(view) & -16777216) == 16777216 && info.b >= 0.0f && info.j.height == -2;
    }
}
