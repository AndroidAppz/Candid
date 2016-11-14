package defpackage;

import com.becandid.candid.data.Post;
import com.becandid.candid.models.NetworkData;
import java.util.List;

/* compiled from: ApiService */
class ie$18 implements apu<NetworkData, apd<List<Post>>> {
    final /* synthetic */ ie a;

    ie$18(ie this$0) {
        this.a = this$0;
    }

    public /* synthetic */ Object call(Object obj) {
        return a((NetworkData) obj);
    }

    public apd<List<Post>> a(NetworkData networkData) {
        if (networkData != null) {
            return apd.a(networkData.posts);
        }
        return null;
    }
}
