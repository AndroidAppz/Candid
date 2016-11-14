/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.os.Parcel
 *  android.os.Parcelable
 *  android.os.Parcelable$Creator
 *  com.google.android.gms.common.internal.safeparcel.zza
 *  com.google.android.gms.common.internal.safeparcel.zza$zza
 *  com.google.android.gms.location.internal.ParcelableGeofence
 *  java.lang.Object
 *  java.lang.String
 */
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.location.internal.ParcelableGeofence;

public class ack
implements Parcelable.Creator<ParcelableGeofence> {
    public static void a(ParcelableGeofence parcelableGeofence, Parcel parcel, int n2) {
        int n3 = xo.zzav((Parcel)parcel);
        xo.a(parcel, 1, parcelableGeofence.a(), false);
        xo.a(parcel, 1000, parcelableGeofence.b());
        xo.a(parcel, 2, parcelableGeofence.g());
        xo.a(parcel, 3, parcelableGeofence.c());
        xo.a(parcel, 4, parcelableGeofence.d());
        xo.a(parcel, 5, parcelableGeofence.e());
        xo.a(parcel, 6, parcelableGeofence.f());
        xo.a(parcel, 7, parcelableGeofence.h());
        xo.a(parcel, 8, parcelableGeofence.i());
        xo.a(parcel, 9, parcelableGeofence.j());
        xo.zzI((Parcel)parcel, (int)n3);
    }

    public ParcelableGeofence a(Parcel parcel) {
        int n2 = zza.zzau((Parcel)parcel);
        int n3 = 0;
        String string2 = null;
        int n4 = 0;
        short s2 = 0;
        double d2 = 0.0;
        double d3 = 0.0;
        float f2 = 0.0f;
        long l2 = 0;
        int n5 = 0;
        int n6 = -1;
        block12 : while (parcel.dataPosition() < n2) {
            int n7 = zza.zzat((Parcel)parcel);
            switch (zza.zzca((int)n7)) {
                default: {
                    zza.b((Parcel)parcel, (int)n7);
                    continue block12;
                }
                case 1: {
                    string2 = zza.zzp((Parcel)parcel, (int)n7);
                    continue block12;
                }
                case 1000: {
                    n3 = zza.f((Parcel)parcel, (int)n7);
                    continue block12;
                }
                case 2: {
                    l2 = zza.h((Parcel)parcel, (int)n7);
                    continue block12;
                }
                case 3: {
                    s2 = zza.e((Parcel)parcel, (int)n7);
                    continue block12;
                }
                case 4: {
                    d2 = zza.l((Parcel)parcel, (int)n7);
                    continue block12;
                }
                case 5: {
                    d3 = zza.l((Parcel)parcel, (int)n7);
                    continue block12;
                }
                case 6: {
                    f2 = zza.j((Parcel)parcel, (int)n7);
                    continue block12;
                }
                case 7: {
                    n4 = zza.f((Parcel)parcel, (int)n7);
                    continue block12;
                }
                case 8: {
                    n5 = zza.f((Parcel)parcel, (int)n7);
                    continue block12;
                }
                case 9: 
            }
            n6 = zza.f((Parcel)parcel, (int)n7);
        }
        if (parcel.dataPosition() != n2) {
            throw new zza.zza("Overread allowed size end=" + n2, parcel);
        }
        return new ParcelableGeofence(n3, string2, n4, s2, d2, d3, f2, l2, n5, n6);
    }

    public ParcelableGeofence[] a(int n2) {
        return new ParcelableGeofence[n2];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return this.a(parcel);
    }

    public /* synthetic */ Object[] newArray(int n2) {
        return this.a(n2);
    }
}

