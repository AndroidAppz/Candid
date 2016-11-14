package defpackage;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public abstract class afa$a extends Binder implements afa {
    public static afa a(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.maps.model.internal.ITileOverlayDelegate");
        return (queryLocalInterface == null || !(queryLocalInterface instanceof afa)) ? new afa$a$a(iBinder) : (afa) queryLocalInterface;
    }

    public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
        int i = 0;
        boolean z;
        boolean e;
        switch (code) {
            case um$h.com_facebook_profile_picture_view_com_facebook_is_cropped /*1*/:
                data.enforceInterface("com.google.android.gms.maps.model.internal.ITileOverlayDelegate");
                a();
                reply.writeNoException();
                return true;
            case um$h.com_facebook_login_view_com_facebook_logout_text /*2*/:
                data.enforceInterface("com.google.android.gms.maps.model.internal.ITileOverlayDelegate");
                b();
                reply.writeNoException();
                return true;
            case um$h.com_facebook_login_view_com_facebook_tooltip_mode /*3*/:
                data.enforceInterface("com.google.android.gms.maps.model.internal.ITileOverlayDelegate");
                String c = c();
                reply.writeNoException();
                reply.writeString(c);
                return true;
            case um$h.com_facebook_like_view_com_facebook_auxiliary_view_position /*4*/:
                data.enforceInterface("com.google.android.gms.maps.model.internal.ITileOverlayDelegate");
                a(data.readFloat());
                reply.writeNoException();
                return true;
            case um$h.com_facebook_like_view_com_facebook_horizontal_alignment /*5*/:
                data.enforceInterface("com.google.android.gms.maps.model.internal.ITileOverlayDelegate");
                float d = d();
                reply.writeNoException();
                reply.writeFloat(d);
                return true;
            case um$h.CardView_cardUseCompatPadding /*6*/:
                data.enforceInterface("com.google.android.gms.maps.model.internal.ITileOverlayDelegate");
                if (data.readInt() != 0) {
                    z = true;
                }
                a(z);
                reply.writeNoException();
                return true;
            case um$h.CardView_cardPreventCornerOverlap /*7*/:
                data.enforceInterface("com.google.android.gms.maps.model.internal.ITileOverlayDelegate");
                e = e();
                reply.writeNoException();
                if (e) {
                    i = 1;
                }
                reply.writeInt(i);
                return true;
            case um$h.CardView_contentPadding /*8*/:
                data.enforceInterface("com.google.android.gms.maps.model.internal.ITileOverlayDelegate");
                e = a(afa$a.a(data.readStrongBinder()));
                reply.writeNoException();
                if (e) {
                    i = 1;
                }
                reply.writeInt(i);
                return true;
            case um$h.CardView_contentPaddingLeft /*9*/:
                data.enforceInterface("com.google.android.gms.maps.model.internal.ITileOverlayDelegate");
                i = f();
                reply.writeNoException();
                reply.writeInt(i);
                return true;
            case um$h.CardView_contentPaddingRight /*10*/:
                data.enforceInterface("com.google.android.gms.maps.model.internal.ITileOverlayDelegate");
                if (data.readInt() != 0) {
                    z = true;
                }
                b(z);
                reply.writeNoException();
                return true;
            case um$h.CardView_contentPaddingTop /*11*/:
                data.enforceInterface("com.google.android.gms.maps.model.internal.ITileOverlayDelegate");
                e = g();
                reply.writeNoException();
                if (e) {
                    i = 1;
                }
                reply.writeInt(i);
                return true;
            case 1598968902:
                reply.writeString("com.google.android.gms.maps.model.internal.ITileOverlayDelegate");
                return true;
            default:
                return super.onTransact(code, data, reply, flags);
        }
    }
}
