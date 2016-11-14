package me.leolin.shortcutbadger.impl;

import android.content.AsyncQueryHandler;
import android.content.ComponentName;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import defpackage.aol;
import java.util.Arrays;
import java.util.List;
import me.leolin.shortcutbadger.ShortcutBadgeException;

public class SonyHomeBadger implements aol {
    private final Uri a = Uri.parse("content://com.sonymobile.home.resourceprovider/badge");
    private AsyncQueryHandler b;

    public void a(Context context, ComponentName componentName, int badgeCount) throws ShortcutBadgeException {
        if (a(context)) {
            c(context, componentName, badgeCount);
        } else {
            b(context, componentName, badgeCount);
        }
    }

    public List<String> a() {
        return Arrays.asList(new String[]{"com.sonyericsson.home"});
    }

    private static void b(Context context, ComponentName componentName, int badgeCount) {
        Intent intent = new Intent("com.sonyericsson.home.action.UPDATE_BADGE");
        intent.putExtra("com.sonyericsson.home.intent.extra.badge.PACKAGE_NAME", componentName.getPackageName());
        intent.putExtra("com.sonyericsson.home.intent.extra.badge.ACTIVITY_NAME", componentName.getClassName());
        intent.putExtra("com.sonyericsson.home.intent.extra.badge.MESSAGE", String.valueOf(badgeCount));
        intent.putExtra("com.sonyericsson.home.intent.extra.badge.SHOW_MESSAGE", badgeCount > 0);
        context.sendBroadcast(intent);
    }

    private void c(Context context, ComponentName componentName, int badgeCount) {
        if (badgeCount >= 0) {
            if (this.b == null) {
                this.b = new AsyncQueryHandler(this, context.getApplicationContext().getContentResolver()) {
                    final /* synthetic */ SonyHomeBadger a;
                };
            }
            a(badgeCount, componentName.getPackageName(), componentName.getClassName());
        }
    }

    private void a(int badgeCount, String packageName, String activityName) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("badge_count", Integer.valueOf(badgeCount));
        contentValues.put("package_name", packageName);
        contentValues.put("activity_name", activityName);
        this.b.startInsert(0, null, this.a, contentValues);
    }

    private static boolean a(Context context) {
        if (context.getPackageManager().resolveContentProvider("com.sonymobile.home.resourceprovider", 0) != null) {
            return true;
        }
        return false;
    }
}
