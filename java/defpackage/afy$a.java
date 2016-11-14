package defpackage;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.IBinder;
import android.os.Looper;
import android.os.RemoteException;
import com.google.android.gms.common.ConnectionResult;

public class afy$a implements ServiceConnection, ya$b, ya$c {
    final /* synthetic */ afy a;
    private volatile boolean b;
    private volatile agu c;

    protected afy$a(afy afy) {
        this.a = afy;
    }

    public void a() {
        this.a.j();
        Context q = this.a.q();
        synchronized (this) {
            if (this.b) {
                this.a.w().E().a("Connection attempt already in progress");
            } else if (this.c != null) {
                this.a.w().E().a("Already awaiting connection attempt");
            } else {
                this.c = new agu(q, Looper.getMainLooper(), this, this);
                this.a.w().E().a("Connecting to remote service");
                this.b = true;
                this.c.k();
            }
        }
    }

    public void a(int i) {
        xr.b("MeasurementServiceConnection.onConnectionSuspended");
        this.a.w().D().a("Service connection suspended");
        this.a.v().a(new afy$a$4(this));
    }

    public void a(Intent intent) {
        this.a.j();
        Context q = this.a.q();
        yw a = yw.a();
        synchronized (this) {
            if (this.b) {
                this.a.w().E().a("Connection attempt already in progress");
                return;
            }
            this.b = true;
            a.a(q, intent, this.a.a, 129);
        }
    }

    public void a(Bundle bundle) {
        xr.b("MeasurementServiceConnection.onConnected");
        synchronized (this) {
            try {
                ags ags = (ags) this.c.r();
                this.c = null;
                this.a.v().a(new afy$a$3(this, ags));
            } catch (DeadObjectException e) {
                this.c = null;
                this.b = false;
            } catch (IllegalStateException e2) {
                this.c = null;
                this.b = false;
            }
        }
    }

    public void a(ConnectionResult connectionResult) {
        xr.b("MeasurementServiceConnection.onConnectionFailed");
        agv g = this.a.n.g();
        if (g != null) {
            g.z().a("Service connection failed", connectionResult);
        }
        synchronized (this) {
            this.b = false;
            this.c = null;
        }
    }

    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        xr.b("MeasurementServiceConnection.onServiceConnected");
        synchronized (this) {
            if (iBinder == null) {
                this.b = false;
                this.a.w().f().a("Service connected with null binder");
                return;
            }
            ags ags = null;
            try {
                String interfaceDescriptor = iBinder.getInterfaceDescriptor();
                if ("com.google.android.gms.measurement.internal.IMeasurementService".equals(interfaceDescriptor)) {
                    ags = ags$a.a(iBinder);
                    this.a.w().E().a("Bound to IMeasurementService interface");
                } else {
                    this.a.w().f().a("Got binder with a wrong descriptor", interfaceDescriptor);
                }
            } catch (RemoteException e) {
                this.a.w().f().a("Service connect failed to get IMeasurementService");
            }
            if (ags == null) {
                this.b = false;
                try {
                    yw.a().a(this.a.q(), this.a.a);
                } catch (IllegalArgumentException e2) {
                }
            } else {
                this.a.v().a(new afy$a$1(this, ags));
            }
        }
    }

    public void onServiceDisconnected(ComponentName componentName) {
        xr.b("MeasurementServiceConnection.onServiceDisconnected");
        this.a.w().D().a("Service disconnected");
        this.a.v().a(new afy$a$2(this, componentName));
    }
}
