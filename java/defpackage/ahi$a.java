package defpackage;

import android.accounts.Account;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.common.internal.AuthAccountRequest;
import com.google.android.gms.common.internal.ResolveAccountRequest;
import com.google.android.gms.signin.internal.CheckServerAuthResult;
import com.google.android.gms.signin.internal.RecordConsentRequest;
import com.google.android.gms.signin.internal.SignInRequest;

public abstract class ahi$a extends Binder implements ahi {
    public static ahi a(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.signin.internal.ISignInService");
        return (queryLocalInterface == null || !(queryLocalInterface instanceof ahi)) ? new ahi$a$a(iBinder) : (ahi) queryLocalInterface;
    }

    public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        boolean z = false;
        SignInRequest signInRequest = null;
        switch (i) {
            case um$h.com_facebook_login_view_com_facebook_logout_text /*2*/:
                AuthAccountRequest authAccountRequest;
                parcel.enforceInterface("com.google.android.gms.signin.internal.ISignInService");
                if (parcel.readInt() != 0) {
                    authAccountRequest = (AuthAccountRequest) AuthAccountRequest.CREATOR.createFromParcel(parcel);
                }
                a(authAccountRequest, ahh$a.a(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            case um$h.com_facebook_login_view_com_facebook_tooltip_mode /*3*/:
                CheckServerAuthResult checkServerAuthResult;
                parcel.enforceInterface("com.google.android.gms.signin.internal.ISignInService");
                if (parcel.readInt() != 0) {
                    checkServerAuthResult = (CheckServerAuthResult) CheckServerAuthResult.CREATOR.createFromParcel(parcel);
                }
                a(checkServerAuthResult);
                parcel2.writeNoException();
                return true;
            case um$h.com_facebook_like_view_com_facebook_auxiliary_view_position /*4*/:
                parcel.enforceInterface("com.google.android.gms.signin.internal.ISignInService");
                a(parcel.readInt() != 0);
                parcel2.writeNoException();
                return true;
            case um$h.com_facebook_like_view_com_facebook_horizontal_alignment /*5*/:
                ResolveAccountRequest resolveAccountRequest;
                parcel.enforceInterface("com.google.android.gms.signin.internal.ISignInService");
                if (parcel.readInt() != 0) {
                    resolveAccountRequest = (ResolveAccountRequest) ResolveAccountRequest.CREATOR.createFromParcel(parcel);
                }
                a(resolveAccountRequest, yq$a.a(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            case um$h.CardView_cardPreventCornerOverlap /*7*/:
                parcel.enforceInterface("com.google.android.gms.signin.internal.ISignInService");
                a(parcel.readInt());
                parcel2.writeNoException();
                return true;
            case um$h.CardView_contentPadding /*8*/:
                Account account;
                parcel.enforceInterface("com.google.android.gms.signin.internal.ISignInService");
                int readInt = parcel.readInt();
                if (parcel.readInt() != 0) {
                    account = (Account) Account.CREATOR.createFromParcel(parcel);
                }
                a(readInt, account, ahh$a.a(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            case um$h.CardView_contentPaddingLeft /*9*/:
                parcel.enforceInterface("com.google.android.gms.signin.internal.ISignInService");
                yl a = yl$a.a(parcel.readStrongBinder());
                int readInt2 = parcel.readInt();
                if (parcel.readInt() != 0) {
                    z = true;
                }
                a(a, readInt2, z);
                parcel2.writeNoException();
                return true;
            case um$h.CardView_contentPaddingRight /*10*/:
                RecordConsentRequest recordConsentRequest;
                parcel.enforceInterface("com.google.android.gms.signin.internal.ISignInService");
                if (parcel.readInt() != 0) {
                    recordConsentRequest = (RecordConsentRequest) RecordConsentRequest.CREATOR.createFromParcel(parcel);
                }
                a(recordConsentRequest, ahh$a.a(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            case um$h.CardView_contentPaddingTop /*11*/:
                parcel.enforceInterface("com.google.android.gms.signin.internal.ISignInService");
                a(ahh$a.a(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            case um$h.CardView_contentPaddingBottom /*12*/:
                parcel.enforceInterface("com.google.android.gms.signin.internal.ISignInService");
                if (parcel.readInt() != 0) {
                    signInRequest = (SignInRequest) SignInRequest.CREATOR.createFromParcel(parcel);
                }
                a(signInRequest, ahh$a.a(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            case 1598968902:
                parcel2.writeString("com.google.android.gms.signin.internal.ISignInService");
                return true;
            default:
                return super.onTransact(i, parcel, parcel2, i2);
        }
    }
}
