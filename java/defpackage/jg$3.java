package defpackage;

import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import java.util.Map;

/* compiled from: DynamicLayoutInflator */
class jg$3 implements jg$c {
    jg$3() {
    }

    public void a(View view, String value, ViewGroup parent, Map<String, String> map) {
        if (view instanceof EditText) {
            ((EditText) view).setHint(value);
        }
    }
}
