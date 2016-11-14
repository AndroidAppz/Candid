package defpackage;

import android.content.Context;
import android.content.pm.PackageManager.NameNotFoundException;

public class ze {
    public static boolean a() {
        return false;
    }

    public static boolean a(Context context, String str) {
        try {
            return (context.getPackageManager().getApplicationInfo(str, 0).flags & 2097152) != 0;
        } catch (NameNotFoundException e) {
            return false;
        }
    }
}
