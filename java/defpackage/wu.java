package defpackage;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.safeparcel.zza;
import java.util.List;

public class wu implements Creator<GoogleSignInAccount> {
    public static void a(GoogleSignInAccount googleSignInAccount, Parcel parcel, int i) {
        int a = xo.a(parcel);
        xo.a(parcel, 1, googleSignInAccount.b);
        xo.a(parcel, 2, googleSignInAccount.a(), false);
        xo.a(parcel, 3, googleSignInAccount.b(), false);
        xo.a(parcel, 4, googleSignInAccount.c(), false);
        xo.a(parcel, 5, googleSignInAccount.d(), false);
        xo.a(parcel, 6, googleSignInAccount.g(), i, false);
        xo.a(parcel, 7, googleSignInAccount.h(), false);
        xo.a(parcel, 8, googleSignInAccount.i());
        xo.a(parcel, 9, googleSignInAccount.j(), false);
        xo.c(parcel, 10, googleSignInAccount.c, false);
        xo.a(parcel, 11, googleSignInAccount.e(), false);
        xo.a(parcel, 12, googleSignInAccount.f(), false);
        xo.a(parcel, a);
    }

    public GoogleSignInAccount a(Parcel parcel) {
        int b = zza.b(parcel);
        int i = 0;
        String str = null;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        Uri uri = null;
        String str5 = null;
        long j = 0;
        String str6 = null;
        List list = null;
        String str7 = null;
        String str8 = null;
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
                    str2 = zza.n(parcel, a);
                    break;
                case um$h.com_facebook_like_view_com_facebook_auxiliary_view_position /*4*/:
                    str3 = zza.n(parcel, a);
                    break;
                case um$h.com_facebook_like_view_com_facebook_horizontal_alignment /*5*/:
                    str4 = zza.n(parcel, a);
                    break;
                case um$h.CardView_cardUseCompatPadding /*6*/:
                    uri = (Uri) zza.a(parcel, a, Uri.CREATOR);
                    break;
                case um$h.CardView_cardPreventCornerOverlap /*7*/:
                    str5 = zza.n(parcel, a);
                    break;
                case um$h.CardView_contentPadding /*8*/:
                    j = zza.h(parcel, a);
                    break;
                case um$h.CardView_contentPaddingLeft /*9*/:
                    str6 = zza.n(parcel, a);
                    break;
                case um$h.CardView_contentPaddingRight /*10*/:
                    list = zza.c(parcel, a, Scope.CREATOR);
                    break;
                case um$h.CardView_contentPaddingTop /*11*/:
                    str7 = zza.n(parcel, a);
                    break;
                case um$h.CardView_contentPaddingBottom /*12*/:
                    str8 = zza.n(parcel, a);
                    break;
                default:
                    zza.b(parcel, a);
                    break;
            }
        }
        if (parcel.dataPosition() == b) {
            return new GoogleSignInAccount(i, str, str2, str3, str4, uri, str5, j, str6, list, str7, str8);
        }
        throw new zza.zza("Overread allowed size end=" + b, parcel);
    }

    public GoogleSignInAccount[] a(int i) {
        return new GoogleSignInAccount[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return a(i);
    }
}
