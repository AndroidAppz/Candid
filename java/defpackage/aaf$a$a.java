package defpackage;

import android.os.IBinder;
import android.os.Message;
import android.os.Parcel;
import android.os.RemoteException;

class aaf$a$a implements aaf {
    private IBinder a;

    aaf$a$a(IBinder iBinder) {
        this.a = iBinder;
    }

    public void a(Message message) throws RemoteException {
        Parcel obtain = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.android.gms.iid.IMessengerCompat");
            if (message != null) {
                obtain.writeInt(1);
                message.writeToParcel(obtain, 0);
            } else {
                obtain.writeInt(0);
            }
            this.a.transact(1, obtain, null, 1);
        } finally {
            obtain.recycle();
        }
    }

    public IBinder asBinder() {
        return this.a;
    }
}
