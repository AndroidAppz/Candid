package defpackage;

import android.support.v7.widget.StaggeredGridLayoutManager;
import rx.schedulers.Schedulers;

/* compiled from: MeGroupsFragment */
class hr$3 extends hl {
    final /* synthetic */ hr a;

    hr$3(hr this$0, StaggeredGridLayoutManager layoutManager, hd adapter) {
        this.a = this$0;
        super(layoutManager, adapter);
    }

    public void onLoadMore(String minPostId) {
        if (minPostId != null) {
            ie.a().i(Integer.parseInt(minPostId)).b(Schedulers.io()).a(apn.a()).b(new hr$3$1(this));
        }
    }
}
