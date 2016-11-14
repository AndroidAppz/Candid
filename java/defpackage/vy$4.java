package defpackage;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

/* compiled from: WebDialog */
class vy$4 implements OnTouchListener {
    final /* synthetic */ vy a;

    vy$4(vy this$0) {
        this.a = this$0;
    }

    public boolean onTouch(View v, MotionEvent event) {
        if (!v.hasFocus()) {
            v.requestFocus();
        }
        return false;
    }
}
