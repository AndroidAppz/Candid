package defpackage;

import android.util.Log;
import android.view.View;
import com.becandid.candid.models.NetworkData;

/* compiled from: MeHistoryFragment */
class hs$1 extends apj<NetworkData> {
    final /* synthetic */ hs a;

    hs$1(hs this$0) {
        this.a = this$0;
    }

    public /* synthetic */ void onNext(Object obj) {
        a((NetworkData) obj);
    }

    public void onCompleted() {
        int i = 0;
        this.a.e.setRefreshing(false);
        View c = this.a.d;
        if (this.a.c.getItemCount() != 0) {
            i = 8;
        }
        c.setVisibility(i);
    }

    public void onError(Throwable e) {
        int i = 0;
        rb.a(e);
        Log.d("GetMyHistory", e.toString());
        this.a.e.setRefreshing(false);
        View c = this.a.d;
        if (this.a.c.getItemCount() != 0) {
            i = 8;
        }
        c.setVisibility(i);
    }

    public void a(NetworkData networkData) {
        if (networkData.success) {
            if (networkData.posts != null) {
                this.a.c.a(networkData.posts);
            }
            if (networkData.next_page != 0) {
                this.a.c.a(String.valueOf(networkData.next_page));
            } else {
                this.a.c.a(null);
            }
        }
    }
}
