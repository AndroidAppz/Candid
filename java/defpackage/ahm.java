package defpackage;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.ResolveAccountResponse;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.signin.internal.SignInResponse;

public class ahm implements Creator<SignInResponse> {
    public static void a(SignInResponse signInResponse, Parcel parcel, int i) {
        int a = xo.a(parcel);
        xo.a(parcel, 1, signInResponse.a);
        xo.a(parcel, 2, signInResponse.a(), i, false);
        xo.a(parcel, 3, signInResponse.b(), i, false);
        xo.a(parcel, a);
    }

    public SignInResponse a(Parcel parcel) {
        ResolveAccountResponse resolveAccountResponse = null;
        int b = zza.b(parcel);
        int i = 0;
        ConnectionResult connectionResult = null;
        while (parcel.dataPosition() < b) {
            ConnectionResult connectionResult2;
            int f;
            ResolveAccountResponse resolveAccountResponse2;
            int a = zza.a(parcel);
            switch (zza.a(a)) {
                case um$h.com_facebook_profile_picture_view_com_facebook_is_cropped /*1*/:
                    ResolveAccountResponse resolveAccountResponse3 = resolveAccountResponse;
                    connectionResult2 = connectionResult;
                    f = zza.f(parcel, a);
                    resolveAccountResponse2 = resolveAccountResponse3;
                    break;
                case um$h.com_facebook_login_view_com_facebook_logout_text /*2*/:
                    f = i;
                    ConnectionResult connectionResult3 = (ConnectionResult) zza.a(parcel, a, ConnectionResult.CREATOR);
                    resolveAccountResponse2 = resolveAccountResponse;
                    connectionResult2 = connectionResult3;
                    break;
                case um$h.com_facebook_login_view_com_facebook_tooltip_mode /*3*/:
                    resolveAccountResponse2 = (ResolveAccountResponse) zza.a(parcel, a, ResolveAccountResponse.CREATOR);
                    connectionResult2 = connectionResult;
                    f = i;
                    break;
                default:
                    zza.b(parcel, a);
                    resolveAccountResponse2 = resolveAccountResponse;
                    connectionResult2 = connectionResult;
                    f = i;
                    break;
            }
            i = f;
            connectionResult = connectionResult2;
            resolveAccountResponse = resolveAccountResponse2;
        }
        if (parcel.dataPosition() == b) {
            return new SignInResponse(i, connectionResult, resolveAccountResponse);
        }
        throw new zza.zza("Overread allowed size end=" + b, parcel);
    }

    public SignInResponse[] a(int i) {
        return new SignInResponse[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return a(i);
    }
}
