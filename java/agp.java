/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 *  android.os.Parcel
 *  android.os.Parcelable
 *  android.os.Parcelable$Creator
 *  com.google.android.gms.common.internal.safeparcel.zza
 *  com.google.android.gms.common.internal.safeparcel.zza$zza
 *  com.google.android.gms.measurement.internal.EventParams
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 */
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.measurement.internal.EventParams;

public class agp
implements Parcelable.Creator<EventParams> {
    public static void a(EventParams eventParams, Parcel parcel, int n2) {
        int n3 = xo.a(parcel);
        xo.a(parcel, 1, eventParams.a);
        xo.a(parcel, 2, eventParams.b(), false);
        xo.a(parcel, n3);
    }

    public EventParams a(Parcel parcel) {
        int n2 = zza.b((Parcel)parcel);
        int n3 = 0;
        Bundle bundle = null;
        block4 : while (parcel.dataPosition() < n2) {
            int n4 = zza.a((Parcel)parcel);
            switch (zza.a((int)n4)) {
                default: {
                    zza.b((Parcel)parcel, (int)n4);
                    continue block4;
                }
                case 1: {
                    n3 = zza.f((Parcel)parcel, (int)n4);
                    continue block4;
                }
                case 2: 
            }
            bundle = zza.p((Parcel)parcel, (int)n4);
        }
        if (parcel.dataPosition() != n2) {
            throw new zza.zza(new StringBuilder(37).append("Overread allowed size end=").append(n2).toString(), parcel);
        }
        return new EventParams(n3, bundle);
    }

    public EventParams[] a(int n2) {
        return new EventParams[n2];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return this.a(parcel);
    }

    public /* synthetic */ Object[] newArray(int n2) {
        return this.a(n2);
    }
}

