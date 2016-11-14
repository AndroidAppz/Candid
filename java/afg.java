/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.os.Parcel
 *  android.os.Parcelable
 *  android.os.Parcelable$Creator
 *  com.google.android.gms.common.internal.safeparcel.zza
 *  com.google.android.gms.common.internal.safeparcel.zza$zza
 *  com.google.android.gms.maps.model.LatLng
 *  java.lang.Object
 *  java.lang.String
 */
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.maps.model.LatLng;

public class afg
implements Parcelable.Creator<LatLng> {
    public static void a(LatLng latLng, Parcel parcel, int n2) {
        int n3 = xo.zzav((Parcel)parcel);
        xo.a(parcel, 1, latLng.a());
        xo.a(parcel, 2, latLng.a);
        xo.a(parcel, 3, latLng.b);
        xo.zzI((Parcel)parcel, (int)n3);
    }

    public LatLng a(Parcel parcel) {
        double d2 = 0.0;
        int n2 = zza.zzau((Parcel)parcel);
        int n3 = 0;
        double d3 = d2;
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
                    d3 = zza.l((Parcel)parcel, (int)n4);
                    continue block5;
                }
                case 3: 
            }
            d2 = zza.l((Parcel)parcel, (int)n4);
        }
        if (parcel.dataPosition() != n2) {
            throw new zza.zza("Overread allowed size end=" + n2, parcel);
        }
        return new LatLng(n3, d3, d2);
    }

    public LatLng[] a(int n2) {
        return new LatLng[n2];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return this.a(parcel);
    }

    public /* synthetic */ Object[] newArray(int n2) {
        return this.a(n2);
    }
}

