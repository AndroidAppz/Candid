package defpackage;

import android.content.Context;
import android.graphics.Color;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import com.becandid.candid.activities.PostDetailsActivity;

/* compiled from: ViewUtils */
class iu$7 extends ClickableSpan {
    final /* synthetic */ Context a;
    final /* synthetic */ boolean b;
    final /* synthetic */ int c;
    final /* synthetic */ String d;
    final /* synthetic */ String e;

    iu$7(Context context, boolean z, int i, String str, String str2) {
        this.a = context;
        this.b = z;
        this.c = i;
        this.d = str;
        this.e = str2;
    }

    public void onClick(View widget) {
        if (!(this.a instanceof PostDetailsActivity) && !this.b) {
            PostDetailsActivity.startPostDetailsActivity(this.c, this.a, this.d);
        }
    }

    public void updateDrawState(TextPaint ds) {
        super.updateDrawState(ds);
        ds.setColor(Color.parseColor(this.e));
        ds.setUnderlineText(false);
    }
}
