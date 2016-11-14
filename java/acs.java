/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.os.Parcel
 *  android.os.Parcelable
 *  android.os.Parcelable$Creator
 *  com.google.android.gms.common.internal.safeparcel.zza
 *  com.google.android.gms.common.internal.safeparcel.zza$zza
 *  com.google.android.gms.location.places.AutocompleteFilter
 *  java.lang.Object
 *  java.lang.String
 *  java.util.ArrayList
 *  java.util.List
 */
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.location.places.AutocompleteFilter;
import java.util.ArrayList;
import java.util.List;

public class acs
implements Parcelable.Creator<AutocompleteFilter> {
    public static void a(AutocompleteFilter autocompleteFilter, Parcel parcel, int n2) {
        int n3 = xo.zzav((Parcel)parcel);
        xo.a(parcel, 1, autocompleteFilter.b);
        xo.a(parcel, 1000, autocompleteFilter.a);
        xo.a(parcel, 2, autocompleteFilter.c, false);
        xo.zzI((Parcel)parcel, (int)n3);
    }

    public AutocompleteFilter a(Parcel parcel) {
        boolean bl2 = false;
        int n2 = zza.zzau((Parcel)parcel);
        ArrayList arrayList = null;
        int n3 = 0;
        block5 : while (parcel.dataPosition() < n2) {
            int n4 = zza.zzat((Parcel)parcel);
            switch (zza.zzca((int)n4)) {
                default: {
                    zza.b((Parcel)parcel, (int)n4);
                    continue block5;
                }
                case 1: {
                    bl2 = zza.c((Parcel)parcel, (int)n4);
                    continue block5;
                }
                case 1000: {
                    n3 = zza.f((Parcel)parcel, (int)n4);
                    continue block5;
                }
                case 2: 
            }
            arrayList = zza.zzC((Parcel)parcel, (int)n4);
        }
        if (parcel.dataPosition() != n2) {
            throw new zza.zza("Overread allowed size end=" + n2, parcel);
        }
        return new AutocompleteFilter(n3, bl2, (List)arrayList);
    }

    public AutocompleteFilter[] a(int n2) {
        return new AutocompleteFilter[n2];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return this.a(parcel);
    }

    public /* synthetic */ Object[] newArray(int n2) {
        return this.a(n2);
    }
}

