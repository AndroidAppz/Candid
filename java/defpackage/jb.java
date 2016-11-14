package defpackage;

import android.app.Activity;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

/* compiled from: UpsellViewHolder */
public class jb extends iv {
    private String a;

    public jb(Activity activity) {
        super(new RelativeLayout(activity), activity);
    }

    public void a(String layoutXml) {
        if (this.a == null || !this.a.equals(layoutXml)) {
            this.a = layoutXml;
            ViewGroup parent = this.itemView;
            parent.removeAllViews();
            jg.a(jg.a(this.f, layoutXml, parent), this.f);
        }
    }
}
