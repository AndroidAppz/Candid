package defpackage;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.ResolveAccountResponse;
import com.google.android.gms.common.internal.safeparcel.zza;

public class xt implements Creator<ResolveAccountResponse> {
    public static void a(ResolveAccountResponse resolveAccountResponse, Parcel parcel, int i) {
        int a = xo.a(parcel);
        xo.a(parcel, 1, resolveAccountResponse.a);
        xo.a(parcel, 2, resolveAccountResponse.b, false);
        xo.a(parcel, 3, resolveAccountResponse.b(), i, false);
        xo.a(parcel, 4, resolveAccountResponse.c());
        xo.a(parcel, 5, resolveAccountResponse.d());
        xo.a(parcel, a);
    }

    public ResolveAccountResponse a(Parcel parcel) {
        ConnectionResult connectionResult = null;
        boolean z = false;
        int b = zza.b(parcel);
        boolean z2 = false;
        IBinder iBinder = null;
        int i = 0;
        while (parcel.dataPosition() < b) {
            int a = zza.a(parcel);
            switch (zza.a(a)) {
                case um$h.com_facebook_profile_picture_view_com_facebook_is_cropped /*1*/:
                    i = zza.f(parcel, a);
                    break;
                case um$h.com_facebook_login_view_com_facebook_logout_text /*2*/:
                    iBinder = zza.o(parcel, a);
                    break;
                case um$h.com_facebook_login_view_com_facebook_tooltip_mode /*3*/:
                    connectionResult = (ConnectionResult) zza.a(parcel, a, ConnectionResult.CREATOR);
                    break;
                case um$h.com_facebook_like_view_com_facebook_auxiliary_view_position /*4*/:
                    z2 = zza.c(parcel, a);
                    break;
                case um$h.com_facebook_like_view_com_facebook_horizontal_alignment /*5*/:
                    z = zza.c(parcel, a);
                    break;
                default:
                    zza.b(parcel, a);
                    break;
            }
        }
        if (parcel.dataPosition() == b) {
            return new ResolveAccountResponse(i, iBinder, connectionResult, z2, z);
        }
        throw new zza.zza("Overread allowed size end=" + b, parcel);
    }

    public ResolveAccountResponse[] a(int i) {
        return new ResolveAccountResponse[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return a(i);
    }
}
