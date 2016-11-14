package defpackage;

import android.util.Log;
import com.becandid.candid.data.MessageThread;
import com.becandid.candid.models.NetworkData;
import java.util.ArrayList;
import java.util.List;

/* compiled from: MessagesActiveFragment */
class hu$1 extends apj<NetworkData> {
    final /* synthetic */ String a;
    final /* synthetic */ hu b;

    hu$1(hu this$0, String str) {
        this.b = this$0;
        this.a = str;
    }

    public /* synthetic */ void onNext(Object obj) {
        a((NetworkData) obj);
    }

    public void onCompleted() {
        this.b.e.setRefreshing(false);
        this.b.a();
    }

    public void onError(Throwable e) {
        this.b.e.setRefreshing(false);
        this.b.a();
        rb.a(e);
        Log.d("MessagesActive", e.toString());
    }

    public void a(NetworkData networkData) {
        if (networkData.threads != null) {
            List online = new ArrayList();
            for (MessageThread thread : networkData.threads) {
                if (thread.online == 1) {
                    online.add(thread);
                }
            }
            if (this.a.equals("0")) {
                this.b.a(online);
            } else {
                this.b.d.b(online);
            }
            if (networkData.thread_next_page != 0) {
                this.b.d.a(networkData.thread_next_page);
            } else {
                this.b.d.a(null);
            }
        }
    }
}
