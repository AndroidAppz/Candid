package defpackage;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

class aek$a$a implements aek {
    private IBinder a;

    aek$a$a(IBinder iBinder) {
        this.a = iBinder;
    }

    public void a(aez aez) throws RemoteException {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.android.gms.maps.internal.IOnPolygonClickListener");
            obtain.writeStrongBinder(aez != null ? aez.asBinder() : null);
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
