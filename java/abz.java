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
 *  com.google.android.gms.location.ActivityRecognitionResult
 *  com.google.android.gms.location.DetectedActivity
 *  java.lang.Object
 *  java.lang.String
 *  java.util.ArrayList
 *  java.util.List
 */
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.location.ActivityRecognitionResult;
import com.google.android.gms.location.DetectedActivity;
import java.util.ArrayList;
import java.util.List;

public class abz
implements Parcelable.Creator<ActivityRecognitionResult> {
    public static void a(ActivityRecognitionResult activityRecognitionResult, Parcel parcel, int n2) {
        int n3 = xo.zzav((Parcel)parcel);
        xo.c(parcel, 1, activityRecognitionResult.a, false);
        xo.a(parcel, 1000, activityRecognitionResult.b());
        xo.a(parcel, 2, activityRecognitionResult.b);
        xo.a(parcel, 3, activityRecognitionResult.c);
        xo.a(parcel, 4, activityRecognitionResult.d);
        xo.a(parcel, 5, activityRecognitionResult.e, false);
        xo.zzI((Parcel)parcel, (int)n3);
    }

    public ActivityRecognitionResult a(Parcel parcel) {
        long l2 = 0;
        Bundle bundle = null;
        int n2 = 0;
        int n3 = zza.zzau((Parcel)parcel);
        long l3 = l2;
        ArrayList arrayList = null;
        int n4 = 0;
        block8 : while (parcel.dataPosition() < n3) {
            int n5 = zza.zzat((Parcel)parcel);
            switch (zza.zzca((int)n5)) {
                default: {
                    zza.b((Parcel)parcel, (int)n5);
                    continue block8;
                }
                case 1: {
                    arrayList = zza.c((Parcel)parcel, (int)n5, (Parcelable.Creator)DetectedActivity.CREATOR);
                    continue block8;
                }
                case 1000: {
                    n4 = zza.f((Parcel)parcel, (int)n5);
                    continue block8;
                }
                case 2: {
                    l3 = zza.h((Parcel)parcel, (int)n5);
                    continue block8;
                }
                case 3: {
                    l2 = zza.h((Parcel)parcel, (int)n5);
                    continue block8;
                }
                case 4: {
                    n2 = zza.f((Parcel)parcel, (int)n5);
                    continue block8;
                }
                case 5: 
            }
            bundle = zza.zzr((Parcel)parcel, (int)n5);
        }
        if (parcel.dataPosition() != n3) {
            throw new zza.zza("Overread allowed size end=" + n3, parcel);
        }
        return new ActivityRecognitionResult(n4, (List)arrayList, l3, l2, n2, bundle);
    }

    public ActivityRecognitionResult[] a(int n2) {
        return new ActivityRecognitionResult[n2];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return this.a(parcel);
    }

    public /* synthetic */ Object[] newArray(int n2) {
        return this.a(n2);
    }
}

