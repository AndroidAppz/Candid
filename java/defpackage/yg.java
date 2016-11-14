package defpackage;

import android.accounts.Account;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.GetServiceRequest;
import com.google.android.gms.common.internal.safeparcel.zza;

public class yg implements Creator<GetServiceRequest> {
    public static void a(GetServiceRequest getServiceRequest, Parcel parcel, int i) {
        int a = xo.a(parcel);
        xo.a(parcel, 1, getServiceRequest.a);
        xo.a(parcel, 2, getServiceRequest.b);
        xo.a(parcel, 3, getServiceRequest.c);
        xo.a(parcel, 4, getServiceRequest.d, false);
        xo.a(parcel, 5, getServiceRequest.e, false);
        xo.a(parcel, 6, getServiceRequest.f, i, false);
        xo.a(parcel, 7, getServiceRequest.g, false);
        xo.a(parcel, 8, getServiceRequest.h, i, false);
        xo.a(parcel, 9, getServiceRequest.i);
        xo.a(parcel, a);
    }

    public GetServiceRequest a(Parcel parcel) {
        int i = 0;
        Account account = null;
        int b = zza.b(parcel);
        long j = 0;
        Bundle bundle = null;
        Scope[] scopeArr = null;
        IBinder iBinder = null;
        String str = null;
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
                    str = zza.n(parcel, a);
                    break;
                case um$h.com_facebook_like_view_com_facebook_horizontal_alignment /*5*/:
                    iBinder = zza.o(parcel, a);
                    break;
                case um$h.CardView_cardUseCompatPadding /*6*/:
                    scopeArr = (Scope[]) zza.b(parcel, a, Scope.CREATOR);
                    break;
                case um$h.CardView_cardPreventCornerOverlap /*7*/:
                    bundle = zza.p(parcel, a);
                    break;
                case um$h.CardView_contentPadding /*8*/:
                    account = (Account) zza.a(parcel, a, Account.CREATOR);
                    break;
                case um$h.CardView_contentPaddingLeft /*9*/:
                    j = zza.h(parcel, a);
                    break;
                default:
                    zza.b(parcel, a);
                    break;
            }
        }
        if (parcel.dataPosition() == b) {
            return new GetServiceRequest(i3, i2, i, str, iBinder, scopeArr, bundle, account, j);
        }
        throw new zza.zza("Overread allowed size end=" + b, parcel);
    }

    public GetServiceRequest[] a(int i) {
        return new GetServiceRequest[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return a(i);
    }
}
