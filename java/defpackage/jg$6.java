package defpackage;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import java.util.Map;

/* compiled from: DynamicLayoutInflator */
class jg$6 implements jg$c {
    jg$6() {
    }

    public void a(View view, String value, ViewGroup parent, Map<String, String> attrs) {
        if (view instanceof ImageView) {
            String imageName = value;
            if (imageName.startsWith("//")) {
                imageName = "http:" + imageName;
            }
            if (imageName.startsWith("http")) {
                if (jg.e == null) {
                    return;
                }
                if (attrs.containsKey("cornerRadius")) {
                    jg.e.a((ImageView) view, imageName, jf.a((String) attrs.get("cornerRadius"), view.getResources().getDisplayMetrics()));
                    return;
                }
                jg.e.a((ImageView) view, imageName);
            } else if (imageName.startsWith("@drawable/")) {
                ((ImageView) view).setImageDrawable(jg.c(view, imageName.substring("@drawable/".length())));
            } else if (imageName.startsWith("@mipmap/")) {
                ((ImageView) view).setImageDrawable(jg.d(view, imageName.substring("@mipmap/".length())));
            }
        }
    }
}
