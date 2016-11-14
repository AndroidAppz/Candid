package defpackage;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;

public final class ya$j extends ya$a {
    public final IBinder e;
    final /* synthetic */ ya f;

    public ya$j(ya yaVar, int i, IBinder iBinder, Bundle bundle) {
        this.f = yaVar;
        super(yaVar, i, bundle);
        this.e = iBinder;
    }

    protected void a(ConnectionResult connectionResult) {
        if (this.f.v != null) {
            this.f.v.a(connectionResult);
        }
        this.f.a(connectionResult);
    }

    protected boolean a() {
        try {
            String interfaceDescriptor = this.e.getInterfaceDescriptor();
            if (this.f.g().equals(interfaceDescriptor)) {
                IInterface a = this.f.a(this.e);
                if (a == null || !this.f.a(2, 3, a)) {
                    return false;
                }
                Bundle q = this.f.q();
                if (this.f.u != null) {
                    this.f.u.a(q);
                }
                return true;
            }
            String valueOf = String.valueOf(this.f.g());
            Log.e("GmsClient", new StringBuilder((String.valueOf(valueOf).length() + 34) + String.valueOf(interfaceDescriptor).length()).append("service descriptor mismatch: ").append(valueOf).append(" vs. ").append(interfaceDescriptor).toString());
            return false;
        } catch (RemoteException e) {
            Log.w("GmsClient", "service probably died");
            return false;
        }
    }
}
