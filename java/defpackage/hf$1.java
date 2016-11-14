package defpackage;

import com.becandid.candid.activities.BaseActivity;
import com.becandid.candid.activities.MainTabsActivity;

/* compiled from: FeedAdapter */
class hf$1 extends apj<ih$q> {
    final /* synthetic */ BaseActivity a;
    final /* synthetic */ hf b;

    hf$1(hf this$0, BaseActivity baseActivity) {
        this.b = this$0;
        this.a = baseActivity;
    }

    public /* synthetic */ void onNext(Object obj) {
        a((ih$q) obj);
    }

    public void onCompleted() {
    }

    public void onError(Throwable e) {
        rb.a(e);
    }

    public void a(ih$q didLikePost) {
        if (!(didLikePost.h instanceof MainTabsActivity) || !(this.a instanceof MainTabsActivity)) {
            this.b.a(didLikePost.a, didLikePost);
        }
    }
}
