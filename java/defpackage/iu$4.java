package defpackage;

import android.content.Context;
import android.widget.Toast;
import com.becandid.candid.models.NetworkData;

/* compiled from: ViewUtils */
class iu$4 extends apj<NetworkData> {
    final /* synthetic */ Context a;
    final /* synthetic */ int b;
    final /* synthetic */ String c;

    iu$4(Context context, int i, String str) {
        this.a = context;
        this.b = i;
        this.c = str;
    }

    public /* synthetic */ void onNext(Object obj) {
        a((NetworkData) obj);
    }

    public void onCompleted() {
    }

    public void onError(Throwable e) {
        rb.a(e);
        Toast.makeText(this.a, e.toString(), 1).show();
    }

    public void a(NetworkData networkData) {
        iq.a().a(new ih$s(this.b, this.c));
        Toast.makeText(this.a, this.a.getResources().getString(2131230951), 0).show();
    }
}
