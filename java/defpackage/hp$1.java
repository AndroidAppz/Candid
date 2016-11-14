package defpackage;

import android.support.v7.widget.LinearLayoutManager;
import rx.schedulers.Schedulers;

/* compiled from: FeedFragment */
class hp$1 extends hl {
    final /* synthetic */ hp a;

    hp$1(hp this$0, LinearLayoutManager layoutManager, hd adapter) {
        this.a = this$0;
        super(layoutManager, adapter);
    }

    public void onLoadMore(String minPostId) {
        if (minPostId != null) {
            ie.a().c(this.a.c, minPostId, this.a.b.b(this.a.c)).b(Schedulers.io()).a(apn.a()).b(new hp$1$1(this));
        }
    }
}
