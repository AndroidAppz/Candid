/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.os.Parcel
 *  android.os.Parcelable
 *  android.os.Parcelable$Creator
 *  com.google.android.gms.common.internal.safeparcel.zza
 *  com.google.android.gms.common.internal.safeparcel.zza$zza
 *  com.google.android.gms.maps.model.CameraPosition
 *  com.google.android.gms.maps.model.LatLng
 *  java.lang.Object
 *  java.lang.String
 */
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;

public class afc
implements Parcelable.Creator<CameraPosition> {
    public static void a(CameraPosition cameraPosition, Parcel parcel, int n2) {
        int n3 = xo.zzav((Parcel)parcel);
        xo.a(parcel, 1, cameraPosition.a());
        xo.a(parcel, 2, (Parcelable)cameraPosition.a, n2, false);
        xo.a(parcel, 3, cameraPosition.b);
        xo.a(parcel, 4, cameraPosition.c);
        xo.a(parcel, 5, cameraPosition.d);
        xo.zzI((Parcel)parcel, (int)n3);
    }

    public CameraPosition a(Parcel parcel) {
        float f2 = 0.0f;
        int n2 = zza.zzau((Parcel)parcel);
        int n3 = 0;
        LatLng latLng = null;
        float f3 = 0.0f;
        float f4 = 0.0f;
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
                    latLng = (LatLng)zza.a((Parcel)parcel, (int)n4, (Parcelable.Creator)LatLng.CREATOR);
                    continue block7;
                }
                case 3: {
                    f4 = zza.j((Parcel)parcel, (int)n4);
                    continue block7;
                }
                case 4: {
                    f3 = zza.j((Parcel)parcel, (int)n4);
                    continue block7;
                }
                case 5: 
            }
            f2 = zza.j((Parcel)parcel, (int)n4);
        }
        if (parcel.dataPosition() != n2) {
            throw new zza.zza("Overread allowed size end=" + n2, parcel);
        }
        return new CameraPosition(n3, latLng, f4, f3, f2);
    }

    public CameraPosition[] a(int n2) {
        return new CameraPosition[n2];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return this.a(parcel);
    }

    public /* synthetic */ Object[] newArray(int n2) {
        return this.a(n2);
    }
}

