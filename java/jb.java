/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.Context
 *  android.view.View
 *  android.view.ViewGroup
 *  android.widget.RelativeLayout
 *  java.lang.Object
 *  java.lang.String
 */
import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

public class jb
extends iv {
    private String a;

    public jb(Activity activity) {
        super((View)new RelativeLayout((Context)activity), activity);
    }

    public void a(String string2) {
        if (this.a != null && this.a.equals((Object)string2)) {
            return;
        }
        this.a = string2;
        RelativeLayout relativeLayout = (RelativeLayout)this.itemView;
        relativeLayout.removeAllViews();
        jg.a(jg.a(this.f, string2, (ViewGroup)relativeLayout), (Object)this.f);
    }
}

