package defpackage;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager.NameNotFoundException;
import android.text.TextUtils;

public class zs {
    private static final zs a = new zs();
    public static final int b = zu.GOOGLE_PLAY_SERVICES_VERSION_CODE;

    zs() {
    }

    private String b(Context context, String str) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("gcore_");
        stringBuilder.append(b);
        stringBuilder.append("-");
        if (!TextUtils.isEmpty(str)) {
            stringBuilder.append(str);
        }
        stringBuilder.append("-");
        if (context != null) {
            stringBuilder.append(context.getPackageName());
        }
        stringBuilder.append("-");
        if (context != null) {
            try {
                stringBuilder.append(context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode);
            } catch (NameNotFoundException e) {
            }
        }
        return stringBuilder.toString();
    }

    public static zs b() {
        return a;
    }

    public int a(Context context) {
        int isGooglePlayServicesAvailable = zu.isGooglePlayServicesAvailable(context);
        return zu.zzc(context, isGooglePlayServicesAvailable) ? 18 : isGooglePlayServicesAvailable;
    }

    public PendingIntent a(Context context, int i, int i2) {
        return a(context, i, i2, null);
    }

    public PendingIntent a(Context context, int i, int i2, String str) {
        if (zi.a(context) && i == 2) {
            i = 42;
        }
        Intent a = a(context, i, str);
        return a == null ? null : PendingIntent.getActivity(context, i2, a, 268435456);
    }

    public Intent a(Context context, int i, String str) {
        switch (i) {
            case um$h.com_facebook_profile_picture_view_com_facebook_is_cropped /*1*/:
            case um$h.com_facebook_login_view_com_facebook_logout_text /*2*/:
                return yk.a(zu.GOOGLE_PLAY_SERVICES_PACKAGE, b(context, str));
            case um$h.com_facebook_login_view_com_facebook_tooltip_mode /*3*/:
                return yk.a(zu.GOOGLE_PLAY_SERVICES_PACKAGE);
            case ha$a.AppCompatTheme_dialogTheme /*42*/:
                return yk.a();
            default:
                return null;
        }
    }

    public boolean a(int i) {
        return zu.isUserRecoverableError(i);
    }

    public boolean a(Context context, String str) {
        return zu.zzk(context, str);
    }
}
