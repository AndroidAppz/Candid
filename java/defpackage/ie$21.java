package defpackage;

import com.becandid.candid.models.PostInfoResponse;
import java.util.Map;

/* compiled from: ApiService */
class ie$21 implements apu<PostInfoResponse, apd<Map<String, String>>> {
    final /* synthetic */ ie a;

    ie$21(ie this$0) {
        this.a = this$0;
    }

    public /* synthetic */ Object call(Object obj) {
        return a((PostInfoResponse) obj);
    }

    public apd<Map<String, String>> a(PostInfoResponse postInfoResponse) {
        if (postInfoResponse != null) {
            return apd.a(postInfoResponse.data);
        }
        return null;
    }
}
