package defpackage;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public abstract class adj$a extends Binder implements adj {
    public static adj a(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.maps.internal.IUiSettingsDelegate");
        return (queryLocalInterface == null || !(queryLocalInterface instanceof adj)) ? new adj$a$a(iBinder) : (adj) queryLocalInterface;
    }

    public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
        int i = 0;
        boolean z;
        boolean a;
        switch (code) {
            case um$h.com_facebook_profile_picture_view_com_facebook_is_cropped /*1*/:
                data.enforceInterface("com.google.android.gms.maps.internal.IUiSettingsDelegate");
                if (data.readInt() != 0) {
                    z = true;
                }
                a(z);
                reply.writeNoException();
                return true;
            case um$h.com_facebook_login_view_com_facebook_logout_text /*2*/:
                data.enforceInterface("com.google.android.gms.maps.internal.IUiSettingsDelegate");
                if (data.readInt() != 0) {
                    z = true;
                }
                b(z);
                reply.writeNoException();
                return true;
            case um$h.com_facebook_login_view_com_facebook_tooltip_mode /*3*/:
                data.enforceInterface("com.google.android.gms.maps.internal.IUiSettingsDelegate");
                if (data.readInt() != 0) {
                    z = true;
                }
                c(z);
                reply.writeNoException();
                return true;
            case um$h.com_facebook_like_view_com_facebook_auxiliary_view_position /*4*/:
                data.enforceInterface("com.google.android.gms.maps.internal.IUiSettingsDelegate");
                if (data.readInt() != 0) {
                    z = true;
                }
                d(z);
                reply.writeNoException();
                return true;
            case um$h.com_facebook_like_view_com_facebook_horizontal_alignment /*5*/:
                data.enforceInterface("com.google.android.gms.maps.internal.IUiSettingsDelegate");
                if (data.readInt() != 0) {
                    z = true;
                }
                e(z);
                reply.writeNoException();
                return true;
            case um$h.CardView_cardUseCompatPadding /*6*/:
                data.enforceInterface("com.google.android.gms.maps.internal.IUiSettingsDelegate");
                if (data.readInt() != 0) {
                    z = true;
                }
                f(z);
                reply.writeNoException();
                return true;
            case um$h.CardView_cardPreventCornerOverlap /*7*/:
                data.enforceInterface("com.google.android.gms.maps.internal.IUiSettingsDelegate");
                if (data.readInt() != 0) {
                    z = true;
                }
                g(z);
                reply.writeNoException();
                return true;
            case um$h.CardView_contentPadding /*8*/:
                data.enforceInterface("com.google.android.gms.maps.internal.IUiSettingsDelegate");
                if (data.readInt() != 0) {
                    z = true;
                }
                h(z);
                reply.writeNoException();
                return true;
            case um$h.CardView_contentPaddingLeft /*9*/:
                data.enforceInterface("com.google.android.gms.maps.internal.IUiSettingsDelegate");
                a = a();
                reply.writeNoException();
                if (a) {
                    i = 1;
                }
                reply.writeInt(i);
                return true;
            case um$h.CardView_contentPaddingRight /*10*/:
                data.enforceInterface("com.google.android.gms.maps.internal.IUiSettingsDelegate");
                a = b();
                reply.writeNoException();
                if (a) {
                    i = 1;
                }
                reply.writeInt(i);
                return true;
            case um$h.CardView_contentPaddingTop /*11*/:
                data.enforceInterface("com.google.android.gms.maps.internal.IUiSettingsDelegate");
                a = c();
                reply.writeNoException();
                if (a) {
                    i = 1;
                }
                reply.writeInt(i);
                return true;
            case um$h.CardView_contentPaddingBottom /*12*/:
                data.enforceInterface("com.google.android.gms.maps.internal.IUiSettingsDelegate");
                a = d();
                reply.writeNoException();
                if (a) {
                    i = 1;
                }
                reply.writeInt(i);
                return true;
            case ha$a.Toolbar_titleMarginStart /*13*/:
                data.enforceInterface("com.google.android.gms.maps.internal.IUiSettingsDelegate");
                a = e();
                reply.writeNoException();
                if (a) {
                    i = 1;
                }
                reply.writeInt(i);
                return true;
            case ha$a.Toolbar_titleMarginEnd /*14*/:
                data.enforceInterface("com.google.android.gms.maps.internal.IUiSettingsDelegate");
                a = f();
                reply.writeNoException();
                if (a) {
                    i = 1;
                }
                reply.writeInt(i);
                return true;
            case ha$a.Toolbar_titleMarginTop /*15*/:
                data.enforceInterface("com.google.android.gms.maps.internal.IUiSettingsDelegate");
                a = g();
                reply.writeNoException();
                if (a) {
                    i = 1;
                }
                reply.writeInt(i);
                return true;
            case ha$a.Toolbar_titleMarginBottom /*16*/:
                data.enforceInterface("com.google.android.gms.maps.internal.IUiSettingsDelegate");
                if (data.readInt() != 0) {
                    z = true;
                }
                i(z);
                reply.writeNoException();
                return true;
            case ha$a.Toolbar_maxButtonHeight /*17*/:
                data.enforceInterface("com.google.android.gms.maps.internal.IUiSettingsDelegate");
                a = h();
                reply.writeNoException();
                if (a) {
                    i = 1;
                }
                reply.writeInt(i);
                return true;
            case ha$a.Toolbar_collapseIcon /*18*/:
                data.enforceInterface("com.google.android.gms.maps.internal.IUiSettingsDelegate");
                if (data.readInt() != 0) {
                    z = true;
                }
                j(z);
                reply.writeNoException();
                return true;
            case ha$a.Toolbar_collapseContentDescription /*19*/:
                data.enforceInterface("com.google.android.gms.maps.internal.IUiSettingsDelegate");
                a = i();
                reply.writeNoException();
                if (a) {
                    i = 1;
                }
                reply.writeInt(i);
                return true;
            case 1598968902:
                reply.writeString("com.google.android.gms.maps.internal.IUiSettingsDelegate");
                return true;
            default:
                return super.onTransact(code, data, reply, flags);
        }
    }
}
