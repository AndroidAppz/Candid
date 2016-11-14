package defpackage;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.maps.model.LatLng;
import okhttp3.internal.http.HttpEngine;

public abstract class aey$a extends Binder implements aey {
    public static aey a(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.maps.model.internal.IMarkerDelegate");
        return (queryLocalInterface == null || !(queryLocalInterface instanceof aey)) ? new aey$a$a(iBinder) : (aey) queryLocalInterface;
    }

    public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
        int i = 0;
        String b;
        boolean z;
        boolean f;
        float m;
        switch (code) {
            case um$h.com_facebook_profile_picture_view_com_facebook_is_cropped /*1*/:
                data.enforceInterface("com.google.android.gms.maps.model.internal.IMarkerDelegate");
                a();
                reply.writeNoException();
                return true;
            case um$h.com_facebook_login_view_com_facebook_logout_text /*2*/:
                data.enforceInterface("com.google.android.gms.maps.model.internal.IMarkerDelegate");
                b = b();
                reply.writeNoException();
                reply.writeString(b);
                return true;
            case um$h.com_facebook_login_view_com_facebook_tooltip_mode /*3*/:
                data.enforceInterface("com.google.android.gms.maps.model.internal.IMarkerDelegate");
                a(data.readInt() != 0 ? LatLng.CREATOR.a(data) : null);
                reply.writeNoException();
                return true;
            case um$h.com_facebook_like_view_com_facebook_auxiliary_view_position /*4*/:
                data.enforceInterface("com.google.android.gms.maps.model.internal.IMarkerDelegate");
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
                data.enforceInterface("com.google.android.gms.maps.model.internal.IMarkerDelegate");
                a(data.readString());
                reply.writeNoException();
                return true;
            case um$h.CardView_cardUseCompatPadding /*6*/:
                data.enforceInterface("com.google.android.gms.maps.model.internal.IMarkerDelegate");
                b = d();
                reply.writeNoException();
                reply.writeString(b);
                return true;
            case um$h.CardView_cardPreventCornerOverlap /*7*/:
                data.enforceInterface("com.google.android.gms.maps.model.internal.IMarkerDelegate");
                b(data.readString());
                reply.writeNoException();
                return true;
            case um$h.CardView_contentPadding /*8*/:
                data.enforceInterface("com.google.android.gms.maps.model.internal.IMarkerDelegate");
                b = e();
                reply.writeNoException();
                reply.writeString(b);
                return true;
            case um$h.CardView_contentPaddingLeft /*9*/:
                data.enforceInterface("com.google.android.gms.maps.model.internal.IMarkerDelegate");
                if (data.readInt() != 0) {
                    z = true;
                }
                a(z);
                reply.writeNoException();
                return true;
            case um$h.CardView_contentPaddingRight /*10*/:
                data.enforceInterface("com.google.android.gms.maps.model.internal.IMarkerDelegate");
                f = f();
                reply.writeNoException();
                if (f) {
                    i = 1;
                }
                reply.writeInt(i);
                return true;
            case um$h.CardView_contentPaddingTop /*11*/:
                data.enforceInterface("com.google.android.gms.maps.model.internal.IMarkerDelegate");
                g();
                reply.writeNoException();
                return true;
            case um$h.CardView_contentPaddingBottom /*12*/:
                data.enforceInterface("com.google.android.gms.maps.model.internal.IMarkerDelegate");
                h();
                reply.writeNoException();
                return true;
            case ha$a.Toolbar_titleMarginStart /*13*/:
                data.enforceInterface("com.google.android.gms.maps.model.internal.IMarkerDelegate");
                f = i();
                reply.writeNoException();
                if (f) {
                    i = 1;
                }
                reply.writeInt(i);
                return true;
            case ha$a.Toolbar_titleMarginEnd /*14*/:
                data.enforceInterface("com.google.android.gms.maps.model.internal.IMarkerDelegate");
                if (data.readInt() != 0) {
                    z = true;
                }
                b(z);
                reply.writeNoException();
                return true;
            case ha$a.Toolbar_titleMarginTop /*15*/:
                data.enforceInterface("com.google.android.gms.maps.model.internal.IMarkerDelegate");
                f = j();
                reply.writeNoException();
                if (f) {
                    i = 1;
                }
                reply.writeInt(i);
                return true;
            case ha$a.Toolbar_titleMarginBottom /*16*/:
                data.enforceInterface("com.google.android.gms.maps.model.internal.IMarkerDelegate");
                f = a(aey$a.a(data.readStrongBinder()));
                reply.writeNoException();
                if (f) {
                    i = 1;
                }
                reply.writeInt(i);
                return true;
            case ha$a.Toolbar_maxButtonHeight /*17*/:
                data.enforceInterface("com.google.android.gms.maps.model.internal.IMarkerDelegate");
                i = k();
                reply.writeNoException();
                reply.writeInt(i);
                return true;
            case ha$a.Toolbar_collapseIcon /*18*/:
                data.enforceInterface("com.google.android.gms.maps.model.internal.IMarkerDelegate");
                a((zy) zy$a.zzbs(data.readStrongBinder()));
                reply.writeNoException();
                return true;
            case ha$a.Toolbar_collapseContentDescription /*19*/:
                data.enforceInterface("com.google.android.gms.maps.model.internal.IMarkerDelegate");
                a(data.readFloat(), data.readFloat());
                reply.writeNoException();
                return true;
            case HttpEngine.MAX_FOLLOW_UPS /*20*/:
                data.enforceInterface("com.google.android.gms.maps.model.internal.IMarkerDelegate");
                if (data.readInt() != 0) {
                    z = true;
                }
                c(z);
                reply.writeNoException();
                return true;
            case ha$a.Toolbar_navigationContentDescription /*21*/:
                data.enforceInterface("com.google.android.gms.maps.model.internal.IMarkerDelegate");
                f = l();
                reply.writeNoException();
                if (f) {
                    i = 1;
                }
                reply.writeInt(i);
                return true;
            case ha$a.Toolbar_logoDescription /*22*/:
                data.enforceInterface("com.google.android.gms.maps.model.internal.IMarkerDelegate");
                a(data.readFloat());
                reply.writeNoException();
                return true;
            case ha$a.Toolbar_titleTextColor /*23*/:
                data.enforceInterface("com.google.android.gms.maps.model.internal.IMarkerDelegate");
                m = m();
                reply.writeNoException();
                reply.writeFloat(m);
                return true;
            case ha$a.Toolbar_subtitleTextColor /*24*/:
                data.enforceInterface("com.google.android.gms.maps.model.internal.IMarkerDelegate");
                b(data.readFloat(), data.readFloat());
                reply.writeNoException();
                return true;
            case ha$a.AppCompatTheme_actionMenuTextAppearance /*25*/:
                data.enforceInterface("com.google.android.gms.maps.model.internal.IMarkerDelegate");
                b(data.readFloat());
                reply.writeNoException();
                return true;
            case ha$a.AppCompatTheme_actionMenuTextColor /*26*/:
                data.enforceInterface("com.google.android.gms.maps.model.internal.IMarkerDelegate");
                m = n();
                reply.writeNoException();
                reply.writeFloat(m);
                return true;
            case 1598968902:
                reply.writeString("com.google.android.gms.maps.model.internal.IMarkerDelegate");
                return true;
            default:
                return super.onTransact(code, data, reply, flags);
        }
    }
}
