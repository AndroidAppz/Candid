/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.os.Parcel
 *  android.os.Parcelable
 *  android.os.Parcelable$Creator
 *  com.google.android.gms.common.internal.safeparcel.zza
 *  com.google.android.gms.common.internal.safeparcel.zza$zza
 *  com.google.android.gms.location.places.internal.PlaceLocalization
 *  java.lang.Object
 *  java.lang.String
 *  java.util.ArrayList
 *  java.util.List
 */
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.location.places.internal.PlaceLocalization;
import java.util.ArrayList;
import java.util.List;

public class aco
implements Parcelable.Creator<PlaceLocalization> {
    public static void a(PlaceLocalization placeLocalization, Parcel parcel, int n2) {
        int n3 = xo.zzav((Parcel)parcel);
        xo.a(parcel, 1, placeLocalization.b, false);
        xo.a(parcel, 1000, placeLocalization.a);
        xo.a(parcel, 2, placeLocalization.c, false);
        xo.a(parcel, 3, placeLocalization.d, false);
        xo.a(parcel, 4, placeLocalization.e, false);
        xo.b(parcel, 5, placeLocalization.f, false);
        xo.zzI((Parcel)parcel, (int)n3);
    }

    public PlaceLocalization a(Parcel parcel) {
        ArrayList arrayList = null;
        int n2 = zza.zzau((Parcel)parcel);
        int n3 = 0;
        String string2 = null;
        String string3 = null;
        String string4 = null;
        String string5 = null;
        block8 : while (parcel.dataPosition() < n2) {
            int n4 = zza.zzat((Parcel)parcel);
            switch (zza.zzca((int)n4)) {
                default: {
                    zza.b((Parcel)parcel, (int)n4);
                    continue block8;
                }
                case 1: {
                    string5 = zza.zzp((Parcel)parcel, (int)n4);
                    continue block8;
                }
                case 1000: {
                    n3 = zza.f((Parcel)parcel, (int)n4);
                    continue block8;
                }
                case 2: {
                    string4 = zza.zzp((Parcel)parcel, (int)n4);
                    continue block8;
                }
                case 3: {
                    string3 = zza.zzp((Parcel)parcel, (int)n4);
                    continue block8;
                }
                case 4: {
                    string2 = zza.zzp((Parcel)parcel, (int)n4);
                    continue block8;
                }
                case 5: 
            }
            arrayList = zza.r((Parcel)parcel, (int)n4);
        }
        if (parcel.dataPosition() != n2) {
            throw new zza.zza("Overread allowed size end=" + n2, parcel);
        }
        return new PlaceLocalization(n3, string5, string4, string3, string2, (List)arrayList);
    }

    public PlaceLocalization[] a(int n2) {
        return new PlaceLocalization[n2];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return this.a(parcel);
    }

    public /* synthetic */ Object[] newArray(int n2) {
        return this.a(n2);
    }
}

