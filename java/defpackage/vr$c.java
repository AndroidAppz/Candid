package defpackage;

import android.content.Context;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.Signature;
import android.os.Build;
import java.util.HashSet;
import java.util.TreeSet;

/* compiled from: NativeProtocol */
abstract class vr$c {
    private static final HashSet<String> a = vr$c.c();
    private TreeSet<Integer> b;

    protected abstract String a();

    private vr$c() {
    }

    private static HashSet<String> c() {
        HashSet<String> set = new HashSet();
        set.add("8a3c4b262d721acd49a4bf97d5213199c86fa2b9");
        set.add("a4b7452e2ed8f5f191058ca7bbfd26b0d3214bfc");
        set.add("5e8f16062ea3cd2c4a0d547876baa6f38cabf625");
        return set;
    }

    public boolean a(Context context, String packageName) {
        String brand = Build.BRAND;
        int applicationFlags = context.getApplicationInfo().flags;
        if (brand.startsWith("generic") && (applicationFlags & 2) != 0) {
            return true;
        }
        try {
            for (Signature signature : context.getPackageManager().getPackageInfo(packageName, 64).signatures) {
                if (a.contains(vw.a(signature.toByteArray()))) {
                    return true;
                }
            }
            return false;
        } catch (NameNotFoundException e) {
            return false;
        }
    }

    public TreeSet<Integer> b() {
        if (this.b == null) {
            a(false);
        }
        return this.b;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private synchronized void a(boolean r2) {
        /*
        r1 = this;
        monitor-enter(r1);
        if (r2 != 0) goto L_0x0007;
    L_0x0003:
        r0 = r1.b;	 Catch:{ all -> 0x000f }
        if (r0 != 0) goto L_0x000d;
    L_0x0007:
        r0 = defpackage.vr.b(r1);	 Catch:{ all -> 0x000f }
        r1.b = r0;	 Catch:{ all -> 0x000f }
    L_0x000d:
        monitor-exit(r1);
        return;
    L_0x000f:
        r0 = move-exception;
        monitor-exit(r1);
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: vr$c.a(boolean):void");
    }
}
