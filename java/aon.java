/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.Intent
 *  android.content.pm.PackageManager
 *  java.lang.Object
 *  java.util.List
 */
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import java.util.List;

public class aon {
    public static boolean a(Context context, Intent intent) {
        List list = context.getPackageManager().queryBroadcastReceivers(intent, 0);
        boolean bl2 = false;
        if (list != null) {
            int n2 = list.size();
            bl2 = false;
            if (n2 > 0) {
                bl2 = true;
            }
        }
        return bl2;
    }
}

