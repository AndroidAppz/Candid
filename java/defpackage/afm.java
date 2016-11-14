package defpackage;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.maps.model.StreetViewPanoramaLink;

public class afm implements Creator<StreetViewPanoramaLink> {
    public static void a(StreetViewPanoramaLink streetViewPanoramaLink, Parcel parcel, int i) {
        int zzav = xo.zzav(parcel);
        xo.a(parcel, 1, streetViewPanoramaLink.a());
        xo.a(parcel, 2, streetViewPanoramaLink.a, false);
        xo.a(parcel, 3, streetViewPanoramaLink.b);
        xo.zzI(parcel, zzav);
    }

    public StreetViewPanoramaLink a(Parcel parcel) {
        int zzau = zza.zzau(parcel);
        int i = 0;
        String str = null;
        float f = 0.0f;
        while (parcel.dataPosition() < zzau) {
            int zzat = zza.zzat(parcel);
            switch (zza.zzca(zzat)) {
                case um$h.com_facebook_profile_picture_view_com_facebook_is_cropped /*1*/:
                    i = zza.f(parcel, zzat);
                    break;
                case um$h.com_facebook_login_view_com_facebook_logout_text /*2*/:
                    str = zza.zzp(parcel, zzat);
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
            return new StreetViewPanoramaLink(i, str, f);
        }
        throw new zza.zza("Overread allowed size end=" + zzau, parcel);
    }

    public StreetViewPanoramaLink[] a(int i) {
        return new StreetViewPanoramaLink[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return a(i);
    }
}
