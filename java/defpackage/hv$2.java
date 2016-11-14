package defpackage;

import android.support.v7.widget.LinearLayoutManager;

/* compiled from: MessagesRequestsFragment */
class hv$2 extends hl {
    final /* synthetic */ hv a;

    hv$2(hv this$0, LinearLayoutManager layoutManager, hd adapter) {
        this.a = this$0;
        super(layoutManager, adapter);
    }

    public void onLoadMore(String minPostId) {
        if (minPostId != null) {
            this.a.a(minPostId);
        }
    }
}
