package defpackage;

import android.util.Log;
import com.becandid.candid.models.NetworkData.UploadResponse;
import rx.exceptions.CompositeException;

/* compiled from: ApiService */
class ie$8$1 extends apj<String> {
    final /* synthetic */ UploadResponse a;
    final /* synthetic */ ie$8 b;

    ie$8$1(ie$8 this$1, UploadResponse uploadResponse) {
        this.b = this$1;
        this.a = uploadResponse;
    }

    public /* synthetic */ void onNext(Object obj) {
        a((String) obj);
    }

    public void onCompleted() {
    }

    public void onError(Throwable e) {
        rb.a(e);
        if (e instanceof CompositeException) {
            for (Throwable err : ((CompositeException) e).a()) {
                Log.d("ERRS", err.toString());
            }
        }
        iq.a().a(new ih$ag(this.a, false, null));
    }

    public void a(String string) {
        iq.a().a(new ih$ag(this.a, true, null));
    }
}
