package defpackage;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.ValidateAccountRequest;
import com.google.android.gms.common.internal.safeparcel.zza;

public class xy implements Creator<ValidateAccountRequest> {
    public static void a(ValidateAccountRequest validateAccountRequest, Parcel parcel, int i) {
        int a = xo.a(parcel);
        xo.a(parcel, 1, validateAccountRequest.a);
        xo.a(parcel, 2, validateAccountRequest.a());
        xo.a(parcel, 3, validateAccountRequest.b, false);
        xo.a(parcel, 4, validateAccountRequest.b(), i, false);
        xo.a(parcel, 5, validateAccountRequest.d(), false);
        xo.a(parcel, 6, validateAccountRequest.c(), false);
        xo.a(parcel, a);
    }

    public ValidateAccountRequest a(Parcel parcel) {
        int i = 0;
        String str = null;
        int b = zza.b(parcel);
        Bundle bundle = null;
        Scope[] scopeArr = null;
        IBinder iBinder = null;
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
                    iBinder = zza.o(parcel, a);
                    break;
                case um$h.com_facebook_like_view_com_facebook_auxiliary_view_position /*4*/:
                    scopeArr = (Scope[]) zza.b(parcel, a, Scope.CREATOR);
                    break;
                case um$h.com_facebook_like_view_com_facebook_horizontal_alignment /*5*/:
                    bundle = zza.p(parcel, a);
                    break;
                case um$h.CardView_cardUseCompatPadding /*6*/:
                    str = zza.n(parcel, a);
                    break;
                default:
                    zza.b(parcel, a);
                    break;
            }
        }
        if (parcel.dataPosition() == b) {
            return new ValidateAccountRequest(i2, i, iBinder, scopeArr, bundle, str);
        }
        throw new zza.zza("Overread allowed size end=" + b, parcel);
    }

    public ValidateAccountRequest[] a(int i) {
        return new ValidateAccountRequest[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return a(i);
    }
}
