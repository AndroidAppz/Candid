package defpackage;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: AttributionIdentifiers */
final class uy$a implements IInterface {
    private IBinder a;

    uy$a(IBinder binder) {
        this.a = binder;
    }

    public IBinder asBinder() {
        return this.a;
    }

    public String a() throws RemoteException {
        Parcel data = Parcel.obtain();
        Parcel reply = Parcel.obtain();
        try {
            data.writeInterfaceToken("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
            this.a.transact(1, data, reply, 0);
            reply.readException();
            String id = reply.readString();
            return id;
        } finally {
            reply.recycle();
            data.recycle();
        }
    }

    public boolean b() throws RemoteException {
        boolean limitAdTracking = true;
        Parcel data = Parcel.obtain();
        Parcel reply = Parcel.obtain();
        try {
            data.writeInterfaceToken("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
            data.writeInt(1);
            this.a.transact(2, data, reply, 0);
            reply.readException();
            if (reply.readInt() == 0) {
                limitAdTracking = false;
            }
            reply.recycle();
            data.recycle();
            return limitAdTracking;
        } catch (Throwable th) {
            reply.recycle();
            data.recycle();
        }
    }
}
