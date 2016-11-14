package defpackage;

import android.content.Context;
import android.widget.Toast;
import com.becandid.candid.models.NetworkData;

/* compiled from: ViewUtils */
class iu$6 extends apj<NetworkData> {
    final /* synthetic */ Context a;
    final /* synthetic */ int b;
    final /* synthetic */ int c;

    iu$6(Context context, int i, int i2) {
        this.a = context;
        this.b = i;
        this.c = i2;
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
        iq.a().a(new ih$l(this.b, this.c));
        Toast.makeText(this.a, this.a.getResources().getString(2131230948), 0).show();
    }
}
