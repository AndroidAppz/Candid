package defpackage;

import android.os.Build.VERSION;
import android.view.View;
import android.view.ViewGroup;
import java.util.Map;

/* compiled from: DynamicLayoutInflator */
class jg$14 implements jg$c {
    jg$14() {
    }

    public void a(View view, String value, ViewGroup parent, Map<String, String> map) {
        if (VERSION.SDK_INT >= 21) {
            view.setElevation((float) jf.a(value, view.getResources().getDisplayMetrics()));
        }
    }
}
