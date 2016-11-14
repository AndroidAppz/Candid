package defpackage;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.location.places.internal.PlaceLocalization;
import java.util.List;

public class aco implements Creator<PlaceLocalization> {
    public static void a(PlaceLocalization placeLocalization, Parcel parcel, int i) {
        int zzav = xo.zzav(parcel);
        xo.a(parcel, 1, placeLocalization.b, false);
        xo.a(parcel, 1000, placeLocalization.a);
        xo.a(parcel, 2, placeLocalization.c, false);
        xo.a(parcel, 3, placeLocalization.d, false);
        xo.a(parcel, 4, placeLocalization.e, false);
        xo.b(parcel, 5, placeLocalization.f, false);
        xo.zzI(parcel, zzav);
    }

    public PlaceLocalization a(Parcel parcel) {
        List list = null;
        int zzau = zza.zzau(parcel);
        int i = 0;
        String str = null;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        while (parcel.dataPosition() < zzau) {
            int zzat = zza.zzat(parcel);
            switch (zza.zzca(zzat)) {
                case um$h.com_facebook_profile_picture_view_com_facebook_is_cropped /*1*/:
                    str4 = zza.zzp(parcel, zzat);
                    break;
                case um$h.com_facebook_login_view_com_facebook_logout_text /*2*/:
                    str3 = zza.zzp(parcel, zzat);
                    break;
                case um$h.com_facebook_login_view_com_facebook_tooltip_mode /*3*/:
                    str2 = zza.zzp(parcel, zzat);
                    break;
                case um$h.com_facebook_like_view_com_facebook_auxiliary_view_position /*4*/:
                    str = zza.zzp(parcel, zzat);
                    break;
                case um$h.com_facebook_like_view_com_facebook_horizontal_alignment /*5*/:
                    list = zza.r(parcel, zzat);
                    break;
                case 1000:
                    i = zza.f(parcel, zzat);
                    break;
                default:
                    zza.b(parcel, zzat);
                    break;
            }
        }
        if (parcel.dataPosition() == zzau) {
            return new PlaceLocalization(i, str4, str3, str2, str, list);
        }
        throw new zza.zza("Overread allowed size end=" + zzau, parcel);
    }

    public PlaceLocalization[] a(int i) {
        return new PlaceLocalization[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return a(i);
    }
}
