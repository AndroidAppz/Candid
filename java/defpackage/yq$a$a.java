package defpackage;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.common.internal.ResolveAccountResponse;

class yq$a$a implements yq {
    private IBinder a;

    yq$a$a(IBinder iBinder) {
        this.a = iBinder;
    }

    public void a(ResolveAccountResponse resolveAccountResponse) throws RemoteException {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.android.gms.common.internal.IResolveAccountCallbacks");
            if (resolveAccountResponse != null) {
                obtain.writeInt(1);
                resolveAccountResponse.writeToParcel(obtain, 0);
            } else {
                obtain.writeInt(0);
            }
            this.a.transact(2, obtain, obtain2, 0);
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
