package defpackage;

import com.becandid.candid.data.AppState;
import com.becandid.candid.models.NetworkData;

/* compiled from: ApiService */
class ie$5 implements apu<NetworkData, apd<NetworkData>> {
    final /* synthetic */ ie a;

    ie$5(ie this$0) {
        this.a = this$0;
    }

    public /* synthetic */ Object call(Object obj) {
        return a((NetworkData) obj);
    }

    public apd<NetworkData> a(NetworkData networkData) {
        if (networkData == null || !networkData.success) {
            return null;
        }
        if (networkData.debug) {
            AppState.internal = networkData.debug;
        }
        return apd.a((Object) networkData);
    }
}
