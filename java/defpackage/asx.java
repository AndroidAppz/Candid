package defpackage;

import android.annotation.TargetApi;
import android.content.Context;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;

@TargetApi(8)
/* compiled from: FroyoGestureDetector */
public class asx extends asw {
    protected final ScaleGestureDetector f;

    public asx(Context context) {
        super(context);
        this.f = new ScaleGestureDetector(context, new asx$1(this));
    }

    public boolean a() {
        return this.f.isInProgress();
    }

    public boolean c(MotionEvent ev) {
        try {
            this.f.onTouchEvent(ev);
            return super.c(ev);
        } catch (IllegalArgumentException e) {
            return true;
        }
    }
}
