package defpackage;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public abstract class ade$a extends Binder implements ade {
    public static ade a(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.maps.internal.IMapViewDelegate");
        return (queryLocalInterface == null || !(queryLocalInterface instanceof ade)) ? new ade$a$a(iBinder) : (ade) queryLocalInterface;
    }

    public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
        Bundle bundle = null;
        IBinder asBinder;
        switch (code) {
            case um$h.com_facebook_profile_picture_view_com_facebook_is_cropped /*1*/:
                data.enforceInterface("com.google.android.gms.maps.internal.IMapViewDelegate");
                adb a = a();
                reply.writeNoException();
                if (a != null) {
                    asBinder = a.asBinder();
                }
                reply.writeStrongBinder(asBinder);
                return true;
            case um$h.com_facebook_login_view_com_facebook_logout_text /*2*/:
                data.enforceInterface("com.google.android.gms.maps.internal.IMapViewDelegate");
                if (data.readInt() != 0) {
                    bundle = (Bundle) Bundle.CREATOR.createFromParcel(data);
                }
                a(bundle);
                reply.writeNoException();
                return true;
            case um$h.com_facebook_login_view_com_facebook_tooltip_mode /*3*/:
                data.enforceInterface("com.google.android.gms.maps.internal.IMapViewDelegate");
                b();
                reply.writeNoException();
                return true;
            case um$h.com_facebook_like_view_com_facebook_auxiliary_view_position /*4*/:
                data.enforceInterface("com.google.android.gms.maps.internal.IMapViewDelegate");
                c();
                reply.writeNoException();
                return true;
            case um$h.com_facebook_like_view_com_facebook_horizontal_alignment /*5*/:
                data.enforceInterface("com.google.android.gms.maps.internal.IMapViewDelegate");
                d();
                reply.writeNoException();
                return true;
            case um$h.CardView_cardUseCompatPadding /*6*/:
                data.enforceInterface("com.google.android.gms.maps.internal.IMapViewDelegate");
                e();
                reply.writeNoException();
                return true;
            case um$h.CardView_cardPreventCornerOverlap /*7*/:
                data.enforceInterface("com.google.android.gms.maps.internal.IMapViewDelegate");
                if (data.readInt() != 0) {
                    bundle = (Bundle) Bundle.CREATOR.createFromParcel(data);
                }
                b(bundle);
                reply.writeNoException();
                if (bundle != null) {
                    reply.writeInt(1);
                    bundle.writeToParcel(reply, 1);
                } else {
                    reply.writeInt(0);
                }
                return true;
            case um$h.CardView_contentPadding /*8*/:
                data.enforceInterface("com.google.android.gms.maps.internal.IMapViewDelegate");
                zy f = f();
                reply.writeNoException();
                if (f != null) {
                    asBinder = f.asBinder();
                }
                reply.writeStrongBinder(asBinder);
                return true;
            case um$h.CardView_contentPaddingLeft /*9*/:
                data.enforceInterface("com.google.android.gms.maps.internal.IMapViewDelegate");
                a(aee$a.a(data.readStrongBinder()));
                reply.writeNoException();
                return true;
            case um$h.CardView_contentPaddingRight /*10*/:
                data.enforceInterface("com.google.android.gms.maps.internal.IMapViewDelegate");
                if (data.readInt() != 0) {
                    bundle = (Bundle) Bundle.CREATOR.createFromParcel(data);
                }
                c(bundle);
                reply.writeNoException();
                return true;
            case um$h.CardView_contentPaddingTop /*11*/:
                data.enforceInterface("com.google.android.gms.maps.internal.IMapViewDelegate");
                g();
                reply.writeNoException();
                return true;
            case 1598968902:
                reply.writeString("com.google.android.gms.maps.internal.IMapViewDelegate");
                return true;
            default:
                return super.onTransact(code, data, reply, flags);
        }
    }
}
