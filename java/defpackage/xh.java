package defpackage;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Status;

public class xh extends xi {
    private final ConnectionResult a;

    public xh(Status status, dh<aas<?>, ConnectionResult> dhVar) {
        super(status, dhVar);
        this.a = (ConnectionResult) dhVar.get(dhVar.b(0));
    }
}
