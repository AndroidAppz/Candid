package defpackage;

import com.becandid.candid.data.Post;
import com.becandid.candid.models.NetworkData;

/* compiled from: ApiService */
class ie$22 implements apu<NetworkData, apd<Post>> {
    final /* synthetic */ ie a;

    ie$22(ie this$0) {
        this.a = this$0;
    }

    public /* synthetic */ Object call(Object obj) {
        return a((NetworkData) obj);
    }

    public apd<Post> a(NetworkData networkData) {
        if (networkData != null) {
            return apd.a(networkData.post);
        }
        return null;
    }
}
