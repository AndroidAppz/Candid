package defpackage;

import android.util.Log;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;

/* compiled from: PercentLayoutHelper */
public class as$a {
    public float a = -1.0f;
    public float b = -1.0f;
    public float c = -1.0f;
    public float d = -1.0f;
    public float e = -1.0f;
    public float f = -1.0f;
    public float g = -1.0f;
    public float h = -1.0f;
    public float i;
    final as$c j = new as$c(0, 0);

    public void a(LayoutParams params, int widthHint, int heightHint) {
        boolean widthNotSet;
        boolean heightNotSet;
        this.j.width = params.width;
        this.j.height = params.height;
        if ((this.j.b || this.j.width == 0) && this.a < 0.0f) {
            widthNotSet = true;
        } else {
            widthNotSet = false;
        }
        if ((this.j.a || this.j.height == 0) && this.b < 0.0f) {
            heightNotSet = true;
        } else {
            heightNotSet = false;
        }
        if (this.a >= 0.0f) {
            params.width = (int) (((float) widthHint) * this.a);
        }
        if (this.b >= 0.0f) {
            params.height = (int) (((float) heightHint) * this.b);
        }
        if (this.i >= 0.0f) {
            if (widthNotSet) {
                params.width = (int) (((float) params.height) * this.i);
                this.j.b = true;
            }
            if (heightNotSet) {
                params.height = (int) (((float) params.width) / this.i);
                this.j.a = true;
            }
        }
        if (Log.isLoggable("PercentLayout", 3)) {
            Log.d("PercentLayout", "after fillLayoutParams: (" + params.width + ", " + params.height + ")");
        }
    }

    public void a(View view, MarginLayoutParams params, int widthHint, int heightHint) {
        a(params, widthHint, heightHint);
        this.j.leftMargin = params.leftMargin;
        this.j.topMargin = params.topMargin;
        this.j.rightMargin = params.rightMargin;
        this.j.bottomMargin = params.bottomMargin;
        eh.a(this.j, eh.a(params));
        eh.b(this.j, eh.b(params));
        if (this.c >= 0.0f) {
            params.leftMargin = (int) (((float) widthHint) * this.c);
        }
        if (this.d >= 0.0f) {
            params.topMargin = (int) (((float) heightHint) * this.d);
        }
        if (this.e >= 0.0f) {
            params.rightMargin = (int) (((float) widthHint) * this.e);
        }
        if (this.f >= 0.0f) {
            params.bottomMargin = (int) (((float) heightHint) * this.f);
        }
        boolean shouldResolveLayoutDirection = false;
        if (this.g >= 0.0f) {
            eh.a(params, (int) (((float) widthHint) * this.g));
            shouldResolveLayoutDirection = true;
        }
        if (this.h >= 0.0f) {
            eh.b(params, (int) (((float) widthHint) * this.h));
            shouldResolveLayoutDirection = true;
        }
        if (shouldResolveLayoutDirection && view != null) {
            eh.c(params, fb.h(view));
        }
        if (Log.isLoggable("PercentLayout", 3)) {
            Log.d("PercentLayout", "after fillMarginLayoutParams: (" + params.width + ", " + params.height + ")");
        }
    }

    public String toString() {
        return String.format("PercentLayoutInformation width: %f height %f, margins (%f, %f,  %f, %f, %f, %f)", new Object[]{Float.valueOf(this.a), Float.valueOf(this.b), Float.valueOf(this.c), Float.valueOf(this.d), Float.valueOf(this.e), Float.valueOf(this.f), Float.valueOf(this.g), Float.valueOf(this.h)});
    }

    public void a(MarginLayoutParams params) {
        a((LayoutParams) params);
        params.leftMargin = this.j.leftMargin;
        params.topMargin = this.j.topMargin;
        params.rightMargin = this.j.rightMargin;
        params.bottomMargin = this.j.bottomMargin;
        eh.a(params, eh.a(this.j));
        eh.b(params, eh.b(this.j));
    }

    public void a(LayoutParams params) {
        if (!this.j.b) {
            params.width = this.j.width;
        }
        if (!this.j.a) {
            params.height = this.j.height;
        }
        this.j.b = false;
        this.j.a = false;
    }
}
