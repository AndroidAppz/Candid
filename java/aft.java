/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.os.Parcel
 *  android.os.Parcelable
 *  android.os.Parcelable$Creator
 *  com.google.android.gms.common.internal.safeparcel.zza
 *  com.google.android.gms.common.internal.safeparcel.zza$zza
 *  com.google.android.gms.maps.StreetViewPanoramaOptions
 *  com.google.android.gms.maps.model.LatLng
 *  com.google.android.gms.maps.model.StreetViewPanoramaCamera
 *  java.lang.Integer
 *  java.lang.Object
 *  java.lang.String
 */
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.maps.StreetViewPanoramaOptions;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.StreetViewPanoramaCamera;

public class aft
implements Parcelable.Creator<StreetViewPanoramaOptions> {
    public static void a(StreetViewPanoramaOptions streetViewPanoramaOptions, Parcel parcel, int n2) {
        int n3 = xo.zzav((Parcel)parcel);
        xo.a(parcel, 1, streetViewPanoramaOptions.a());
        xo.a(parcel, 2, (Parcelable)streetViewPanoramaOptions.g(), n2, false);
        xo.a(parcel, 3, streetViewPanoramaOptions.j(), false);
        xo.a(parcel, 4, (Parcelable)streetViewPanoramaOptions.h(), n2, false);
        xo.a(parcel, 5, streetViewPanoramaOptions.i(), false);
        xo.a(parcel, 6, streetViewPanoramaOptions.b());
        xo.a(parcel, 7, streetViewPanoramaOptions.c());
        xo.a(parcel, 8, streetViewPanoramaOptions.d());
        xo.a(parcel, 9, streetViewPanoramaOptions.e());
        xo.a(parcel, 10, streetViewPanoramaOptions.f());
        xo.zzI((Parcel)parcel, (int)n3);
    }

    public StreetViewPanoramaOptions a(Parcel parcel) {
        Integer n2 = null;
        byte by2 = 0;
        int n3 = zza.zzau((Parcel)parcel);
        byte by3 = 0;
        byte by4 = 0;
        byte by5 = 0;
        byte by6 = 0;
        LatLng latLng = null;
        String string2 = null;
        StreetViewPanoramaCamera streetViewPanoramaCamera = null;
        int n4 = 0;
        block12 : while (parcel.dataPosition() < n3) {
            int n5 = zza.zzat((Parcel)parcel);
            switch (zza.zzca((int)n5)) {
                default: {
                    zza.b((Parcel)parcel, (int)n5);
                    continue block12;
                }
                case 1: {
                    n4 = zza.f((Parcel)parcel, (int)n5);
                    continue block12;
                }
                case 2: {
                    streetViewPanoramaCamera = (StreetViewPanoramaCamera)zza.a((Parcel)parcel, (int)n5, (Parcelable.Creator)StreetViewPanoramaCamera.CREATOR);
                    continue block12;
                }
                case 3: {
                    string2 = zza.zzp((Parcel)parcel, (int)n5);
                    continue block12;
                }
                case 4: {
                    latLng = (LatLng)zza.a((Parcel)parcel, (int)n5, (Parcelable.Creator)LatLng.CREATOR);
                    continue block12;
                }
                case 5: {
                    n2 = zza.g((Parcel)parcel, (int)n5);
                    continue block12;
                }
                case 6: {
                    by6 = zza.d((Parcel)parcel, (int)n5);
                    continue block12;
                }
                case 7: {
                    by5 = zza.d((Parcel)parcel, (int)n5);
                    continue block12;
                }
                case 8: {
                    by4 = zza.d((Parcel)parcel, (int)n5);
                    continue block12;
                }
                case 9: {
                    by3 = zza.d((Parcel)parcel, (int)n5);
                    continue block12;
                }
                case 10: 
            }
            by2 = zza.d((Parcel)parcel, (int)n5);
        }
        if (parcel.dataPosition() != n3) {
            throw new zza.zza("Overread allowed size end=" + n3, parcel);
        }
        return new StreetViewPanoramaOptions(n4, streetViewPanoramaCamera, string2, latLng, n2, by6, by5, by4, by3, by2);
    }

    public StreetViewPanoramaOptions[] a(int n2) {
        return new StreetViewPanoramaOptions[n2];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return this.a(parcel);
    }

    public /* synthetic */ Object[] newArray(int n2) {
        return this.a(n2);
    }
}

