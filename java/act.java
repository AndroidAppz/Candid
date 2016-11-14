/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.os.Parcel
 *  android.os.Parcelable
 *  android.os.Parcelable$Creator
 *  com.google.android.gms.common.internal.safeparcel.zza
 *  com.google.android.gms.common.internal.safeparcel.zza$zza
 *  com.google.android.gms.location.GeofencingRequest
 *  com.google.android.gms.location.internal.ParcelableGeofence
 *  java.lang.Object
 *  java.lang.String
 *  java.util.ArrayList
 *  java.util.List
 */
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.location.GeofencingRequest;
import com.google.android.gms.location.internal.ParcelableGeofence;
import java.util.ArrayList;
import java.util.List;

public class act
implements Parcelable.Creator<GeofencingRequest> {
    public static void a(GeofencingRequest geofencingRequest, Parcel parcel, int n2) {
        int n3 = xo.zzav((Parcel)parcel);
        xo.c(parcel, 1, geofencingRequest.b(), false);
        xo.a(parcel, 1000, geofencingRequest.a());
        xo.a(parcel, 2, geofencingRequest.c());
        xo.zzI((Parcel)parcel, (int)n3);
    }

    public GeofencingRequest a(Parcel parcel) {
        int n2 = 0;
        int n3 = zza.zzau((Parcel)parcel);
        ArrayList arrayList = null;
        int n4 = 0;
        block5 : while (parcel.dataPosition() < n3) {
            int n5 = zza.zzat((Parcel)parcel);
            switch (zza.zzca((int)n5)) {
                default: {
                    zza.b((Parcel)parcel, (int)n5);
                    continue block5;
                }
                case 1: {
                    arrayList = zza.c((Parcel)parcel, (int)n5, (Parcelable.Creator)ParcelableGeofence.CREATOR);
                    continue block5;
                }
                case 1000: {
                    n4 = zza.f((Parcel)parcel, (int)n5);
                    continue block5;
                }
                case 2: 
            }
            n2 = zza.f((Parcel)parcel, (int)n5);
        }
        if (parcel.dataPosition() != n3) {
            throw new zza.zza("Overread allowed size end=" + n3, parcel);
        }
        return new GeofencingRequest(n4, (List)arrayList, n2);
    }

    public GeofencingRequest[] a(int n2) {
        return new GeofencingRequest[n2];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return this.a(parcel);
    }

    public /* synthetic */ Object[] newArray(int n2) {
        return this.a(n2);
    }
}

