package defpackage;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.SignInButtonConfig;
import com.google.android.gms.common.internal.safeparcel.zza;

public class xu implements Creator<SignInButtonConfig> {
    public static void a(SignInButtonConfig signInButtonConfig, Parcel parcel, int i) {
        int a = xo.a(parcel);
        xo.a(parcel, 1, signInButtonConfig.a);
        xo.a(parcel, 2, signInButtonConfig.a());
        xo.a(parcel, 3, signInButtonConfig.b());
        xo.a(parcel, 4, signInButtonConfig.c(), i, false);
        xo.a(parcel, a);
    }

    public SignInButtonConfig a(Parcel parcel) {
        int i = 0;
        int b = zza.b(parcel);
        Scope[] scopeArr = null;
        int i2 = 0;
        int i3 = 0;
        while (parcel.dataPosition() < b) {
            int a = zza.a(parcel);
            switch (zza.a(a)) {
                case um$h.com_facebook_profile_picture_view_com_facebook_is_cropped /*1*/:
                    i3 = zza.f(parcel, a);
                    break;
                case um$h.com_facebook_login_view_com_facebook_logout_text /*2*/:
                    i2 = zza.f(parcel, a);
                    break;
                case um$h.com_facebook_login_view_com_facebook_tooltip_mode /*3*/:
                    i = zza.f(parcel, a);
                    break;
                case um$h.com_facebook_like_view_com_facebook_auxiliary_view_position /*4*/:
                    scopeArr = (Scope[]) zza.b(parcel, a, Scope.CREATOR);
                    break;
                default:
                    zza.b(parcel, a);
                    break;
            }
        }
        if (parcel.dataPosition() == b) {
            return new SignInButtonConfig(i3, i2, i, scopeArr);
        }
        throw new zza.zza("Overread allowed size end=" + b, parcel);
    }

    public SignInButtonConfig[] a(int i) {
        return new SignInButtonConfig[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return a(i);
    }
}
