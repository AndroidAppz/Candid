package defpackage;

import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import java.util.Map;

/* compiled from: DynamicLayoutInflator */
class jg$15 implements jg$c {
    jg$15() {
    }

    public void a(View view, String value, ViewGroup parent, Map<String, String> map) {
        if (view instanceof LinearLayout) {
            ((LinearLayout) view).setOrientation(value.equals("vertical") ? 1 : 0);
        }
    }
}
