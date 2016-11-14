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
 *  com.google.android.gms.maps.model.PolygonOptions
 *  java.lang.Class
 *  java.lang.ClassLoader
 *  java.lang.Object
 *  java.lang.String
 *  java.util.ArrayList
 *  java.util.List
 */
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.PolygonOptions;
import java.util.ArrayList;
import java.util.List;

public class afj
implements Parcelable.Creator<PolygonOptions> {
    public static void a(PolygonOptions polygonOptions, Parcel parcel, int n2) {
        int n3 = xo.zzav((Parcel)parcel);
        xo.a(parcel, 1, polygonOptions.a());
        xo.c(parcel, 2, polygonOptions.c(), false);
        xo.d(parcel, 3, polygonOptions.b(), false);
        xo.a(parcel, 4, polygonOptions.d());
        xo.a(parcel, 5, polygonOptions.e());
        xo.a(parcel, 6, polygonOptions.f());
        xo.a(parcel, 7, polygonOptions.g());
        xo.a(parcel, 8, polygonOptions.h());
        xo.a(parcel, 9, polygonOptions.i());
        xo.a(parcel, 10, polygonOptions.j());
        xo.zzI((Parcel)parcel, (int)n3);
    }

    public PolygonOptions a(Parcel parcel) {
        float f2 = 0.0f;
        boolean bl2 = false;
        int n2 = zza.zzau((Parcel)parcel);
        ArrayList arrayList = null;
        ArrayList arrayList2 = new ArrayList();
        boolean bl3 = false;
        boolean bl4 = false;
        int n3 = 0;
        int n4 = 0;
        float f3 = 0.0f;
        int n5 = 0;
        block12 : while (parcel.dataPosition() < n2) {
            int n6 = zza.zzat((Parcel)parcel);
            switch (zza.zzca((int)n6)) {
                default: {
                    zza.b((Parcel)parcel, (int)n6);
                    continue block12;
                }
                case 1: {
                    n5 = zza.f((Parcel)parcel, (int)n6);
                    continue block12;
                }
                case 2: {
                    arrayList = zza.c((Parcel)parcel, (int)n6, (Parcelable.Creator)LatLng.CREATOR);
                    continue block12;
                }
                case 3: {
                    zza.a((Parcel)parcel, (int)n6, (List)arrayList2, (ClassLoader)this.getClass().getClassLoader());
                    continue block12;
                }
                case 4: {
                    f3 = zza.j((Parcel)parcel, (int)n6);
                    continue block12;
                }
                case 5: {
                    n4 = zza.f((Parcel)parcel, (int)n6);
                    continue block12;
                }
                case 6: {
                    n3 = zza.f((Parcel)parcel, (int)n6);
                    continue block12;
                }
                case 7: {
                    f2 = zza.j((Parcel)parcel, (int)n6);
                    continue block12;
                }
                case 8: {
                    bl4 = zza.c((Parcel)parcel, (int)n6);
                    continue block12;
                }
                case 9: {
                    bl3 = zza.c((Parcel)parcel, (int)n6);
                    continue block12;
                }
                case 10: 
            }
            bl2 = zza.c((Parcel)parcel, (int)n6);
        }
        if (parcel.dataPosition() != n2) {
            throw new zza.zza("Overread allowed size end=" + n2, parcel);
        }
        return new PolygonOptions(n5, (List)arrayList, (List)arrayList2, f3, n4, n3, f2, bl4, bl3, bl2);
    }

    public PolygonOptions[] a(int n2) {
        return new PolygonOptions[n2];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return this.a(parcel);
    }

    public /* synthetic */ Object[] newArray(int n2) {
        return this.a(n2);
    }
}

