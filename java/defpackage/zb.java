package defpackage;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.stats.WakeLockEvent;
import java.util.List;

public class zb implements Creator<WakeLockEvent> {
    public static void a(WakeLockEvent wakeLockEvent, Parcel parcel, int i) {
        int a = xo.a(parcel);
        xo.a(parcel, 1, wakeLockEvent.a);
        xo.a(parcel, 2, wakeLockEvent.a());
        xo.a(parcel, 4, wakeLockEvent.c(), false);
        xo.a(parcel, 5, wakeLockEvent.f());
        xo.b(parcel, 6, wakeLockEvent.g(), false);
        xo.a(parcel, 8, wakeLockEvent.j());
        xo.a(parcel, 10, wakeLockEvent.d(), false);
        xo.a(parcel, 11, wakeLockEvent.b());
        xo.a(parcel, 12, wakeLockEvent.h(), false);
        xo.a(parcel, 13, wakeLockEvent.m(), false);
        xo.a(parcel, 14, wakeLockEvent.k());
        xo.a(parcel, 15, wakeLockEvent.n());
        xo.a(parcel, 16, wakeLockEvent.o());
        xo.a(parcel, 17, wakeLockEvent.e(), false);
        xo.a(parcel, a);
    }

    public WakeLockEvent a(Parcel parcel) {
        int b = zza.b(parcel);
        int i = 0;
        long j = 0;
        int i2 = 0;
        String str = null;
        int i3 = 0;
        List list = null;
        String str2 = null;
        long j2 = 0;
        int i4 = 0;
        String str3 = null;
        String str4 = null;
        float f = 0.0f;
        long j3 = 0;
        String str5 = null;
        while (parcel.dataPosition() < b) {
            int a = zza.a(parcel);
            switch (zza.a(a)) {
                case um$h.com_facebook_profile_picture_view_com_facebook_is_cropped /*1*/:
                    i = zza.f(parcel, a);
                    break;
                case um$h.com_facebook_login_view_com_facebook_logout_text /*2*/:
                    j = zza.h(parcel, a);
                    break;
                case um$h.com_facebook_like_view_com_facebook_auxiliary_view_position /*4*/:
                    str = zza.n(parcel, a);
                    break;
                case um$h.com_facebook_like_view_com_facebook_horizontal_alignment /*5*/:
                    i3 = zza.f(parcel, a);
                    break;
                case um$h.CardView_cardUseCompatPadding /*6*/:
                    list = zza.s(parcel, a);
                    break;
                case um$h.CardView_contentPadding /*8*/:
                    j2 = zza.h(parcel, a);
                    break;
                case um$h.CardView_contentPaddingRight /*10*/:
                    str3 = zza.n(parcel, a);
                    break;
                case um$h.CardView_contentPaddingTop /*11*/:
                    i2 = zza.f(parcel, a);
                    break;
                case um$h.CardView_contentPaddingBottom /*12*/:
                    str2 = zza.n(parcel, a);
                    break;
                case ha$a.Toolbar_titleMarginStart /*13*/:
                    str4 = zza.n(parcel, a);
                    break;
                case ha$a.Toolbar_titleMarginEnd /*14*/:
                    i4 = zza.f(parcel, a);
                    break;
                case ha$a.Toolbar_titleMarginTop /*15*/:
                    f = zza.j(parcel, a);
                    break;
                case ha$a.Toolbar_titleMarginBottom /*16*/:
                    j3 = zza.h(parcel, a);
                    break;
                case ha$a.Toolbar_maxButtonHeight /*17*/:
                    str5 = zza.n(parcel, a);
                    break;
                default:
                    zza.b(parcel, a);
                    break;
            }
        }
        if (parcel.dataPosition() == b) {
            return new WakeLockEvent(i, j, i2, str, i3, list, str2, j2, i4, str3, str4, f, j3, str5);
        }
        throw new zza.zza("Overread allowed size end=" + b, parcel);
    }

    public WakeLockEvent[] a(int i) {
        return new WakeLockEvent[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return a(i);
    }
}
