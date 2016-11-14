package defpackage;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.maps.model.GroundOverlayOptions;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;

public class afe implements Creator<GroundOverlayOptions> {
    public static void a(GroundOverlayOptions groundOverlayOptions, Parcel parcel, int i) {
        int zzav = xo.zzav(parcel);
        xo.a(parcel, 1, groundOverlayOptions.b());
        xo.a(parcel, 2, groundOverlayOptions.a(), false);
        xo.a(parcel, 3, groundOverlayOptions.c(), i, false);
        xo.a(parcel, 4, groundOverlayOptions.d());
        xo.a(parcel, 5, groundOverlayOptions.e());
        xo.a(parcel, 6, groundOverlayOptions.f(), i, false);
        xo.a(parcel, 7, groundOverlayOptions.g());
        xo.a(parcel, 8, groundOverlayOptions.h());
        xo.a(parcel, 9, groundOverlayOptions.l());
        xo.a(parcel, 10, groundOverlayOptions.i());
        xo.a(parcel, 11, groundOverlayOptions.j());
        xo.a(parcel, 12, groundOverlayOptions.k());
        xo.a(parcel, 13, groundOverlayOptions.m());
        xo.zzI(parcel, zzav);
    }

    public GroundOverlayOptions a(Parcel parcel) {
        int zzau = zza.zzau(parcel);
        int i = 0;
        IBinder iBinder = null;
        LatLng latLng = null;
        float f = 0.0f;
        float f2 = 0.0f;
        LatLngBounds latLngBounds = null;
        float f3 = 0.0f;
        float f4 = 0.0f;
        boolean z = false;
        float f5 = 0.0f;
        float f6 = 0.0f;
        float f7 = 0.0f;
        boolean z2 = false;
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
                    latLng = (LatLng) zza.a(parcel, zzat, LatLng.CREATOR);
                    break;
                case um$h.com_facebook_like_view_com_facebook_auxiliary_view_position /*4*/:
                    f = zza.j(parcel, zzat);
                    break;
                case um$h.com_facebook_like_view_com_facebook_horizontal_alignment /*5*/:
                    f2 = zza.j(parcel, zzat);
                    break;
                case um$h.CardView_cardUseCompatPadding /*6*/:
                    latLngBounds = (LatLngBounds) zza.a(parcel, zzat, LatLngBounds.CREATOR);
                    break;
                case um$h.CardView_cardPreventCornerOverlap /*7*/:
                    f3 = zza.j(parcel, zzat);
                    break;
                case um$h.CardView_contentPadding /*8*/:
                    f4 = zza.j(parcel, zzat);
                    break;
                case um$h.CardView_contentPaddingLeft /*9*/:
                    z = zza.c(parcel, zzat);
                    break;
                case um$h.CardView_contentPaddingRight /*10*/:
                    f5 = zza.j(parcel, zzat);
                    break;
                case um$h.CardView_contentPaddingTop /*11*/:
                    f6 = zza.j(parcel, zzat);
                    break;
                case um$h.CardView_contentPaddingBottom /*12*/:
                    f7 = zza.j(parcel, zzat);
                    break;
                case ha$a.Toolbar_titleMarginStart /*13*/:
                    z2 = zza.c(parcel, zzat);
                    break;
                default:
                    zza.b(parcel, zzat);
                    break;
            }
        }
        if (parcel.dataPosition() == zzau) {
            return new GroundOverlayOptions(i, iBinder, latLng, f, f2, latLngBounds, f3, f4, z, f5, f6, f7, z2);
        }
        throw new zza.zza("Overread allowed size end=" + zzau, parcel);
    }

    public GroundOverlayOptions[] a(int i) {
        return new GroundOverlayOptions[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return a(i);
    }
}
