package defpackage;

import com.becandid.candid.models.NetworkData;

/* compiled from: MePostsFragment */
class ht$2$1 extends apj<NetworkData> {
    final /* synthetic */ ht$2 a;

    ht$2$1(ht$2 this$1) {
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
        if (data == null || data.posts == null || data.posts.isEmpty()) {
            this.a.a.c.a(null);
            return;
        }
        this.a.a.c.b(data.posts);
        if (data.next_page != 0) {
            this.a.a.c.a(String.valueOf(data.next_page));
        } else {
            this.a.a.c.a(null);
        }
    }
}
