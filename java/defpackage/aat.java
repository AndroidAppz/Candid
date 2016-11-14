package defpackage;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Status;
import java.util.Set;

public final class aat extends aaw<xi> {
    private int d;
    private boolean e;

    private void a(ConnectionResult connectionResult) {
        dh dhVar = null;
        for (int i = 0; i < dhVar.size(); i++) {
            a((aas) dhVar.b(i), connectionResult);
        }
    }

    protected xi a(Status status) {
        xi xiVar;
        synchronized (null) {
            try {
                a(new ConnectionResult(8));
                dh dhVar = null;
                if (dhVar.size() != 1) {
                    xiVar = new xi(status, null);
                }
            } finally {
            }
        }
        return xiVar;
    }

    public void a(aas<?> aas_, ConnectionResult connectionResult) {
        synchronized (null) {
            dh dhVar = null;
            try {
                dhVar.put(aas_, connectionResult);
                this.d--;
                boolean b = connectionResult.b();
                if (!b) {
                    this.e = b;
                }
                if (this.d == 0) {
                    Status status = this.e ? new Status(13) : Status.a;
                    dhVar = null;
                    b(dhVar.size() == 1 ? new xh(status, null) : new xi(status, null));
                }
            } finally {
            }
        }
    }

    public Set<aas<?>> b() {
        dh dhVar = null;
        return dhVar.keySet();
    }

    protected /* synthetic */ xc b(Status status) {
        return a(status);
    }
}
