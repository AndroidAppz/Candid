/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.os.Parcel
 *  android.os.Parcelable
 *  android.os.Parcelable$Creator
 *  com.google.android.gms.common.internal.safeparcel.zza
 *  com.google.android.gms.common.internal.safeparcel.zza$zza
 *  com.google.android.gms.maps.model.CircleOptions
 *  com.google.android.gms.maps.model.LatLng
 *  java.lang.Object
 *  java.lang.String
 */
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.maps.model.CircleOptions;
import com.google.android.gms.maps.model.LatLng;

public class afd
implements Parcelable.Creator<CircleOptions> {
    public static void a(CircleOptions circleOptions, Parcel parcel, int n2) {
        int n3 = xo.zzav((Parcel)parcel);
        xo.a(parcel, 1, circleOptions.a());
        xo.a(parcel, 2, (Parcelable)circleOptions.b(), n2, false);
        xo.a(parcel, 3, circleOptions.c());
        xo.a(parcel, 4, circleOptions.d());
        xo.a(parcel, 5, circleOptions.e());
        xo.a(parcel, 6, circleOptions.f());
        xo.a(parcel, 7, circleOptions.g());
        xo.a(parcel, 8, circleOptions.h());
        xo.zzI((Parcel)parcel, (int)n3);
    }

    public CircleOptions a(Parcel parcel) {
        float f2 = 0.0f;
        boolean bl2 = false;
        int n2 = zza.zzau((Parcel)parcel);
        LatLng latLng = null;
        double d2 = 0.0;
        int n3 = 0;
        int n4 = 0;
        float f3 = 0.0f;
        int n5 = 0;
        block10 : while (parcel.dataPosition() < n2) {
            int n6 = zza.zzat((Parcel)parcel);
            switch (zza.zzca((int)n6)) {
                default: {
                    zza.b((Parcel)parcel, (int)n6);
                    continue block10;
                }
                case 1: {
                    n5 = zza.f((Parcel)parcel, (int)n6);
                    continue block10;
                }
                case 2: {
                    latLng = (LatLng)zza.a((Parcel)parcel, (int)n6, (Parcelable.Creator)LatLng.CREATOR);
                    continue block10;
                }
                case 3: {
                    d2 = zza.l((Parcel)parcel, (int)n6);
                    continue block10;
                }
                case 4: {
                    f3 = zza.j((Parcel)parcel, (int)n6);
                    continue block10;
                }
                case 5: {
                    n4 = zza.f((Parcel)parcel, (int)n6);
                    continue block10;
                }
                case 6: {
                    n3 = zza.f((Parcel)parcel, (int)n6);
                    continue block10;
                }
                case 7: {
                    f2 = zza.j((Parcel)parcel, (int)n6);
                    continue block10;
                }
                case 8: 
            }
            bl2 = zza.c((Parcel)parcel, (int)n6);
        }
        if (parcel.dataPosition() != n2) {
            throw new zza.zza("Overread allowed size end=" + n2, parcel);
        }
        return new CircleOptions(n5, latLng, d2, f3, n4, n3, f2, bl2);
    }

    public CircleOptions[] a(int n2) {
        return new CircleOptions[n2];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return this.a(parcel);
    }

    public /* synthetic */ Object[] newArray(int n2) {
        return this.a(n2);
    }
}

