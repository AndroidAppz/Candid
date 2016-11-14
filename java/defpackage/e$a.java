package defpackage;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: ICustomTabsCallback */
public abstract class e$a extends Binder implements e {
    public static e a(IBinder obj) {
        if (obj == null) {
            return null;
        }
        IInterface iin = obj.queryLocalInterface("android.support.customtabs.ICustomTabsCallback");
        if (iin == null || !(iin instanceof e)) {
            return new e$a$a(obj);
        }
        return (e) iin;
    }

    public IBinder asBinder() {
        return this;
    }

    public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
        Bundle _arg1;
        switch (code) {
            case um$h.com_facebook_login_view_com_facebook_logout_text /*2*/:
                data.enforceInterface("android.support.customtabs.ICustomTabsCallback");
                int _arg0 = data.readInt();
                if (data.readInt() != 0) {
                    _arg1 = (Bundle) Bundle.CREATOR.createFromParcel(data);
                } else {
                    _arg1 = null;
                }
                a(_arg0, _arg1);
                return true;
            case um$h.com_facebook_login_view_com_facebook_tooltip_mode /*3*/:
                data.enforceInterface("android.support.customtabs.ICustomTabsCallback");
                String _arg02 = data.readString();
                if (data.readInt() != 0) {
                    _arg1 = (Bundle) Bundle.CREATOR.createFromParcel(data);
                } else {
                    _arg1 = null;
                }
                a(_arg02, _arg1);
                return true;
            case 1598968902:
                reply.writeString("android.support.customtabs.ICustomTabsCallback");
                return true;
            default:
                return super.onTransact(code, data, reply, flags);
        }
    }
}
