package defpackage;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: ICustomTabsCallback */
class e$a$a implements e {
    private IBinder a;

    e$a$a(IBinder remote) {
        this.a = remote;
    }

    public IBinder asBinder() {
        return this.a;
    }

    public void a(int navigationEvent, Bundle extras) throws RemoteException {
        Parcel _data = Parcel.obtain();
        try {
            _data.writeInterfaceToken("android.support.customtabs.ICustomTabsCallback");
            _data.writeInt(navigationEvent);
            if (extras != null) {
                _data.writeInt(1);
                extras.writeToParcel(_data, 0);
            } else {
                _data.writeInt(0);
            }
            this.a.transact(2, _data, null, 1);
        } finally {
            _data.recycle();
        }
    }

    public void a(String callbackName, Bundle args) throws RemoteException {
        Parcel _data = Parcel.obtain();
        try {
            _data.writeInterfaceToken("android.support.customtabs.ICustomTabsCallback");
            _data.writeString(callbackName);
            if (args != null) {
                _data.writeInt(1);
                args.writeToParcel(_data, 0);
            } else {
                _data.writeInt(0);
            }
            this.a.transact(3, _data, null, 1);
        } finally {
            _data.recycle();
        }
    }
}
