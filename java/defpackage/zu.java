package defpackage;

import android.annotation.TargetApi;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageInstaller.SessionInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.Resources;
import android.net.Uri.Builder;
import android.os.Build;
import android.os.Bundle;
import android.os.UserManager;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.R;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import java.io.InputStream;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicBoolean;

public class zu {
    @Deprecated
    public static final String GOOGLE_PLAY_SERVICES_PACKAGE = "com.google.android.gms";
    @Deprecated
    public static final int GOOGLE_PLAY_SERVICES_VERSION_CODE = zu.zzqZ();
    public static final String GOOGLE_PLAY_STORE_PACKAGE = "com.android.vending";
    public static final AtomicBoolean zzakA = new AtomicBoolean();
    private static final AtomicBoolean zzakB = new AtomicBoolean();
    public static boolean zzaku = false;
    public static boolean zzakv = false;
    static boolean zzakw = false;
    private static String zzakx = null;
    private static int zzaky = GOOGLE_PLAY_SERVICES_VERSION_CODE;
    private static boolean zzakz = false;

    @Deprecated
    public static PendingIntent getErrorPendingIntent(int i, Context context, int i2) {
        return zs.b().a(context, i, i2);
    }

    @Deprecated
    public static String getErrorString(int i) {
        return ConnectionResult.a(i);
    }

    @Deprecated
    public static String getOpenSourceSoftwareLicenseInfo(Context context) {
        InputStream openInputStream;
        try {
            openInputStream = context.getContentResolver().openInputStream(new Builder().scheme("android.resource").authority(GOOGLE_PLAY_SERVICES_PACKAGE).appendPath("raw").appendPath("third_party_licenses").build());
            String next = new Scanner(openInputStream).useDelimiter("\\A").next();
            if (openInputStream == null) {
                return next;
            }
            openInputStream.close();
            return next;
        } catch (NoSuchElementException e) {
            if (openInputStream != null) {
                openInputStream.close();
            }
            return null;
        } catch (Exception e2) {
            return null;
        } catch (Throwable th) {
            if (openInputStream != null) {
                openInputStream.close();
            }
        }
    }

    public static Context getRemoteContext(Context context) {
        try {
            return context.createPackageContext(GOOGLE_PLAY_SERVICES_PACKAGE, 3);
        } catch (NameNotFoundException e) {
            return null;
        }
    }

    public static Resources getRemoteResource(Context context) {
        try {
            return context.getPackageManager().getResourcesForApplication(GOOGLE_PLAY_SERVICES_PACKAGE);
        } catch (NameNotFoundException e) {
            return null;
        }
    }

    @Deprecated
    public static int isGooglePlayServicesAvailable(Context context) {
        PackageManager packageManager = context.getPackageManager();
        try {
            context.getResources().getString(R.string.common_google_play_services_unknown_issue);
        } catch (Throwable th) {
            Log.e("GooglePlayServicesUtil", "The Google Play services resources were not found. Check your project configuration to ensure that the resources are included.");
        }
        if (!GOOGLE_PLAY_SERVICES_PACKAGE.equals(context.getPackageName())) {
            zu.zzaj(context);
        }
        try {
            PackageInfo packageInfo = packageManager.getPackageInfo(GOOGLE_PLAY_SERVICES_PACKAGE, 64);
            zv a = zv.a(context);
            if (!zi.a(context)) {
                try {
                    if (a.a(packageManager.getPackageInfo(GOOGLE_PLAY_STORE_PACKAGE, 8256), zt$d.a) == null) {
                        Log.w("GooglePlayServicesUtil", "Google Play Store signature invalid.");
                        return 9;
                    }
                    if (a.a(packageInfo, a.a(packageManager.getPackageInfo(GOOGLE_PLAY_STORE_PACKAGE, 8256), zt$d.a)) == null) {
                        Log.w("GooglePlayServicesUtil", "Google Play services signature invalid.");
                        return 9;
                    }
                } catch (NameNotFoundException e) {
                    Log.w("GooglePlayServicesUtil", "Google Play Store is neither installed nor updating.");
                    return 9;
                }
            } else if (a.a(packageInfo, zt$d.a) == null) {
                Log.w("GooglePlayServicesUtil", "Google Play services signature invalid.");
                return 9;
            }
            if (zk.a(packageInfo.versionCode) < zk.a(GOOGLE_PLAY_SERVICES_VERSION_CODE)) {
                Log.w("GooglePlayServicesUtil", "Google Play services out of date.  Requires " + GOOGLE_PLAY_SERVICES_VERSION_CODE + " but found " + packageInfo.versionCode);
                return 2;
            }
            ApplicationInfo applicationInfo = packageInfo.applicationInfo;
            if (applicationInfo == null) {
                try {
                    applicationInfo = packageManager.getApplicationInfo(GOOGLE_PLAY_SERVICES_PACKAGE, GOOGLE_PLAY_SERVICES_VERSION_CODE);
                } catch (Throwable e2) {
                    Log.wtf("GooglePlayServicesUtil", "Google Play services missing when getting application info.", e2);
                    return 1;
                }
            }
            return !applicationInfo.enabled ? 3 : GOOGLE_PLAY_SERVICES_VERSION_CODE;
        } catch (NameNotFoundException e3) {
            Log.w("GooglePlayServicesUtil", "Google Play services is missing.");
            return 1;
        }
    }

    @Deprecated
    public static boolean isUserRecoverableError(int i) {
        switch (i) {
            case um$h.com_facebook_profile_picture_view_com_facebook_is_cropped /*1*/:
            case um$h.com_facebook_login_view_com_facebook_logout_text /*2*/:
            case um$h.com_facebook_login_view_com_facebook_tooltip_mode /*3*/:
            case um$h.CardView_contentPaddingLeft /*9*/:
                return true;
            default:
                return false;
        }
    }

    @Deprecated
    public static void zzaa(Context context) throws GooglePlayServicesRepairableException, GooglePlayServicesNotAvailableException {
        int a = zs.b().a(context);
        if (a != 0) {
            Intent a2 = zs.b().a(context, a, "e");
            Log.e("GooglePlayServicesUtil", "GooglePlayServices not available due to error " + a);
            if (a2 == null) {
                throw new GooglePlayServicesNotAvailableException(a);
            }
            throw new GooglePlayServicesRepairableException(a, "Google Play Services not available", a2);
        }
    }

    @Deprecated
    public static int zzae(Context context) {
        int i = GOOGLE_PLAY_SERVICES_VERSION_CODE;
        try {
            return context.getPackageManager().getPackageInfo(GOOGLE_PLAY_SERVICES_PACKAGE, GOOGLE_PLAY_SERVICES_VERSION_CODE).versionCode;
        } catch (NameNotFoundException e) {
            Log.w("GooglePlayServicesUtil", "Google Play services is missing.");
            return i;
        }
    }

    @Deprecated
    public static void zzag(Context context) {
        if (!zzakA.getAndSet(true)) {
            try {
                ((NotificationManager) context.getSystemService("notification")).cancel(10436);
            } catch (SecurityException e) {
            }
        }
    }

    private static void zzaj(Context context) {
        if (!zzakB.get()) {
            zu.zzao(context);
            if (zzaky == 0) {
                throw new IllegalStateException("A required meta-data tag in your app's AndroidManifest.xml does not exist.  You must have the following declaration within the <application> element:     <meta-data android:name=\"com.google.android.gms.version\" android:value=\"@integer/google_play_services_version\" />");
            } else if (zzaky != GOOGLE_PLAY_SERVICES_VERSION_CODE) {
                int i = GOOGLE_PLAY_SERVICES_VERSION_CODE;
                int i2 = zzaky;
                String valueOf = String.valueOf("com.google.android.gms.version");
                throw new IllegalStateException(new StringBuilder(String.valueOf(valueOf).length() + 290).append("The meta-data tag in your app's AndroidManifest.xml does not have the right value.  Expected ").append(i).append(" but found ").append(i2).append(".  You must have the following declaration within the <application> element:     <meta-data android:name=\"").append(valueOf).append("\" android:value=\"@integer/google_play_services_version\" />").toString());
            }
        }
    }

    public static boolean zzak(Context context) {
        zu.zzao(context);
        return zzakw;
    }

    public static boolean zzal(Context context) {
        return zu.zzak(context) || !zu.zzra();
    }

    public static String zzam(Context context) {
        Object obj = context.getApplicationInfo().name;
        if (!TextUtils.isEmpty(obj)) {
            return obj;
        }
        ApplicationInfo a;
        String packageName = context.getPackageName();
        PackageManager packageManager = context.getApplicationContext().getPackageManager();
        try {
            a = abn.b(context).a(context.getPackageName(), (int) GOOGLE_PLAY_SERVICES_VERSION_CODE);
        } catch (NameNotFoundException e) {
            a = null;
        }
        return a != null ? packageManager.getApplicationLabel(a).toString() : packageName;
    }

    @TargetApi(18)
    public static boolean zzan(Context context) {
        if (zl.e()) {
            Bundle applicationRestrictions = ((UserManager) context.getSystemService("user")).getApplicationRestrictions(context.getPackageName());
            if (applicationRestrictions != null && "true".equals(applicationRestrictions.getString("restricted_profile"))) {
                return true;
            }
        }
        return false;
    }

    private static void zzao(Context context) {
        if (!zzakz) {
            zu.zzap(context);
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static void zzap(android.content.Context r7) {
        /*
        r6 = 1;
        r0 = r7.getPackageName();	 Catch:{ NameNotFoundException -> 0x003a }
        zzakx = r0;	 Catch:{ NameNotFoundException -> 0x003a }
        r0 = defpackage.abn.b(r7);	 Catch:{ NameNotFoundException -> 0x003a }
        r1 = defpackage.yt.b(r7);	 Catch:{ NameNotFoundException -> 0x003a }
        zzaky = r1;	 Catch:{ NameNotFoundException -> 0x003a }
        r1 = "com.google.android.gms";
        r2 = 64;
        r0 = r0.b(r1, r2);	 Catch:{ NameNotFoundException -> 0x003a }
        if (r0 == 0) goto L_0x0036;
    L_0x001b:
        r1 = defpackage.zv.a(r7);	 Catch:{ NameNotFoundException -> 0x003a }
        r2 = 1;
        r2 = new defpackage.zt$a[r2];	 Catch:{ NameNotFoundException -> 0x003a }
        r3 = 0;
        r4 = defpackage.zt$d.a;	 Catch:{ NameNotFoundException -> 0x003a }
        r5 = 1;
        r4 = r4[r5];	 Catch:{ NameNotFoundException -> 0x003a }
        r2[r3] = r4;	 Catch:{ NameNotFoundException -> 0x003a }
        r0 = r1.a(r0, r2);	 Catch:{ NameNotFoundException -> 0x003a }
        if (r0 == 0) goto L_0x0036;
    L_0x0030:
        r0 = 1;
        zzakw = r0;	 Catch:{ NameNotFoundException -> 0x003a }
    L_0x0033:
        zzakz = r6;
    L_0x0035:
        return;
    L_0x0036:
        r0 = 0;
        zzakw = r0;	 Catch:{ NameNotFoundException -> 0x003a }
        goto L_0x0033;
    L_0x003a:
        r0 = move-exception;
        r1 = "GooglePlayServicesUtil";
        r2 = "Cannot find Google Play services package name.";
        android.util.Log.w(r1, r2, r0);	 Catch:{ all -> 0x0045 }
        zzakz = r6;
        goto L_0x0035;
    L_0x0045:
        r0 = move-exception;
        zzakz = r6;
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: zu.zzap(android.content.Context):void");
    }

    @Deprecated
    public static Intent zzbC(int i) {
        return zs.b().a(null, i, null);
    }

    public static boolean zzbD(int i) {
        switch (i) {
            case um$h.com_facebook_profile_picture_view_com_facebook_is_cropped /*1*/:
            case um$h.com_facebook_login_view_com_facebook_logout_text /*2*/:
            case um$h.com_facebook_login_view_com_facebook_tooltip_mode /*3*/:
            case ha$a.Toolbar_collapseIcon /*18*/:
            case ha$a.AppCompatTheme_dialogTheme /*42*/:
                return true;
            default:
                return false;
        }
    }

    @Deprecated
    public static boolean zzc(Context context, int i) {
        return i == 18 ? true : i == 1 ? zu.zzk(context, GOOGLE_PLAY_SERVICES_PACKAGE) : false;
    }

    @Deprecated
    public static boolean zzd(Context context, int i) {
        return i == 9 ? zu.zzk(context, GOOGLE_PLAY_STORE_PACKAGE) : false;
    }

    @Deprecated
    public static boolean zze(Context context, int i) {
        return zo.a(context, i);
    }

    @TargetApi(21)
    static boolean zzk(Context context, String str) {
        if (zl.h()) {
            for (SessionInfo appPackageName : context.getPackageManager().getPackageInstaller().getAllSessions()) {
                if (str.equals(appPackageName.getAppPackageName())) {
                    return true;
                }
            }
        }
        if (zu.zzan(context)) {
            return false;
        }
        try {
            return context.getPackageManager().getApplicationInfo(str, 8192).enabled;
        } catch (NameNotFoundException e) {
            return false;
        }
    }

    private static int zzqZ() {
        return yb.a;
    }

    @Deprecated
    public static boolean zzra() {
        return "user".equals(Build.TYPE);
    }
}
