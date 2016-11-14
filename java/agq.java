/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.os.Parcel
 *  android.os.Parcelable
 *  android.os.Parcelable$Creator
 *  com.google.android.gms.common.internal.safeparcel.zza
 *  com.google.android.gms.common.internal.safeparcel.zza$zza
 *  com.google.android.gms.measurement.internal.EventParams
 *  com.google.android.gms.measurement.internal.EventParcel
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 */
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.measurement.internal.EventParams;
import com.google.android.gms.measurement.internal.EventParcel;

public class agq
implements Parcelable.Creator<EventParcel> {
    public static void a(EventParcel eventParcel, Parcel parcel, int n2) {
        int n3 = xo.a(parcel);
        xo.a(parcel, 1, eventParcel.a);
        xo.a(parcel, 2, eventParcel.b, false);
        xo.a(parcel, 3, (Parcelable)eventParcel.c, n2, false);
        xo.a(parcel, 4, eventParcel.d, false);
        xo.a(parcel, 5, eventParcel.e);
        xo.a(parcel, n3);
    }

    public EventParcel a(Parcel parcel) {
        String string2 = null;
        int n2 = zza.b((Parcel)parcel);
        int n3 = 0;
        long l2 = 0;
        EventParams eventParams = null;
        String string3 = null;
        block7 : while (parcel.dataPosition() < n2) {
            int n4 = zza.a((Parcel)parcel);
            switch (zza.a((int)n4)) {
                default: {
                    zza.b((Parcel)parcel, (int)n4);
                    continue block7;
                }
                case 1: {
                    n3 = zza.f((Parcel)parcel, (int)n4);
                    continue block7;
                }
                case 2: {
                    string3 = zza.n((Parcel)parcel, (int)n4);
                    continue block7;
                }
                case 3: {
                    eventParams = (EventParams)zza.a((Parcel)parcel, (int)n4, (Parcelable.Creator)EventParams.CREATOR);
                    continue block7;
                }
                case 4: {
                    string2 = zza.n((Parcel)parcel, (int)n4);
                    continue block7;
                }
                case 5: 
            }
            l2 = zza.h((Parcel)parcel, (int)n4);
        }
        if (parcel.dataPosition() != n2) {
            throw new zza.zza(new StringBuilder(37).append("Overread allowed size end=").append(n2).toString(), parcel);
        }
        return new EventParcel(n3, string3, eventParams, string2, l2);
    }

    public EventParcel[] a(int n2) {
        return new EventParcel[n2];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return this.a(parcel);
    }

    public /* synthetic */ Object[] newArray(int n2) {
        return this.a(n2);
    }
}

