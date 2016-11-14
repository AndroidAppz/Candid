/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.view.MenuItem
 *  android.view.View
 *  java.lang.Object
 */
import android.view.MenuItem;
import android.view.View;

class ek {
    public static MenuItem a(MenuItem menuItem, View view) {
        return menuItem.setActionView(view);
    }

    public static View a(MenuItem menuItem) {
        return menuItem.getActionView();
    }

    public static void a(MenuItem menuItem, int n2) {
        menuItem.setShowAsAction(n2);
    }

    public static MenuItem b(MenuItem menuItem, int n2) {
        return menuItem.setActionView(n2);
    }
}

