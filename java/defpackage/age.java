package defpackage;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.measurement.internal.UserAttributeParcel;

public class age implements Creator<UserAttributeParcel> {
    public static void a(UserAttributeParcel userAttributeParcel, Parcel parcel, int i) {
        int a = xo.a(parcel);
        xo.a(parcel, 1, userAttributeParcel.a);
        xo.a(parcel, 2, userAttributeParcel.b, false);
        xo.a(parcel, 3, userAttributeParcel.c);
        xo.a(parcel, 4, userAttributeParcel.d, false);
        xo.a(parcel, 5, userAttributeParcel.e, false);
        xo.a(parcel, 6, userAttributeParcel.f, false);
        xo.a(parcel, 7, userAttributeParcel.g, false);
        xo.a(parcel, 8, userAttributeParcel.h, false);
        xo.a(parcel, a);
    }

    public UserAttributeParcel a(Parcel parcel) {
        Double d = null;
        int b = zza.b(parcel);
        int i = 0;
        long j = 0;
        String str = null;
        String str2 = null;
        Float f = null;
        Long l = null;
        String str3 = null;
        while (parcel.dataPosition() < b) {
            int a = zza.a(parcel);
            switch (zza.a(a)) {
                case um$h.com_facebook_profile_picture_view_com_facebook_is_cropped /*1*/:
                    i = zza.f(parcel, a);
                    break;
                case um$h.com_facebook_login_view_com_facebook_logout_text /*2*/:
                    str3 = zza.n(parcel, a);
                    break;
                case um$h.com_facebook_login_view_com_facebook_tooltip_mode /*3*/:
                    j = zza.h(parcel, a);
                    break;
                case um$h.com_facebook_like_view_com_facebook_auxiliary_view_position /*4*/:
                    l = zza.i(parcel, a);
                    break;
                case um$h.com_facebook_like_view_com_facebook_horizontal_alignment /*5*/:
                    f = zza.k(parcel, a);
                    break;
                case um$h.CardView_cardUseCompatPadding /*6*/:
                    str2 = zza.n(parcel, a);
                    break;
                case um$h.CardView_cardPreventCornerOverlap /*7*/:
                    str = zza.n(parcel, a);
                    break;
                case um$h.CardView_contentPadding /*8*/:
                    d = zza.m(parcel, a);
                    break;
                default:
                    zza.b(parcel, a);
                    break;
            }
        }
        if (parcel.dataPosition() == b) {
            return new UserAttributeParcel(i, str3, j, l, f, str2, str, d);
        }
        throw new zza.zza("Overread allowed size end=" + b, parcel);
    }

    public UserAttributeParcel[] a(int i) {
        return new UserAttributeParcel[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return a(i);
    }
}
