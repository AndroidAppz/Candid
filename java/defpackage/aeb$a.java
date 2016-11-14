package defpackage;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.maps.model.LatLng;

public abstract class aeb$a extends Binder implements aeb {
    public static aeb a(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.maps.internal.IOnMapClickListener");
        return (queryLocalInterface == null || !(queryLocalInterface instanceof aeb)) ? new aeb$a$a(iBinder) : (aeb) queryLocalInterface;
    }

    public IBinder asBinder() {
        return this;
    }

    public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
        switch (code) {
            case um$h.com_facebook_profile_picture_view_com_facebook_is_cropped /*1*/:
                data.enforceInterface("com.google.android.gms.maps.internal.IOnMapClickListener");
                a(data.readInt() != 0 ? LatLng.CREATOR.a(data) : null);
                reply.writeNoException();
                return true;
            case 1598968902:
                reply.writeString("com.google.android.gms.maps.internal.IOnMapClickListener");
                return true;
            default:
                return super.onTransact(code, data, reply, flags);
        }
    }
}
