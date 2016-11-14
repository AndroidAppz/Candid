/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.os.Parcel
 *  android.os.Parcelable
 *  android.os.Parcelable$Creator
 *  com.google.android.gms.common.internal.safeparcel.zza
 *  com.google.android.gms.common.internal.safeparcel.zza$zza
 *  com.google.android.gms.measurement.internal.AppMetadata
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 */
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.measurement.internal.AppMetadata;

public class agh
implements Parcelable.Creator<AppMetadata> {
    public static void a(AppMetadata appMetadata, Parcel parcel, int n2) {
        int n3 = xo.a(parcel);
        xo.a(parcel, 1, appMetadata.a);
        xo.a(parcel, 2, appMetadata.b, false);
        xo.a(parcel, 3, appMetadata.c, false);
        xo.a(parcel, 4, appMetadata.d, false);
        xo.a(parcel, 5, appMetadata.e, false);
        xo.a(parcel, 6, appMetadata.f);
        xo.a(parcel, 7, appMetadata.g);
        xo.a(parcel, 8, appMetadata.h, false);
        xo.a(parcel, 9, appMetadata.i);
        xo.a(parcel, 10, appMetadata.j);
        xo.a(parcel, 11, appMetadata.k);
        xo.a(parcel, 12, appMetadata.l, false);
        xo.a(parcel, n3);
    }

    public AppMetadata a(Parcel parcel) {
        int n2 = zza.b((Parcel)parcel);
        int n3 = 0;
        String string2 = null;
        String string3 = null;
        String string4 = null;
        String string5 = null;
        long l2 = 0;
        long l3 = 0;
        String string6 = null;
        boolean bl2 = false;
        boolean bl3 = false;
        long l4 = 0;
        String string7 = null;
        block14 : while (parcel.dataPosition() < n2) {
            int n4 = zza.a((Parcel)parcel);
            switch (zza.a((int)n4)) {
                default: {
                    zza.b((Parcel)parcel, (int)n4);
                    continue block14;
                }
                case 1: {
                    n3 = zza.f((Parcel)parcel, (int)n4);
                    continue block14;
                }
                case 2: {
                    string2 = zza.n((Parcel)parcel, (int)n4);
                    continue block14;
                }
                case 3: {
                    string3 = zza.n((Parcel)parcel, (int)n4);
                    continue block14;
                }
                case 4: {
                    string4 = zza.n((Parcel)parcel, (int)n4);
                    continue block14;
                }
                case 5: {
                    string5 = zza.n((Parcel)parcel, (int)n4);
                    continue block14;
                }
                case 6: {
                    l2 = zza.h((Parcel)parcel, (int)n4);
                    continue block14;
                }
                case 7: {
                    l3 = zza.h((Parcel)parcel, (int)n4);
                    continue block14;
                }
                case 8: {
                    string6 = zza.n((Parcel)parcel, (int)n4);
                    continue block14;
                }
                case 9: {
                    bl2 = zza.c((Parcel)parcel, (int)n4);
                    continue block14;
                }
                case 10: {
                    bl3 = zza.c((Parcel)parcel, (int)n4);
                    continue block14;
                }
                case 11: {
                    l4 = zza.h((Parcel)parcel, (int)n4);
                    continue block14;
                }
                case 12: 
            }
            string7 = zza.n((Parcel)parcel, (int)n4);
        }
        if (parcel.dataPosition() != n2) {
            throw new zza.zza(new StringBuilder(37).append("Overread allowed size end=").append(n2).toString(), parcel);
        }
        return new AppMetadata(n3, string2, string3, string4, string5, l2, l3, string6, bl2, bl3, l4, string7);
    }

    public AppMetadata[] a(int n2) {
        return new AppMetadata[n2];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return this.a(parcel);
    }

    public /* synthetic */ Object[] newArray(int n2) {
        return this.a(n2);
    }
}

