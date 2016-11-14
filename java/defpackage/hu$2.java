package defpackage;

import android.support.v7.widget.LinearLayoutManager;

/* compiled from: MessagesActiveFragment */
class hu$2 extends hl {
    final /* synthetic */ hu a;

    hu$2(hu this$0, LinearLayoutManager layoutManager, hd adapter) {
        this.a = this$0;
        super(layoutManager, adapter);
    }

    public void onLoadMore(String minPostId) {
        if (minPostId != null && Integer.valueOf(minPostId).intValue() > 0) {
            this.a.a(minPostId);
        }
    }
}
