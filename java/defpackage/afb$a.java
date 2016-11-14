package defpackage;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.maps.model.Tile;

public abstract class afb$a extends Binder implements afb {
    public static afb a(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.maps.model.internal.ITileProviderDelegate");
        return (queryLocalInterface == null || !(queryLocalInterface instanceof afb)) ? new afb$a$a(iBinder) : (afb) queryLocalInterface;
    }

    public IBinder asBinder() {
        return this;
    }

    public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
        switch (code) {
            case um$h.com_facebook_profile_picture_view_com_facebook_is_cropped /*1*/:
                data.enforceInterface("com.google.android.gms.maps.model.internal.ITileProviderDelegate");
                Tile a = a(data.readInt(), data.readInt(), data.readInt());
                reply.writeNoException();
                if (a != null) {
                    reply.writeInt(1);
                    a.writeToParcel(reply, 1);
                    return true;
                }
                reply.writeInt(0);
                return true;
            case 1598968902:
                reply.writeString("com.google.android.gms.maps.model.internal.ITileProviderDelegate");
                return true;
            default:
                return super.onTransact(code, data, reply, flags);
        }
    }
}
