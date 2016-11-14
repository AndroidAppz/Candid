package defpackage;

import android.database.CursorWindow;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.internal.safeparcel.zza;

public class xn implements Creator<DataHolder> {
    public static void a(DataHolder dataHolder, Parcel parcel, int i) {
        int a = xo.a(parcel);
        xo.a(parcel, 1, dataHolder.c(), false);
        xo.a(parcel, 2, dataHolder.d(), i, false);
        xo.a(parcel, 3, dataHolder.e());
        xo.a(parcel, 4, dataHolder.f(), false);
        xo.a(parcel, 1000, dataHolder.b());
        xo.a(parcel, a);
    }

    public DataHolder a(Parcel parcel) {
        int i = 0;
        Bundle bundle = null;
        int b = zza.b(parcel);
        CursorWindow[] cursorWindowArr = null;
        String[] strArr = null;
        int i2 = 0;
        while (parcel.dataPosition() < b) {
            int a = zza.a(parcel);
            switch (zza.a(a)) {
                case um$h.com_facebook_profile_picture_view_com_facebook_is_cropped /*1*/:
                    strArr = zza.q(parcel, a);
                    break;
                case um$h.com_facebook_login_view_com_facebook_logout_text /*2*/:
                    cursorWindowArr = (CursorWindow[]) zza.b(parcel, a, CursorWindow.CREATOR);
                    break;
                case um$h.com_facebook_login_view_com_facebook_tooltip_mode /*3*/:
                    i = zza.f(parcel, a);
                    break;
                case um$h.com_facebook_like_view_com_facebook_auxiliary_view_position /*4*/:
                    bundle = zza.p(parcel, a);
                    break;
                case 1000:
                    i2 = zza.f(parcel, a);
                    break;
                default:
                    zza.b(parcel, a);
                    break;
            }
        }
        if (parcel.dataPosition() != b) {
            throw new zza.zza("Overread allowed size end=" + b, parcel);
        }
        DataHolder dataHolder = new DataHolder(i2, strArr, cursorWindowArr, i, bundle);
        dataHolder.a();
        return dataHolder;
    }

    public DataHolder[] a(int i) {
        return new DataHolder[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return a(i);
    }
}
