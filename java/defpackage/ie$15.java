package defpackage;

import com.becandid.candid.models.NetworkData;

/* compiled from: ApiService */
class ie$15 implements apu<NetworkData, apd<NetworkData>> {
    final /* synthetic */ ie a;

    ie$15(ie this$0) {
        this.a = this$0;
    }

    public /* synthetic */ Object call(Object obj) {
        return a((NetworkData) obj);
    }

    public apd<NetworkData> a(NetworkData networkData) {
        if (networkData == null || !networkData.success) {
            return null;
        }
        return apd.a((Object) networkData);
    }
}
