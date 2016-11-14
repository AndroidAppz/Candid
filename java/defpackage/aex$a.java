package defpackage;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import java.util.List;

public abstract class aex$a extends Binder implements aex {
    public static aex a(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.maps.model.internal.IIndoorBuildingDelegate");
        return (queryLocalInterface == null || !(queryLocalInterface instanceof aex)) ? new aex$a$a(iBinder) : (aex) queryLocalInterface;
    }

    public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
        int i = 0;
        boolean d;
        switch (code) {
            case um$h.com_facebook_profile_picture_view_com_facebook_is_cropped /*1*/:
                data.enforceInterface("com.google.android.gms.maps.model.internal.IIndoorBuildingDelegate");
                i = a();
                reply.writeNoException();
                reply.writeInt(i);
                return true;
            case um$h.com_facebook_login_view_com_facebook_logout_text /*2*/:
                data.enforceInterface("com.google.android.gms.maps.model.internal.IIndoorBuildingDelegate");
                i = b();
                reply.writeNoException();
                reply.writeInt(i);
                return true;
            case um$h.com_facebook_login_view_com_facebook_tooltip_mode /*3*/:
                data.enforceInterface("com.google.android.gms.maps.model.internal.IIndoorBuildingDelegate");
                List c = c();
                reply.writeNoException();
                reply.writeBinderList(c);
                return true;
            case um$h.com_facebook_like_view_com_facebook_auxiliary_view_position /*4*/:
                data.enforceInterface("com.google.android.gms.maps.model.internal.IIndoorBuildingDelegate");
                d = d();
                reply.writeNoException();
                if (d) {
                    i = 1;
                }
                reply.writeInt(i);
                return true;
            case um$h.com_facebook_like_view_com_facebook_horizontal_alignment /*5*/:
                data.enforceInterface("com.google.android.gms.maps.model.internal.IIndoorBuildingDelegate");
                d = a(aex$a.a(data.readStrongBinder()));
                reply.writeNoException();
                if (d) {
                    i = 1;
                }
                reply.writeInt(i);
                return true;
            case um$h.CardView_cardUseCompatPadding /*6*/:
                data.enforceInterface("com.google.android.gms.maps.model.internal.IIndoorBuildingDelegate");
                i = e();
                reply.writeNoException();
                reply.writeInt(i);
                return true;
            case 1598968902:
                reply.writeString("com.google.android.gms.maps.model.internal.IIndoorBuildingDelegate");
                return true;
            default:
                return super.onTransact(code, data, reply, flags);
        }
    }
}
