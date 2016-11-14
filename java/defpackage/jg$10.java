package defpackage;

import android.view.View;
import android.view.ViewGroup;
import java.util.Map;

/* compiled from: DynamicLayoutInflator */
class jg$10 implements jg$c {
    jg$10() {
    }

    public void a(View view, String value, ViewGroup parent, Map<String, String> map) {
        view.setClickable(value.equals("true"));
    }
}
