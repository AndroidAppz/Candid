/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.os.Parcel
 *  android.os.Parcelable
 *  android.os.Parcelable$Creator
 *  com.google.android.gms.common.internal.safeparcel.zza
 *  com.google.android.gms.common.internal.safeparcel.zza$zza
 *  com.google.android.gms.maps.model.StreetViewPanoramaLink
 *  java.lang.Object
 *  java.lang.String
 */
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.maps.model.StreetViewPanoramaLink;

public class afm
implements Parcelable.Creator<StreetViewPanoramaLink> {
    public static void a(StreetViewPanoramaLink streetViewPanoramaLink, Parcel parcel, int n2) {
        int n3 = xo.zzav((Parcel)parcel);
        xo.a(parcel, 1, streetViewPanoramaLink.a());
        xo.a(parcel, 2, streetViewPanoramaLink.a, false);
        xo.a(parcel, 3, streetViewPanoramaLink.b);
        xo.zzI((Parcel)parcel, (int)n3);
    }

    public StreetViewPanoramaLink a(Parcel parcel) {
        int n2 = zza.zzau((Parcel)parcel);
        int n3 = 0;
        String string2 = null;
        float f2 = 0.0f;
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
                    string2 = zza.zzp((Parcel)parcel, (int)n4);
                    continue block5;
                }
                case 3: 
            }
            f2 = zza.j((Parcel)parcel, (int)n4);
        }
        if (parcel.dataPosition() != n2) {
            throw new zza.zza("Overread allowed size end=" + n2, parcel);
        }
        return new StreetViewPanoramaLink(n3, string2, f2);
    }

    public StreetViewPanoramaLink[] a(int n2) {
        return new StreetViewPanoramaLink[n2];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return this.a(parcel);
    }

    public /* synthetic */ Object[] newArray(int n2) {
        return this.a(n2);
    }
}

