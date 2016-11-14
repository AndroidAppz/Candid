/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.os.IBinder
 *  android.os.Parcel
 *  android.os.Parcelable
 *  android.os.Parcelable$Creator
 *  com.google.android.gms.common.internal.safeparcel.zza
 *  com.google.android.gms.common.internal.safeparcel.zza$zza
 *  com.google.android.gms.maps.model.LatLng
 *  com.google.android.gms.maps.model.MarkerOptions
 *  java.lang.Object
 *  java.lang.String
 */
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class afh
implements Parcelable.Creator<MarkerOptions> {
    public static void a(MarkerOptions markerOptions, Parcel parcel, int n2) {
        int n3 = xo.zzav((Parcel)parcel);
        xo.a(parcel, 1, markerOptions.a());
        xo.a(parcel, 2, (Parcelable)markerOptions.c(), n2, false);
        xo.a(parcel, 3, markerOptions.d(), false);
        xo.a(parcel, 4, markerOptions.e(), false);
        xo.a(parcel, 5, markerOptions.b(), false);
        xo.a(parcel, 6, markerOptions.f());
        xo.a(parcel, 7, markerOptions.g());
        xo.a(parcel, 8, markerOptions.h());
        xo.a(parcel, 9, markerOptions.i());
        xo.a(parcel, 10, markerOptions.j());
        xo.a(parcel, 11, markerOptions.k());
        xo.a(parcel, 12, markerOptions.l());
        xo.a(parcel, 13, markerOptions.m());
        xo.a(parcel, 14, markerOptions.n());
        xo.zzI((Parcel)parcel, (int)n3);
    }

    public MarkerOptions a(Parcel parcel) {
        int n2 = zza.zzau((Parcel)parcel);
        int n3 = 0;
        LatLng latLng = null;
        String string2 = null;
        String string3 = null;
        IBinder iBinder = null;
        float f2 = 0.0f;
        float f3 = 0.0f;
        boolean bl2 = false;
        boolean bl3 = false;
        boolean bl4 = false;
        float f4 = 0.0f;
        float f5 = 0.5f;
        float f6 = 0.0f;
        float f7 = 1.0f;
        block16 : while (parcel.dataPosition() < n2) {
            int n4 = zza.zzat((Parcel)parcel);
            switch (zza.zzca((int)n4)) {
                default: {
                    zza.b((Parcel)parcel, (int)n4);
                    continue block16;
                }
                case 1: {
                    n3 = zza.f((Parcel)parcel, (int)n4);
                    continue block16;
                }
                case 2: {
                    latLng = (LatLng)zza.a((Parcel)parcel, (int)n4, (Parcelable.Creator)LatLng.CREATOR);
                    continue block16;
                }
                case 3: {
                    string2 = zza.zzp((Parcel)parcel, (int)n4);
                    continue block16;
                }
                case 4: {
                    string3 = zza.zzp((Parcel)parcel, (int)n4);
                    continue block16;
                }
                case 5: {
                    iBinder = zza.zzq((Parcel)parcel, (int)n4);
                    continue block16;
                }
                case 6: {
                    f2 = zza.j((Parcel)parcel, (int)n4);
                    continue block16;
                }
                case 7: {
                    f3 = zza.j((Parcel)parcel, (int)n4);
                    continue block16;
                }
                case 8: {
                    bl2 = zza.c((Parcel)parcel, (int)n4);
                    continue block16;
                }
                case 9: {
                    bl3 = zza.c((Parcel)parcel, (int)n4);
                    continue block16;
                }
                case 10: {
                    bl4 = zza.c((Parcel)parcel, (int)n4);
                    continue block16;
                }
                case 11: {
                    f4 = zza.j((Parcel)parcel, (int)n4);
                    continue block16;
                }
                case 12: {
                    f5 = zza.j((Parcel)parcel, (int)n4);
                    continue block16;
                }
                case 13: {
                    f6 = zza.j((Parcel)parcel, (int)n4);
                    continue block16;
                }
                case 14: 
            }
            f7 = zza.j((Parcel)parcel, (int)n4);
        }
        if (parcel.dataPosition() != n2) {
            throw new zza.zza("Overread allowed size end=" + n2, parcel);
        }
        return new MarkerOptions(n3, latLng, string2, string3, iBinder, f2, f3, bl2, bl3, bl4, f4, f5, f6, f7);
    }

    public MarkerOptions[] a(int n2) {
        return new MarkerOptions[n2];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return this.a(parcel);
    }

    public /* synthetic */ Object[] newArray(int n2) {
        return this.a(n2);
    }
}

