/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.os.Parcel
 *  android.os.Parcelable
 *  android.os.Parcelable$Creator
 *  com.google.android.gms.common.internal.safeparcel.zza
 *  com.google.android.gms.common.internal.safeparcel.zza$zza
 *  com.google.android.gms.measurement.internal.UserAttributeParcel
 *  java.lang.Double
 *  java.lang.Float
 *  java.lang.Long
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 */
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.measurement.internal.UserAttributeParcel;

public class age
implements Parcelable.Creator<UserAttributeParcel> {
    public static void a(UserAttributeParcel userAttributeParcel, Parcel parcel, int n2) {
        int n3 = xo.a(parcel);
        xo.a(parcel, 1, userAttributeParcel.a);
        xo.a(parcel, 2, userAttributeParcel.b, false);
        xo.a(parcel, 3, userAttributeParcel.c);
        xo.a(parcel, 4, userAttributeParcel.d, false);
        xo.a(parcel, 5, userAttributeParcel.e, false);
        xo.a(parcel, 6, userAttributeParcel.f, false);
        xo.a(parcel, 7, userAttributeParcel.g, false);
        xo.a(parcel, 8, userAttributeParcel.h, false);
        xo.a(parcel, n3);
    }

    public UserAttributeParcel a(Parcel parcel) {
        Double d2 = null;
        int n2 = zza.b((Parcel)parcel);
        int n3 = 0;
        long l2 = 0;
        String string2 = null;
        String string3 = null;
        Float f2 = null;
        Long l3 = null;
        String string4 = null;
        block10 : while (parcel.dataPosition() < n2) {
            int n4 = zza.a((Parcel)parcel);
            switch (zza.a((int)n4)) {
                default: {
                    zza.b((Parcel)parcel, (int)n4);
                    continue block10;
                }
                case 1: {
                    n3 = zza.f((Parcel)parcel, (int)n4);
                    continue block10;
                }
                case 2: {
                    string4 = zza.n((Parcel)parcel, (int)n4);
                    continue block10;
                }
                case 3: {
                    l2 = zza.h((Parcel)parcel, (int)n4);
                    continue block10;
                }
                case 4: {
                    l3 = zza.i((Parcel)parcel, (int)n4);
                    continue block10;
                }
                case 5: {
                    f2 = zza.k((Parcel)parcel, (int)n4);
                    continue block10;
                }
                case 6: {
                    string3 = zza.n((Parcel)parcel, (int)n4);
                    continue block10;
                }
                case 7: {
                    string2 = zza.n((Parcel)parcel, (int)n4);
                    continue block10;
                }
                case 8: 
            }
            d2 = zza.m((Parcel)parcel, (int)n4);
        }
        if (parcel.dataPosition() != n2) {
            throw new zza.zza(new StringBuilder(37).append("Overread allowed size end=").append(n2).toString(), parcel);
        }
        return new UserAttributeParcel(n3, string4, l2, l3, f2, string3, string2, d2);
    }

    public UserAttributeParcel[] a(int n2) {
        return new UserAttributeParcel[n2];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return this.a(parcel);
    }

    public /* synthetic */ Object[] newArray(int n2) {
        return this.a(n2);
    }
}

