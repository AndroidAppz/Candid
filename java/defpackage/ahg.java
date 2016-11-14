package defpackage;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.signin.internal.CheckServerAuthResult;
import java.util.List;

public class ahg implements Creator<CheckServerAuthResult> {
    public static void a(CheckServerAuthResult checkServerAuthResult, Parcel parcel, int i) {
        int a = xo.a(parcel);
        xo.a(parcel, 1, checkServerAuthResult.a);
        xo.a(parcel, 2, checkServerAuthResult.b);
        xo.c(parcel, 3, checkServerAuthResult.c, false);
        xo.a(parcel, a);
    }

    public CheckServerAuthResult a(Parcel parcel) {
        boolean z = false;
        int b = zza.b(parcel);
        List list = null;
        int i = 0;
        while (parcel.dataPosition() < b) {
            int a = zza.a(parcel);
            switch (zza.a(a)) {
                case um$h.com_facebook_profile_picture_view_com_facebook_is_cropped /*1*/:
                    i = zza.f(parcel, a);
                    break;
                case um$h.com_facebook_login_view_com_facebook_logout_text /*2*/:
                    z = zza.c(parcel, a);
                    break;
                case um$h.com_facebook_login_view_com_facebook_tooltip_mode /*3*/:
                    list = zza.c(parcel, a, Scope.CREATOR);
                    break;
                default:
                    zza.b(parcel, a);
                    break;
            }
        }
        if (parcel.dataPosition() == b) {
            return new CheckServerAuthResult(i, z, list);
        }
        throw new zza.zza("Overread allowed size end=" + b, parcel);
    }

    public CheckServerAuthResult[] a(int i) {
        return new CheckServerAuthResult[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return a(i);
    }
}
