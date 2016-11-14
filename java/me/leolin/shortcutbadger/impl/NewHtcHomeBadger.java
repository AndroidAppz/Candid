package me.leolin.shortcutbadger.impl;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import defpackage.aol;
import defpackage.aon;
import java.util.Arrays;
import java.util.List;
import me.leolin.shortcutbadger.ShortcutBadgeException;

public class NewHtcHomeBadger implements aol {
    public void a(Context context, ComponentName componentName, int badgeCount) throws ShortcutBadgeException {
        Intent intent1 = new Intent("com.htc.launcher.action.SET_NOTIFICATION");
        intent1.putExtra("com.htc.launcher.extra.COMPONENT", componentName.flattenToShortString());
        intent1.putExtra("com.htc.launcher.extra.COUNT", badgeCount);
        Intent intent = new Intent("com.htc.launcher.action.UPDATE_SHORTCUT");
        intent.putExtra("packagename", componentName.getPackageName());
        intent.putExtra("count", badgeCount);
        if (aon.a(context, intent1) || aon.a(context, intent)) {
            context.sendBroadcast(intent1);
            context.sendBroadcast(intent);
            return;
        }
        throw new ShortcutBadgeException("unable to resolve intent: " + intent.toString());
    }

    public List<String> a() {
        return Arrays.asList(new String[]{"com.htc.launcher"});
    }
}
