package defpackage;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.util.Log;
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

/* compiled from: ShortcutBadger */
public final class aom {
    private static final String a = aom.class.getSimpleName();
    private static final List<Class<? extends aol>> b = new LinkedList();
    private static aol c;
    private static ComponentName d;

    static {
        b.add(AdwHomeBadger.class);
        b.add(ApexHomeBadger.class);
        b.add(NewHtcHomeBadger.class);
        b.add(NovaHomeBadger.class);
        b.add(SolidHomeBadger.class);
        b.add(SonyHomeBadger.class);
        b.add(XiaomiHomeBadger.class);
        b.add(AsusHomeLauncher.class);
    }

    public static boolean a(Context context, int badgeCount) {
        try {
            aom.b(context, badgeCount);
            return true;
        } catch (ShortcutBadgeException e) {
            Log.e(a, "Unable to execute badge:" + e.getMessage());
            return false;
        }
    }

    public static void b(Context context, int badgeCount) throws ShortcutBadgeException {
        if (c == null) {
            aom.b(context);
        }
        try {
            c.a(context, d, badgeCount);
        } catch (Throwable e) {
            ShortcutBadgeException shortcutBadgeException = new ShortcutBadgeException("Unable to execute badge:" + e.getMessage());
        }
    }

    public static boolean a(Context context) {
        return aom.a(context, 0);
    }

    private static void b(Context context) {
        try {
            d = context.getPackageManager().getLaunchIntentForPackage(context.getPackageName()).getComponent();
            Log.d(a, "Finding badger");
            Intent intent = new Intent("android.intent.action.MAIN");
            intent.addCategory("android.intent.category.HOME");
            String currentHomePackage = context.getPackageManager().resolveActivity(intent, 65536).activityInfo.packageName;
            for (Class<? extends aol> badger : b) {
                aol shortcutBadger = (aol) badger.newInstance();
                if (shortcutBadger.a().contains(currentHomePackage)) {
                    c = shortcutBadger;
                    break;
                }
            }
            if (c == null && Build.MANUFACTURER.equalsIgnoreCase("Xiaomi")) {
                c = new XiaomiHomeBadger();
                return;
            }
        } catch (Exception e) {
            Log.e(a, e.getMessage(), e);
        }
        if (c == null) {
            c = new DefaultBadger();
        }
        Log.d(a, "Current badger:" + c.getClass().getCanonicalName());
    }

    private aom() {
    }
}
