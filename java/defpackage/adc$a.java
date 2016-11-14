package defpackage;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public abstract class adc$a extends Binder implements adc {
    public static adc a(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.maps.internal.ILocationSourceDelegate");
        return (queryLocalInterface == null || !(queryLocalInterface instanceof adc)) ? new adc$a$a(iBinder) : (adc) queryLocalInterface;
    }

    public IBinder asBinder() {
        return this;
    }

    public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
        switch (code) {
            case um$h.com_facebook_profile_picture_view_com_facebook_is_cropped /*1*/:
                data.enforceInterface("com.google.android.gms.maps.internal.ILocationSourceDelegate");
                a(aea$a.a(data.readStrongBinder()));
                reply.writeNoException();
                return true;
            case um$h.com_facebook_login_view_com_facebook_logout_text /*2*/:
                data.enforceInterface("com.google.android.gms.maps.internal.ILocationSourceDelegate");
                a();
                reply.writeNoException();
                return true;
            case 1598968902:
                reply.writeString("com.google.android.gms.maps.internal.ILocationSourceDelegate");
                return true;
            default:
                return super.onTransact(code, data, reply, flags);
        }
    }
}
