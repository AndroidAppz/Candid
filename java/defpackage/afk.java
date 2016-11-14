package defpackage;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.PolylineOptions;
import java.util.List;

public class afk implements Creator<PolylineOptions> {
    public static void a(PolylineOptions polylineOptions, Parcel parcel, int i) {
        int zzav = xo.zzav(parcel);
        xo.a(parcel, 1, polylineOptions.a());
        xo.c(parcel, 2, polylineOptions.b(), false);
        xo.a(parcel, 3, polylineOptions.c());
        xo.a(parcel, 4, polylineOptions.d());
        xo.a(parcel, 5, polylineOptions.e());
        xo.a(parcel, 6, polylineOptions.f());
        xo.a(parcel, 7, polylineOptions.g());
        xo.a(parcel, 8, polylineOptions.h());
        xo.zzI(parcel, zzav);
    }

    public PolylineOptions a(Parcel parcel) {
        float f = 0.0f;
        boolean z = false;
        int zzau = zza.zzau(parcel);
        List list = null;
        boolean z2 = false;
        boolean z3 = false;
        int i = 0;
        float f2 = 0.0f;
        int i2 = 0;
        while (parcel.dataPosition() < zzau) {
            int zzat = zza.zzat(parcel);
            switch (zza.zzca(zzat)) {
                case um$h.com_facebook_profile_picture_view_com_facebook_is_cropped /*1*/:
                    i2 = zza.f(parcel, zzat);
                    break;
                case um$h.com_facebook_login_view_com_facebook_logout_text /*2*/:
                    list = zza.c(parcel, zzat, LatLng.CREATOR);
                    break;
                case um$h.com_facebook_login_view_com_facebook_tooltip_mode /*3*/:
                    f2 = zza.j(parcel, zzat);
                    break;
                case um$h.com_facebook_like_view_com_facebook_auxiliary_view_position /*4*/:
                    i = zza.f(parcel, zzat);
                    break;
                case um$h.com_facebook_like_view_com_facebook_horizontal_alignment /*5*/:
                    f = zza.j(parcel, zzat);
                    break;
                case um$h.CardView_cardUseCompatPadding /*6*/:
                    z3 = zza.c(parcel, zzat);
                    break;
                case um$h.CardView_cardPreventCornerOverlap /*7*/:
                    z2 = zza.c(parcel, zzat);
                    break;
                case um$h.CardView_contentPadding /*8*/:
                    z = zza.c(parcel, zzat);
                    break;
                default:
                    zza.b(parcel, zzat);
                    break;
            }
        }
        if (parcel.dataPosition() == zzau) {
            return new PolylineOptions(i2, list, f2, i, f, z3, z2, z);
        }
        throw new zza.zza("Overread allowed size end=" + zzau, parcel);
    }

    public PolylineOptions[] a(int i) {
        return new PolylineOptions[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return a(i);
    }
}
