package defpackage;

import android.support.v7.widget.LinearLayoutManager;
import rx.schedulers.Schedulers;

/* compiled from: MePostsFragment */
class ht$2 extends hl {
    final /* synthetic */ ht a;

    ht$2(ht this$0, LinearLayoutManager layoutManager, hd adapter) {
        this.a = this$0;
        super(layoutManager, adapter);
    }

    public void onLoadMore(String minPostId) {
        if (minPostId != null) {
            ie.a().h(Integer.parseInt(minPostId)).b(Schedulers.io()).a(apn.a()).b(new ht$2$1(this));
        }
    }
}
