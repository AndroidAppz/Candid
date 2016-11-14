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
 *  com.google.android.gms.maps.model.VisibleRegion
 *  java.lang.Object
 *  java.lang.String
 */
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.VisibleRegion;

public class afr
implements Parcelable.Creator<VisibleRegion> {
    public static void a(VisibleRegion visibleRegion, Parcel parcel, int n2) {
        int n3 = xo.zzav((Parcel)parcel);
        xo.a(parcel, 1, visibleRegion.a());
        xo.a(parcel, 2, (Parcelable)visibleRegion.a, n2, false);
        xo.a(parcel, 3, (Parcelable)visibleRegion.b, n2, false);
        xo.a(parcel, 4, (Parcelable)visibleRegion.c, n2, false);
        xo.a(parcel, 5, (Parcelable)visibleRegion.d, n2, false);
        xo.a(parcel, 6, (Parcelable)visibleRegion.e, n2, false);
        xo.zzI((Parcel)parcel, (int)n3);
    }

    public VisibleRegion a(Parcel parcel) {
        LatLngBounds latLngBounds = null;
        int n2 = zza.zzau((Parcel)parcel);
        int n3 = 0;
        LatLng latLng = null;
        LatLng latLng2 = null;
        LatLng latLng3 = null;
        LatLng latLng4 = null;
        block8 : while (parcel.dataPosition() < n2) {
            int n4 = zza.zzat((Parcel)parcel);
            switch (zza.zzca((int)n4)) {
                default: {
                    zza.b((Parcel)parcel, (int)n4);
                    continue block8;
                }
                case 1: {
                    n3 = zza.f((Parcel)parcel, (int)n4);
                    continue block8;
                }
                case 2: {
                    latLng4 = (LatLng)zza.a((Parcel)parcel, (int)n4, (Parcelable.Creator)LatLng.CREATOR);
                    continue block8;
                }
                case 3: {
                    latLng3 = (LatLng)zza.a((Parcel)parcel, (int)n4, (Parcelable.Creator)LatLng.CREATOR);
                    continue block8;
                }
                case 4: {
                    latLng2 = (LatLng)zza.a((Parcel)parcel, (int)n4, (Parcelable.Creator)LatLng.CREATOR);
                    continue block8;
                }
                case 5: {
                    latLng = (LatLng)zza.a((Parcel)parcel, (int)n4, (Parcelable.Creator)LatLng.CREATOR);
                    continue block8;
                }
                case 6: 
            }
            latLngBounds = (LatLngBounds)zza.a((Parcel)parcel, (int)n4, (Parcelable.Creator)LatLngBounds.CREATOR);
        }
        if (parcel.dataPosition() != n2) {
            throw new zza.zza("Overread allowed size end=" + n2, parcel);
        }
        return new VisibleRegion(n3, latLng4, latLng3, latLng2, latLng, latLngBounds);
    }

    public VisibleRegion[] a(int n2) {
        return new VisibleRegion[n2];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return this.a(parcel);
    }

    public /* synthetic */ Object[] newArray(int n2) {
        return this.a(n2);
    }
}

