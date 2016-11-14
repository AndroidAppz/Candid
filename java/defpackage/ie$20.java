package defpackage;

import com.becandid.candid.data.AppState;
import com.becandid.candid.models.NetworkData;

/* compiled from: ApiService */
class ie$20 implements apu<NetworkData, apd<NetworkData>> {
    final /* synthetic */ ie a;

    ie$20(ie this$0) {
        this.a = this$0;
    }

    public /* synthetic */ Object call(Object obj) {
        return a((NetworkData) obj);
    }

    public apd<NetworkData> a(NetworkData networkData) {
        if (networkData == null) {
            return null;
        }
        if (networkData.group != null) {
            AppState.groups.add(networkData.group);
            iq.a().a(new ih$m(networkData.group));
        }
        return apd.a((Object) networkData);
    }
}
