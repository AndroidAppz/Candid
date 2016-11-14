package defpackage;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.util.Base64;
import android.util.Log;

public class zv {
    private static zv a;
    private final Context b;

    private zv(Context context) {
        this.b = context.getApplicationContext();
    }

    public static zv a(Context context) {
        xr.a((Object) context);
        synchronized (zv.class) {
            if (a == null) {
                zt.a(context);
                a = new zv(context);
            }
        }
        return a;
    }

    zt$a a(PackageInfo packageInfo, zt$a... zt_aArr) {
        if (packageInfo.signatures == null) {
            return null;
        }
        if (packageInfo.signatures.length != 1) {
            Log.w("GoogleSignatureVerifier", "Package has more than one signature.");
            return null;
        }
        zt$a zt_b = new zt$b(packageInfo.signatures[0].toByteArray());
        for (int i = 0; i < zt_aArr.length; i++) {
            if (zt_aArr[i].equals(zt_b)) {
                return zt_aArr[i];
            }
        }
        String valueOf = String.valueOf(packageInfo.packageName);
        String valueOf2 = String.valueOf(Base64.encodeToString(zt_b.c(), 0));
        Log.v("GoogleSignatureVerifier", new StringBuilder((String.valueOf(valueOf).length() + 31) + String.valueOf(valueOf2).length()).append(valueOf).append(" signature not valid.  Found: \n").append(valueOf2).toString());
        return null;
    }

    public boolean a(PackageInfo packageInfo, boolean z) {
        if (!(packageInfo == null || packageInfo.signatures == null)) {
            zt$a a;
            if (z) {
                a = a(packageInfo, zt$d.a);
            } else {
                a = a(packageInfo, zt$d.a[0]);
            }
            if (a != null) {
                return true;
            }
        }
        return false;
    }

    public boolean a(PackageManager packageManager, PackageInfo packageInfo) {
        if (packageInfo == null) {
            return false;
        }
        if (zu.zzal(this.b)) {
            return a(packageInfo, true);
        }
        boolean a = a(packageInfo, false);
        if (a || !a(packageInfo, true)) {
            return a;
        }
        Log.w("GoogleSignatureVerifier", "Test-keys aren't accepted on this build.");
        return a;
    }
}
