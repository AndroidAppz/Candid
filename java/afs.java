/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.os.Parcel
 *  android.os.Parcelable
 *  android.os.Parcelable$Creator
 *  com.google.android.gms.common.internal.safeparcel.zza
 *  com.google.android.gms.common.internal.safeparcel.zza$zza
 *  com.google.android.gms.maps.GoogleMapOptions
 *  com.google.android.gms.maps.model.CameraPosition
 *  java.lang.Object
 *  java.lang.String
 */
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.maps.GoogleMapOptions;
import com.google.android.gms.maps.model.CameraPosition;

public class afs
implements Parcelable.Creator<GoogleMapOptions> {
    public static void a(GoogleMapOptions googleMapOptions, Parcel parcel, int n2) {
        int n3 = xo.zzav((Parcel)parcel);
        xo.a(parcel, 1, googleMapOptions.a());
        xo.a(parcel, 2, googleMapOptions.b());
        xo.a(parcel, 3, googleMapOptions.c());
        xo.a(parcel, 4, googleMapOptions.m());
        xo.a(parcel, 5, (Parcelable)googleMapOptions.n(), n2, false);
        xo.a(parcel, 6, googleMapOptions.d());
        xo.a(parcel, 7, googleMapOptions.e());
        xo.a(parcel, 8, googleMapOptions.f());
        xo.a(parcel, 9, googleMapOptions.g());
        xo.a(parcel, 10, googleMapOptions.h());
        xo.a(parcel, 11, googleMapOptions.i());
        xo.a(parcel, 12, googleMapOptions.j());
        xo.a(parcel, 14, googleMapOptions.k());
        xo.a(parcel, 15, googleMapOptions.l());
        xo.zzI((Parcel)parcel, (int)n3);
    }

    public GoogleMapOptions a(Parcel parcel) {
        int n2 = zza.zzau((Parcel)parcel);
        int n3 = 0;
        byte by2 = -1;
        byte by3 = -1;
        int n4 = 0;
        CameraPosition cameraPosition = null;
        byte by4 = -1;
        byte by5 = -1;
        byte by6 = -1;
        byte by7 = -1;
        byte by8 = -1;
        byte by9 = -1;
        byte by10 = -1;
        byte by11 = -1;
        byte by12 = -1;
        block16 : while (parcel.dataPosition() < n2) {
            int n5 = zza.zzat((Parcel)parcel);
            switch (zza.zzca((int)n5)) {
                default: {
                    zza.b((Parcel)parcel, (int)n5);
                    continue block16;
                }
                case 1: {
                    n3 = zza.f((Parcel)parcel, (int)n5);
                    continue block16;
                }
                case 2: {
                    by2 = zza.d((Parcel)parcel, (int)n5);
                    continue block16;
                }
                case 3: {
                    by3 = zza.d((Parcel)parcel, (int)n5);
                    continue block16;
                }
                case 4: {
                    n4 = zza.f((Parcel)parcel, (int)n5);
                    continue block16;
                }
                case 5: {
                    cameraPosition = (CameraPosition)zza.a((Parcel)parcel, (int)n5, (Parcelable.Creator)CameraPosition.CREATOR);
                    continue block16;
                }
                case 6: {
                    by4 = zza.d((Parcel)parcel, (int)n5);
                    continue block16;
                }
                case 7: {
                    by5 = zza.d((Parcel)parcel, (int)n5);
                    continue block16;
                }
                case 8: {
                    by6 = zza.d((Parcel)parcel, (int)n5);
                    continue block16;
                }
                case 9: {
                    by7 = zza.d((Parcel)parcel, (int)n5);
                    continue block16;
                }
                case 10: {
                    by8 = zza.d((Parcel)parcel, (int)n5);
                    continue block16;
                }
                case 11: {
                    by9 = zza.d((Parcel)parcel, (int)n5);
                    continue block16;
                }
                case 12: {
                    by10 = zza.d((Parcel)parcel, (int)n5);
                    continue block16;
                }
                case 14: {
                    by11 = zza.d((Parcel)parcel, (int)n5);
                    continue block16;
                }
                case 15: 
            }
            by12 = zza.d((Parcel)parcel, (int)n5);
        }
        if (parcel.dataPosition() != n2) {
            throw new zza.zza("Overread allowed size end=" + n2, parcel);
        }
        return new GoogleMapOptions(n3, by2, by3, n4, cameraPosition, by4, by5, by6, by7, by8, by9, by10, by11, by12);
    }

    public GoogleMapOptions[] a(int n2) {
        return new GoogleMapOptions[n2];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return this.a(parcel);
    }

    public /* synthetic */ Object[] newArray(int n2) {
        return this.a(n2);
    }
}

