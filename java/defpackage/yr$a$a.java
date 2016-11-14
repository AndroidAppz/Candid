package defpackage;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.common.internal.SignInButtonConfig;

class yr$a$a implements yr {
    private IBinder a;

    yr$a$a(IBinder iBinder) {
        this.a = iBinder;
    }

    public zy a(zy zyVar, int i, int i2) throws RemoteException {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.android.gms.common.internal.ISignInButtonCreator");
            obtain.writeStrongBinder(zyVar != null ? zyVar.asBinder() : null);
            obtain.writeInt(i);
            obtain.writeInt(i2);
            this.a.transact(1, obtain, obtain2, 0);
            obtain2.readException();
            zy a = zy$a.a(obtain2.readStrongBinder());
            return a;
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public zy a(zy zyVar, SignInButtonConfig signInButtonConfig) throws RemoteException {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.android.gms.common.internal.ISignInButtonCreator");
            obtain.writeStrongBinder(zyVar != null ? zyVar.asBinder() : null);
            if (signInButtonConfig != null) {
                obtain.writeInt(1);
                signInButtonConfig.writeToParcel(obtain, 0);
            } else {
                obtain.writeInt(0);
            }
            this.a.transact(2, obtain, obtain2, 0);
            obtain2.readException();
            zy a = zy$a.a(obtain2.readStrongBinder());
            return a;
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public IBinder asBinder() {
        return this.a;
    }
}
