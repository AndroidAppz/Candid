package defpackage;

import android.support.v4.widget.SwipeRefreshLayout.OnRefreshListener;

/* compiled from: MeActivityFragment */
class hq$2 implements OnRefreshListener {
    final /* synthetic */ hq a;

    hq$2(hq this$0) {
        this.a = this$0;
    }

    public void onRefresh() {
        if (this.a.f != null) {
            this.a.f.unsubscribe();
        }
        this.a.f = this.a.b(true);
    }
}
