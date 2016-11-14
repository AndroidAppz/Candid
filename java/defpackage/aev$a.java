package defpackage;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.maps.model.LatLng;

public abstract class aev$a extends Binder implements aev {
    public static aev a(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.maps.model.internal.ICircleDelegate");
        return (queryLocalInterface == null || !(queryLocalInterface instanceof aev)) ? new aev$a$a(iBinder) : (aev) queryLocalInterface;
    }

    public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
        int i = 0;
        float e;
        boolean i2;
        switch (code) {
            case um$h.com_facebook_profile_picture_view_com_facebook_is_cropped /*1*/:
                data.enforceInterface("com.google.android.gms.maps.model.internal.ICircleDelegate");
                a();
                reply.writeNoException();
                return true;
            case um$h.com_facebook_login_view_com_facebook_logout_text /*2*/:
                data.enforceInterface("com.google.android.gms.maps.model.internal.ICircleDelegate");
                String b = b();
                reply.writeNoException();
                reply.writeString(b);
                return true;
            case um$h.com_facebook_login_view_com_facebook_tooltip_mode /*3*/:
                data.enforceInterface("com.google.android.gms.maps.model.internal.ICircleDelegate");
                a(data.readInt() != 0 ? LatLng.CREATOR.a(data) : null);
                reply.writeNoException();
                return true;
            case um$h.com_facebook_like_view_com_facebook_auxiliary_view_position /*4*/:
                data.enforceInterface("com.google.android.gms.maps.model.internal.ICircleDelegate");
                LatLng c = c();
                reply.writeNoException();
                if (c != null) {
                    reply.writeInt(1);
                    c.writeToParcel(reply, 1);
                    return true;
                }
                reply.writeInt(0);
                return true;
            case um$h.com_facebook_like_view_com_facebook_horizontal_alignment /*5*/:
                data.enforceInterface("com.google.android.gms.maps.model.internal.ICircleDelegate");
                a(data.readDouble());
                reply.writeNoException();
                return true;
            case um$h.CardView_cardUseCompatPadding /*6*/:
                data.enforceInterface("com.google.android.gms.maps.model.internal.ICircleDelegate");
                double d = d();
                reply.writeNoException();
                reply.writeDouble(d);
                return true;
            case um$h.CardView_cardPreventCornerOverlap /*7*/:
                data.enforceInterface("com.google.android.gms.maps.model.internal.ICircleDelegate");
                a(data.readFloat());
                reply.writeNoException();
                return true;
            case um$h.CardView_contentPadding /*8*/:
                data.enforceInterface("com.google.android.gms.maps.model.internal.ICircleDelegate");
                e = e();
                reply.writeNoException();
                reply.writeFloat(e);
                return true;
            case um$h.CardView_contentPaddingLeft /*9*/:
                data.enforceInterface("com.google.android.gms.maps.model.internal.ICircleDelegate");
                a(data.readInt());
                reply.writeNoException();
                return true;
            case um$h.CardView_contentPaddingRight /*10*/:
                data.enforceInterface("com.google.android.gms.maps.model.internal.ICircleDelegate");
                i = f();
                reply.writeNoException();
                reply.writeInt(i);
                return true;
            case um$h.CardView_contentPaddingTop /*11*/:
                data.enforceInterface("com.google.android.gms.maps.model.internal.ICircleDelegate");
                b(data.readInt());
                reply.writeNoException();
                return true;
            case um$h.CardView_contentPaddingBottom /*12*/:
                data.enforceInterface("com.google.android.gms.maps.model.internal.ICircleDelegate");
                i = g();
                reply.writeNoException();
                reply.writeInt(i);
                return true;
            case ha$a.Toolbar_titleMarginStart /*13*/:
                data.enforceInterface("com.google.android.gms.maps.model.internal.ICircleDelegate");
                b(data.readFloat());
                reply.writeNoException();
                return true;
            case ha$a.Toolbar_titleMarginEnd /*14*/:
                data.enforceInterface("com.google.android.gms.maps.model.internal.ICircleDelegate");
                e = h();
                reply.writeNoException();
                reply.writeFloat(e);
                return true;
            case ha$a.Toolbar_titleMarginTop /*15*/:
                boolean z;
                data.enforceInterface("com.google.android.gms.maps.model.internal.ICircleDelegate");
                if (data.readInt() != 0) {
                    z = true;
                }
                a(z);
                reply.writeNoException();
                return true;
            case ha$a.Toolbar_titleMarginBottom /*16*/:
                data.enforceInterface("com.google.android.gms.maps.model.internal.ICircleDelegate");
                i2 = i();
                reply.writeNoException();
                if (i2) {
                    i = 1;
                }
                reply.writeInt(i);
                return true;
            case ha$a.Toolbar_maxButtonHeight /*17*/:
                data.enforceInterface("com.google.android.gms.maps.model.internal.ICircleDelegate");
                i2 = a(aev$a.a(data.readStrongBinder()));
                reply.writeNoException();
                if (i2) {
                    i = 1;
                }
                reply.writeInt(i);
                return true;
            case ha$a.Toolbar_collapseIcon /*18*/:
                data.enforceInterface("com.google.android.gms.maps.model.internal.ICircleDelegate");
                i = j();
                reply.writeNoException();
                reply.writeInt(i);
                return true;
            case 1598968902:
                reply.writeString("com.google.android.gms.maps.model.internal.ICircleDelegate");
                return true;
            default:
                return super.onTransact(code, data, reply, flags);
        }
    }
}
