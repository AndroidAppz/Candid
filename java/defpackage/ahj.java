package defpackage;

import android.accounts.Account;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.signin.internal.RecordConsentRequest;

public class ahj implements Creator<RecordConsentRequest> {
    public static void a(RecordConsentRequest recordConsentRequest, Parcel parcel, int i) {
        int a = xo.a(parcel);
        xo.a(parcel, 1, recordConsentRequest.a);
        xo.a(parcel, 2, recordConsentRequest.a(), i, false);
        xo.a(parcel, 3, recordConsentRequest.b(), i, false);
        xo.a(parcel, 4, recordConsentRequest.c(), false);
        xo.a(parcel, a);
    }

    public RecordConsentRequest a(Parcel parcel) {
        String str = null;
        int b = zza.b(parcel);
        int i = 0;
        Scope[] scopeArr = null;
        Account account = null;
        while (parcel.dataPosition() < b) {
            Scope[] scopeArr2;
            Account account2;
            int f;
            String str2;
            int a = zza.a(parcel);
            String str3;
            switch (zza.a(a)) {
                case um$h.com_facebook_profile_picture_view_com_facebook_is_cropped /*1*/:
                    str3 = str;
                    scopeArr2 = scopeArr;
                    account2 = account;
                    f = zza.f(parcel, a);
                    str2 = str3;
                    break;
                case um$h.com_facebook_login_view_com_facebook_logout_text /*2*/:
                    f = i;
                    Scope[] scopeArr3 = scopeArr;
                    account2 = (Account) zza.a(parcel, a, Account.CREATOR);
                    str2 = str;
                    scopeArr2 = scopeArr3;
                    break;
                case um$h.com_facebook_login_view_com_facebook_tooltip_mode /*3*/:
                    account2 = account;
                    f = i;
                    str3 = str;
                    scopeArr2 = (Scope[]) zza.b(parcel, a, Scope.CREATOR);
                    str2 = str3;
                    break;
                case um$h.com_facebook_like_view_com_facebook_auxiliary_view_position /*4*/:
                    str2 = zza.n(parcel, a);
                    scopeArr2 = scopeArr;
                    account2 = account;
                    f = i;
                    break;
                default:
                    zza.b(parcel, a);
                    str2 = str;
                    scopeArr2 = scopeArr;
                    account2 = account;
                    f = i;
                    break;
            }
            i = f;
            account = account2;
            scopeArr = scopeArr2;
            str = str2;
        }
        if (parcel.dataPosition() == b) {
            return new RecordConsentRequest(i, account, scopeArr, str);
        }
        throw new zza.zza("Overread allowed size end=" + b, parcel);
    }

    public RecordConsentRequest[] a(int i) {
        return new RecordConsentRequest[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return a(i);
    }
}
