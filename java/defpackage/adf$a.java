package defpackage;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.VisibleRegion;

public abstract class adf$a extends Binder implements adf {
    public static adf a(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.maps.internal.IProjectionDelegate");
        return (queryLocalInterface == null || !(queryLocalInterface instanceof adf)) ? new adf$a$a(iBinder) : (adf) queryLocalInterface;
    }

    public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
        IBinder iBinder = null;
        switch (code) {
            case um$h.com_facebook_profile_picture_view_com_facebook_is_cropped /*1*/:
                data.enforceInterface("com.google.android.gms.maps.internal.IProjectionDelegate");
                LatLng a = a((zy) zy$a.zzbs(data.readStrongBinder()));
                reply.writeNoException();
                if (a != null) {
                    reply.writeInt(1);
                    a.writeToParcel(reply, 1);
                } else {
                    reply.writeInt(0);
                }
                return true;
            case um$h.com_facebook_login_view_com_facebook_logout_text /*2*/:
                data.enforceInterface("com.google.android.gms.maps.internal.IProjectionDelegate");
                zy a2 = a(data.readInt() != 0 ? LatLng.CREATOR.a(data) : null);
                reply.writeNoException();
                if (a2 != null) {
                    iBinder = a2.asBinder();
                }
                reply.writeStrongBinder(iBinder);
                return true;
            case um$h.com_facebook_login_view_com_facebook_tooltip_mode /*3*/:
                data.enforceInterface("com.google.android.gms.maps.internal.IProjectionDelegate");
                VisibleRegion a3 = a();
                reply.writeNoException();
                if (a3 != null) {
                    reply.writeInt(1);
                    a3.writeToParcel(reply, 1);
                } else {
                    reply.writeInt(0);
                }
                return true;
            case 1598968902:
                reply.writeString("com.google.android.gms.maps.internal.IProjectionDelegate");
                return true;
            default:
                return super.onTransact(code, data, reply, flags);
        }
    }
}
