package defpackage;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.maps.StreetViewPanoramaOptions;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.StreetViewPanoramaCamera;

public class aft implements Creator<StreetViewPanoramaOptions> {
    public static void a(StreetViewPanoramaOptions streetViewPanoramaOptions, Parcel parcel, int i) {
        int zzav = xo.zzav(parcel);
        xo.a(parcel, 1, streetViewPanoramaOptions.a());
        xo.a(parcel, 2, streetViewPanoramaOptions.g(), i, false);
        xo.a(parcel, 3, streetViewPanoramaOptions.j(), false);
        xo.a(parcel, 4, streetViewPanoramaOptions.h(), i, false);
        xo.a(parcel, 5, streetViewPanoramaOptions.i(), false);
        xo.a(parcel, 6, streetViewPanoramaOptions.b());
        xo.a(parcel, 7, streetViewPanoramaOptions.c());
        xo.a(parcel, 8, streetViewPanoramaOptions.d());
        xo.a(parcel, 9, streetViewPanoramaOptions.e());
        xo.a(parcel, 10, streetViewPanoramaOptions.f());
        xo.zzI(parcel, zzav);
    }

    public StreetViewPanoramaOptions a(Parcel parcel) {
        Integer num = null;
        byte b = (byte) 0;
        int zzau = zza.zzau(parcel);
        byte b2 = (byte) 0;
        byte b3 = (byte) 0;
        byte b4 = (byte) 0;
        byte b5 = (byte) 0;
        LatLng latLng = null;
        String str = null;
        StreetViewPanoramaCamera streetViewPanoramaCamera = null;
        int i = 0;
        while (parcel.dataPosition() < zzau) {
            int zzat = zza.zzat(parcel);
            switch (zza.zzca(zzat)) {
                case um$h.com_facebook_profile_picture_view_com_facebook_is_cropped /*1*/:
                    i = zza.f(parcel, zzat);
                    break;
                case um$h.com_facebook_login_view_com_facebook_logout_text /*2*/:
                    streetViewPanoramaCamera = (StreetViewPanoramaCamera) zza.a(parcel, zzat, StreetViewPanoramaCamera.CREATOR);
                    break;
                case um$h.com_facebook_login_view_com_facebook_tooltip_mode /*3*/:
                    str = zza.zzp(parcel, zzat);
                    break;
                case um$h.com_facebook_like_view_com_facebook_auxiliary_view_position /*4*/:
                    latLng = (LatLng) zza.a(parcel, zzat, LatLng.CREATOR);
                    break;
                case um$h.com_facebook_like_view_com_facebook_horizontal_alignment /*5*/:
                    num = zza.g(parcel, zzat);
                    break;
                case um$h.CardView_cardUseCompatPadding /*6*/:
                    b5 = zza.d(parcel, zzat);
                    break;
                case um$h.CardView_cardPreventCornerOverlap /*7*/:
                    b4 = zza.d(parcel, zzat);
                    break;
                case um$h.CardView_contentPadding /*8*/:
                    b3 = zza.d(parcel, zzat);
                    break;
                case um$h.CardView_contentPaddingLeft /*9*/:
                    b2 = zza.d(parcel, zzat);
                    break;
                case um$h.CardView_contentPaddingRight /*10*/:
                    b = zza.d(parcel, zzat);
                    break;
                default:
                    zza.b(parcel, zzat);
                    break;
            }
        }
        if (parcel.dataPosition() == zzau) {
            return new StreetViewPanoramaOptions(i, streetViewPanoramaCamera, str, latLng, num, b5, b4, b3, b2, b);
        }
        throw new zza.zza("Overread allowed size end=" + zzau, parcel);
    }

    public StreetViewPanoramaOptions[] a(int i) {
        return new StreetViewPanoramaOptions[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return a(i);
    }
}
