package defpackage;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.measurement.internal.EventParams;

public class agp implements Creator<EventParams> {
    public static void a(EventParams eventParams, Parcel parcel, int i) {
        int a = xo.a(parcel);
        xo.a(parcel, 1, eventParams.a);
        xo.a(parcel, 2, eventParams.b(), false);
        xo.a(parcel, a);
    }

    public EventParams a(Parcel parcel) {
        int b = zza.b(parcel);
        int i = 0;
        Bundle bundle = null;
        while (parcel.dataPosition() < b) {
            int a = zza.a(parcel);
            switch (zza.a(a)) {
                case um$h.com_facebook_profile_picture_view_com_facebook_is_cropped /*1*/:
                    i = zza.f(parcel, a);
                    break;
                case um$h.com_facebook_login_view_com_facebook_logout_text /*2*/:
                    bundle = zza.p(parcel, a);
                    break;
                default:
                    zza.b(parcel, a);
                    break;
            }
        }
        if (parcel.dataPosition() == b) {
            return new EventParams(i, bundle);
        }
        throw new zza.zza("Overread allowed size end=" + b, parcel);
    }

    public EventParams[] a(int i) {
        return new EventParams[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return a(i);
    }
}
