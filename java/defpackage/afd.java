package defpackage;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.maps.model.CircleOptions;
import com.google.android.gms.maps.model.LatLng;

public class afd implements Creator<CircleOptions> {
    public static void a(CircleOptions circleOptions, Parcel parcel, int i) {
        int zzav = xo.zzav(parcel);
        xo.a(parcel, 1, circleOptions.a());
        xo.a(parcel, 2, circleOptions.b(), i, false);
        xo.a(parcel, 3, circleOptions.c());
        xo.a(parcel, 4, circleOptions.d());
        xo.a(parcel, 5, circleOptions.e());
        xo.a(parcel, 6, circleOptions.f());
        xo.a(parcel, 7, circleOptions.g());
        xo.a(parcel, 8, circleOptions.h());
        xo.zzI(parcel, zzav);
    }

    public CircleOptions a(Parcel parcel) {
        float f = 0.0f;
        boolean z = false;
        int zzau = zza.zzau(parcel);
        LatLng latLng = null;
        double d = 0.0d;
        int i = 0;
        int i2 = 0;
        float f2 = 0.0f;
        int i3 = 0;
        while (parcel.dataPosition() < zzau) {
            int zzat = zza.zzat(parcel);
            switch (zza.zzca(zzat)) {
                case um$h.com_facebook_profile_picture_view_com_facebook_is_cropped /*1*/:
                    i3 = zza.f(parcel, zzat);
                    break;
                case um$h.com_facebook_login_view_com_facebook_logout_text /*2*/:
                    latLng = (LatLng) zza.a(parcel, zzat, LatLng.CREATOR);
                    break;
                case um$h.com_facebook_login_view_com_facebook_tooltip_mode /*3*/:
                    d = zza.l(parcel, zzat);
                    break;
                case um$h.com_facebook_like_view_com_facebook_auxiliary_view_position /*4*/:
                    f2 = zza.j(parcel, zzat);
                    break;
                case um$h.com_facebook_like_view_com_facebook_horizontal_alignment /*5*/:
                    i2 = zza.f(parcel, zzat);
                    break;
                case um$h.CardView_cardUseCompatPadding /*6*/:
                    i = zza.f(parcel, zzat);
                    break;
                case um$h.CardView_cardPreventCornerOverlap /*7*/:
                    f = zza.j(parcel, zzat);
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
            return new CircleOptions(i3, latLng, d, f2, i2, i, f, z);
        }
        throw new zza.zza("Overread allowed size end=" + zzau, parcel);
    }

    public CircleOptions[] a(int i) {
        return new CircleOptions[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return a(i);
    }
}
