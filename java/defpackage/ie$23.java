package defpackage;

import com.becandid.candid.data.Group;
import com.becandid.candid.models.NetworkData;

/* compiled from: ApiService */
class ie$23 implements apu<NetworkData, apd<Group>> {
    final /* synthetic */ ie a;

    ie$23(ie this$0) {
        this.a = this$0;
    }

    public /* synthetic */ Object call(Object obj) {
        return a((NetworkData) obj);
    }

    public apd<Group> a(NetworkData data) {
        if (data != null) {
            return apd.a(data.group);
        }
        return null;
    }
}
