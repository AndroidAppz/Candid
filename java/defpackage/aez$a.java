package defpackage;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.maps.model.LatLng;
import java.util.List;
import okhttp3.internal.http.HttpEngine;

public abstract class aez$a extends Binder implements aez {
    public static aez a(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.maps.model.internal.IPolygonDelegate");
        return (queryLocalInterface == null || !(queryLocalInterface instanceof aez)) ? new aez$a$a(iBinder) : (aez) queryLocalInterface;
    }

    public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
        int i = 0;
        List c;
        float e;
        boolean z;
        boolean i2;
        switch (code) {
            case um$h.com_facebook_profile_picture_view_com_facebook_is_cropped /*1*/:
                data.enforceInterface("com.google.android.gms.maps.model.internal.IPolygonDelegate");
                a();
                reply.writeNoException();
                return true;
            case um$h.com_facebook_login_view_com_facebook_logout_text /*2*/:
                data.enforceInterface("com.google.android.gms.maps.model.internal.IPolygonDelegate");
                String b = b();
                reply.writeNoException();
                reply.writeString(b);
                return true;
            case um$h.com_facebook_login_view_com_facebook_tooltip_mode /*3*/:
                data.enforceInterface("com.google.android.gms.maps.model.internal.IPolygonDelegate");
                a(data.createTypedArrayList(LatLng.CREATOR));
                reply.writeNoException();
                return true;
            case um$h.com_facebook_like_view_com_facebook_auxiliary_view_position /*4*/:
                data.enforceInterface("com.google.android.gms.maps.model.internal.IPolygonDelegate");
                c = c();
                reply.writeNoException();
                reply.writeTypedList(c);
                return true;
            case um$h.com_facebook_like_view_com_facebook_horizontal_alignment /*5*/:
                data.enforceInterface("com.google.android.gms.maps.model.internal.IPolygonDelegate");
                b(data.readArrayList(getClass().getClassLoader()));
                reply.writeNoException();
                return true;
            case um$h.CardView_cardUseCompatPadding /*6*/:
                data.enforceInterface("com.google.android.gms.maps.model.internal.IPolygonDelegate");
                c = d();
                reply.writeNoException();
                reply.writeList(c);
                return true;
            case um$h.CardView_cardPreventCornerOverlap /*7*/:
                data.enforceInterface("com.google.android.gms.maps.model.internal.IPolygonDelegate");
                a(data.readFloat());
                reply.writeNoException();
                return true;
            case um$h.CardView_contentPadding /*8*/:
                data.enforceInterface("com.google.android.gms.maps.model.internal.IPolygonDelegate");
                e = e();
                reply.writeNoException();
                reply.writeFloat(e);
                return true;
            case um$h.CardView_contentPaddingLeft /*9*/:
                data.enforceInterface("com.google.android.gms.maps.model.internal.IPolygonDelegate");
                a(data.readInt());
                reply.writeNoException();
                return true;
            case um$h.CardView_contentPaddingRight /*10*/:
                data.enforceInterface("com.google.android.gms.maps.model.internal.IPolygonDelegate");
                i = f();
                reply.writeNoException();
                reply.writeInt(i);
                return true;
            case um$h.CardView_contentPaddingTop /*11*/:
                data.enforceInterface("com.google.android.gms.maps.model.internal.IPolygonDelegate");
                b(data.readInt());
                reply.writeNoException();
                return true;
            case um$h.CardView_contentPaddingBottom /*12*/:
                data.enforceInterface("com.google.android.gms.maps.model.internal.IPolygonDelegate");
                i = g();
                reply.writeNoException();
                reply.writeInt(i);
                return true;
            case ha$a.Toolbar_titleMarginStart /*13*/:
                data.enforceInterface("com.google.android.gms.maps.model.internal.IPolygonDelegate");
                b(data.readFloat());
                reply.writeNoException();
                return true;
            case ha$a.Toolbar_titleMarginEnd /*14*/:
                data.enforceInterface("com.google.android.gms.maps.model.internal.IPolygonDelegate");
                e = h();
                reply.writeNoException();
                reply.writeFloat(e);
                return true;
            case ha$a.Toolbar_titleMarginTop /*15*/:
                data.enforceInterface("com.google.android.gms.maps.model.internal.IPolygonDelegate");
                if (data.readInt() != 0) {
                    z = true;
                }
                a(z);
                reply.writeNoException();
                return true;
            case ha$a.Toolbar_titleMarginBottom /*16*/:
                data.enforceInterface("com.google.android.gms.maps.model.internal.IPolygonDelegate");
                i2 = i();
                reply.writeNoException();
                if (i2) {
                    i = 1;
                }
                reply.writeInt(i);
                return true;
            case ha$a.Toolbar_maxButtonHeight /*17*/:
                data.enforceInterface("com.google.android.gms.maps.model.internal.IPolygonDelegate");
                if (data.readInt() != 0) {
                    z = true;
                }
                b(z);
                reply.writeNoException();
                return true;
            case ha$a.Toolbar_collapseIcon /*18*/:
                data.enforceInterface("com.google.android.gms.maps.model.internal.IPolygonDelegate");
                i2 = j();
                reply.writeNoException();
                if (i2) {
                    i = 1;
                }
                reply.writeInt(i);
                return true;
            case ha$a.Toolbar_collapseContentDescription /*19*/:
                data.enforceInterface("com.google.android.gms.maps.model.internal.IPolygonDelegate");
                i2 = a(aez$a.a(data.readStrongBinder()));
                reply.writeNoException();
                if (i2) {
                    i = 1;
                }
                reply.writeInt(i);
                return true;
            case HttpEngine.MAX_FOLLOW_UPS /*20*/:
                data.enforceInterface("com.google.android.gms.maps.model.internal.IPolygonDelegate");
                i = k();
                reply.writeNoException();
                reply.writeInt(i);
                return true;
            case ha$a.Toolbar_navigationContentDescription /*21*/:
                data.enforceInterface("com.google.android.gms.maps.model.internal.IPolygonDelegate");
                if (data.readInt() != 0) {
                    z = true;
                }
                c(z);
                reply.writeNoException();
                return true;
            case ha$a.Toolbar_logoDescription /*22*/:
                data.enforceInterface("com.google.android.gms.maps.model.internal.IPolygonDelegate");
                i2 = l();
                reply.writeNoException();
                if (i2) {
                    i = 1;
                }
                reply.writeInt(i);
                return true;
            case 1598968902:
                reply.writeString("com.google.android.gms.maps.model.internal.IPolygonDelegate");
                return true;
            default:
                return super.onTransact(code, data, reply, flags);
        }
    }
}
