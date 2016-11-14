package defpackage;

import android.accounts.Account;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.common.internal.ResolveAccountRequest;
import com.google.android.gms.common.internal.safeparcel.zza;

public class xs implements Creator<ResolveAccountRequest> {
    public static void a(ResolveAccountRequest resolveAccountRequest, Parcel parcel, int i) {
        int a = xo.a(parcel);
        xo.a(parcel, 1, resolveAccountRequest.a);
        xo.a(parcel, 2, resolveAccountRequest.a(), i, false);
        xo.a(parcel, 3, resolveAccountRequest.b());
        xo.a(parcel, 4, resolveAccountRequest.c(), i, false);
        xo.a(parcel, a);
    }

    public ResolveAccountRequest a(Parcel parcel) {
        GoogleSignInAccount googleSignInAccount = null;
        int i = 0;
        int b = zza.b(parcel);
        Account account = null;
        int i2 = 0;
        while (parcel.dataPosition() < b) {
            int i3;
            Account account2;
            int f;
            GoogleSignInAccount googleSignInAccount2;
            int a = zza.a(parcel);
            GoogleSignInAccount googleSignInAccount3;
            switch (zza.a(a)) {
                case um$h.com_facebook_profile_picture_view_com_facebook_is_cropped /*1*/:
                    googleSignInAccount3 = googleSignInAccount;
                    i3 = i;
                    account2 = account;
                    f = zza.f(parcel, a);
                    googleSignInAccount2 = googleSignInAccount3;
                    break;
                case um$h.com_facebook_login_view_com_facebook_logout_text /*2*/:
                    f = i2;
                    int i4 = i;
                    account2 = (Account) zza.a(parcel, a, Account.CREATOR);
                    googleSignInAccount2 = googleSignInAccount;
                    i3 = i4;
                    break;
                case um$h.com_facebook_login_view_com_facebook_tooltip_mode /*3*/:
                    account2 = account;
                    f = i2;
                    googleSignInAccount3 = googleSignInAccount;
                    i3 = zza.f(parcel, a);
                    googleSignInAccount2 = googleSignInAccount3;
                    break;
                case um$h.com_facebook_like_view_com_facebook_auxiliary_view_position /*4*/:
                    googleSignInAccount2 = (GoogleSignInAccount) zza.a(parcel, a, GoogleSignInAccount.CREATOR);
                    i3 = i;
                    account2 = account;
                    f = i2;
                    break;
                default:
                    zza.b(parcel, a);
                    googleSignInAccount2 = googleSignInAccount;
                    i3 = i;
                    account2 = account;
                    f = i2;
                    break;
            }
            i2 = f;
            account = account2;
            i = i3;
            googleSignInAccount = googleSignInAccount2;
        }
        if (parcel.dataPosition() == b) {
            return new ResolveAccountRequest(i2, account, i, googleSignInAccount);
        }
        throw new zza.zza("Overread allowed size end=" + b, parcel);
    }

    public ResolveAccountRequest[] a(int i) {
        return new ResolveAccountRequest[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return a(i);
    }
}
