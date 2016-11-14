package defpackage;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.common.internal.GetServiceRequest;
import com.google.android.gms.common.internal.ValidateAccountRequest;
import okhttp3.internal.http.HttpEngine;

public abstract class yp$a extends Binder implements yp {
    public static yp a(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
        return (queryLocalInterface == null || !(queryLocalInterface instanceof yp)) ? new yp$a$a(iBinder) : (yp) queryLocalInterface;
    }

    public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        ValidateAccountRequest validateAccountRequest = null;
        yo a;
        int readInt;
        String readString;
        Bundle bundle;
        switch (i) {
            case um$h.com_facebook_profile_picture_view_com_facebook_is_cropped /*1*/:
                parcel.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                a(yo$a.a(parcel.readStrongBinder()), parcel.readInt(), parcel.readString(), parcel.readString(), parcel.createStringArray(), parcel.readString(), parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null);
                parcel2.writeNoException();
                return true;
            case um$h.com_facebook_login_view_com_facebook_logout_text /*2*/:
                parcel.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                a = yo$a.a(parcel.readStrongBinder());
                readInt = parcel.readInt();
                readString = parcel.readString();
                if (parcel.readInt() != 0) {
                    bundle = (Bundle) Bundle.CREATOR.createFromParcel(parcel);
                }
                a(a, readInt, readString, bundle);
                parcel2.writeNoException();
                return true;
            case um$h.com_facebook_login_view_com_facebook_tooltip_mode /*3*/:
                parcel.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                a(yo$a.a(parcel.readStrongBinder()), parcel.readInt(), parcel.readString());
                parcel2.writeNoException();
                return true;
            case um$h.com_facebook_like_view_com_facebook_auxiliary_view_position /*4*/:
                parcel.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                a(yo$a.a(parcel.readStrongBinder()), parcel.readInt());
                parcel2.writeNoException();
                return true;
            case um$h.com_facebook_like_view_com_facebook_horizontal_alignment /*5*/:
                parcel.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                a = yo$a.a(parcel.readStrongBinder());
                readInt = parcel.readInt();
                readString = parcel.readString();
                if (parcel.readInt() != 0) {
                    bundle = (Bundle) Bundle.CREATOR.createFromParcel(parcel);
                }
                b(a, readInt, readString, bundle);
                parcel2.writeNoException();
                return true;
            case um$h.CardView_cardUseCompatPadding /*6*/:
                parcel.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                a = yo$a.a(parcel.readStrongBinder());
                readInt = parcel.readInt();
                readString = parcel.readString();
                if (parcel.readInt() != 0) {
                    bundle = (Bundle) Bundle.CREATOR.createFromParcel(parcel);
                }
                c(a, readInt, readString, bundle);
                parcel2.writeNoException();
                return true;
            case um$h.CardView_cardPreventCornerOverlap /*7*/:
                parcel.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                a = yo$a.a(parcel.readStrongBinder());
                readInt = parcel.readInt();
                readString = parcel.readString();
                if (parcel.readInt() != 0) {
                    bundle = (Bundle) Bundle.CREATOR.createFromParcel(parcel);
                }
                d(a, readInt, readString, bundle);
                parcel2.writeNoException();
                return true;
            case um$h.CardView_contentPadding /*8*/:
                parcel.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                a = yo$a.a(parcel.readStrongBinder());
                readInt = parcel.readInt();
                readString = parcel.readString();
                if (parcel.readInt() != 0) {
                    bundle = (Bundle) Bundle.CREATOR.createFromParcel(parcel);
                }
                e(a, readInt, readString, bundle);
                parcel2.writeNoException();
                return true;
            case um$h.CardView_contentPaddingLeft /*9*/:
                parcel.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                a(yo$a.a(parcel.readStrongBinder()), parcel.readInt(), parcel.readString(), parcel.readString(), parcel.createStringArray(), parcel.readString(), parcel.readStrongBinder(), parcel.readString(), parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null);
                parcel2.writeNoException();
                return true;
            case um$h.CardView_contentPaddingRight /*10*/:
                parcel.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                a(yo$a.a(parcel.readStrongBinder()), parcel.readInt(), parcel.readString(), parcel.readString(), parcel.createStringArray());
                parcel2.writeNoException();
                return true;
            case um$h.CardView_contentPaddingTop /*11*/:
                parcel.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                a = yo$a.a(parcel.readStrongBinder());
                readInt = parcel.readInt();
                readString = parcel.readString();
                if (parcel.readInt() != 0) {
                    bundle = (Bundle) Bundle.CREATOR.createFromParcel(parcel);
                }
                f(a, readInt, readString, bundle);
                parcel2.writeNoException();
                return true;
            case um$h.CardView_contentPaddingBottom /*12*/:
                parcel.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                a = yo$a.a(parcel.readStrongBinder());
                readInt = parcel.readInt();
                readString = parcel.readString();
                if (parcel.readInt() != 0) {
                    bundle = (Bundle) Bundle.CREATOR.createFromParcel(parcel);
                }
                g(a, readInt, readString, bundle);
                parcel2.writeNoException();
                return true;
            case ha$a.Toolbar_titleMarginStart /*13*/:
                parcel.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                a = yo$a.a(parcel.readStrongBinder());
                readInt = parcel.readInt();
                readString = parcel.readString();
                if (parcel.readInt() != 0) {
                    bundle = (Bundle) Bundle.CREATOR.createFromParcel(parcel);
                }
                h(a, readInt, readString, bundle);
                parcel2.writeNoException();
                return true;
            case ha$a.Toolbar_titleMarginEnd /*14*/:
                parcel.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                a = yo$a.a(parcel.readStrongBinder());
                readInt = parcel.readInt();
                readString = parcel.readString();
                if (parcel.readInt() != 0) {
                    bundle = (Bundle) Bundle.CREATOR.createFromParcel(parcel);
                }
                i(a, readInt, readString, bundle);
                parcel2.writeNoException();
                return true;
            case ha$a.Toolbar_titleMarginTop /*15*/:
                parcel.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                a = yo$a.a(parcel.readStrongBinder());
                readInt = parcel.readInt();
                readString = parcel.readString();
                if (parcel.readInt() != 0) {
                    bundle = (Bundle) Bundle.CREATOR.createFromParcel(parcel);
                }
                j(a, readInt, readString, bundle);
                parcel2.writeNoException();
                return true;
            case ha$a.Toolbar_titleMarginBottom /*16*/:
                parcel.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                a = yo$a.a(parcel.readStrongBinder());
                readInt = parcel.readInt();
                readString = parcel.readString();
                if (parcel.readInt() != 0) {
                    bundle = (Bundle) Bundle.CREATOR.createFromParcel(parcel);
                }
                k(a, readInt, readString, bundle);
                parcel2.writeNoException();
                return true;
            case ha$a.Toolbar_maxButtonHeight /*17*/:
                parcel.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                a = yo$a.a(parcel.readStrongBinder());
                readInt = parcel.readInt();
                readString = parcel.readString();
                if (parcel.readInt() != 0) {
                    bundle = (Bundle) Bundle.CREATOR.createFromParcel(parcel);
                }
                l(a, readInt, readString, bundle);
                parcel2.writeNoException();
                return true;
            case ha$a.Toolbar_collapseIcon /*18*/:
                parcel.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                a = yo$a.a(parcel.readStrongBinder());
                readInt = parcel.readInt();
                readString = parcel.readString();
                if (parcel.readInt() != 0) {
                    bundle = (Bundle) Bundle.CREATOR.createFromParcel(parcel);
                }
                m(a, readInt, readString, bundle);
                parcel2.writeNoException();
                return true;
            case ha$a.Toolbar_collapseContentDescription /*19*/:
                parcel.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                a(yo$a.a(parcel.readStrongBinder()), parcel.readInt(), parcel.readString(), parcel.readStrongBinder(), parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null);
                parcel2.writeNoException();
                return true;
            case HttpEngine.MAX_FOLLOW_UPS /*20*/:
                parcel.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                a(yo$a.a(parcel.readStrongBinder()), parcel.readInt(), parcel.readString(), parcel.createStringArray(), parcel.readString(), parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null);
                parcel2.writeNoException();
                return true;
            case ha$a.Toolbar_navigationContentDescription /*21*/:
                parcel.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                b(yo$a.a(parcel.readStrongBinder()), parcel.readInt(), parcel.readString());
                parcel2.writeNoException();
                return true;
            case ha$a.Toolbar_logoDescription /*22*/:
                parcel.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                c(yo$a.a(parcel.readStrongBinder()), parcel.readInt(), parcel.readString());
                parcel2.writeNoException();
                return true;
            case ha$a.Toolbar_titleTextColor /*23*/:
                parcel.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                a = yo$a.a(parcel.readStrongBinder());
                readInt = parcel.readInt();
                readString = parcel.readString();
                if (parcel.readInt() != 0) {
                    bundle = (Bundle) Bundle.CREATOR.createFromParcel(parcel);
                }
                n(a, readInt, readString, bundle);
                parcel2.writeNoException();
                return true;
            case ha$a.Toolbar_subtitleTextColor /*24*/:
                parcel.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                d(yo$a.a(parcel.readStrongBinder()), parcel.readInt(), parcel.readString());
                parcel2.writeNoException();
                return true;
            case ha$a.AppCompatTheme_actionMenuTextAppearance /*25*/:
                parcel.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                a = yo$a.a(parcel.readStrongBinder());
                readInt = parcel.readInt();
                readString = parcel.readString();
                if (parcel.readInt() != 0) {
                    bundle = (Bundle) Bundle.CREATOR.createFromParcel(parcel);
                }
                o(a, readInt, readString, bundle);
                parcel2.writeNoException();
                return true;
            case ha$a.AppCompatTheme_actionMenuTextColor /*26*/:
                parcel.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                e(yo$a.a(parcel.readStrongBinder()), parcel.readInt(), parcel.readString());
                parcel2.writeNoException();
                return true;
            case ha$a.AppCompatTheme_actionModeStyle /*27*/:
                parcel.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                a = yo$a.a(parcel.readStrongBinder());
                readInt = parcel.readInt();
                readString = parcel.readString();
                if (parcel.readInt() != 0) {
                    bundle = (Bundle) Bundle.CREATOR.createFromParcel(parcel);
                }
                p(a, readInt, readString, bundle);
                parcel2.writeNoException();
                return true;
            case ha$a.AppCompatTheme_actionModeCloseButtonStyle /*28*/:
                parcel.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                a();
                parcel2.writeNoException();
                return true;
            case ha$a.AppCompatTheme_actionModeSplitBackground /*30*/:
                parcel.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                a(yo$a.a(parcel.readStrongBinder()), parcel.readInt(), parcel.readString(), parcel.readString(), parcel.createStringArray(), parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null);
                parcel2.writeNoException();
                return true;
            case ha$a.AppCompatTheme_actionModeCloseDrawable /*31*/:
                parcel.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                f(yo$a.a(parcel.readStrongBinder()), parcel.readInt(), parcel.readString());
                parcel2.writeNoException();
                return true;
            case ha$a.AppCompatTheme_actionModeCutDrawable /*32*/:
                parcel.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                g(yo$a.a(parcel.readStrongBinder()), parcel.readInt(), parcel.readString());
                parcel2.writeNoException();
                return true;
            case ha$a.AppCompatTheme_actionModeCopyDrawable /*33*/:
                parcel.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                a(yo$a.a(parcel.readStrongBinder()), parcel.readInt(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.createStringArray());
                parcel2.writeNoException();
                return true;
            case ha$a.AppCompatTheme_actionModePasteDrawable /*34*/:
                parcel.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                a(yo$a.a(parcel.readStrongBinder()), parcel.readInt(), parcel.readString(), parcel.readString());
                parcel2.writeNoException();
                return true;
            case ha$a.AppCompatTheme_actionModeSelectAllDrawable /*35*/:
                parcel.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                h(yo$a.a(parcel.readStrongBinder()), parcel.readInt(), parcel.readString());
                parcel2.writeNoException();
                return true;
            case ha$a.AppCompatTheme_actionModeShareDrawable /*36*/:
                parcel.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                i(yo$a.a(parcel.readStrongBinder()), parcel.readInt(), parcel.readString());
                parcel2.writeNoException();
                return true;
            case ha$a.AppCompatTheme_actionModeFindDrawable /*37*/:
                parcel.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                a = yo$a.a(parcel.readStrongBinder());
                readInt = parcel.readInt();
                readString = parcel.readString();
                if (parcel.readInt() != 0) {
                    bundle = (Bundle) Bundle.CREATOR.createFromParcel(parcel);
                }
                q(a, readInt, readString, bundle);
                parcel2.writeNoException();
                return true;
            case ha$a.AppCompatTheme_actionModeWebSearchDrawable /*38*/:
                parcel.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                a = yo$a.a(parcel.readStrongBinder());
                readInt = parcel.readInt();
                readString = parcel.readString();
                if (parcel.readInt() != 0) {
                    bundle = (Bundle) Bundle.CREATOR.createFromParcel(parcel);
                }
                r(a, readInt, readString, bundle);
                parcel2.writeNoException();
                return true;
            case ha$a.AppCompatTheme_textAppearanceLargePopupMenu /*40*/:
                parcel.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                j(yo$a.a(parcel.readStrongBinder()), parcel.readInt(), parcel.readString());
                parcel2.writeNoException();
                return true;
            case ha$a.AppCompatTheme_textAppearanceSmallPopupMenu /*41*/:
                parcel.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                a = yo$a.a(parcel.readStrongBinder());
                readInt = parcel.readInt();
                readString = parcel.readString();
                if (parcel.readInt() != 0) {
                    bundle = (Bundle) Bundle.CREATOR.createFromParcel(parcel);
                }
                s(a, readInt, readString, bundle);
                parcel2.writeNoException();
                return true;
            case ha$a.AppCompatTheme_dialogTheme /*42*/:
                parcel.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                k(yo$a.a(parcel.readStrongBinder()), parcel.readInt(), parcel.readString());
                parcel2.writeNoException();
                return true;
            case ha$a.AppCompatTheme_dialogPreferredPadding /*43*/:
                parcel.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                a = yo$a.a(parcel.readStrongBinder());
                readInt = parcel.readInt();
                readString = parcel.readString();
                if (parcel.readInt() != 0) {
                    bundle = (Bundle) Bundle.CREATOR.createFromParcel(parcel);
                }
                t(a, readInt, readString, bundle);
                parcel2.writeNoException();
                return true;
            case ha$a.AppCompatTheme_listDividerAlertDialog /*44*/:
                parcel.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                l(yo$a.a(parcel.readStrongBinder()), parcel.readInt(), parcel.readString());
                parcel2.writeNoException();
                return true;
            case ha$a.AppCompatTheme_actionDropDownStyle /*45*/:
                parcel.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                m(yo$a.a(parcel.readStrongBinder()), parcel.readInt(), parcel.readString());
                parcel2.writeNoException();
                return true;
            case ha$a.AppCompatTheme_dropdownListPreferredItemHeight /*46*/:
                GetServiceRequest getServiceRequest;
                parcel.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                a = yo$a.a(parcel.readStrongBinder());
                if (parcel.readInt() != 0) {
                    getServiceRequest = (GetServiceRequest) GetServiceRequest.CREATOR.createFromParcel(parcel);
                }
                a(a, getServiceRequest);
                parcel2.writeNoException();
                return true;
            case ha$a.AppCompatTheme_spinnerDropDownItemStyle /*47*/:
                parcel.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                a = yo$a.a(parcel.readStrongBinder());
                if (parcel.readInt() != 0) {
                    validateAccountRequest = (ValidateAccountRequest) ValidateAccountRequest.CREATOR.createFromParcel(parcel);
                }
                a(a, validateAccountRequest);
                parcel2.writeNoException();
                return true;
            case 1598968902:
                parcel2.writeString("com.google.android.gms.common.internal.IGmsServiceBroker");
                return true;
            default:
                return super.onTransact(i, parcel, parcel2, i2);
        }
    }
}
