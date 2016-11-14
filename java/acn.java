/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.net.Uri
 *  android.os.Bundle
 *  android.os.Parcel
 *  android.os.Parcelable
 *  android.os.Parcelable$Creator
 *  com.google.android.gms.common.internal.safeparcel.zza
 *  com.google.android.gms.common.internal.safeparcel.zza$zza
 *  com.google.android.gms.location.places.internal.PlaceImpl
 *  com.google.android.gms.location.places.internal.PlaceLocalization
 *  com.google.android.gms.maps.model.LatLng
 *  com.google.android.gms.maps.model.LatLngBounds
 *  java.lang.Object
 *  java.lang.String
 *  java.util.ArrayList
 *  java.util.List
 */
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.location.places.internal.PlaceImpl;
import com.google.android.gms.location.places.internal.PlaceLocalization;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import java.util.ArrayList;
import java.util.List;

public class acn
implements Parcelable.Creator<PlaceImpl> {
    public static void a(PlaceImpl placeImpl, Parcel parcel, int n2) {
        int n3 = xo.zzav((Parcel)parcel);
        xo.a(parcel, 1, placeImpl.b(), false);
        xo.a(parcel, 2, placeImpl.r(), false);
        xo.a(parcel, 3, (Parcelable)placeImpl.t(), n2, false);
        xo.a(parcel, 4, (Parcelable)placeImpl.g(), n2, false);
        xo.a(parcel, 5, placeImpl.h());
        xo.a(parcel, 6, (Parcelable)placeImpl.i(), n2, false);
        xo.a(parcel, 7, placeImpl.s(), false);
        xo.a(parcel, 8, (Parcelable)placeImpl.j(), n2, false);
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
        xo.zzI((Parcel)parcel, (int)n3);
    }

    public PlaceImpl a(Parcel parcel) {
        int n2 = zza.zzau((Parcel)parcel);
        int n3 = 0;
        String string2 = null;
        ArrayList arrayList = null;
        ArrayList arrayList2 = null;
        Bundle bundle = null;
        String string3 = null;
        String string4 = null;
        String string5 = null;
        String string6 = null;
        ArrayList arrayList3 = null;
        LatLng latLng = null;
        float f2 = 0.0f;
        LatLngBounds latLngBounds = null;
        String string7 = null;
        Uri uri = null;
        boolean bl2 = false;
        float f3 = 0.0f;
        int n4 = 0;
        long l2 = 0;
        PlaceLocalization placeLocalization = null;
        block22 : while (parcel.dataPosition() < n2) {
            int n5 = zza.zzat((Parcel)parcel);
            switch (zza.zzca((int)n5)) {
                default: {
                    zza.b((Parcel)parcel, (int)n5);
                    continue block22;
                }
                case 1: {
                    string2 = zza.zzp((Parcel)parcel, (int)n5);
                    continue block22;
                }
                case 2: {
                    bundle = zza.zzr((Parcel)parcel, (int)n5);
                    continue block22;
                }
                case 3: {
                    placeLocalization = (PlaceLocalization)zza.a((Parcel)parcel, (int)n5, (Parcelable.Creator)PlaceLocalization.CREATOR);
                    continue block22;
                }
                case 4: {
                    latLng = (LatLng)zza.a((Parcel)parcel, (int)n5, (Parcelable.Creator)LatLng.CREATOR);
                    continue block22;
                }
                case 5: {
                    f2 = zza.j((Parcel)parcel, (int)n5);
                    continue block22;
                }
                case 6: {
                    latLngBounds = (LatLngBounds)zza.a((Parcel)parcel, (int)n5, (Parcelable.Creator)LatLngBounds.CREATOR);
                    continue block22;
                }
                case 7: {
                    string7 = zza.zzp((Parcel)parcel, (int)n5);
                    continue block22;
                }
                case 8: {
                    uri = (Uri)zza.a((Parcel)parcel, (int)n5, (Parcelable.Creator)Uri.CREATOR);
                    continue block22;
                }
                case 9: {
                    bl2 = zza.c((Parcel)parcel, (int)n5);
                    continue block22;
                }
                case 10: {
                    f3 = zza.j((Parcel)parcel, (int)n5);
                    continue block22;
                }
                case 11: {
                    n4 = zza.f((Parcel)parcel, (int)n5);
                    continue block22;
                }
                case 12: {
                    l2 = zza.h((Parcel)parcel, (int)n5);
                    continue block22;
                }
                case 13: {
                    arrayList2 = zza.zzC((Parcel)parcel, (int)n5);
                    continue block22;
                }
                case 14: {
                    string4 = zza.zzp((Parcel)parcel, (int)n5);
                    continue block22;
                }
                case 15: {
                    string5 = zza.zzp((Parcel)parcel, (int)n5);
                    continue block22;
                }
                case 17: {
                    arrayList3 = zza.r((Parcel)parcel, (int)n5);
                    continue block22;
                }
                case 16: {
                    string6 = zza.zzp((Parcel)parcel, (int)n5);
                    continue block22;
                }
                case 1000: {
                    n3 = zza.f((Parcel)parcel, (int)n5);
                    continue block22;
                }
                case 19: {
                    string3 = zza.zzp((Parcel)parcel, (int)n5);
                    continue block22;
                }
                case 20: 
            }
            arrayList = zza.zzC((Parcel)parcel, (int)n5);
        }
        if (parcel.dataPosition() != n2) {
            throw new zza.zza("Overread allowed size end=" + n2, parcel);
        }
        return new PlaceImpl(n3, string2, (List)arrayList, (List)arrayList2, bundle, string3, string4, string5, string6, (List)arrayList3, latLng, f2, latLngBounds, string7, uri, bl2, f3, n4, l2, placeLocalization);
    }

    public PlaceImpl[] a(int n2) {
        return new PlaceImpl[n2];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return this.a(parcel);
    }

    public /* synthetic */ Object[] newArray(int n2) {
        return this.a(n2);
    }
}

