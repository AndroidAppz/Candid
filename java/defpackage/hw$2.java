package defpackage;

import android.support.v7.widget.LinearLayoutManager;

/* compiled from: MessagesThreadsFragment */
class hw$2 extends hl {
    final /* synthetic */ hw a;

    hw$2(hw this$0, LinearLayoutManager layoutManager, hd adapter) {
        this.a = this$0;
        super(layoutManager, adapter);
    }

    public void onLoadMore(String minPostId) {
        if (minPostId != null) {
            this.a.a(minPostId);
        }
    }
}
