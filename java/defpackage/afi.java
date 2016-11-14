package defpackage;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.PointOfInterest;

public class afi implements Creator<PointOfInterest> {
    public static void a(PointOfInterest pointOfInterest, Parcel parcel, int i) {
        int zzav = xo.zzav(parcel);
        xo.a(parcel, 1, pointOfInterest.a());
        xo.a(parcel, 2, pointOfInterest.a, i, false);
        xo.a(parcel, 3, pointOfInterest.b, false);
        xo.a(parcel, 4, pointOfInterest.c, false);
        xo.zzI(parcel, zzav);
    }

    public PointOfInterest a(Parcel parcel) {
        String str = null;
        int zzau = zza.zzau(parcel);
        int i = 0;
        String str2 = null;
        LatLng latLng = null;
        while (parcel.dataPosition() < zzau) {
            LatLng latLng2;
            int f;
            String str3;
            int zzat = zza.zzat(parcel);
            String str4;
            switch (zza.zzca(zzat)) {
                case um$h.com_facebook_profile_picture_view_com_facebook_is_cropped /*1*/:
                    str4 = str;
                    str = str2;
                    latLng2 = latLng;
                    f = zza.f(parcel, zzat);
                    str3 = str4;
                    break;
                case um$h.com_facebook_login_view_com_facebook_logout_text /*2*/:
                    f = i;
                    str4 = str2;
                    latLng2 = (LatLng) zza.a(parcel, zzat, LatLng.CREATOR);
                    str3 = str;
                    str = str4;
                    break;
                case um$h.com_facebook_login_view_com_facebook_tooltip_mode /*3*/:
                    latLng2 = latLng;
                    f = i;
                    str4 = str;
                    str = zza.zzp(parcel, zzat);
                    str3 = str4;
                    break;
                case um$h.com_facebook_like_view_com_facebook_auxiliary_view_position /*4*/:
                    str3 = zza.zzp(parcel, zzat);
                    str = str2;
                    latLng2 = latLng;
                    f = i;
                    break;
                default:
                    zza.b(parcel, zzat);
                    str3 = str;
                    str = str2;
                    latLng2 = latLng;
                    f = i;
                    break;
            }
            i = f;
            latLng = latLng2;
            str2 = str;
            str = str3;
        }
        if (parcel.dataPosition() == zzau) {
            return new PointOfInterest(i, latLng, str2, str);
        }
        throw new zza.zza("Overread allowed size end=" + zzau, parcel);
    }

    public PointOfInterest[] a(int i) {
        return new PointOfInterest[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return a(i);
    }
}
