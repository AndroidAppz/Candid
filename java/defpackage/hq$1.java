package defpackage;

import android.view.View;
import com.becandid.candid.data.AppState;
import com.becandid.candid.models.NetworkData;

/* compiled from: MeActivityFragment */
class hq$1 extends apj<NetworkData> {
    final /* synthetic */ hq a;

    hq$1(hq this$0) {
        this.a = this$0;
    }

    public /* synthetic */ void onNext(Object obj) {
        a((NetworkData) obj);
    }

    public void onCompleted() {
        int i = 0;
        this.a.d.setRefreshing(false);
        View c = this.a.e;
        if (this.a.c.getItemCount() != 0) {
            i = 8;
        }
        c.setVisibility(i);
    }

    public void onError(Throwable e) {
        int i = 0;
        rb.a(e);
        this.a.d.setRefreshing(false);
        View c = this.a.e;
        if (this.a.c.getItemCount() != 0) {
            i = 8;
        }
        c.setVisibility(i);
    }

    public void a(NetworkData networkData) {
        if (networkData.success) {
            if (networkData.activity != null) {
                this.a.c.a(networkData.activity);
            }
            this.a.c.a(networkData.last_activity_id);
            if (networkData.unread_count > -1) {
                AppState.account.unread_activity_count = networkData.unread_count;
                iq.a().a(new ih$an(3, networkData.unread_count, true));
            }
            if (networkData.unread_groups_count > -1) {
                AppState.account.unread_groups_count = networkData.unread_groups_count;
                iq.a().a(new ih$an(1, networkData.unread_groups_count, true));
            }
        }
    }
}
