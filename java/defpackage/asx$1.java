package defpackage;

import android.view.ScaleGestureDetector;
import android.view.ScaleGestureDetector.OnScaleGestureListener;

/* compiled from: FroyoGestureDetector */
class asx$1 implements OnScaleGestureListener {
    final /* synthetic */ asx a;

    asx$1(asx asx) {
        this.a = asx;
    }

    public boolean onScale(ScaleGestureDetector detector) {
        float scaleFactor = detector.getScaleFactor();
        if (Float.isNaN(scaleFactor) || Float.isInfinite(scaleFactor)) {
            return false;
        }
        this.a.a.a(scaleFactor, detector.getFocusX(), detector.getFocusY());
        return true;
    }

    public boolean onScaleBegin(ScaleGestureDetector detector) {
        return true;
    }

    public void onScaleEnd(ScaleGestureDetector detector) {
    }
}
