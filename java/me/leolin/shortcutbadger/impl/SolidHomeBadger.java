package me.leolin.shortcutbadger.impl;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import defpackage.aol;
import defpackage.aon;
import java.util.Arrays;
import java.util.List;
import me.leolin.shortcutbadger.ShortcutBadgeException;

public class SolidHomeBadger implements aol {
    public void a(Context context, ComponentName componentName, int badgeCount) throws ShortcutBadgeException {
        Intent intent = new Intent("com.majeur.launcher.intent.action.UPDATE_BADGE");
        intent.putExtra("com.majeur.launcher.intent.extra.BADGE_PACKAGE", componentName.getPackageName());
        intent.putExtra("com.majeur.launcher.intent.extra.BADGE_COUNT", badgeCount);
        intent.putExtra("com.majeur.launcher.intent.extra.BADGE_CLASS", componentName.getClassName());
        if (aon.a(context, intent)) {
            context.sendBroadcast(intent);
            return;
        }
        throw new ShortcutBadgeException("unable to resolve intent: " + intent.toString());
    }

    public List<String> a() {
        return Arrays.asList(new String[]{"com.majeur.launcher"});
    }
}
