package defpackage;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.signin.internal.AuthAccountResult;
import com.google.android.gms.signin.internal.SignInResponse;

public abstract class ahh$a extends Binder implements ahh {
    public static ahh a(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.signin.internal.ISignInCallbacks");
        return (queryLocalInterface == null || !(queryLocalInterface instanceof ahh)) ? new ahh$a$a(iBinder) : (ahh) queryLocalInterface;
    }

    public IBinder asBinder() {
        return this;
    }

    public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        switch (i) {
            case um$h.com_facebook_login_view_com_facebook_tooltip_mode /*3*/:
                parcel.enforceInterface("com.google.android.gms.signin.internal.ISignInCallbacks");
                a(parcel.readInt() != 0 ? (ConnectionResult) ConnectionResult.CREATOR.createFromParcel(parcel) : null, parcel.readInt() != 0 ? (AuthAccountResult) AuthAccountResult.CREATOR.createFromParcel(parcel) : null);
                parcel2.writeNoException();
                return true;
            case um$h.com_facebook_like_view_com_facebook_auxiliary_view_position /*4*/:
                parcel.enforceInterface("com.google.android.gms.signin.internal.ISignInCallbacks");
                a(parcel.readInt() != 0 ? (Status) Status.CREATOR.createFromParcel(parcel) : null);
                parcel2.writeNoException();
                return true;
            case um$h.CardView_cardUseCompatPadding /*6*/:
                parcel.enforceInterface("com.google.android.gms.signin.internal.ISignInCallbacks");
                b(parcel.readInt() != 0 ? (Status) Status.CREATOR.createFromParcel(parcel) : null);
                parcel2.writeNoException();
                return true;
            case um$h.CardView_cardPreventCornerOverlap /*7*/:
                parcel.enforceInterface("com.google.android.gms.signin.internal.ISignInCallbacks");
                a(parcel.readInt() != 0 ? (Status) Status.CREATOR.createFromParcel(parcel) : null, parcel.readInt() != 0 ? (GoogleSignInAccount) GoogleSignInAccount.CREATOR.createFromParcel(parcel) : null);
                parcel2.writeNoException();
                return true;
            case um$h.CardView_contentPadding /*8*/:
                parcel.enforceInterface("com.google.android.gms.signin.internal.ISignInCallbacks");
                a(parcel.readInt() != 0 ? (SignInResponse) SignInResponse.CREATOR.createFromParcel(parcel) : null);
                parcel2.writeNoException();
                return true;
            case 1598968902:
                parcel2.writeString("com.google.android.gms.signin.internal.ISignInCallbacks");
                return true;
            default:
                return super.onTransact(i, parcel, parcel2, i2);
        }
    }
}
