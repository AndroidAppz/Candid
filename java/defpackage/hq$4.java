package defpackage;

import android.support.v7.widget.LinearLayoutManager;
import rx.schedulers.Schedulers;

/* compiled from: MeActivityFragment */
class hq$4 extends hl {
    final /* synthetic */ hq a;

    hq$4(hq this$0, LinearLayoutManager layoutManager, hd adapter) {
        this.a = this$0;
        super(layoutManager, adapter);
    }

    public void onLoadMore(String minPostId) {
        if (minPostId != null) {
            ie.a().b(Boolean.toString(true), minPostId).b(Schedulers.io()).a(apn.a()).b(new hq$4$1(this));
        }
    }
}
