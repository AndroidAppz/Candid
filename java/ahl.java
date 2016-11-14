/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.os.Parcel
 *  android.os.Parcelable
 *  android.os.Parcelable$Creator
 *  com.google.android.gms.common.internal.ResolveAccountRequest
 *  com.google.android.gms.common.internal.safeparcel.zza
 *  com.google.android.gms.common.internal.safeparcel.zza$zza
 *  com.google.android.gms.signin.internal.SignInRequest
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 */
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.ResolveAccountRequest;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.signin.internal.SignInRequest;

public class ahl
implements Parcelable.Creator<SignInRequest> {
    public static void a(SignInRequest signInRequest, Parcel parcel, int n2) {
        int n3 = xo.a(parcel);
        xo.a(parcel, 1, signInRequest.a);
        xo.a(parcel, 2, (Parcelable)signInRequest.a(), n2, false);
        xo.a(parcel, n3);
    }

    public SignInRequest a(Parcel parcel) {
        int n2 = zza.b((Parcel)parcel);
        int n3 = 0;
        ResolveAccountRequest resolveAccountRequest = null;
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
            resolveAccountRequest = (ResolveAccountRequest)zza.a((Parcel)parcel, (int)n4, (Parcelable.Creator)ResolveAccountRequest.CREATOR);
        }
        if (parcel.dataPosition() != n2) {
            throw new zza.zza(new StringBuilder(37).append("Overread allowed size end=").append(n2).toString(), parcel);
        }
        return new SignInRequest(n3, resolveAccountRequest);
    }

    public SignInRequest[] a(int n2) {
        return new SignInRequest[n2];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return this.a(parcel);
    }

    public /* synthetic */ Object[] newArray(int n2) {
        return this.a(n2);
    }
}

