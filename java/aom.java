/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.content.ComponentName
 *  android.content.Context
 *  android.content.Intent
 *  android.content.pm.ActivityInfo
 *  android.content.pm.PackageManager
 *  android.content.pm.ResolveInfo
 *  android.os.Build
 *  android.util.Log
 *  java.lang.Class
 *  java.lang.Exception
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.Throwable
 *  java.util.Iterator
 *  java.util.LinkedList
 *  java.util.List
 */
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.Build;
import android.util.Log;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import me.leolin.shortcutbadger.ShortcutBadgeException;
import me.leolin.shortcutbadger.impl.AdwHomeBadger;
import me.leolin.shortcutbadger.impl.ApexHomeBadger;
import me.leolin.shortcutbadger.impl.AsusHomeLauncher;
import me.leolin.shortcutbadger.impl.DefaultBadger;
import me.leolin.shortcutbadger.impl.NewHtcHomeBadger;
import me.leolin.shortcutbadger.impl.NovaHomeBadger;
import me.leolin.shortcutbadger.impl.SolidHomeBadger;
import me.leolin.shortcutbadger.impl.SonyHomeBadger;
import me.leolin.shortcutbadger.impl.XiaomiHomeBadger;

public final class aom {
    private static final String a = aom.class.getSimpleName();
    private static final List<Class<? extends aol>> b = new LinkedList();
    private static aol c;
    private static ComponentName d;

    static {
        b.add((Object)AdwHomeBadger.class);
        b.add((Object)ApexHomeBadger.class);
        b.add((Object)NewHtcHomeBadger.class);
        b.add((Object)NovaHomeBadger.class);
        b.add((Object)SolidHomeBadger.class);
        b.add((Object)SonyHomeBadger.class);
        b.add((Object)XiaomiHomeBadger.class);
        b.add((Object)AsusHomeLauncher.class);
    }

    private aom() {
    }

    public static boolean a(Context context) {
        return aom.a(context, 0);
    }

    public static boolean a(Context context, int n2) {
        try {
            aom.b(context, n2);
            return true;
        }
        catch (ShortcutBadgeException var2_2) {
            Log.e((String)a, (String)("Unable to execute badge:" + var2_2.getMessage()));
            return false;
        }
    }

    private static void b(Context context) {
        try {
            d = context.getPackageManager().getLaunchIntentForPackage(context.getPackageName()).getComponent();
            Log.d((String)a, (String)"Finding badger");
            Intent intent = new Intent("android.intent.action.MAIN");
            intent.addCategory("android.intent.category.HOME");
            String string2 = context.getPackageManager().resolveActivity((Intent)intent, (int)65536).activityInfo.packageName;
            Iterator iterator = b.iterator();
            while (iterator.hasNext()) {
                aol aol2 = (aol)((Class)iterator.next()).newInstance();
                if (!aol2.a().contains((Object)string2)) continue;
                c = aol2;
                break;
            }
            if (c == null && Build.MANUFACTURER.equalsIgnoreCase("Xiaomi")) {
                c = new XiaomiHomeBadger();
                return;
            }
        }
        catch (Exception var1_5) {
            Log.e((String)a, (String)var1_5.getMessage(), (Throwable)var1_5);
        }
        if (c == null) {
            c = new DefaultBadger();
        }
        Log.d((String)a, (String)("Current badger:" + c.getClass().getCanonicalName()));
    }

    public static void b(Context context, int n2) throws ShortcutBadgeException {
        if (c == null) {
            aom.b(context);
        }
        try {
            c.a(context, d, n2);
            return;
        }
        catch (Throwable var2_2) {
            throw new ShortcutBadgeException("Unable to execute badge:" + var2_2.getMessage());
        }
    }
}

