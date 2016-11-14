package defpackage;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.location.places.AutocompleteFilter;
import java.util.List;

public class acs implements Creator<AutocompleteFilter> {
    public static void a(AutocompleteFilter autocompleteFilter, Parcel parcel, int i) {
        int zzav = xo.zzav(parcel);
        xo.a(parcel, 1, autocompleteFilter.b);
        xo.a(parcel, 1000, autocompleteFilter.a);
        xo.a(parcel, 2, autocompleteFilter.c, false);
        xo.zzI(parcel, zzav);
    }

    public AutocompleteFilter a(Parcel parcel) {
        boolean z = false;
        int zzau = zza.zzau(parcel);
        List list = null;
        int i = 0;
        while (parcel.dataPosition() < zzau) {
            int zzat = zza.zzat(parcel);
            switch (zza.zzca(zzat)) {
                case um$h.com_facebook_profile_picture_view_com_facebook_is_cropped /*1*/:
                    z = zza.c(parcel, zzat);
                    break;
                case um$h.com_facebook_login_view_com_facebook_logout_text /*2*/:
                    list = zza.zzC(parcel, zzat);
                    break;
                case 1000:
                    i = zza.f(parcel, zzat);
                    break;
                default:
                    zza.b(parcel, zzat);
                    break;
            }
        }
        if (parcel.dataPosition() == zzau) {
            return new AutocompleteFilter(i, z, list);
        }
        throw new zza.zza("Overread allowed size end=" + zzau, parcel);
    }

    public AutocompleteFilter[] a(int i) {
        return new AutocompleteFilter[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return a(i);
    }
}
