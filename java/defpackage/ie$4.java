package defpackage;

import com.becandid.candid.data.EmptyClass;
import com.becandid.candid.models.NetworkData;

/* compiled from: ApiService */
class ie$4 implements apu<NetworkData, apd<EmptyClass>> {
    final /* synthetic */ ie a;

    ie$4(ie this$0) {
        this.a = this$0;
    }

    public /* synthetic */ Object call(Object obj) {
        return a((NetworkData) obj);
    }

    public apd<EmptyClass> a(NetworkData networkData) {
        if (networkData == null || !networkData.success) {
            return null;
        }
        return apd.a(new EmptyClass());
    }
}
