package defpackage;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.location.GeofencingRequest;
import com.google.android.gms.location.internal.ParcelableGeofence;
import java.util.List;

public class act implements Creator<GeofencingRequest> {
    public static void a(GeofencingRequest geofencingRequest, Parcel parcel, int i) {
        int zzav = xo.zzav(parcel);
        xo.c(parcel, 1, geofencingRequest.b(), false);
        xo.a(parcel, 1000, geofencingRequest.a());
        xo.a(parcel, 2, geofencingRequest.c());
        xo.zzI(parcel, zzav);
    }

    public GeofencingRequest a(Parcel parcel) {
        int i = 0;
        int zzau = zza.zzau(parcel);
        List list = null;
        int i2 = 0;
        while (parcel.dataPosition() < zzau) {
            int zzat = zza.zzat(parcel);
            switch (zza.zzca(zzat)) {
                case um$h.com_facebook_profile_picture_view_com_facebook_is_cropped /*1*/:
                    list = zza.c(parcel, zzat, ParcelableGeofence.CREATOR);
                    break;
                case um$h.com_facebook_login_view_com_facebook_logout_text /*2*/:
                    i = zza.f(parcel, zzat);
                    break;
                case 1000:
                    i2 = zza.f(parcel, zzat);
                    break;
                default:
                    zza.b(parcel, zzat);
                    break;
            }
        }
        if (parcel.dataPosition() == zzau) {
            return new GeofencingRequest(i2, list, i);
        }
        throw new zza.zza("Overread allowed size end=" + zzau, parcel);
    }

    public GeofencingRequest[] a(int i) {
        return new GeofencingRequest[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return a(i);
    }
}
