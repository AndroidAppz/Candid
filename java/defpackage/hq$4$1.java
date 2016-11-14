package defpackage;

import com.becandid.candid.models.NetworkData;

/* compiled from: MeActivityFragment */
class hq$4$1 extends apj<NetworkData> {
    final /* synthetic */ hq$4 a;

    hq$4$1(hq$4 this$1) {
        this.a = this$1;
    }

    public /* synthetic */ void onNext(Object obj) {
        a((NetworkData) obj);
    }

    public void onCompleted() {
    }

    public void onError(Throwable e) {
    }

    public void a(NetworkData data) {
        if (data == null || data.activity == null || data.activity.isEmpty()) {
            this.a.a.c.a(null);
            return;
        }
        this.a.a.c.b(data.activity);
        this.a.a.c.a(String.valueOf(data.last_activity_id));
    }
}
