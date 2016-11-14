package defpackage;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Build.VERSION;

/* compiled from: PermissionUtils */
public final class apb {
    private static final dq<String, Integer> a = new dq(8);
    private static volatile int b = -1;

    static {
        a.put("com.android.voicemail.permission.ADD_VOICEMAIL", Integer.valueOf(14));
        a.put("android.permission.BODY_SENSORS", Integer.valueOf(20));
        a.put("android.permission.READ_CALL_LOG", Integer.valueOf(16));
        a.put("android.permission.READ_EXTERNAL_STORAGE", Integer.valueOf(16));
        a.put("android.permission.USE_SIP", Integer.valueOf(9));
        a.put("android.permission.WRITE_CALL_LOG", Integer.valueOf(16));
        a.put("android.permission.SYSTEM_ALERT_WINDOW", Integer.valueOf(23));
        a.put("android.permission.WRITE_SETTINGS", Integer.valueOf(23));
    }

    public static boolean a(int... grantResults) {
        if (grantResults.length == 0) {
            return false;
        }
        for (int result : grantResults) {
            if (result != 0) {
                return false;
            }
        }
        return true;
    }

    private static boolean a(String permission) {
        Integer minVersion = (Integer) a.get(permission);
        return minVersion == null || VERSION.SDK_INT >= minVersion.intValue();
    }

    public static boolean a(Context context, String... permissions) {
        for (String permission : permissions) {
            if (apb.a(permission) && !apb.a(context, permission)) {
                return false;
            }
        }
        return true;
    }

    private static boolean a(Context context, String permission) {
        try {
            return bq.a(context, permission) == 0;
        } catch (RuntimeException e) {
            return false;
        }
    }

    @TargetApi(4)
    public static int a(Context context) {
        if (b != -1) {
            return b;
        }
        try {
            b = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).applicationInfo.targetSdkVersion;
        } catch (NameNotFoundException e) {
        }
        return b;
    }
}
