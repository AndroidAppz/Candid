/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.pm.PackageManager
 *  android.os.Process
 *  android.support.v4.app.AppOpsManagerCompat
 *  java.lang.Object
 *  java.lang.String
 */
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Process;
import android.support.v4.app.AppOpsManagerCompat;

public final class bq {
    public static int a(Context context, String string2) {
        return bq.a(context, string2, Process.myPid(), Process.myUid(), context.getPackageName());
    }

    /*
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    public static int a(Context context, String string2, int n2, int n3, String string3) {
        if (context.checkPermission(string2, n2, n3) == -1) {
            return -1;
        }
        String string4 = AppOpsManagerCompat.permissionToOp((String)string2);
        if (string4 == null) {
            return 0;
        }
        if (string3 == null) {
            String[] arrstring = context.getPackageManager().getPackagesForUid(n3);
            if (arrstring == null) return -1;
            if (arrstring.length <= 0) return -1;
            string3 = arrstring[0];
        }
        if (AppOpsManagerCompat.noteProxyOp((Context)context, (String)string4, (String)string3) == 0) return 0;
        return -2;
    }
}

