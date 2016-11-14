package defpackage;

import com.becandid.candid.data.AppState;
import com.becandid.candid.models.NetworkData;
import java.util.ArrayList;

/* compiled from: ApiService */
class ie$24 implements apu<NetworkData, apd<NetworkData>> {
    final /* synthetic */ ie a;

    ie$24(ie this$0) {
        this.a = this$0;
    }

    public /* synthetic */ Object call(Object obj) {
        return a((NetworkData) obj);
    }

    public apd<NetworkData> a(NetworkData networkData) {
        if (networkData == null || !networkData.success) {
            return null;
        }
        if (AppState.groups == null) {
            AppState.groups = new ArrayList();
        }
        AppState.groups.add(networkData.group);
        iq.a().a(new ih$m(networkData.group));
        return apd.a((Object) networkData);
    }
}
