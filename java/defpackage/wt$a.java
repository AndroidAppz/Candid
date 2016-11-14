package defpackage;

import android.app.Activity;
import com.facebook.share.model.ShareContent;

/* compiled from: MessageDialog */
class wt$a extends vd$a {
    final /* synthetic */ wt b;

    private wt$a(wt wtVar) {
        this.b = wtVar;
        super(wtVar);
    }

    public boolean a(ShareContent shareContent, boolean isBestEffort) {
        return shareContent != null && wt.a(shareContent.getClass());
    }

    public ux a(ShareContent content) {
        wq.a(content);
        ux appCall = this.b.d();
        boolean shouldFailOnDataError = this.b.e();
        Activity activity = this.b.b();
        vc.a(appCall, new wt$a$1(this, appCall, content, shouldFailOnDataError), wt.c(content.getClass()));
        return appCall;
    }
}
