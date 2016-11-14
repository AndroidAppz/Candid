package defpackage;

import android.support.v7.widget.LinearLayoutManager;
import rx.schedulers.Schedulers;

/* compiled from: MeHistoryFragment */
class hs$2 extends hl {
    final /* synthetic */ hs a;

    hs$2(hs this$0, LinearLayoutManager layoutManager, hd adapter) {
        this.a = this$0;
        super(layoutManager, adapter);
    }

    public void onLoadMore(String minPostId) {
        if (minPostId != null) {
            ie.a().g(Integer.parseInt(minPostId)).b(Schedulers.io()).a(apn.a()).b(new hs$2$1(this));
        }
    }
}
