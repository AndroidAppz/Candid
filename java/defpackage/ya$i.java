package defpackage;

import com.google.android.gms.common.ConnectionResult;

public class ya$i implements ya$f {
    final /* synthetic */ ya a;

    public ya$i(ya yaVar) {
        this.a = yaVar;
    }

    public void a(ConnectionResult connectionResult) {
        if (connectionResult.b()) {
            this.a.a(null, this.a.u());
        } else if (this.a.v != null) {
            this.a.v.a(connectionResult);
        }
    }
}
