package defpackage;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.StreetViewPanoramaCamera;
import com.google.android.gms.maps.model.StreetViewPanoramaLocation;
import com.google.android.gms.maps.model.StreetViewPanoramaOrientation;
import okhttp3.internal.http.HttpEngine;

public abstract class adg$a extends Binder implements adg {
    public static adg a(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.maps.internal.IStreetViewPanoramaDelegate");
        return (queryLocalInterface == null || !(queryLocalInterface instanceof adg)) ? new adg$a$a(iBinder) : (adg) queryLocalInterface;
    }

    public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
        IBinder iBinder = null;
        int i = 0;
        boolean z;
        boolean a;
        LatLng a2;
        switch (code) {
            case um$h.com_facebook_profile_picture_view_com_facebook_is_cropped /*1*/:
                data.enforceInterface("com.google.android.gms.maps.internal.IStreetViewPanoramaDelegate");
                if (data.readInt() != 0) {
                    z = true;
                }
                a(z);
                reply.writeNoException();
                return true;
            case um$h.com_facebook_login_view_com_facebook_logout_text /*2*/:
                data.enforceInterface("com.google.android.gms.maps.internal.IStreetViewPanoramaDelegate");
                if (data.readInt() != 0) {
                    z = true;
                }
                b(z);
                reply.writeNoException();
                return true;
            case um$h.com_facebook_login_view_com_facebook_tooltip_mode /*3*/:
                data.enforceInterface("com.google.android.gms.maps.internal.IStreetViewPanoramaDelegate");
                if (data.readInt() != 0) {
                    z = true;
                }
                c(z);
                reply.writeNoException();
                return true;
            case um$h.com_facebook_like_view_com_facebook_auxiliary_view_position /*4*/:
                data.enforceInterface("com.google.android.gms.maps.internal.IStreetViewPanoramaDelegate");
                if (data.readInt() != 0) {
                    z = true;
                }
                d(z);
                reply.writeNoException();
                return true;
            case um$h.com_facebook_like_view_com_facebook_horizontal_alignment /*5*/:
                data.enforceInterface("com.google.android.gms.maps.internal.IStreetViewPanoramaDelegate");
                a = a();
                reply.writeNoException();
                if (a) {
                    i = 1;
                }
                reply.writeInt(i);
                return true;
            case um$h.CardView_cardUseCompatPadding /*6*/:
                data.enforceInterface("com.google.android.gms.maps.internal.IStreetViewPanoramaDelegate");
                a = b();
                reply.writeNoException();
                if (a) {
                    i = 1;
                }
                reply.writeInt(i);
                return true;
            case um$h.CardView_cardPreventCornerOverlap /*7*/:
                data.enforceInterface("com.google.android.gms.maps.internal.IStreetViewPanoramaDelegate");
                a = c();
                reply.writeNoException();
                if (a) {
                    i = 1;
                }
                reply.writeInt(i);
                return true;
            case um$h.CardView_contentPadding /*8*/:
                data.enforceInterface("com.google.android.gms.maps.internal.IStreetViewPanoramaDelegate");
                a = d();
                reply.writeNoException();
                if (a) {
                    i = 1;
                }
                reply.writeInt(i);
                return true;
            case um$h.CardView_contentPaddingLeft /*9*/:
                data.enforceInterface("com.google.android.gms.maps.internal.IStreetViewPanoramaDelegate");
                a(data.readInt() != 0 ? StreetViewPanoramaCamera.CREATOR.a(data) : null, data.readLong());
                reply.writeNoException();
                return true;
            case um$h.CardView_contentPaddingRight /*10*/:
                data.enforceInterface("com.google.android.gms.maps.internal.IStreetViewPanoramaDelegate");
                StreetViewPanoramaCamera e = e();
                reply.writeNoException();
                if (e != null) {
                    reply.writeInt(1);
                    e.writeToParcel(reply, 1);
                    return true;
                }
                reply.writeInt(0);
                return true;
            case um$h.CardView_contentPaddingTop /*11*/:
                data.enforceInterface("com.google.android.gms.maps.internal.IStreetViewPanoramaDelegate");
                a(data.readString());
                reply.writeNoException();
                return true;
            case um$h.CardView_contentPaddingBottom /*12*/:
                data.enforceInterface("com.google.android.gms.maps.internal.IStreetViewPanoramaDelegate");
                if (data.readInt() != 0) {
                    a2 = LatLng.CREATOR.a(data);
                }
                a(a2);
                reply.writeNoException();
                return true;
            case ha$a.Toolbar_titleMarginStart /*13*/:
                data.enforceInterface("com.google.android.gms.maps.internal.IStreetViewPanoramaDelegate");
                if (data.readInt() != 0) {
                    a2 = LatLng.CREATOR.a(data);
                }
                a(a2, data.readInt());
                reply.writeNoException();
                return true;
            case ha$a.Toolbar_titleMarginEnd /*14*/:
                data.enforceInterface("com.google.android.gms.maps.internal.IStreetViewPanoramaDelegate");
                StreetViewPanoramaLocation f = f();
                reply.writeNoException();
                if (f != null) {
                    reply.writeInt(1);
                    f.writeToParcel(reply, 1);
                    return true;
                }
                reply.writeInt(0);
                return true;
            case ha$a.Toolbar_titleMarginTop /*15*/:
                data.enforceInterface("com.google.android.gms.maps.internal.IStreetViewPanoramaDelegate");
                a(aen$a.a(data.readStrongBinder()));
                reply.writeNoException();
                return true;
            case ha$a.Toolbar_titleMarginBottom /*16*/:
                data.enforceInterface("com.google.android.gms.maps.internal.IStreetViewPanoramaDelegate");
                a(aem$a.a(data.readStrongBinder()));
                reply.writeNoException();
                return true;
            case ha$a.Toolbar_maxButtonHeight /*17*/:
                data.enforceInterface("com.google.android.gms.maps.internal.IStreetViewPanoramaDelegate");
                a(aeo$a.a(data.readStrongBinder()));
                reply.writeNoException();
                return true;
            case ha$a.Toolbar_collapseIcon /*18*/:
                data.enforceInterface("com.google.android.gms.maps.internal.IStreetViewPanoramaDelegate");
                StreetViewPanoramaOrientation a3 = a((zy) zy$a.zzbs(data.readStrongBinder()));
                reply.writeNoException();
                if (a3 != null) {
                    reply.writeInt(1);
                    a3.writeToParcel(reply, 1);
                    return true;
                }
                reply.writeInt(0);
                return true;
            case ha$a.Toolbar_collapseContentDescription /*19*/:
                data.enforceInterface("com.google.android.gms.maps.internal.IStreetViewPanoramaDelegate");
                zy a4 = a(data.readInt() != 0 ? StreetViewPanoramaOrientation.CREATOR.a(data) : null);
                reply.writeNoException();
                if (a4 != null) {
                    iBinder = a4.asBinder();
                }
                reply.writeStrongBinder(iBinder);
                return true;
            case HttpEngine.MAX_FOLLOW_UPS /*20*/:
                data.enforceInterface("com.google.android.gms.maps.internal.IStreetViewPanoramaDelegate");
                a(aep$a.a(data.readStrongBinder()));
                reply.writeNoException();
                return true;
            case 1598968902:
                reply.writeString("com.google.android.gms.maps.internal.IStreetViewPanoramaDelegate");
                return true;
            default:
                return super.onTransact(code, data, reply, flags);
        }
    }
}
