package defpackage;

import android.graphics.Bitmap;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public abstract class aeu$a extends Binder implements aeu {
    public static aeu a(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.maps.model.internal.IBitmapDescriptorFactoryDelegate");
        return (queryLocalInterface == null || !(queryLocalInterface instanceof aeu)) ? new aeu$a$a(iBinder) : (aeu) queryLocalInterface;
    }

    public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
        IBinder iBinder = null;
        zy a;
        switch (code) {
            case um$h.com_facebook_profile_picture_view_com_facebook_is_cropped /*1*/:
                data.enforceInterface("com.google.android.gms.maps.model.internal.IBitmapDescriptorFactoryDelegate");
                a = a(data.readInt());
                reply.writeNoException();
                reply.writeStrongBinder(a != null ? a.asBinder() : null);
                return true;
            case um$h.com_facebook_login_view_com_facebook_logout_text /*2*/:
                data.enforceInterface("com.google.android.gms.maps.model.internal.IBitmapDescriptorFactoryDelegate");
                a = a(data.readString());
                reply.writeNoException();
                if (a != null) {
                    iBinder = a.asBinder();
                }
                reply.writeStrongBinder(iBinder);
                return true;
            case um$h.com_facebook_login_view_com_facebook_tooltip_mode /*3*/:
                data.enforceInterface("com.google.android.gms.maps.model.internal.IBitmapDescriptorFactoryDelegate");
                a = b(data.readString());
                reply.writeNoException();
                if (a != null) {
                    iBinder = a.asBinder();
                }
                reply.writeStrongBinder(iBinder);
                return true;
            case um$h.com_facebook_like_view_com_facebook_auxiliary_view_position /*4*/:
                data.enforceInterface("com.google.android.gms.maps.model.internal.IBitmapDescriptorFactoryDelegate");
                a = a();
                reply.writeNoException();
                if (a != null) {
                    iBinder = a.asBinder();
                }
                reply.writeStrongBinder(iBinder);
                return true;
            case um$h.com_facebook_like_view_com_facebook_horizontal_alignment /*5*/:
                data.enforceInterface("com.google.android.gms.maps.model.internal.IBitmapDescriptorFactoryDelegate");
                a = a(data.readFloat());
                reply.writeNoException();
                if (a != null) {
                    iBinder = a.asBinder();
                }
                reply.writeStrongBinder(iBinder);
                return true;
            case um$h.CardView_cardUseCompatPadding /*6*/:
                data.enforceInterface("com.google.android.gms.maps.model.internal.IBitmapDescriptorFactoryDelegate");
                a = a(data.readInt() != 0 ? (Bitmap) Bitmap.CREATOR.createFromParcel(data) : null);
                reply.writeNoException();
                if (a != null) {
                    iBinder = a.asBinder();
                }
                reply.writeStrongBinder(iBinder);
                return true;
            case um$h.CardView_cardPreventCornerOverlap /*7*/:
                data.enforceInterface("com.google.android.gms.maps.model.internal.IBitmapDescriptorFactoryDelegate");
                a = c(data.readString());
                reply.writeNoException();
                if (a != null) {
                    iBinder = a.asBinder();
                }
                reply.writeStrongBinder(iBinder);
                return true;
            case 1598968902:
                reply.writeString("com.google.android.gms.maps.model.internal.IBitmapDescriptorFactoryDelegate");
                return true;
            default:
                return super.onTransact(code, data, reply, flags);
        }
    }
}
