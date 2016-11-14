package defpackage;

import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.location.places.internal.PlaceImpl;
import com.google.android.gms.location.places.internal.PlaceLocalization;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import java.util.List;
import okhttp3.internal.http.HttpEngine;

public class acn implements Creator<PlaceImpl> {
    public static void a(PlaceImpl placeImpl, Parcel parcel, int i) {
        int zzav = xo.zzav(parcel);
        xo.a(parcel, 1, placeImpl.b(), false);
        xo.a(parcel, 2, placeImpl.r(), false);
        xo.a(parcel, 3, placeImpl.t(), i, false);
        xo.a(parcel, 4, placeImpl.g(), i, false);
        xo.a(parcel, 5, placeImpl.h());
        xo.a(parcel, 6, placeImpl.i(), i, false);
        xo.a(parcel, 7, placeImpl.s(), false);
        xo.a(parcel, 8, placeImpl.j(), i, false);
        xo.a(parcel, 9, placeImpl.n());
        xo.a(parcel, 10, placeImpl.o());
        xo.a(parcel, 11, placeImpl.p());
        xo.a(parcel, 12, placeImpl.q());
        xo.a(parcel, 13, placeImpl.d(), false);
        xo.a(parcel, 14, placeImpl.f(), false);
        xo.a(parcel, 15, placeImpl.k(), false);
        xo.b(parcel, 17, placeImpl.m(), false);
        xo.a(parcel, 16, placeImpl.l(), false);
        xo.a(parcel, 1000, placeImpl.a);
        xo.a(parcel, 19, placeImpl.e(), false);
        xo.a(parcel, 20, placeImpl.c(), false);
        xo.zzI(parcel, zzav);
    }

    public PlaceImpl a(Parcel parcel) {
        int zzau = zza.zzau(parcel);
        int i = 0;
        String str = null;
        List list = null;
        List list2 = null;
        Bundle bundle = null;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        String str5 = null;
        List list3 = null;
        LatLng latLng = null;
        float f = 0.0f;
        LatLngBounds latLngBounds = null;
        String str6 = null;
        Uri uri = null;
        boolean z = false;
        float f2 = 0.0f;
        int i2 = 0;
        long j = 0;
        PlaceLocalization placeLocalization = null;
        while (parcel.dataPosition() < zzau) {
            int zzat = zza.zzat(parcel);
            switch (zza.zzca(zzat)) {
                case um$h.com_facebook_profile_picture_view_com_facebook_is_cropped /*1*/:
                    str = zza.zzp(parcel, zzat);
                    break;
                case um$h.com_facebook_login_view_com_facebook_logout_text /*2*/:
                    bundle = zza.zzr(parcel, zzat);
                    break;
                case um$h.com_facebook_login_view_com_facebook_tooltip_mode /*3*/:
                    placeLocalization = (PlaceLocalization) zza.a(parcel, zzat, PlaceLocalization.CREATOR);
                    break;
                case um$h.com_facebook_like_view_com_facebook_auxiliary_view_position /*4*/:
                    latLng = (LatLng) zza.a(parcel, zzat, LatLng.CREATOR);
                    break;
                case um$h.com_facebook_like_view_com_facebook_horizontal_alignment /*5*/:
                    f = zza.j(parcel, zzat);
                    break;
                case um$h.CardView_cardUseCompatPadding /*6*/:
                    latLngBounds = (LatLngBounds) zza.a(parcel, zzat, LatLngBounds.CREATOR);
                    break;
                case um$h.CardView_cardPreventCornerOverlap /*7*/:
                    str6 = zza.zzp(parcel, zzat);
                    break;
                case um$h.CardView_contentPadding /*8*/:
                    uri = (Uri) zza.a(parcel, zzat, Uri.CREATOR);
                    break;
                case um$h.CardView_contentPaddingLeft /*9*/:
                    z = zza.c(parcel, zzat);
                    break;
                case um$h.CardView_contentPaddingRight /*10*/:
                    f2 = zza.j(parcel, zzat);
                    break;
                case um$h.CardView_contentPaddingTop /*11*/:
                    i2 = zza.f(parcel, zzat);
                    break;
                case um$h.CardView_contentPaddingBottom /*12*/:
                    j = zza.h(parcel, zzat);
                    break;
                case ha$a.Toolbar_titleMarginStart /*13*/:
                    list2 = zza.zzC(parcel, zzat);
                    break;
                case ha$a.Toolbar_titleMarginEnd /*14*/:
                    str3 = zza.zzp(parcel, zzat);
                    break;
                case ha$a.Toolbar_titleMarginTop /*15*/:
                    str4 = zza.zzp(parcel, zzat);
                    break;
                case ha$a.Toolbar_titleMarginBottom /*16*/:
                    str5 = zza.zzp(parcel, zzat);
                    break;
                case ha$a.Toolbar_maxButtonHeight /*17*/:
                    list3 = zza.r(parcel, zzat);
                    break;
                case ha$a.Toolbar_collapseContentDescription /*19*/:
                    str2 = zza.zzp(parcel, zzat);
                    break;
                case HttpEngine.MAX_FOLLOW_UPS /*20*/:
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
            return new PlaceImpl(i, str, list, list2, bundle, str2, str3, str4, str5, list3, latLng, f, latLngBounds, str6, uri, z, f2, i2, j, placeLocalization);
        }
        throw new zza.zza("Overread allowed size end=" + zzau, parcel);
    }

    public PlaceImpl[] a(int i) {
        return new PlaceImpl[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return a(i);
    }
}
