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
 *  com.google.android.gms.maps.model.GroundOverlayOptions
 *  com.google.android.gms.maps.model.LatLng
 *  com.google.android.gms.maps.model.LatLngBounds
 *  java.lang.Object
 *  java.lang.String
 */
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.maps.model.GroundOverlayOptions;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;

public class afe
implements Parcelable.Creator<GroundOverlayOptions> {
    public static void a(GroundOverlayOptions groundOverlayOptions, Parcel parcel, int n2) {
        int n3 = xo.zzav((Parcel)parcel);
        xo.a(parcel, 1, groundOverlayOptions.b());
        xo.a(parcel, 2, groundOverlayOptions.a(), false);
        xo.a(parcel, 3, (Parcelable)groundOverlayOptions.c(), n2, false);
        xo.a(parcel, 4, groundOverlayOptions.d());
        xo.a(parcel, 5, groundOverlayOptions.e());
        xo.a(parcel, 6, (Parcelable)groundOverlayOptions.f(), n2, false);
        xo.a(parcel, 7, groundOverlayOptions.g());
        xo.a(parcel, 8, groundOverlayOptions.h());
        xo.a(parcel, 9, groundOverlayOptions.l());
        xo.a(parcel, 10, groundOverlayOptions.i());
        xo.a(parcel, 11, groundOverlayOptions.j());
        xo.a(parcel, 12, groundOverlayOptions.k());
        xo.a(parcel, 13, groundOverlayOptions.m());
        xo.zzI((Parcel)parcel, (int)n3);
    }

    public GroundOverlayOptions a(Parcel parcel) {
        int n2 = zza.zzau((Parcel)parcel);
        int n3 = 0;
        IBinder iBinder = null;
        LatLng latLng = null;
        float f2 = 0.0f;
        float f3 = 0.0f;
        LatLngBounds latLngBounds = null;
        float f4 = 0.0f;
        float f5 = 0.0f;
        boolean bl2 = false;
        float f6 = 0.0f;
        float f7 = 0.0f;
        float f8 = 0.0f;
        boolean bl3 = false;
        block15 : while (parcel.dataPosition() < n2) {
            int n4 = zza.zzat((Parcel)parcel);
            switch (zza.zzca((int)n4)) {
                default: {
                    zza.b((Parcel)parcel, (int)n4);
                    continue block15;
                }
                case 1: {
                    n3 = zza.f((Parcel)parcel, (int)n4);
                    continue block15;
                }
                case 2: {
                    iBinder = zza.zzq((Parcel)parcel, (int)n4);
                    continue block15;
                }
                case 3: {
                    latLng = (LatLng)zza.a((Parcel)parcel, (int)n4, (Parcelable.Creator)LatLng.CREATOR);
                    continue block15;
                }
                case 4: {
                    f2 = zza.j((Parcel)parcel, (int)n4);
                    continue block15;
                }
                case 5: {
                    f3 = zza.j((Parcel)parcel, (int)n4);
                    continue block15;
                }
                case 6: {
                    latLngBounds = (LatLngBounds)zza.a((Parcel)parcel, (int)n4, (Parcelable.Creator)LatLngBounds.CREATOR);
                    continue block15;
                }
                case 7: {
                    f4 = zza.j((Parcel)parcel, (int)n4);
                    continue block15;
                }
                case 8: {
                    f5 = zza.j((Parcel)parcel, (int)n4);
                    continue block15;
                }
                case 9: {
                    bl2 = zza.c((Parcel)parcel, (int)n4);
                    continue block15;
                }
                case 10: {
                    f6 = zza.j((Parcel)parcel, (int)n4);
                    continue block15;
                }
                case 11: {
                    f7 = zza.j((Parcel)parcel, (int)n4);
                    continue block15;
                }
                case 12: {
                    f8 = zza.j((Parcel)parcel, (int)n4);
                    continue block15;
                }
                case 13: 
            }
            bl3 = zza.c((Parcel)parcel, (int)n4);
        }
        if (parcel.dataPosition() != n2) {
            throw new zza.zza("Overread allowed size end=" + n2, parcel);
        }
        return new GroundOverlayOptions(n3, iBinder, latLng, f2, f3, latLngBounds, f4, f5, bl2, f6, f7, f8, bl3);
    }

    public GroundOverlayOptions[] a(int n2) {
        return new GroundOverlayOptions[n2];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return this.a(parcel);
    }

    public /* synthetic */ Object[] newArray(int n2) {
        return this.a(n2);
    }
}

