package defpackage;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.maps.model.PointOfInterest;

public abstract class aej$a extends Binder implements aej {
    public static aej a(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.maps.internal.IOnPoiClickListener");
        return (queryLocalInterface == null || !(queryLocalInterface instanceof aej)) ? new aej$a$a(iBinder) : (aej) queryLocalInterface;
    }

    public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
        switch (code) {
            case um$h.com_facebook_profile_picture_view_com_facebook_is_cropped /*1*/:
                data.enforceInterface("com.google.android.gms.maps.internal.IOnPoiClickListener");
                a(data.readInt() != 0 ? PointOfInterest.CREATOR.a(data) : null);
                reply.writeNoException();
                return true;
            case 1598968902:
                reply.writeString("com.google.android.gms.maps.internal.IOnPoiClickListener");
                return true;
            default:
                return super.onTransact(code, data, reply, flags);
        }
    }
}
