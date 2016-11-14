package defpackage;

import android.view.View;
import android.view.ViewGroup;
import java.util.Map;

/* compiled from: DynamicLayoutInflator */
class jg$13 implements jg$c {
    jg$13() {
    }

    public void a(View view, String value, ViewGroup parent, Map<String, String> map) {
        view.setOnClickListener(jg.b(parent, value));
    }
}
