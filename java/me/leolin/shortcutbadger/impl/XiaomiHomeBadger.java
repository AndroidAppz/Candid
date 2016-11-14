package me.leolin.shortcutbadger.impl;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import defpackage.aol;
import defpackage.aon;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;
import me.leolin.shortcutbadger.ShortcutBadgeException;

public class XiaomiHomeBadger implements aol {
    public void a(Context context, ComponentName componentName, int badgeCount) throws ShortcutBadgeException {
        try {
            Object obj;
            Object miuiNotification = Class.forName("android.app.MiuiNotification").newInstance();
            Field field = miuiNotification.getClass().getDeclaredField("messageCount");
            field.setAccessible(true);
            if (badgeCount == 0) {
                obj = "";
            } else {
                obj = Integer.valueOf(badgeCount);
            }
            field.set(miuiNotification, String.valueOf(obj));
        } catch (Exception e) {
            Intent localIntent = new Intent("android.intent.action.APPLICATION_MESSAGE_UPDATE");
            localIntent.putExtra("android.intent.extra.update_application_component_name", componentName.getPackageName() + "/" + componentName.getClassName());
            localIntent.putExtra("android.intent.extra.update_application_message_text", String.valueOf(badgeCount == 0 ? "" : Integer.valueOf(badgeCount)));
            if (aon.a(context, localIntent)) {
                context.sendBroadcast(localIntent);
                return;
            }
            throw new ShortcutBadgeException("unable to resolve intent: " + localIntent.toString());
        }
    }

    public List<String> a() {
        return Arrays.asList(new String[]{"com.miui.miuilite", "com.miui.home", "com.miui.miuihome", "com.miui.miuihome2", "com.miui.mihome", "com.miui.mihome2"});
    }
}
