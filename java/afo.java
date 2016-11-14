/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.os.Parcel
 *  android.os.Parcelable
 *  android.os.Parcelable$Creator
 *  com.google.android.gms.common.internal.safeparcel.zza
 *  com.google.android.gms.common.internal.safeparcel.zza$zza
 *  com.google.android.gms.maps.model.StreetViewPanoramaOrientation
 *  java.lang.Object
 *  java.lang.String
 */
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.maps.model.StreetViewPanoramaOrientation;

public class afo
implements Parcelable.Creator<StreetViewPanoramaOrientation> {
    public static void a(StreetViewPanoramaOrientation streetViewPanoramaOrientation, Parcel parcel, int n2) {
        int n3 = xo.zzav((Parcel)parcel);
        xo.a(parcel, 1, streetViewPanoramaOrientation.a());
        xo.a(parcel, 2, streetViewPanoramaOrientation.a);
        xo.a(parcel, 3, streetViewPanoramaOrientation.b);
        xo.zzI((Parcel)parcel, (int)n3);
    }

    public StreetViewPanoramaOrientation a(Parcel parcel) {
        float f2 = 0.0f;
        int n2 = zza.zzau((Parcel)parcel);
        int n3 = 0;
        float f3 = 0.0f;
        block5 : while (parcel.dataPosition() < n2) {
            int n4 = zza.zzat((Parcel)parcel);
            switch (zza.zzca((int)n4)) {
                default: {
                    zza.b((Parcel)parcel, (int)n4);
                    continue block5;
                }
                case 1: {
                    n3 = zza.f((Parcel)parcel, (int)n4);
                    continue block5;
                }
                case 2: {
                    f3 = zza.j((Parcel)parcel, (int)n4);
                    continue block5;
                }
                case 3: 
            }
            f2 = zza.j((Parcel)parcel, (int)n4);
        }
        if (parcel.dataPosition() != n2) {
            throw new zza.zza("Overread allowed size end=" + n2, parcel);
        }
        return new StreetViewPanoramaOrientation(n3, f3, f2);
    }

    public StreetViewPanoramaOrientation[] a(int n2) {
        return new StreetViewPanoramaOrientation[n2];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return this.a(parcel);
    }

    public /* synthetic */ Object[] newArray(int n2) {
        return this.a(n2);
    }
}

