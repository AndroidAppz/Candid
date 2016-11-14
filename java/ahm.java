/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.os.Parcel
 *  android.os.Parcelable
 *  android.os.Parcelable$Creator
 *  com.google.android.gms.common.ConnectionResult
 *  com.google.android.gms.common.internal.ResolveAccountResponse
 *  com.google.android.gms.common.internal.safeparcel.zza
 *  com.google.android.gms.common.internal.safeparcel.zza$zza
 *  com.google.android.gms.signin.internal.SignInResponse
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 */
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.ResolveAccountResponse;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.signin.internal.SignInResponse;

public class ahm
implements Parcelable.Creator<SignInResponse> {
    public static void a(SignInResponse signInResponse, Parcel parcel, int n2) {
        int n3 = xo.a(parcel);
        xo.a(parcel, 1, signInResponse.a);
        xo.a(parcel, 2, (Parcelable)signInResponse.a(), n2, false);
        xo.a(parcel, 3, (Parcelable)signInResponse.b(), n2, false);
        xo.a(parcel, n3);
    }

    /*
     * Enabled aggressive block sorting
     */
    public SignInResponse a(Parcel parcel) {
        ResolveAccountResponse resolveAccountResponse = null;
        int n2 = zza.b((Parcel)parcel);
        int n3 = 0;
        ConnectionResult connectionResult = null;
        while (parcel.dataPosition() < n2) {
            ResolveAccountResponse resolveAccountResponse2;
            ConnectionResult connectionResult2;
            int n4;
            int n5 = zza.a((Parcel)parcel);
            switch (zza.a((int)n5)) {
                default: {
                    zza.b((Parcel)parcel, (int)n5);
                    resolveAccountResponse2 = resolveAccountResponse;
                    connectionResult2 = connectionResult;
                    n4 = n3;
                    break;
                }
                case 1: {
                    int n6 = zza.f((Parcel)parcel, (int)n5);
                    ResolveAccountResponse resolveAccountResponse3 = resolveAccountResponse;
                    connectionResult2 = connectionResult;
                    n4 = n6;
                    resolveAccountResponse2 = resolveAccountResponse3;
                    break;
                }
                case 2: {
                    ConnectionResult connectionResult3 = (ConnectionResult)zza.a((Parcel)parcel, (int)n5, (Parcelable.Creator)ConnectionResult.CREATOR);
                    n4 = n3;
                    resolveAccountResponse2 = resolveAccountResponse;
                    connectionResult2 = connectionResult3;
                    break;
                }
                case 3: {
                    resolveAccountResponse2 = (ResolveAccountResponse)zza.a((Parcel)parcel, (int)n5, (Parcelable.Creator)ResolveAccountResponse.CREATOR);
                    connectionResult2 = connectionResult;
                    n4 = n3;
                }
            }
            n3 = n4;
            connectionResult = connectionResult2;
            resolveAccountResponse = resolveAccountResponse2;
        }
        if (parcel.dataPosition() != n2) {
            throw new zza.zza(new StringBuilder(37).append("Overread allowed size end=").append(n2).toString(), parcel);
        }
        return new SignInResponse(n3, connectionResult, resolveAccountResponse);
    }

    public SignInResponse[] a(int n2) {
        return new SignInResponse[n2];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return this.a(parcel);
    }

    public /* synthetic */ Object[] newArray(int n2) {
        return this.a(n2);
    }
}

