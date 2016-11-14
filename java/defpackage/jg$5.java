package defpackage;

import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import java.util.Map;

/* compiled from: DynamicLayoutInflator */
class jg$5 implements jg$c {
    jg$5() {
    }

    public void a(View view, String value, ViewGroup parent, Map<String, String> map) {
        int gravity = jg.c(value);
        if (view instanceof TextView) {
            ((TextView) view).setGravity(gravity);
        } else if (view instanceof LinearLayout) {
            ((LinearLayout) view).setGravity(gravity);
        } else if (view instanceof RelativeLayout) {
            ((RelativeLayout) view).setGravity(gravity);
        }
    }
}
