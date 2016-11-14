package defpackage;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.maps.model.TileOverlayOptions;

public class afq implements Creator<TileOverlayOptions> {
    public static void a(TileOverlayOptions tileOverlayOptions, Parcel parcel, int i) {
        int zzav = xo.zzav(parcel);
        xo.a(parcel, 1, tileOverlayOptions.a());
        xo.a(parcel, 2, tileOverlayOptions.b(), false);
        xo.a(parcel, 3, tileOverlayOptions.d());
        xo.a(parcel, 4, tileOverlayOptions.c());
        xo.a(parcel, 5, tileOverlayOptions.e());
        xo.zzI(parcel, zzav);
    }

    public TileOverlayOptions a(Parcel parcel) {
        boolean z = false;
        int zzau = zza.zzau(parcel);
        IBinder iBinder = null;
        float f = 0.0f;
        boolean z2 = true;
        int i = 0;
        while (parcel.dataPosition() < zzau) {
            int zzat = zza.zzat(parcel);
            switch (zza.zzca(zzat)) {
                case um$h.com_facebook_profile_picture_view_com_facebook_is_cropped /*1*/:
                    i = zza.f(parcel, zzat);
                    break;
                case um$h.com_facebook_login_view_com_facebook_logout_text /*2*/:
                    iBinder = zza.zzq(parcel, zzat);
                    break;
                case um$h.com_facebook_login_view_com_facebook_tooltip_mode /*3*/:
                    z = zza.c(parcel, zzat);
                    break;
                case um$h.com_facebook_like_view_com_facebook_auxiliary_view_position /*4*/:
                    f = zza.j(parcel, zzat);
                    break;
                case um$h.com_facebook_like_view_com_facebook_horizontal_alignment /*5*/:
                    z2 = zza.c(parcel, zzat);
                    break;
                default:
                    zza.b(parcel, zzat);
                    break;
            }
        }
        if (parcel.dataPosition() == zzau) {
            return new TileOverlayOptions(i, iBinder, z, f, z2);
        }
        throw new zza.zza("Overread allowed size end=" + zzau, parcel);
    }

    public TileOverlayOptions[] a(int i) {
        return new TileOverlayOptions[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return a(i);
    }
}
