package defpackage;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.VisibleRegion;

public class afr implements Creator<VisibleRegion> {
    public static void a(VisibleRegion visibleRegion, Parcel parcel, int i) {
        int zzav = xo.zzav(parcel);
        xo.a(parcel, 1, visibleRegion.a());
        xo.a(parcel, 2, visibleRegion.a, i, false);
        xo.a(parcel, 3, visibleRegion.b, i, false);
        xo.a(parcel, 4, visibleRegion.c, i, false);
        xo.a(parcel, 5, visibleRegion.d, i, false);
        xo.a(parcel, 6, visibleRegion.e, i, false);
        xo.zzI(parcel, zzav);
    }

    public VisibleRegion a(Parcel parcel) {
        LatLngBounds latLngBounds = null;
        int zzau = zza.zzau(parcel);
        int i = 0;
        LatLng latLng = null;
        LatLng latLng2 = null;
        LatLng latLng3 = null;
        LatLng latLng4 = null;
        while (parcel.dataPosition() < zzau) {
            int zzat = zza.zzat(parcel);
            switch (zza.zzca(zzat)) {
                case um$h.com_facebook_profile_picture_view_com_facebook_is_cropped /*1*/:
                    i = zza.f(parcel, zzat);
                    break;
                case um$h.com_facebook_login_view_com_facebook_logout_text /*2*/:
                    latLng4 = (LatLng) zza.a(parcel, zzat, LatLng.CREATOR);
                    break;
                case um$h.com_facebook_login_view_com_facebook_tooltip_mode /*3*/:
                    latLng3 = (LatLng) zza.a(parcel, zzat, LatLng.CREATOR);
                    break;
                case um$h.com_facebook_like_view_com_facebook_auxiliary_view_position /*4*/:
                    latLng2 = (LatLng) zza.a(parcel, zzat, LatLng.CREATOR);
                    break;
                case um$h.com_facebook_like_view_com_facebook_horizontal_alignment /*5*/:
                    latLng = (LatLng) zza.a(parcel, zzat, LatLng.CREATOR);
                    break;
                case um$h.CardView_cardUseCompatPadding /*6*/:
                    latLngBounds = (LatLngBounds) zza.a(parcel, zzat, LatLngBounds.CREATOR);
                    break;
                default:
                    zza.b(parcel, zzat);
                    break;
            }
        }
        if (parcel.dataPosition() == zzau) {
            return new VisibleRegion(i, latLng4, latLng3, latLng2, latLng, latLngBounds);
        }
        throw new zza.zza("Overread allowed size end=" + zzau, parcel);
    }

    public VisibleRegion[] a(int i) {
        return new VisibleRegion[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return a(i);
    }
}
