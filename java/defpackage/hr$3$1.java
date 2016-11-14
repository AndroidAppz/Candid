package defpackage;

import com.becandid.candid.models.NetworkData;

/* compiled from: MeGroupsFragment */
class hr$3$1 extends apj<NetworkData> {
    final /* synthetic */ hr$3 a;

    hr$3$1(hr$3 this$1) {
        this.a = this$1;
    }

    public /* synthetic */ void onNext(Object obj) {
        a((NetworkData) obj);
    }

    public void onCompleted() {
    }

    public void onError(Throwable e) {
    }

    public void a(NetworkData networkData) {
        if (networkData == null || networkData.groups == null || networkData.groups.isEmpty()) {
            this.a.a.c.a(null);
            return;
        }
        this.a.a.c.b(networkData.groups);
        if (networkData.next_page != 0) {
            this.a.a.c.a(String.valueOf(networkData.next_page));
        } else {
            this.a.a.c.a(null);
        }
    }
}
