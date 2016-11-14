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
 *  com.google.android.gms.maps.model.StreetViewPanoramaLink
 *  com.google.android.gms.maps.model.StreetViewPanoramaLocation
 *  java.lang.Object
 *  java.lang.String
 */
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.StreetViewPanoramaLink;
import com.google.android.gms.maps.model.StreetViewPanoramaLocation;

public class afn
implements Parcelable.Creator<StreetViewPanoramaLocation> {
    public static void a(StreetViewPanoramaLocation streetViewPanoramaLocation, Parcel parcel, int n2) {
        int n3 = xo.zzav((Parcel)parcel);
        xo.a(parcel, 1, streetViewPanoramaLocation.a());
        xo.a((Parcel)parcel, (int)2, (Parcelable[])streetViewPanoramaLocation.a, (int)n2, (boolean)false);
        xo.a(parcel, 3, (Parcelable)streetViewPanoramaLocation.b, n2, false);
        xo.a(parcel, 4, streetViewPanoramaLocation.c, false);
        xo.zzI((Parcel)parcel, (int)n3);
    }

    /*
     * Enabled aggressive block sorting
     */
    public StreetViewPanoramaLocation a(Parcel parcel) {
        String string2 = null;
        int n2 = zza.zzau((Parcel)parcel);
        int n3 = 0;
        LatLng latLng = null;
        StreetViewPanoramaLink[] arrstreetViewPanoramaLink = null;
        while (parcel.dataPosition() < n2) {
            LatLng latLng2;
            StreetViewPanoramaLink[] arrstreetViewPanoramaLink2;
            int n4;
            String string3;
            int n5 = zza.zzat((Parcel)parcel);
            switch (zza.zzca((int)n5)) {
                default: {
                    zza.b((Parcel)parcel, (int)n5);
                    string3 = string2;
                    latLng2 = latLng;
                    arrstreetViewPanoramaLink2 = arrstreetViewPanoramaLink;
                    n4 = n3;
                    break;
                }
                case 1: {
                    int n6 = zza.f((Parcel)parcel, (int)n5);
                    String string4 = string2;
                    latLng2 = latLng;
                    arrstreetViewPanoramaLink2 = arrstreetViewPanoramaLink;
                    n4 = n6;
                    string3 = string4;
                    break;
                }
                case 2: {
                    StreetViewPanoramaLink[] arrstreetViewPanoramaLink3 = (StreetViewPanoramaLink[])zza.b((Parcel)parcel, (int)n5, (Parcelable.Creator)StreetViewPanoramaLink.CREATOR);
                    n4 = n3;
                    LatLng latLng3 = latLng;
                    arrstreetViewPanoramaLink2 = arrstreetViewPanoramaLink3;
                    string3 = string2;
                    latLng2 = latLng3;
                    break;
                }
                case 3: {
                    LatLng latLng4 = (LatLng)zza.a((Parcel)parcel, (int)n5, (Parcelable.Creator)LatLng.CREATOR);
                    arrstreetViewPanoramaLink2 = arrstreetViewPanoramaLink;
                    n4 = n3;
                    String string5 = string2;
                    latLng2 = latLng4;
                    string3 = string5;
                    break;
                }
                case 4: {
                    string3 = zza.zzp((Parcel)parcel, (int)n5);
                    latLng2 = latLng;
                    arrstreetViewPanoramaLink2 = arrstreetViewPanoramaLink;
                    n4 = n3;
                }
            }
            n3 = n4;
            arrstreetViewPanoramaLink = arrstreetViewPanoramaLink2;
            latLng = latLng2;
            string2 = string3;
        }
        if (parcel.dataPosition() != n2) {
            throw new zza.zza("Overread allowed size end=" + n2, parcel);
        }
        return new StreetViewPanoramaLocation(n3, arrstreetViewPanoramaLink, latLng, string2);
    }

    public StreetViewPanoramaLocation[] a(int n2) {
        return new StreetViewPanoramaLocation[n2];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return this.a(parcel);
    }

    public /* synthetic */ Object[] newArray(int n2) {
        return this.a(n2);
    }
}

