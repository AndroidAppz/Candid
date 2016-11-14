package defpackage;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

class ael$a$a implements ael {
    private IBinder a;

    ael$a$a(IBinder iBinder) {
        this.a = iBinder;
    }

    public void a(aet aet) throws RemoteException {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.android.gms.maps.internal.IOnPolylineClickListener");
            obtain.writeStrongBinder(aet != null ? aet.asBinder() : null);
            this.a.transact(1, obtain, obtain2, 0);
            obtain2.readException();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public IBinder asBinder() {
        return this.a;
    }
}
