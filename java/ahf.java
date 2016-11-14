/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.content.Intent
 *  android.os.Parcel
 *  android.os.Parcelable
 *  android.os.Parcelable$Creator
 *  com.google.android.gms.common.internal.safeparcel.zza
 *  com.google.android.gms.common.internal.safeparcel.zza$zza
 *  com.google.android.gms.signin.internal.AuthAccountResult
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 */
import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.signin.internal.AuthAccountResult;

public class ahf
implements Parcelable.Creator<AuthAccountResult> {
    public static void a(AuthAccountResult authAccountResult, Parcel parcel, int n2) {
        int n3 = xo.a(parcel);
        xo.a(parcel, 1, authAccountResult.a);
        xo.a(parcel, 2, authAccountResult.b());
        xo.a(parcel, 3, (Parcelable)authAccountResult.c(), n2, false);
        xo.a(parcel, n3);
    }

    public AuthAccountResult a(Parcel parcel) {
        int n2 = 0;
        int n3 = zza.b((Parcel)parcel);
        Intent intent = null;
        int n4 = 0;
        block5 : while (parcel.dataPosition() < n3) {
            int n5 = zza.a((Parcel)parcel);
            switch (zza.a((int)n5)) {
                default: {
                    zza.b((Parcel)parcel, (int)n5);
                    continue block5;
                }
                case 1: {
                    n4 = zza.f((Parcel)parcel, (int)n5);
                    continue block5;
                }
                case 2: {
                    n2 = zza.f((Parcel)parcel, (int)n5);
                    continue block5;
                }
                case 3: 
            }
            intent = (Intent)zza.a((Parcel)parcel, (int)n5, (Parcelable.Creator)Intent.CREATOR);
        }
        if (parcel.dataPosition() != n3) {
            throw new zza.zza(new StringBuilder(37).append("Overread allowed size end=").append(n3).toString(), parcel);
        }
        return new AuthAccountResult(n4, n2, intent);
    }

    public AuthAccountResult[] a(int n2) {
        return new AuthAccountResult[n2];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return this.a(parcel);
    }

    public /* synthetic */ Object[] newArray(int n2) {
        return this.a(n2);
    }
}

