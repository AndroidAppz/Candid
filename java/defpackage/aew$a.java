package defpackage;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import okhttp3.internal.http.HttpEngine;

public abstract class aew$a extends Binder implements aew {
    public static aew a(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.maps.model.internal.IGroundOverlayDelegate");
        return (queryLocalInterface == null || !(queryLocalInterface instanceof aew)) ? new aew$a$a(iBinder) : (aew) queryLocalInterface;
    }

    public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
        LatLngBounds latLngBounds = null;
        int i = 0;
        LatLng a;
        float d;
        boolean i2;
        switch (code) {
            case um$h.com_facebook_profile_picture_view_com_facebook_is_cropped /*1*/:
                data.enforceInterface("com.google.android.gms.maps.model.internal.IGroundOverlayDelegate");
                a();
                reply.writeNoException();
                return true;
            case um$h.com_facebook_login_view_com_facebook_logout_text /*2*/:
                data.enforceInterface("com.google.android.gms.maps.model.internal.IGroundOverlayDelegate");
                String b = b();
                reply.writeNoException();
                reply.writeString(b);
                return true;
            case um$h.com_facebook_login_view_com_facebook_tooltip_mode /*3*/:
                data.enforceInterface("com.google.android.gms.maps.model.internal.IGroundOverlayDelegate");
                if (data.readInt() != 0) {
                    a = LatLng.CREATOR.a(data);
                }
                a(a);
                reply.writeNoException();
                return true;
            case um$h.com_facebook_like_view_com_facebook_auxiliary_view_position /*4*/:
                data.enforceInterface("com.google.android.gms.maps.model.internal.IGroundOverlayDelegate");
                a = c();
                reply.writeNoException();
                if (a != null) {
                    reply.writeInt(1);
                    a.writeToParcel(reply, 1);
                    return true;
                }
                reply.writeInt(0);
                return true;
            case um$h.com_facebook_like_view_com_facebook_horizontal_alignment /*5*/:
                data.enforceInterface("com.google.android.gms.maps.model.internal.IGroundOverlayDelegate");
                a(data.readFloat());
                reply.writeNoException();
                return true;
            case um$h.CardView_cardUseCompatPadding /*6*/:
                data.enforceInterface("com.google.android.gms.maps.model.internal.IGroundOverlayDelegate");
                a(data.readFloat(), data.readFloat());
                reply.writeNoException();
                return true;
            case um$h.CardView_cardPreventCornerOverlap /*7*/:
                data.enforceInterface("com.google.android.gms.maps.model.internal.IGroundOverlayDelegate");
                d = d();
                reply.writeNoException();
                reply.writeFloat(d);
                return true;
            case um$h.CardView_contentPadding /*8*/:
                data.enforceInterface("com.google.android.gms.maps.model.internal.IGroundOverlayDelegate");
                d = e();
                reply.writeNoException();
                reply.writeFloat(d);
                return true;
            case um$h.CardView_contentPaddingLeft /*9*/:
                data.enforceInterface("com.google.android.gms.maps.model.internal.IGroundOverlayDelegate");
                if (data.readInt() != 0) {
                    latLngBounds = LatLngBounds.CREATOR.a(data);
                }
                a(latLngBounds);
                reply.writeNoException();
                return true;
            case um$h.CardView_contentPaddingRight /*10*/:
                data.enforceInterface("com.google.android.gms.maps.model.internal.IGroundOverlayDelegate");
                latLngBounds = f();
                reply.writeNoException();
                if (latLngBounds != null) {
                    reply.writeInt(1);
                    latLngBounds.writeToParcel(reply, 1);
                    return true;
                }
                reply.writeInt(0);
                return true;
            case um$h.CardView_contentPaddingTop /*11*/:
                data.enforceInterface("com.google.android.gms.maps.model.internal.IGroundOverlayDelegate");
                b(data.readFloat());
                reply.writeNoException();
                return true;
            case um$h.CardView_contentPaddingBottom /*12*/:
                data.enforceInterface("com.google.android.gms.maps.model.internal.IGroundOverlayDelegate");
                d = g();
                reply.writeNoException();
                reply.writeFloat(d);
                return true;
            case ha$a.Toolbar_titleMarginStart /*13*/:
                data.enforceInterface("com.google.android.gms.maps.model.internal.IGroundOverlayDelegate");
                c(data.readFloat());
                reply.writeNoException();
                return true;
            case ha$a.Toolbar_titleMarginEnd /*14*/:
                data.enforceInterface("com.google.android.gms.maps.model.internal.IGroundOverlayDelegate");
                d = h();
                reply.writeNoException();
                reply.writeFloat(d);
                return true;
            case ha$a.Toolbar_titleMarginTop /*15*/:
                data.enforceInterface("com.google.android.gms.maps.model.internal.IGroundOverlayDelegate");
                a(data.readInt() != 0);
                reply.writeNoException();
                return true;
            case ha$a.Toolbar_titleMarginBottom /*16*/:
                data.enforceInterface("com.google.android.gms.maps.model.internal.IGroundOverlayDelegate");
                i2 = i();
                reply.writeNoException();
                if (i2) {
                    i = 1;
                }
                reply.writeInt(i);
                return true;
            case ha$a.Toolbar_maxButtonHeight /*17*/:
                data.enforceInterface("com.google.android.gms.maps.model.internal.IGroundOverlayDelegate");
                d(data.readFloat());
                reply.writeNoException();
                return true;
            case ha$a.Toolbar_collapseIcon /*18*/:
                data.enforceInterface("com.google.android.gms.maps.model.internal.IGroundOverlayDelegate");
                d = j();
                reply.writeNoException();
                reply.writeFloat(d);
                return true;
            case ha$a.Toolbar_collapseContentDescription /*19*/:
                data.enforceInterface("com.google.android.gms.maps.model.internal.IGroundOverlayDelegate");
                i2 = a(aew$a.a(data.readStrongBinder()));
                reply.writeNoException();
                if (i2) {
                    i = 1;
                }
                reply.writeInt(i);
                return true;
            case HttpEngine.MAX_FOLLOW_UPS /*20*/:
                data.enforceInterface("com.google.android.gms.maps.model.internal.IGroundOverlayDelegate");
                int k = k();
                reply.writeNoException();
                reply.writeInt(k);
                return true;
            case ha$a.Toolbar_navigationContentDescription /*21*/:
                data.enforceInterface("com.google.android.gms.maps.model.internal.IGroundOverlayDelegate");
                a((zy) zy$a.zzbs(data.readStrongBinder()));
                reply.writeNoException();
                return true;
            case ha$a.Toolbar_logoDescription /*22*/:
                boolean z;
                data.enforceInterface("com.google.android.gms.maps.model.internal.IGroundOverlayDelegate");
                if (data.readInt() != 0) {
                    z = true;
                }
                b(z);
                reply.writeNoException();
                return true;
            case ha$a.Toolbar_titleTextColor /*23*/:
                data.enforceInterface("com.google.android.gms.maps.model.internal.IGroundOverlayDelegate");
                i2 = l();
                reply.writeNoException();
                if (i2) {
                    i = 1;
                }
                reply.writeInt(i);
                return true;
            case 1598968902:
                reply.writeString("com.google.android.gms.maps.model.internal.IGroundOverlayDelegate");
                return true;
            default:
                return super.onTransact(code, data, reply, flags);
        }
    }
}
