package defpackage;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

class aeh$a$a implements aeh {
    private IBinder a;

    aeh$a$a(IBinder iBinder) {
        this.a = iBinder;
    }

    public boolean a() throws RemoteException {
        boolean z = true;
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.android.gms.maps.internal.IOnMyLocationButtonClickListener");
            this.a.transact(1, obtain, obtain2, 0);
            obtain2.readException();
            if (obtain2.readInt() == 0) {
                z = false;
            }
            obtain2.recycle();
            obtain.recycle();
            return z;
        } catch (Throwable th) {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public IBinder asBinder() {
        return this.a;
    }
}
