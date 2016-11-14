/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.annotation.TargetApi
 *  android.content.Context
 *  android.view.MotionEvent
 *  android.view.ScaleGestureDetector
 *  android.view.ScaleGestureDetector$OnScaleGestureListener
 *  java.lang.Float
 *  java.lang.IllegalArgumentException
 *  java.lang.Object
 */
import android.annotation.TargetApi;
import android.content.Context;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;

@TargetApi(value=8)
public class asx
extends asw {
    protected final ScaleGestureDetector f;

    public asx(Context context) {
        super(context);
        this.f = new ScaleGestureDetector(context, new ScaleGestureDetector.OnScaleGestureListener(){

            public boolean onScale(ScaleGestureDetector scaleGestureDetector) {
                float f2 = scaleGestureDetector.getScaleFactor();
                if (Float.isNaN((float)f2) || Float.isInfinite((float)f2)) {
                    return false;
                }
                asx.this.a.a(f2, scaleGestureDetector.getFocusX(), scaleGestureDetector.getFocusY());
                return true;
            }

            public boolean onScaleBegin(ScaleGestureDetector scaleGestureDetector) {
                return true;
            }

            public void onScaleEnd(ScaleGestureDetector scaleGestureDetector) {
            }
        });
    }

    @Override
    public boolean a() {
        return this.f.isInProgress();
    }

    @Override
    public boolean c(MotionEvent motionEvent) {
        try {
            this.f.onTouchEvent(motionEvent);
            boolean bl2 = super.c(motionEvent);
            return bl2;
        }
        catch (IllegalArgumentException var2_3) {
            return true;
        }
    }

}

