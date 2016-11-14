/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.os.Parcel
 *  android.os.Parcelable
 *  android.os.Parcelable$Creator
 *  com.google.android.gms.common.internal.safeparcel.zza
 *  com.google.android.gms.common.internal.safeparcel.zza$zza
 *  com.google.android.gms.location.DetectedActivity
 *  java.lang.Object
 *  java.lang.String
 */
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.location.DetectedActivity;

public class aca
implements Parcelable.Creator<DetectedActivity> {
    public static void a(DetectedActivity detectedActivity, Parcel parcel, int n2) {
        int n3 = xo.zzav((Parcel)parcel);
        xo.a(parcel, 1, detectedActivity.c);
        xo.a(parcel, 1000, detectedActivity.c());
        xo.a(parcel, 2, detectedActivity.d);
        xo.zzI((Parcel)parcel, (int)n3);
    }

    public DetectedActivity a(Parcel parcel) {
        int n2 = 0;
        int n3 = zza.zzau((Parcel)parcel);
        int n4 = 0;
        int n5 = 0;
        block5 : while (parcel.dataPosition() < n3) {
            int n6 = zza.zzat((Parcel)parcel);
            switch (zza.zzca((int)n6)) {
                default: {
                    zza.b((Parcel)parcel, (int)n6);
                    continue block5;
                }
                case 1: {
                    n4 = zza.f((Parcel)parcel, (int)n6);
                    continue block5;
                }
                case 1000: {
                    n5 = zza.f((Parcel)parcel, (int)n6);
                    continue block5;
                }
                case 2: 
            }
            n2 = zza.f((Parcel)parcel, (int)n6);
        }
        if (parcel.dataPosition() != n3) {
            throw new zza.zza("Overread allowed size end=" + n3, parcel);
        }
        return new DetectedActivity(n5, n4, n2);
    }

    public DetectedActivity[] a(int n2) {
        return new DetectedActivity[n2];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return this.a(parcel);
    }

    public /* synthetic */ Object[] newArray(int n2) {
        return this.a(n2);
    }
}

