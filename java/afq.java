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
 *  com.google.android.gms.maps.model.TileOverlayOptions
 *  java.lang.Object
 *  java.lang.String
 */
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.maps.model.TileOverlayOptions;

public class afq
implements Parcelable.Creator<TileOverlayOptions> {
    public static void a(TileOverlayOptions tileOverlayOptions, Parcel parcel, int n2) {
        int n3 = xo.zzav((Parcel)parcel);
        xo.a(parcel, 1, tileOverlayOptions.a());
        xo.a(parcel, 2, tileOverlayOptions.b(), false);
        xo.a(parcel, 3, tileOverlayOptions.d());
        xo.a(parcel, 4, tileOverlayOptions.c());
        xo.a(parcel, 5, tileOverlayOptions.e());
        xo.zzI((Parcel)parcel, (int)n3);
    }

    public TileOverlayOptions a(Parcel parcel) {
        boolean bl2 = false;
        int n2 = zza.zzau((Parcel)parcel);
        IBinder iBinder = null;
        float f2 = 0.0f;
        boolean bl3 = true;
        int n3 = 0;
        block7 : while (parcel.dataPosition() < n2) {
            int n4 = zza.zzat((Parcel)parcel);
            switch (zza.zzca((int)n4)) {
                default: {
                    zza.b((Parcel)parcel, (int)n4);
                    continue block7;
                }
                case 1: {
                    n3 = zza.f((Parcel)parcel, (int)n4);
                    continue block7;
                }
                case 2: {
                    iBinder = zza.zzq((Parcel)parcel, (int)n4);
                    continue block7;
                }
                case 3: {
                    bl2 = zza.c((Parcel)parcel, (int)n4);
                    continue block7;
                }
                case 4: {
                    f2 = zza.j((Parcel)parcel, (int)n4);
                    continue block7;
                }
                case 5: 
            }
            bl3 = zza.c((Parcel)parcel, (int)n4);
        }
        if (parcel.dataPosition() != n2) {
            throw new zza.zza("Overread allowed size end=" + n2, parcel);
        }
        return new TileOverlayOptions(n3, iBinder, bl2, f2, bl3);
    }

    public TileOverlayOptions[] a(int n2) {
        return new TileOverlayOptions[n2];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return this.a(parcel);
    }

    public /* synthetic */ Object[] newArray(int n2) {
        return this.a(n2);
    }
}

