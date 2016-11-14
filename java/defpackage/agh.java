package defpackage;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.measurement.internal.AppMetadata;

public class agh implements Creator<AppMetadata> {
    public static void a(AppMetadata appMetadata, Parcel parcel, int i) {
        int a = xo.a(parcel);
        xo.a(parcel, 1, appMetadata.a);
        xo.a(parcel, 2, appMetadata.b, false);
        xo.a(parcel, 3, appMetadata.c, false);
        xo.a(parcel, 4, appMetadata.d, false);
        xo.a(parcel, 5, appMetadata.e, false);
        xo.a(parcel, 6, appMetadata.f);
        xo.a(parcel, 7, appMetadata.g);
        xo.a(parcel, 8, appMetadata.h, false);
        xo.a(parcel, 9, appMetadata.i);
        xo.a(parcel, 10, appMetadata.j);
        xo.a(parcel, 11, appMetadata.k);
        xo.a(parcel, 12, appMetadata.l, false);
        xo.a(parcel, a);
    }

    public AppMetadata a(Parcel parcel) {
        int b = zza.b(parcel);
        int i = 0;
        String str = null;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        long j = 0;
        long j2 = 0;
        String str5 = null;
        boolean z = false;
        boolean z2 = false;
        long j3 = 0;
        String str6 = null;
        while (parcel.dataPosition() < b) {
            int a = zza.a(parcel);
            switch (zza.a(a)) {
                case um$h.com_facebook_profile_picture_view_com_facebook_is_cropped /*1*/:
                    i = zza.f(parcel, a);
                    break;
                case um$h.com_facebook_login_view_com_facebook_logout_text /*2*/:
                    str = zza.n(parcel, a);
                    break;
                case um$h.com_facebook_login_view_com_facebook_tooltip_mode /*3*/:
                    str2 = zza.n(parcel, a);
                    break;
                case um$h.com_facebook_like_view_com_facebook_auxiliary_view_position /*4*/:
                    str3 = zza.n(parcel, a);
                    break;
                case um$h.com_facebook_like_view_com_facebook_horizontal_alignment /*5*/:
                    str4 = zza.n(parcel, a);
                    break;
                case um$h.CardView_cardUseCompatPadding /*6*/:
                    j = zza.h(parcel, a);
                    break;
                case um$h.CardView_cardPreventCornerOverlap /*7*/:
                    j2 = zza.h(parcel, a);
                    break;
                case um$h.CardView_contentPadding /*8*/:
                    str5 = zza.n(parcel, a);
                    break;
                case um$h.CardView_contentPaddingLeft /*9*/:
                    z = zza.c(parcel, a);
                    break;
                case um$h.CardView_contentPaddingRight /*10*/:
                    z2 = zza.c(parcel, a);
                    break;
                case um$h.CardView_contentPaddingTop /*11*/:
                    j3 = zza.h(parcel, a);
                    break;
                case um$h.CardView_contentPaddingBottom /*12*/:
                    str6 = zza.n(parcel, a);
                    break;
                default:
                    zza.b(parcel, a);
                    break;
            }
        }
        if (parcel.dataPosition() == b) {
            return new AppMetadata(i, str, str2, str3, str4, j, j2, str5, z, z2, j3, str6);
        }
        throw new zza.zza("Overread allowed size end=" + b, parcel);
    }

    public AppMetadata[] a(int i) {
        return new AppMetadata[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return a(i);
    }
}
