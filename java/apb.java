/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.annotation.TargetApi
 *  android.content.Context
 *  android.content.pm.ApplicationInfo
 *  android.content.pm.PackageInfo
 *  android.content.pm.PackageManager
 *  android.content.pm.PackageManager$NameNotFoundException
 *  android.os.Build
 *  android.os.Build$VERSION
 *  java.lang.Integer
 *  java.lang.Object
 *  java.lang.RuntimeException
 *  java.lang.String
 */
import android.annotation.TargetApi;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;

public final class apb {
    private static final dq<String, Integer> a = new dq(8);
    private static volatile int b;

    static {
        a.put("com.android.voicemail.permission.ADD_VOICEMAIL", 14);
        a.put("android.permission.BODY_SENSORS", 20);
        a.put("android.permission.READ_CALL_LOG", 16);
        a.put("android.permission.READ_EXTERNAL_STORAGE", 16);
        a.put("android.permission.USE_SIP", 9);
        a.put("android.permission.WRITE_CALL_LOG", 16);
        a.put("android.permission.SYSTEM_ALERT_WINDOW", 23);
        a.put("android.permission.WRITE_SETTINGS", 23);
        b = -1;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    @TargetApi(value=4)
    public static int a(Context context) {
        if (b != -1) {
            return b;
        }
        try {
            b = context.getPackageManager().getPackageInfo((String)context.getPackageName(), (int)0).applicationInfo.targetSdkVersion;
            do {
                return b;
                break;
            } while (true);
        }
        catch (PackageManager.NameNotFoundException var1_1) {
            return b;
        }
    }

    private static boolean a(Context context, String string2) {
        try {
            int n2 = bq.a(context, string2);
            boolean bl2 = false;
            if (n2 == 0) {
                bl2 = true;
            }
            return bl2;
        }
        catch (RuntimeException var2_4) {
            return false;
        }
    }

    public static /* varargs */ boolean a(Context context, String ... arrstring) {
        for (String string2 : arrstring) {
            if (!apb.a(string2) || apb.a(context, string2)) continue;
            return false;
        }
        return true;
    }

    private static boolean a(String string2) {
        Integer n2 = a.get(string2);
        if (n2 == null || Build.VERSION.SDK_INT >= n2) {
            return true;
        }
        return false;
    }

    /*
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    public static /* varargs */ boolean a(int ... arrn) {
        if (arrn.length == 0) {
            return false;
        }
        int n2 = arrn.length;
        int n3 = 0;
        while (n3 < n2) {
            if (arrn[n3] != 0) return false;
            ++n3;
        }
        return true;
    }
}

