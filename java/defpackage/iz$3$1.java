package defpackage;

import android.util.Log;
import android.widget.Toast;
import com.becandid.candid.models.NetworkData;

/* compiled from: MessageViewHolder */
class iz$3$1 extends apj<NetworkData> {
    final /* synthetic */ iz$3 a;

    iz$3$1(iz$3 this$0) {
        this.a = this$0;
    }

    public /* synthetic */ void onNext(Object obj) {
        a((NetworkData) obj);
    }

    public void onCompleted() {
    }

    public void onError(Throwable e) {
        Log.d("AddMessage", e.toString());
        Toast.makeText(this.a.c, e.toString(), 1).show();
        this.a.d.a(this.a.b.messageTempId, false, false, null);
    }

    public void a(NetworkData networkData) {
        if (networkData != null && !networkData.success) {
            Toast.makeText(this.a.c, networkData.error, 1).show();
            if (networkData.error.contains("blocked") || networkData.error.contains("disabled")) {
                this.a.d.a(this.a.b.messageTempId, false, true, null);
                return;
            }
            this.a.d.a(this.a.b.messageTempId, false, false, null);
            this.a.a.g.setEnabled(true);
            this.a.a.i.setEnabled(true);
            this.a.a.h.setEnabled(true);
        } else if (networkData != null && networkData.message != null) {
            this.a.d.a(this.a.b.messageTempId, true, false, networkData.message);
        }
    }
}
