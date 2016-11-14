package defpackage;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: IResultReceiver */
class ct$a$a implements ct {
    private IBinder a;

    ct$a$a(IBinder remote) {
        this.a = remote;
    }

    public IBinder asBinder() {
        return this.a;
    }

    public void a(int resultCode, Bundle resultData) throws RemoteException {
        Parcel _data = Parcel.obtain();
        try {
            _data.writeInterfaceToken("android.support.v4.os.IResultReceiver");
            _data.writeInt(resultCode);
            if (resultData != null) {
                _data.writeInt(1);
                resultData.writeToParcel(_data, 0);
            } else {
                _data.writeInt(0);
            }
            this.a.transact(1, _data, null, 1);
        } finally {
            _data.recycle();
        }
    }
}
