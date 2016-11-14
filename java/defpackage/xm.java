package defpackage;

import android.app.PendingIntent;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.safeparcel.zza;

public class xm implements Creator<Status> {
    public static void a(Status status, Parcel parcel, int i) {
        int a = xo.a(parcel);
        xo.a(parcel, 1, status.g());
        xo.a(parcel, 2, status.c(), false);
        xo.a(parcel, 3, status.b(), i, false);
        xo.a(parcel, 1000, status.d());
        xo.a(parcel, a);
    }

    public Status a(Parcel parcel) {
        PendingIntent pendingIntent = null;
        int i = 0;
        int b = zza.b(parcel);
        String str = null;
        int i2 = 0;
        while (parcel.dataPosition() < b) {
            int a = zza.a(parcel);
            switch (zza.a(a)) {
                case um$h.com_facebook_profile_picture_view_com_facebook_is_cropped /*1*/:
                    i = zza.f(parcel, a);
                    break;
                case um$h.com_facebook_login_view_com_facebook_logout_text /*2*/:
                    str = zza.n(parcel, a);
                    break;
                case um$h.com_facebook_login_view_com_facebook_tooltip_mode /*3*/:
                    pendingIntent = (PendingIntent) zza.a(parcel, a, PendingIntent.CREATOR);
                    break;
                case 1000:
                    i2 = zza.f(parcel, a);
                    break;
                default:
                    zza.b(parcel, a);
                    break;
            }
        }
        if (parcel.dataPosition() == b) {
            return new Status(i2, i, str, pendingIntent);
        }
        throw new zza.zza("Overread allowed size end=" + b, parcel);
    }

    public Status[] a(int i) {
        return new Status[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return a(i);
    }
}
