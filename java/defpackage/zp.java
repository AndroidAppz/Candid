package defpackage;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.WorkSource;
import android.util.Log;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class zp {
    private static final Method a = zp.a();
    private static final Method b = zp.b();
    private static final Method c = zp.c();
    private static final Method d = zp.d();
    private static final Method e = zp.e();

    public static int a(WorkSource workSource) {
        if (c != null) {
            try {
                return ((Integer) c.invoke(workSource, new Object[0])).intValue();
            } catch (Throwable e) {
                Log.wtf("WorkSourceUtil", "Unable to assign blame through WorkSource", e);
            }
        }
        return 0;
    }

    public static WorkSource a(int i, String str) {
        WorkSource workSource = new WorkSource();
        zp.a(workSource, i, str);
        return workSource;
    }

    public static WorkSource a(Context context, String str) {
        String str2;
        String str3;
        String valueOf;
        if (context == null || context.getPackageManager() == null) {
            return null;
        }
        try {
            ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(str, 0);
            if (applicationInfo != null) {
                return zp.a(applicationInfo.uid, str);
            }
            str2 = "WorkSourceUtil";
            str3 = "Could not get applicationInfo from package: ";
            valueOf = String.valueOf(str);
            Log.e(str2, valueOf.length() != 0 ? str3.concat(valueOf) : new String(str3));
            return null;
        } catch (NameNotFoundException e) {
            str2 = "WorkSourceUtil";
            str3 = "Could not find package: ";
            valueOf = String.valueOf(str);
            Log.e(str2, valueOf.length() != 0 ? str3.concat(valueOf) : new String(str3));
            return null;
        }
    }

    public static String a(WorkSource workSource, int i) {
        if (e != null) {
            try {
                return (String) e.invoke(workSource, new Object[]{Integer.valueOf(i)});
            } catch (Throwable e) {
                Log.wtf("WorkSourceUtil", "Unable to assign blame through WorkSource", e);
            }
        }
        return null;
    }

    private static Method a() {
        Method method = null;
        try {
            method = WorkSource.class.getMethod("add", new Class[]{Integer.TYPE});
        } catch (Exception e) {
        }
        return method;
    }

    public static void a(WorkSource workSource, int i, String str) {
        if (b != null) {
            if (str == null) {
                str = "";
            }
            try {
                b.invoke(workSource, new Object[]{Integer.valueOf(i), str});
            } catch (Throwable e) {
                Log.wtf("WorkSourceUtil", "Unable to assign blame through WorkSource", e);
            }
        } else if (a != null) {
            try {
                a.invoke(workSource, new Object[]{Integer.valueOf(i)});
            } catch (Throwable e2) {
                Log.wtf("WorkSourceUtil", "Unable to assign blame through WorkSource", e2);
            }
        }
    }

    public static boolean a(Context context) {
        if (context == null) {
            return false;
        }
        PackageManager packageManager = context.getPackageManager();
        return packageManager != null && packageManager.checkPermission("android.permission.UPDATE_DEVICE_STATS", context.getPackageName()) == 0;
    }

    private static Method b() {
        Method method = null;
        if (zl.e()) {
            try {
                method = WorkSource.class.getMethod("add", new Class[]{Integer.TYPE, String.class});
            } catch (Exception e) {
            }
        }
        return method;
    }

    public static List<String> b(WorkSource workSource) {
        int i = 0;
        int a = workSource == null ? 0 : zp.a(workSource);
        if (a == 0) {
            return Collections.EMPTY_LIST;
        }
        List<String> arrayList = new ArrayList();
        while (i < a) {
            String a2 = zp.a(workSource, i);
            if (!zn.a(a2)) {
                arrayList.add(a2);
            }
            i++;
        }
        return arrayList;
    }

    private static Method c() {
        Method method = null;
        try {
            method = WorkSource.class.getMethod("size", new Class[0]);
        } catch (Exception e) {
        }
        return method;
    }

    private static Method d() {
        Method method = null;
        try {
            method = WorkSource.class.getMethod("get", new Class[]{Integer.TYPE});
        } catch (Exception e) {
        }
        return method;
    }

    private static Method e() {
        Method method = null;
        if (zl.e()) {
            try {
                method = WorkSource.class.getMethod("getName", new Class[]{Integer.TYPE});
            } catch (Exception e) {
            }
        }
        return method;
    }
}
