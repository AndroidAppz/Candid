/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.os.Parcel
 *  android.os.Parcelable
 *  android.os.Parcelable$Creator
 *  com.google.android.gms.common.internal.safeparcel.zza
 *  com.google.android.gms.common.internal.safeparcel.zza$zza
 *  com.google.android.gms.maps.model.LatLng
 *  com.google.android.gms.maps.model.PolylineOptions
 *  java.lang.Object
 *  java.lang.String
 *  java.util.ArrayList
 *  java.util.List
 */
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.PolylineOptions;
import java.util.ArrayList;
import java.util.List;

public class afk
implements Parcelable.Creator<PolylineOptions> {
    public static void a(PolylineOptions polylineOptions, Parcel parcel, int n2) {
        int n3 = xo.zzav((Parcel)parcel);
        xo.a(parcel, 1, polylineOptions.a());
        xo.c(parcel, 2, polylineOptions.b(), false);
        xo.a(parcel, 3, polylineOptions.c());
        xo.a(parcel, 4, polylineOptions.d());
        xo.a(parcel, 5, polylineOptions.e());
        xo.a(parcel, 6, polylineOptions.f());
        xo.a(parcel, 7, polylineOptions.g());
        xo.a(parcel, 8, polylineOptions.h());
        xo.zzI((Parcel)parcel, (int)n3);
    }

    public PolylineOptions a(Parcel parcel) {
        float f2 = 0.0f;
        boolean bl2 = false;
        int n2 = zza.zzau((Parcel)parcel);
        ArrayList arrayList = null;
        boolean bl3 = false;
        boolean bl4 = false;
        int n3 = 0;
        float f3 = 0.0f;
        int n4 = 0;
        block10 : while (parcel.dataPosition() < n2) {
            int n5 = zza.zzat((Parcel)parcel);
            switch (zza.zzca((int)n5)) {
                default: {
                    zza.b((Parcel)parcel, (int)n5);
                    continue block10;
                }
                case 1: {
                    n4 = zza.f((Parcel)parcel, (int)n5);
                    continue block10;
                }
                case 2: {
                    arrayList = zza.c((Parcel)parcel, (int)n5, (Parcelable.Creator)LatLng.CREATOR);
                    continue block10;
                }
                case 3: {
                    f3 = zza.j((Parcel)parcel, (int)n5);
                    continue block10;
                }
                case 4: {
                    n3 = zza.f((Parcel)parcel, (int)n5);
                    continue block10;
                }
                case 5: {
                    f2 = zza.j((Parcel)parcel, (int)n5);
                    continue block10;
                }
                case 6: {
                    bl4 = zza.c((Parcel)parcel, (int)n5);
                    continue block10;
                }
                case 7: {
                    bl3 = zza.c((Parcel)parcel, (int)n5);
                    continue block10;
                }
                case 8: 
            }
            bl2 = zza.c((Parcel)parcel, (int)n5);
        }
        if (parcel.dataPosition() != n2) {
            throw new zza.zza("Overread allowed size end=" + n2, parcel);
        }
        return new PolylineOptions(n4, (List)arrayList, f3, n3, f2, bl4, bl3, bl2);
    }

    public PolylineOptions[] a(int n2) {
        return new PolylineOptions[n2];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return this.a(parcel);
    }

    public /* synthetic */ Object[] newArray(int n2) {
        return this.a(n2);
    }
}

