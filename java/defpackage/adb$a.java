package defpackage;

import android.location.Location;
import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.CircleOptions;
import com.google.android.gms.maps.model.GroundOverlayOptions;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PolygonOptions;
import com.google.android.gms.maps.model.PolylineOptions;
import com.google.android.gms.maps.model.TileOverlayOptions;
import okhttp3.internal.http.HttpEngine;

public abstract class adb$a extends Binder implements adb {
    public static adb a(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
        return (queryLocalInterface == null || !(queryLocalInterface instanceof adb)) ? new adb$a$a(iBinder) : (adb) queryLocalInterface;
    }

    public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
        int i = 0;
        IBinder iBinder = null;
        float b;
        boolean g;
        boolean z;
        switch (code) {
            case um$h.com_facebook_profile_picture_view_com_facebook_is_cropped /*1*/:
                data.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
                CameraPosition a = a();
                reply.writeNoException();
                if (a != null) {
                    reply.writeInt(1);
                    a.writeToParcel(reply, 1);
                    return true;
                }
                reply.writeInt(0);
                return true;
            case um$h.com_facebook_login_view_com_facebook_logout_text /*2*/:
                data.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
                b = b();
                reply.writeNoException();
                reply.writeFloat(b);
                return true;
            case um$h.com_facebook_login_view_com_facebook_tooltip_mode /*3*/:
                data.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
                b = c();
                reply.writeNoException();
                reply.writeFloat(b);
                return true;
            case um$h.com_facebook_like_view_com_facebook_auxiliary_view_position /*4*/:
                data.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
                a((zy) zy$a.zzbs(data.readStrongBinder()));
                reply.writeNoException();
                return true;
            case um$h.com_facebook_like_view_com_facebook_horizontal_alignment /*5*/:
                data.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
                b((zy) zy$a.zzbs(data.readStrongBinder()));
                reply.writeNoException();
                return true;
            case um$h.CardView_cardUseCompatPadding /*6*/:
                data.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
                a((zy) zy$a.zzbs(data.readStrongBinder()), adr$a.a(data.readStrongBinder()));
                reply.writeNoException();
                return true;
            case um$h.CardView_cardPreventCornerOverlap /*7*/:
                data.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
                a(zy$a.zzbs(data.readStrongBinder()), data.readInt(), adr$a.a(data.readStrongBinder()));
                reply.writeNoException();
                return true;
            case um$h.CardView_contentPadding /*8*/:
                data.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
                d();
                reply.writeNoException();
                return true;
            case um$h.CardView_contentPaddingLeft /*9*/:
                data.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
                aet a2 = a(data.readInt() != 0 ? PolylineOptions.CREATOR.a(data) : null);
                reply.writeNoException();
                if (a2 != null) {
                    iBinder = a2.asBinder();
                }
                reply.writeStrongBinder(iBinder);
                return true;
            case um$h.CardView_contentPaddingRight /*10*/:
                data.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
                aez a3 = a(data.readInt() != 0 ? PolygonOptions.CREATOR.a(data) : null);
                reply.writeNoException();
                if (a3 != null) {
                    iBinder = a3.asBinder();
                }
                reply.writeStrongBinder(iBinder);
                return true;
            case um$h.CardView_contentPaddingTop /*11*/:
                data.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
                aey a4 = a(data.readInt() != 0 ? MarkerOptions.CREATOR.a(data) : null);
                reply.writeNoException();
                if (a4 != null) {
                    iBinder = a4.asBinder();
                }
                reply.writeStrongBinder(iBinder);
                return true;
            case um$h.CardView_contentPaddingBottom /*12*/:
                data.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
                aew a5 = a(data.readInt() != 0 ? GroundOverlayOptions.CREATOR.a(data) : null);
                reply.writeNoException();
                if (a5 != null) {
                    iBinder = a5.asBinder();
                }
                reply.writeStrongBinder(iBinder);
                return true;
            case ha$a.Toolbar_titleMarginStart /*13*/:
                data.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
                afa a6 = a(data.readInt() != 0 ? TileOverlayOptions.CREATOR.a(data) : null);
                reply.writeNoException();
                if (a6 != null) {
                    iBinder = a6.asBinder();
                }
                reply.writeStrongBinder(iBinder);
                return true;
            case ha$a.Toolbar_titleMarginEnd /*14*/:
                data.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
                e();
                reply.writeNoException();
                return true;
            case ha$a.Toolbar_titleMarginTop /*15*/:
                data.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
                int f = f();
                reply.writeNoException();
                reply.writeInt(f);
                return true;
            case ha$a.Toolbar_titleMarginBottom /*16*/:
                data.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
                a(data.readInt());
                reply.writeNoException();
                return true;
            case ha$a.Toolbar_maxButtonHeight /*17*/:
                data.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
                g = g();
                reply.writeNoException();
                reply.writeInt(g ? 1 : 0);
                return true;
            case ha$a.Toolbar_collapseIcon /*18*/:
                data.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
                if (data.readInt() != 0) {
                    z = true;
                }
                a(z);
                reply.writeNoException();
                return true;
            case ha$a.Toolbar_collapseContentDescription /*19*/:
                data.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
                g = h();
                reply.writeNoException();
                if (g) {
                    i = 1;
                }
                reply.writeInt(i);
                return true;
            case HttpEngine.MAX_FOLLOW_UPS /*20*/:
                data.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
                g = b(data.readInt() != 0);
                reply.writeNoException();
                if (g) {
                    i = 1;
                }
                reply.writeInt(i);
                return true;
            case ha$a.Toolbar_navigationContentDescription /*21*/:
                data.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
                g = i();
                reply.writeNoException();
                if (g) {
                    i = 1;
                }
                reply.writeInt(i);
                return true;
            case ha$a.Toolbar_logoDescription /*22*/:
                data.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
                if (data.readInt() != 0) {
                    z = true;
                }
                c(z);
                reply.writeNoException();
                return true;
            case ha$a.Toolbar_titleTextColor /*23*/:
                data.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
                Location j = j();
                reply.writeNoException();
                if (j != null) {
                    reply.writeInt(1);
                    j.writeToParcel(reply, 1);
                    return true;
                }
                reply.writeInt(0);
                return true;
            case ha$a.Toolbar_subtitleTextColor /*24*/:
                data.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
                a(adc$a.a(data.readStrongBinder()));
                reply.writeNoException();
                return true;
            case ha$a.AppCompatTheme_actionMenuTextAppearance /*25*/:
                data.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
                adj k = k();
                reply.writeNoException();
                if (k != null) {
                    iBinder = k.asBinder();
                }
                reply.writeStrongBinder(iBinder);
                return true;
            case ha$a.AppCompatTheme_actionMenuTextColor /*26*/:
                data.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
                adf l = l();
                reply.writeNoException();
                if (l != null) {
                    iBinder = l.asBinder();
                }
                reply.writeStrongBinder(iBinder);
                return true;
            case ha$a.AppCompatTheme_actionModeStyle /*27*/:
                data.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
                a(adu$a.a(data.readStrongBinder()));
                reply.writeNoException();
                return true;
            case ha$a.AppCompatTheme_actionModeCloseButtonStyle /*28*/:
                data.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
                a(aeb$a.a(data.readStrongBinder()));
                reply.writeNoException();
                return true;
            case ha$a.AppCompatTheme_actionModeBackground /*29*/:
                data.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
                a(aed$a.a(data.readStrongBinder()));
                reply.writeNoException();
                return true;
            case ha$a.AppCompatTheme_actionModeSplitBackground /*30*/:
                data.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
                a(aef$a.a(data.readStrongBinder()));
                reply.writeNoException();
                return true;
            case ha$a.AppCompatTheme_actionModeCloseDrawable /*31*/:
                data.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
                a(aeg$a.a(data.readStrongBinder()));
                reply.writeNoException();
                return true;
            case ha$a.AppCompatTheme_actionModeCutDrawable /*32*/:
                data.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
                a(adx$a.a(data.readStrongBinder()));
                reply.writeNoException();
                return true;
            case ha$a.AppCompatTheme_actionModeCopyDrawable /*33*/:
                data.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
                a(adt$a.a(data.readStrongBinder()));
                reply.writeNoException();
                return true;
            case ha$a.AppCompatTheme_actionModeSelectAllDrawable /*35*/:
                data.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
                aev a7 = a(data.readInt() != 0 ? CircleOptions.CREATOR.a(data) : null);
                reply.writeNoException();
                if (a7 != null) {
                    iBinder = a7.asBinder();
                }
                reply.writeStrongBinder(iBinder);
                return true;
            case ha$a.AppCompatTheme_actionModeShareDrawable /*36*/:
                data.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
                a(aei$a.a(data.readStrongBinder()));
                reply.writeNoException();
                return true;
            case ha$a.AppCompatTheme_actionModeFindDrawable /*37*/:
                data.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
                a(aeh$a.a(data.readStrongBinder()));
                reply.writeNoException();
                return true;
            case ha$a.AppCompatTheme_actionModeWebSearchDrawable /*38*/:
                data.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
                a(ado$a.a(data.readStrongBinder()), (zy) zy$a.zzbs(data.readStrongBinder()));
                reply.writeNoException();
                return true;
            case ha$a.AppCompatTheme_actionModePopupWindowStyle /*39*/:
                data.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
                a(data.readInt(), data.readInt(), data.readInt(), data.readInt());
                reply.writeNoException();
                return true;
            case ha$a.AppCompatTheme_textAppearanceLargePopupMenu /*40*/:
                data.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
                g = m();
                reply.writeNoException();
                if (g) {
                    i = 1;
                }
                reply.writeInt(i);
                return true;
            case ha$a.AppCompatTheme_textAppearanceSmallPopupMenu /*41*/:
                data.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
                if (data.readInt() != 0) {
                    z = true;
                }
                d(z);
                reply.writeNoException();
                return true;
            case ha$a.AppCompatTheme_dialogTheme /*42*/:
                data.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
                a(aec$a.a(data.readStrongBinder()));
                reply.writeNoException();
                return true;
            case ha$a.AppCompatTheme_listDividerAlertDialog /*44*/:
                data.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
                aex n = n();
                reply.writeNoException();
                if (n != null) {
                    iBinder = n.asBinder();
                }
                reply.writeStrongBinder(iBinder);
                return true;
            case ha$a.AppCompatTheme_actionDropDownStyle /*45*/:
                data.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
                a(adw$a.a(data.readStrongBinder()));
                reply.writeNoException();
                return true;
            case ha$a.AppCompatTheme_selectableItemBackgroundBorderless /*53*/:
                data.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
                a(aee$a.a(data.readStrongBinder()));
                reply.writeNoException();
                return true;
            case ha$a.AppCompatTheme_borderlessButtonStyle /*54*/:
                data.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
                a(data.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(data) : null);
                reply.writeNoException();
                return true;
            case ha$a.AppCompatTheme_dividerVertical /*55*/:
                data.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
                o();
                reply.writeNoException();
                return true;
            case ha$a.AppCompatTheme_dividerHorizontal /*56*/:
                data.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
                p();
                reply.writeNoException();
                return true;
            case ha$a.AppCompatTheme_activityChooserViewStyle /*57*/:
                data.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
                q();
                reply.writeNoException();
                return true;
            case ha$a.AppCompatTheme_toolbarStyle /*58*/:
                data.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
                r();
                reply.writeNoException();
                return true;
            case ha$a.AppCompatTheme_toolbarNavigationButtonStyle /*59*/:
                data.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
                g = s();
                reply.writeNoException();
                if (g) {
                    i = 1;
                }
                reply.writeInt(i);
                return true;
            case ha$a.AppCompatTheme_popupMenuStyle /*60*/:
                data.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
                Bundle bundle = data.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(data) : null;
                b(bundle);
                reply.writeNoException();
                if (bundle != null) {
                    reply.writeInt(1);
                    bundle.writeToParcel(reply, 1);
                    return true;
                }
                reply.writeInt(0);
                return true;
            case ha$a.AppCompatTheme_popupWindowStyle /*61*/:
                data.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
                a(data.readString());
                reply.writeNoException();
                return true;
            case ha$a.AppCompatTheme_panelMenuListTheme /*80*/:
                data.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
                a(aej$a.a(data.readStrongBinder()));
                reply.writeNoException();
                return true;
            case ha$a.AppCompatTheme_listChoiceBackgroundIndicator /*81*/:
                data.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
                c(data.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(data) : null);
                reply.writeNoException();
                return true;
            case ha$a.AppCompatTheme_colorPrimary /*82*/:
                data.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
                t();
                reply.writeNoException();
                return true;
            case ha$a.AppCompatTheme_colorPrimaryDark /*83*/:
                data.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
                a(adv$a.a(data.readStrongBinder()));
                reply.writeNoException();
                return true;
            case ha$a.AppCompatTheme_colorAccent /*84*/:
                data.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
                a(adz$a.a(data.readStrongBinder()));
                reply.writeNoException();
                return true;
            case ha$a.AppCompatTheme_colorControlNormal /*85*/:
                data.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
                a(aek$a.a(data.readStrongBinder()));
                reply.writeNoException();
                return true;
            case ha$a.AppCompatTheme_colorControlActivated /*86*/:
                data.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
                a(ady$a.a(data.readStrongBinder()));
                reply.writeNoException();
                return true;
            case ha$a.AppCompatTheme_colorControlHighlight /*87*/:
                data.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
                a(ael$a.a(data.readStrongBinder()));
                reply.writeNoException();
                return true;
            case 1598968902:
                reply.writeString("com.google.android.gms.maps.internal.IGoogleMapDelegate");
                return true;
            default:
                return super.onTransact(code, data, reply, flags);
        }
    }
}
