package defpackage;

import android.os.Bundle;
import com.google.android.gms.common.ConnectionResult;

public final class ya$k extends ya$a {
    final /* synthetic */ ya e;

    public ya$k(ya yaVar, int i, Bundle bundle) {
        this.e = yaVar;
        super(yaVar, i, bundle);
    }

    protected void a(ConnectionResult connectionResult) {
        this.e.p.a(connectionResult);
        this.e.a(connectionResult);
    }

    protected boolean a() {
        this.e.p.a(ConnectionResult.a);
        return true;
    }
}
