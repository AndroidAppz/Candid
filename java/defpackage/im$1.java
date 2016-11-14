package defpackage;

import com.becandid.candid.models.NetworkData.UploadResponse;

/* compiled from: PhotoHelper */
class im$1 extends apj<UploadResponse> {
    final /* synthetic */ im a;

    im$1(im this$0) {
        this.a = this$0;
    }

    public /* synthetic */ void onNext(Object obj) {
        a((UploadResponse) obj);
    }

    public void onCompleted() {
    }

    public void onError(Throwable e) {
        iq.a().a(new ih$ag(null, false, e.toString()));
    }

    public void a(UploadResponse uploadResponse) {
    }
}
