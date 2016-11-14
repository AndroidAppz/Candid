package defpackage;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.measurement.internal.EventParams;
import com.google.android.gms.measurement.internal.EventParcel;

public class agq implements Creator<EventParcel> {
    public static void a(EventParcel eventParcel, Parcel parcel, int i) {
        int a = xo.a(parcel);
        xo.a(parcel, 1, eventParcel.a);
        xo.a(parcel, 2, eventParcel.b, false);
        xo.a(parcel, 3, eventParcel.c, i, false);
        xo.a(parcel, 4, eventParcel.d, false);
        xo.a(parcel, 5, eventParcel.e);
        xo.a(parcel, a);
    }

    public EventParcel a(Parcel parcel) {
        String str = null;
        int b = zza.b(parcel);
        int i = 0;
        long j = 0;
        EventParams eventParams = null;
        String str2 = null;
        while (parcel.dataPosition() < b) {
            int a = zza.a(parcel);
            switch (zza.a(a)) {
                case um$h.com_facebook_profile_picture_view_com_facebook_is_cropped /*1*/:
                    i = zza.f(parcel, a);
                    break;
                case um$h.com_facebook_login_view_com_facebook_logout_text /*2*/:
                    str2 = zza.n(parcel, a);
                    break;
                case um$h.com_facebook_login_view_com_facebook_tooltip_mode /*3*/:
                    eventParams = (EventParams) zza.a(parcel, a, EventParams.CREATOR);
                    break;
                case um$h.com_facebook_like_view_com_facebook_auxiliary_view_position /*4*/:
                    str = zza.n(parcel, a);
                    break;
                case um$h.com_facebook_like_view_com_facebook_horizontal_alignment /*5*/:
                    j = zza.h(parcel, a);
                    break;
                default:
                    zza.b(parcel, a);
                    break;
            }
        }
        if (parcel.dataPosition() == b) {
            return new EventParcel(i, str2, eventParams, str, j);
        }
        throw new zza.zza("Overread allowed size end=" + b, parcel);
    }

    public EventParcel[] a(int i) {
        return new EventParcel[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return a(i);
    }
}
