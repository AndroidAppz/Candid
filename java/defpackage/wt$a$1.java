package defpackage;

import android.os.Bundle;
import com.facebook.share.model.ShareContent;

/* compiled from: MessageDialog */
class wt$a$1 implements vc$a {
    final /* synthetic */ ux a;
    final /* synthetic */ ShareContent b;
    final /* synthetic */ boolean c;
    final /* synthetic */ wt$a d;

    wt$a$1(wt$a this$1, ux uxVar, ShareContent shareContent, boolean z) {
        this.d = this$1;
        this.a = uxVar;
        this.b = shareContent;
        this.c = z;
    }

    public Bundle a() {
        return wn.a(this.a.c(), this.b, this.c);
    }

    public Bundle b() {
        return wj.a(this.a.c(), this.b, this.c);
    }
}
