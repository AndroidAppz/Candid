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
 *  com.google.android.gms.maps.model.LatLngBounds
 *  java.lang.Object
 *  java.lang.String
 */
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;

public class aff
implements Parcelable.Creator<LatLngBounds> {
    public static void a(LatLngBounds latLngBounds, Parcel parcel, int n2) {
        int n3 = xo.zzav((Parcel)parcel);
        xo.a(parcel, 1, latLngBounds.a());
        xo.a(parcel, 2, (Parcelable)latLngBounds.a, n2, false);
        xo.a(parcel, 3, (Parcelable)latLngBounds.b, n2, false);
        xo.zzI((Parcel)parcel, (int)n3);
    }

    /*
     * Enabled aggressive block sorting
     */
    public LatLngBounds a(Parcel parcel) {
        LatLng latLng = null;
        int n2 = zza.zzau((Parcel)parcel);
        int n3 = 0;
        LatLng latLng2 = null;
        while (parcel.dataPosition() < n2) {
            LatLng latLng3;
            LatLng latLng4;
            int n4;
            int n5 = zza.zzat((Parcel)parcel);
            switch (zza.zzca((int)n5)) {
                default: {
                    zza.b((Parcel)parcel, (int)n5);
                    latLng3 = latLng;
                    latLng4 = latLng2;
                    n4 = n3;
                    break;
                }
                case 1: {
                    int n6 = zza.f((Parcel)parcel, (int)n5);
                    LatLng latLng5 = latLng;
                    latLng4 = latLng2;
                    n4 = n6;
                    latLng3 = latLng5;
                    break;
                }
                case 2: {
                    LatLng latLng6 = (LatLng)zza.a((Parcel)parcel, (int)n5, (Parcelable.Creator)LatLng.CREATOR);
                    n4 = n3;
                    latLng3 = latLng;
                    latLng4 = latLng6;
                    break;
                }
                case 3: {
                    latLng3 = (LatLng)zza.a((Parcel)parcel, (int)n5, (Parcelable.Creator)LatLng.CREATOR);
                    latLng4 = latLng2;
                    n4 = n3;
                }
            }
            n3 = n4;
            latLng2 = latLng4;
            latLng = latLng3;
        }
        if (parcel.dataPosition() != n2) {
            throw new zza.zza("Overread allowed size end=" + n2, parcel);
        }
        return new LatLngBounds(n3, latLng2, latLng);
    }

    public LatLngBounds[] a(int n2) {
        return new LatLngBounds[n2];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return this.a(parcel);
    }

    public /* synthetic */ Object[] newArray(int n2) {
        return this.a(n2);
    }
}

