/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.annotation.TargetApi
 *  android.app.AppOpsManager
 *  android.content.Context
 *  android.content.pm.ApplicationInfo
 *  android.content.pm.PackageInfo
 *  android.content.pm.PackageManager
 *  android.content.pm.PackageManager$NameNotFoundException
 *  java.lang.Object
 *  java.lang.SecurityException
 *  java.lang.String
 */
import android.annotation.TargetApi;
import android.app.AppOpsManager;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;

public class abm {
    protected final Context a;

    public abm(Context context) {
        this.a = context;
    }

    public ApplicationInfo a(String string2, int n2) throws PackageManager.NameNotFoundException {
        return this.a.getPackageManager().getApplicationInfo(string2, n2);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    @TargetApi(value=19)
    public boolean a(int n2, String string2) {
        if (zl.f()) {
            try {
                ((AppOpsManager)this.a.getSystemService("appops")).checkPackage(n2, string2);
                return true;
            }
            catch (SecurityException securityException) {
                return false;
            }
        }
        String[] arrstring = this.a.getPackageManager().getPackagesForUid(n2);
        boolean bl2 = false;
        if (string2 == null) return bl2;
        bl2 = false;
        if (arrstring == null) return bl2;
        int n3 = 0;
        do {
            int n4 = arrstring.length;
            bl2 = false;
            if (n3 >= n4) return bl2;
            if (string2.equals((Object)arrstring[n3])) {
                return true;
            }
            ++n3;
        } while (true);
    }

    public PackageInfo b(String string2, int n2) throws PackageManager.NameNotFoundException {
        return this.a.getPackageManager().getPackageInfo(string2, n2);
    }
}

