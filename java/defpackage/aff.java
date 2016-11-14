package defpackage;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;

public class aff implements Creator<LatLngBounds> {
    public static void a(LatLngBounds latLngBounds, Parcel parcel, int i) {
        int zzav = xo.zzav(parcel);
        xo.a(parcel, 1, latLngBounds.a());
        xo.a(parcel, 2, latLngBounds.a, i, false);
        xo.a(parcel, 3, latLngBounds.b, i, false);
        xo.zzI(parcel, zzav);
    }

    public LatLngBounds a(Parcel parcel) {
        LatLng latLng = null;
        int zzau = zza.zzau(parcel);
        int i = 0;
        LatLng latLng2 = null;
        while (parcel.dataPosition() < zzau) {
            int f;
            LatLng latLng3;
            int zzat = zza.zzat(parcel);
            LatLng latLng4;
            switch (zza.zzca(zzat)) {
                case um$h.com_facebook_profile_picture_view_com_facebook_is_cropped /*1*/:
                    latLng4 = latLng;
                    latLng = latLng2;
                    f = zza.f(parcel, zzat);
                    latLng3 = latLng4;
                    break;
                case um$h.com_facebook_login_view_com_facebook_logout_text /*2*/:
                    f = i;
                    latLng4 = (LatLng) zza.a(parcel, zzat, LatLng.CREATOR);
                    latLng3 = latLng;
                    latLng = latLng4;
                    break;
                case um$h.com_facebook_login_view_com_facebook_tooltip_mode /*3*/:
                    latLng3 = (LatLng) zza.a(parcel, zzat, LatLng.CREATOR);
                    latLng = latLng2;
                    f = i;
                    break;
                default:
                    zza.b(parcel, zzat);
                    latLng3 = latLng;
                    latLng = latLng2;
                    f = i;
                    break;
            }
            i = f;
            latLng2 = latLng;
            latLng = latLng3;
        }
        if (parcel.dataPosition() == zzau) {
            return new LatLngBounds(i, latLng2, latLng);
        }
        throw new zza.zza("Overread allowed size end=" + zzau, parcel);
    }

    public LatLngBounds[] a(int i) {
        return new LatLngBounds[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return a(i);
    }
}
