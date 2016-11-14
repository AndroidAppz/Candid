package defpackage;

import android.annotation.TargetApi;
import android.app.AppOpsManager;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager.NameNotFoundException;

public class abm {
    protected final Context a;

    public abm(Context context) {
        this.a = context;
    }

    public ApplicationInfo a(String str, int i) throws NameNotFoundException {
        return this.a.getPackageManager().getApplicationInfo(str, i);
    }

    @TargetApi(19)
    public boolean a(int i, String str) {
        if (zl.f()) {
            try {
                ((AppOpsManager) this.a.getSystemService("appops")).checkPackage(i, str);
                return true;
            } catch (SecurityException e) {
                return false;
            }
        }
        String[] packagesForUid = this.a.getPackageManager().getPackagesForUid(i);
        if (str == null || packagesForUid == null) {
            return false;
        }
        for (Object equals : packagesForUid) {
            if (str.equals(equals)) {
                return true;
            }
        }
        return false;
    }

    public PackageInfo b(String str, int i) throws NameNotFoundException {
        return this.a.getPackageManager().getPackageInfo(str, i);
    }
}
