/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.common.ConnectionResult
 *  com.google.android.gms.common.api.Status
 *  java.lang.Object
 *  java.util.Set
 */
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Status;
import java.util.Set;

public final class aat
extends aaw<xi> {
    private int d;
    private boolean e;

    private void a(ConnectionResult connectionResult) {
        for (int i2 = 0; i2 < ((dq)null).size(); ++i2) {
            this.a((aas)((dq)null).b(i2), connectionResult);
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    protected xi a(Status status) {
        Object var4_2 = null;
        synchronized (null) {
            super.a(new ConnectionResult(8));
            if (((dq)null).size() != 1) return new xi(status, null);
            return new xh(status, null);
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void a(aas<?> aas2, ConnectionResult connectionResult) {
        Object var7_3 = null;
        synchronized (null) {
            ((dq)null).put(aas2, connectionResult);
            this.d = -1 + this.d;
            if (!connectionResult.b()) {
                this.e = true;
            }
            if (this.d == 0) {
                Status status = this.e ? new Status(13) : Status.a;
                xi xi2 = ((dq)null).size() == 1 ? new xh(status, null) : new xi(status, null);
                this.b(xi2);
            }
            // ** MonitorExit[var7_3] (shouldn't be in output)
            return;
        }
    }

    public Set<aas<?>> b() {
        return ((dh)null).keySet();
    }

    @Override
    protected /* synthetic */ xc b(Status status) {
        return this.a(status);
    }
}

