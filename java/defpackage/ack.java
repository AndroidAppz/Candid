package defpackage;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.location.internal.ParcelableGeofence;

public class ack implements Creator<ParcelableGeofence> {
    public static void a(ParcelableGeofence parcelableGeofence, Parcel parcel, int i) {
        int zzav = xo.zzav(parcel);
        xo.a(parcel, 1, parcelableGeofence.a(), false);
        xo.a(parcel, 1000, parcelableGeofence.b());
        xo.a(parcel, 2, parcelableGeofence.g());
        xo.a(parcel, 3, parcelableGeofence.c());
        xo.a(parcel, 4, parcelableGeofence.d());
        xo.a(parcel, 5, parcelableGeofence.e());
        xo.a(parcel, 6, parcelableGeofence.f());
        xo.a(parcel, 7, parcelableGeofence.h());
        xo.a(parcel, 8, parcelableGeofence.i());
        xo.a(parcel, 9, parcelableGeofence.j());
        xo.zzI(parcel, zzav);
    }

    public ParcelableGeofence a(Parcel parcel) {
        int zzau = zza.zzau(parcel);
        int i = 0;
        String str = null;
        int i2 = 0;
        short s = (short) 0;
        double d = 0.0d;
        double d2 = 0.0d;
        float f = 0.0f;
        long j = 0;
        int i3 = 0;
        int i4 = -1;
        while (parcel.dataPosition() < zzau) {
            int zzat = zza.zzat(parcel);
            switch (zza.zzca(zzat)) {
                case um$h.com_facebook_profile_picture_view_com_facebook_is_cropped /*1*/:
                    str = zza.zzp(parcel, zzat);
                    break;
                case um$h.com_facebook_login_view_com_facebook_logout_text /*2*/:
                    j = zza.h(parcel, zzat);
                    break;
                case um$h.com_facebook_login_view_com_facebook_tooltip_mode /*3*/:
                    s = zza.e(parcel, zzat);
                    break;
                case um$h.com_facebook_like_view_com_facebook_auxiliary_view_position /*4*/:
                    d = zza.l(parcel, zzat);
                    break;
                case um$h.com_facebook_like_view_com_facebook_horizontal_alignment /*5*/:
                    d2 = zza.l(parcel, zzat);
                    break;
                case um$h.CardView_cardUseCompatPadding /*6*/:
                    f = zza.j(parcel, zzat);
                    break;
                case um$h.CardView_cardPreventCornerOverlap /*7*/:
                    i2 = zza.f(parcel, zzat);
                    break;
                case um$h.CardView_contentPadding /*8*/:
                    i3 = zza.f(parcel, zzat);
                    break;
                case um$h.CardView_contentPaddingLeft /*9*/:
                    i4 = zza.f(parcel, zzat);
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
            return new ParcelableGeofence(i, str, i2, s, d, d2, f, j, i3, i4);
        }
        throw new zza.zza("Overread allowed size end=" + zzau, parcel);
    }

    public ParcelableGeofence[] a(int i) {
        return new ParcelableGeofence[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return a(i);
    }
}
