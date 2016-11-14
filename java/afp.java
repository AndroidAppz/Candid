/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.os.Parcel
 *  android.os.Parcelable
 *  android.os.Parcelable$Creator
 *  com.google.android.gms.common.internal.safeparcel.zza
 *  com.google.android.gms.common.internal.safeparcel.zza$zza
 *  com.google.android.gms.maps.model.Tile
 *  java.lang.Object
 *  java.lang.String
 */
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.maps.model.Tile;

public class afp
implements Parcelable.Creator<Tile> {
    public static void a(Tile tile, Parcel parcel, int n2) {
        int n3 = xo.zzav((Parcel)parcel);
        xo.a(parcel, 1, tile.a());
        xo.a(parcel, 2, tile.a);
        xo.a(parcel, 3, tile.b);
        xo.a(parcel, 4, tile.c, false);
        xo.zzI((Parcel)parcel, (int)n3);
    }

    public Tile a(Parcel parcel) {
        int n2 = 0;
        int n3 = zza.zzau((Parcel)parcel);
        Object object = null;
        int n4 = 0;
        int n5 = 0;
        block6 : while (parcel.dataPosition() < n3) {
            int n6 = zza.zzat((Parcel)parcel);
            switch (zza.zzca((int)n6)) {
                default: {
                    zza.b((Parcel)parcel, (int)n6);
                    continue block6;
                }
                case 1: {
                    n5 = zza.f((Parcel)parcel, (int)n6);
                    continue block6;
                }
                case 2: {
                    n4 = zza.f((Parcel)parcel, (int)n6);
                    continue block6;
                }
                case 3: {
                    n2 = zza.f((Parcel)parcel, (int)n6);
                    continue block6;
                }
                case 4: 
            }
            object = zza.zzs((Parcel)parcel, (int)n6);
        }
        if (parcel.dataPosition() != n3) {
            throw new zza.zza("Overread allowed size end=" + n3, parcel);
        }
        return new Tile(n5, n4, n2, (byte[])object);
    }

    public Tile[] a(int n2) {
        return new Tile[n2];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return this.a(parcel);
    }

    public /* synthetic */ Object[] newArray(int n2) {
        return this.a(n2);
    }
}

