package defpackage;

import com.google.android.gms.common.ConnectionResult;
import java.util.Collections;

class aay$d implements ya$f {
    final /* synthetic */ aay a;
    private final wx$f b;
    private final aas<?> c;

    public aay$d(aay aay, wx$f wx_f, aas<?> aas_) {
        this.a = aay;
        this.b = wx_f;
        this.c = aas_;
    }

    public void a(ConnectionResult connectionResult) {
        if (connectionResult.b()) {
            this.b.a(null, Collections.emptySet());
        } else {
            ((aay$c) this.a.j.get(this.c)).a(connectionResult);
        }
    }
}
