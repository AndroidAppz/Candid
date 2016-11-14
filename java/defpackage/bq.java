package defpackage;

import android.content.Context;
import android.os.Process;
import android.support.v4.app.AppOpsManagerCompat;

/* compiled from: PermissionChecker */
public final class bq {
    public static int a(Context context, String permission, int pid, int uid, String packageName) {
        if (context.checkPermission(permission, pid, uid) == -1) {
            return -1;
        }
        String op = AppOpsManagerCompat.permissionToOp(permission);
        if (op == null) {
            return 0;
        }
        if (packageName == null) {
            String[] packageNames = context.getPackageManager().getPackagesForUid(uid);
            if (packageNames == null || packageNames.length <= 0) {
                return -1;
            }
            packageName = packageNames[0];
        }
        return AppOpsManagerCompat.noteProxyOp(context, op, packageName) != 0 ? -2 : 0;
    }

    public static int a(Context context, String permission) {
        return bq.a(context, permission, Process.myPid(), Process.myUid(), context.getPackageName());
    }
}
