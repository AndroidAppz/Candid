package defpackage;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.StreetViewPanoramaLink;
import com.google.android.gms.maps.model.StreetViewPanoramaLocation;

public class afn implements Creator<StreetViewPanoramaLocation> {
    public static void a(StreetViewPanoramaLocation streetViewPanoramaLocation, Parcel parcel, int i) {
        int zzav = xo.zzav(parcel);
        xo.a(parcel, 1, streetViewPanoramaLocation.a());
        xo.a(parcel, 2, streetViewPanoramaLocation.a, i, false);
        xo.a(parcel, 3, streetViewPanoramaLocation.b, i, false);
        xo.a(parcel, 4, streetViewPanoramaLocation.c, false);
        xo.zzI(parcel, zzav);
    }

    public StreetViewPanoramaLocation a(Parcel parcel) {
        String str = null;
        int zzau = zza.zzau(parcel);
        int i = 0;
        LatLng latLng = null;
        StreetViewPanoramaLink[] streetViewPanoramaLinkArr = null;
        while (parcel.dataPosition() < zzau) {
            LatLng latLng2;
            StreetViewPanoramaLink[] streetViewPanoramaLinkArr2;
            int f;
            String str2;
            int zzat = zza.zzat(parcel);
            String str3;
            switch (zza.zzca(zzat)) {
                case um$h.com_facebook_profile_picture_view_com_facebook_is_cropped /*1*/:
                    str3 = str;
                    latLng2 = latLng;
                    streetViewPanoramaLinkArr2 = streetViewPanoramaLinkArr;
                    f = zza.f(parcel, zzat);
                    str2 = str3;
                    break;
                case um$h.com_facebook_login_view_com_facebook_logout_text /*2*/:
                    f = i;
                    LatLng latLng3 = latLng;
                    streetViewPanoramaLinkArr2 = (StreetViewPanoramaLink[]) zza.b(parcel, zzat, StreetViewPanoramaLink.CREATOR);
                    str2 = str;
                    latLng2 = latLng3;
                    break;
                case um$h.com_facebook_login_view_com_facebook_tooltip_mode /*3*/:
                    streetViewPanoramaLinkArr2 = streetViewPanoramaLinkArr;
                    f = i;
                    str3 = str;
                    latLng2 = (LatLng) zza.a(parcel, zzat, LatLng.CREATOR);
                    str2 = str3;
                    break;
                case um$h.com_facebook_like_view_com_facebook_auxiliary_view_position /*4*/:
                    str2 = zza.zzp(parcel, zzat);
                    latLng2 = latLng;
                    streetViewPanoramaLinkArr2 = streetViewPanoramaLinkArr;
                    f = i;
                    break;
                default:
                    zza.b(parcel, zzat);
                    str2 = str;
                    latLng2 = latLng;
                    streetViewPanoramaLinkArr2 = streetViewPanoramaLinkArr;
                    f = i;
                    break;
            }
            i = f;
            streetViewPanoramaLinkArr = streetViewPanoramaLinkArr2;
            latLng = latLng2;
            str = str2;
        }
        if (parcel.dataPosition() == zzau) {
            return new StreetViewPanoramaLocation(i, streetViewPanoramaLinkArr, latLng, str);
        }
        throw new zza.zza("Overread allowed size end=" + zzau, parcel);
    }

    public StreetViewPanoramaLocation[] a(int i) {
        return new StreetViewPanoramaLocation[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return a(i);
    }
}
