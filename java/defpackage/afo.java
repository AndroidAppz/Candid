package defpackage;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.maps.model.StreetViewPanoramaOrientation;

public class afo implements Creator<StreetViewPanoramaOrientation> {
    public static void a(StreetViewPanoramaOrientation streetViewPanoramaOrientation, Parcel parcel, int i) {
        int zzav = xo.zzav(parcel);
        xo.a(parcel, 1, streetViewPanoramaOrientation.a());
        xo.a(parcel, 2, streetViewPanoramaOrientation.a);
        xo.a(parcel, 3, streetViewPanoramaOrientation.b);
        xo.zzI(parcel, zzav);
    }

    public StreetViewPanoramaOrientation a(Parcel parcel) {
        float f = 0.0f;
        int zzau = zza.zzau(parcel);
        int i = 0;
        float f2 = 0.0f;
        while (parcel.dataPosition() < zzau) {
            int zzat = zza.zzat(parcel);
            switch (zza.zzca(zzat)) {
                case um$h.com_facebook_profile_picture_view_com_facebook_is_cropped /*1*/:
                    i = zza.f(parcel, zzat);
                    break;
                case um$h.com_facebook_login_view_com_facebook_logout_text /*2*/:
                    f2 = zza.j(parcel, zzat);
                    break;
                case um$h.com_facebook_login_view_com_facebook_tooltip_mode /*3*/:
                    f = zza.j(parcel, zzat);
                    break;
                default:
                    zza.b(parcel, zzat);
                    break;
            }
        }
        if (parcel.dataPosition() == zzau) {
            return new StreetViewPanoramaOrientation(i, f2, f);
        }
        throw new zza.zza("Overread allowed size end=" + zzau, parcel);
    }

    public StreetViewPanoramaOrientation[] a(int i) {
        return new StreetViewPanoramaOrientation[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return a(i);
    }
}
