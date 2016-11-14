package defpackage;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.signin.internal.AuthAccountResult;

public class ahf implements Creator<AuthAccountResult> {
    public static void a(AuthAccountResult authAccountResult, Parcel parcel, int i) {
        int a = xo.a(parcel);
        xo.a(parcel, 1, authAccountResult.a);
        xo.a(parcel, 2, authAccountResult.b());
        xo.a(parcel, 3, authAccountResult.c(), i, false);
        xo.a(parcel, a);
    }

    public AuthAccountResult a(Parcel parcel) {
        int i = 0;
        int b = zza.b(parcel);
        Intent intent = null;
        int i2 = 0;
        while (parcel.dataPosition() < b) {
            int a = zza.a(parcel);
            switch (zza.a(a)) {
                case um$h.com_facebook_profile_picture_view_com_facebook_is_cropped /*1*/:
                    i2 = zza.f(parcel, a);
                    break;
                case um$h.com_facebook_login_view_com_facebook_logout_text /*2*/:
                    i = zza.f(parcel, a);
                    break;
                case um$h.com_facebook_login_view_com_facebook_tooltip_mode /*3*/:
                    intent = (Intent) zza.a(parcel, a, Intent.CREATOR);
                    break;
                default:
                    zza.b(parcel, a);
                    break;
            }
        }
        if (parcel.dataPosition() == b) {
            return new AuthAccountResult(i2, i, intent);
        }
        throw new zza.zza("Overread allowed size end=" + b, parcel);
    }

    public AuthAccountResult[] a(int i) {
        return new AuthAccountResult[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return a(i);
    }
}
