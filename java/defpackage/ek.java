package defpackage;

import android.view.MenuItem;
import android.view.View;

/* compiled from: MenuItemCompatHoneycomb */
class ek {
    public static void a(MenuItem item, int actionEnum) {
        item.setShowAsAction(actionEnum);
    }

    public static MenuItem a(MenuItem item, View view) {
        return item.setActionView(view);
    }

    public static MenuItem b(MenuItem item, int resId) {
        return item.setActionView(resId);
    }

    public static View a(MenuItem item) {
        return item.getActionView();
    }
}
