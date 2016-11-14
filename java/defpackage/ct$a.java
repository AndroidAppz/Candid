package defpackage;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: IResultReceiver */
public abstract class ct$a extends Binder implements ct {
    public ct$a() {
        attachInterface(this, "android.support.v4.os.IResultReceiver");
    }

    public static ct a(IBinder obj) {
        if (obj == null) {
            return null;
        }
        IInterface iin = obj.queryLocalInterface("android.support.v4.os.IResultReceiver");
        if (iin == null || !(iin instanceof ct)) {
            return new ct$a$a(obj);
        }
        return (ct) iin;
    }

    public IBinder asBinder() {
        return this;
    }

    public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
        switch (code) {
            case um$h.com_facebook_profile_picture_view_com_facebook_is_cropped /*1*/:
                Bundle _arg1;
                data.enforceInterface("android.support.v4.os.IResultReceiver");
                int _arg0 = data.readInt();
                if (data.readInt() != 0) {
                    _arg1 = (Bundle) Bundle.CREATOR.createFromParcel(data);
                } else {
                    _arg1 = null;
                }
                a(_arg0, _arg1);
                return true;
            case 1598968902:
                reply.writeString("android.support.v4.os.IResultReceiver");
                return true;
            default:
                return super.onTransact(code, data, reply, flags);
        }
    }
}
