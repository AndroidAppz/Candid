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
 *  com.google.android.gms.maps.model.PointOfInterest
 *  java.lang.Object
 *  java.lang.String
 */
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.PointOfInterest;

public class afi
implements Parcelable.Creator<PointOfInterest> {
    public static void a(PointOfInterest pointOfInterest, Parcel parcel, int n2) {
        int n3 = xo.zzav((Parcel)parcel);
        xo.a(parcel, 1, pointOfInterest.a());
        xo.a(parcel, 2, (Parcelable)pointOfInterest.a, n2, false);
        xo.a(parcel, 3, pointOfInterest.b, false);
        xo.a(parcel, 4, pointOfInterest.c, false);
        xo.zzI((Parcel)parcel, (int)n3);
    }

    /*
     * Enabled aggressive block sorting
     */
    public PointOfInterest a(Parcel parcel) {
        String string2 = null;
        int n2 = zza.zzau((Parcel)parcel);
        int n3 = 0;
        String string3 = null;
        LatLng latLng = null;
        while (parcel.dataPosition() < n2) {
            LatLng latLng2;
            int n4;
            String string4;
            String string5;
            int n5 = zza.zzat((Parcel)parcel);
            switch (zza.zzca((int)n5)) {
                default: {
                    zza.b((Parcel)parcel, (int)n5);
                    string4 = string2;
                    string5 = string3;
                    latLng2 = latLng;
                    n4 = n3;
                    break;
                }
                case 1: {
                    int n6 = zza.f((Parcel)parcel, (int)n5);
                    String string6 = string2;
                    string5 = string3;
                    latLng2 = latLng;
                    n4 = n6;
                    string4 = string6;
                    break;
                }
                case 2: {
                    LatLng latLng3 = (LatLng)zza.a((Parcel)parcel, (int)n5, (Parcelable.Creator)LatLng.CREATOR);
                    n4 = n3;
                    String string7 = string3;
                    latLng2 = latLng3;
                    string4 = string2;
                    string5 = string7;
                    break;
                }
                case 3: {
                    String string8 = zza.zzp((Parcel)parcel, (int)n5);
                    latLng2 = latLng;
                    n4 = n3;
                    String string9 = string2;
                    string5 = string8;
                    string4 = string9;
                    break;
                }
                case 4: {
                    string4 = zza.zzp((Parcel)parcel, (int)n5);
                    string5 = string3;
                    latLng2 = latLng;
                    n4 = n3;
                }
            }
            n3 = n4;
            latLng = latLng2;
            string3 = string5;
            string2 = string4;
        }
        if (parcel.dataPosition() != n2) {
            throw new zza.zza("Overread allowed size end=" + n2, parcel);
        }
        return new PointOfInterest(n3, latLng, string3, string2);
    }

    public PointOfInterest[] a(int n2) {
        return new PointOfInterest[n2];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return this.a(parcel);
    }

    public /* synthetic */ Object[] newArray(int n2) {
        return this.a(n2);
    }
}

