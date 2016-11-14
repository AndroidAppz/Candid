/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.accounts.Account
 *  android.os.Parcel
 *  android.os.Parcelable
 *  android.os.Parcelable$Creator
 *  com.google.android.gms.common.api.Scope
 *  com.google.android.gms.common.internal.safeparcel.zza
 *  com.google.android.gms.common.internal.safeparcel.zza$zza
 *  com.google.android.gms.signin.internal.RecordConsentRequest
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 */
import android.accounts.Account;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.signin.internal.RecordConsentRequest;

public class ahj
implements Parcelable.Creator<RecordConsentRequest> {
    public static void a(RecordConsentRequest recordConsentRequest, Parcel parcel, int n2) {
        int n3 = xo.a(parcel);
        xo.a(parcel, 1, recordConsentRequest.a);
        xo.a(parcel, 2, (Parcelable)recordConsentRequest.a(), n2, false);
        xo.a((Parcel)parcel, (int)3, (Parcelable[])recordConsentRequest.b(), (int)n2, (boolean)false);
        xo.a(parcel, 4, recordConsentRequest.c(), false);
        xo.a(parcel, n3);
    }

    /*
     * Enabled aggressive block sorting
     */
    public RecordConsentRequest a(Parcel parcel) {
        String string2 = null;
        int n2 = zza.b((Parcel)parcel);
        int n3 = 0;
        Scope[] arrscope = null;
        Account account = null;
        while (parcel.dataPosition() < n2) {
            Account account2;
            int n4;
            String string3;
            Scope[] arrscope2;
            int n5 = zza.a((Parcel)parcel);
            switch (zza.a((int)n5)) {
                default: {
                    zza.b((Parcel)parcel, (int)n5);
                    string3 = string2;
                    arrscope2 = arrscope;
                    account2 = account;
                    n4 = n3;
                    break;
                }
                case 1: {
                    int n6 = zza.f((Parcel)parcel, (int)n5);
                    String string4 = string2;
                    arrscope2 = arrscope;
                    account2 = account;
                    n4 = n6;
                    string3 = string4;
                    break;
                }
                case 2: {
                    Account account3 = (Account)zza.a((Parcel)parcel, (int)n5, (Parcelable.Creator)Account.CREATOR);
                    n4 = n3;
                    Scope[] arrscope3 = arrscope;
                    account2 = account3;
                    string3 = string2;
                    arrscope2 = arrscope3;
                    break;
                }
                case 3: {
                    Scope[] arrscope4 = (Scope[])zza.b((Parcel)parcel, (int)n5, (Parcelable.Creator)Scope.CREATOR);
                    account2 = account;
                    n4 = n3;
                    String string5 = string2;
                    arrscope2 = arrscope4;
                    string3 = string5;
                    break;
                }
                case 4: {
                    string3 = zza.n((Parcel)parcel, (int)n5);
                    arrscope2 = arrscope;
                    account2 = account;
                    n4 = n3;
                }
            }
            n3 = n4;
            account = account2;
            arrscope = arrscope2;
            string2 = string3;
        }
        if (parcel.dataPosition() != n2) {
            throw new zza.zza(new StringBuilder(37).append("Overread allowed size end=").append(n2).toString(), parcel);
        }
        return new RecordConsentRequest(n3, account, arrscope, string2);
    }

    public RecordConsentRequest[] a(int n2) {
        return new RecordConsentRequest[n2];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return this.a(parcel);
    }

    public /* synthetic */ Object[] newArray(int n2) {
        return this.a(n2);
    }
}

