package defpackage;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public abstract class aee$a extends Binder implements aee {
    public aee$a() {
        attachInterface(this, "com.google.android.gms.maps.internal.IOnMapReadyCallback");
    }

    public static aee a(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.maps.internal.IOnMapReadyCallback");
        return (queryLocalInterface == null || !(queryLocalInterface instanceof aee)) ? new aee$a$a(iBinder) : (aee) queryLocalInterface;
    }

    public IBinder asBinder() {
        return this;
    }

    public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
        switch (code) {
            case um$h.com_facebook_profile_picture_view_com_facebook_is_cropped /*1*/:
                data.enforceInterface("com.google.android.gms.maps.internal.IOnMapReadyCallback");
                a(adb$a.a(data.readStrongBinder()));
                reply.writeNoException();
                return true;
            case 1598968902:
                reply.writeString("com.google.android.gms.maps.internal.IOnMapReadyCallback");
                return true;
            default:
                return super.onTransact(code, data, reply, flags);
        }
    }
}
