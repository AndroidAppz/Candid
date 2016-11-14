package defpackage;

import android.view.View;
import android.view.ViewGroup;
import java.util.Map;

/* compiled from: DynamicLayoutInflator */
class jg$11 implements jg$c {
    jg$11() {
    }

    public void a(View view, String value, ViewGroup parent, Map<String, String> map) {
        if (view.getTag() == null) {
            view.setTag(value);
        }
    }
}
