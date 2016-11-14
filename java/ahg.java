/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.os.Parcel
 *  android.os.Parcelable
 *  android.os.Parcelable$Creator
 *  com.google.android.gms.common.api.Scope
 *  com.google.android.gms.common.internal.safeparcel.zza
 *  com.google.android.gms.common.internal.safeparcel.zza$zza
 *  com.google.android.gms.signin.internal.CheckServerAuthResult
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.util.ArrayList
 *  java.util.List
 */
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.signin.internal.CheckServerAuthResult;
import java.util.ArrayList;
import java.util.List;

public class ahg
implements Parcelable.Creator<CheckServerAuthResult> {
    public static void a(CheckServerAuthResult checkServerAuthResult, Parcel parcel, int n2) {
        int n3 = xo.a(parcel);
        xo.a(parcel, 1, checkServerAuthResult.a);
        xo.a(parcel, 2, checkServerAuthResult.b);
        xo.c(parcel, 3, checkServerAuthResult.c, false);
        xo.a(parcel, n3);
    }

    public CheckServerAuthResult a(Parcel parcel) {
        boolean bl2 = false;
        int n2 = zza.b((Parcel)parcel);
        ArrayList arrayList = null;
        int n3 = 0;
        block5 : while (parcel.dataPosition() < n2) {
            int n4 = zza.a((Parcel)parcel);
            switch (zza.a((int)n4)) {
                default: {
                    zza.b((Parcel)parcel, (int)n4);
                    continue block5;
                }
                case 1: {
                    n3 = zza.f((Parcel)parcel, (int)n4);
                    continue block5;
                }
                case 2: {
                    bl2 = zza.c((Parcel)parcel, (int)n4);
                    continue block5;
                }
                case 3: 
            }
            arrayList = zza.c((Parcel)parcel, (int)n4, (Parcelable.Creator)Scope.CREATOR);
        }
        if (parcel.dataPosition() != n2) {
            throw new zza.zza(new StringBuilder(37).append("Overread allowed size end=").append(n2).toString(), parcel);
        }
        return new CheckServerAuthResult(n3, bl2, (List)arrayList);
    }

    public CheckServerAuthResult[] a(int n2) {
        return new CheckServerAuthResult[n2];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return this.a(parcel);
    }

    public /* synthetic */ Object[] newArray(int n2) {
        return this.a(n2);
    }
}

