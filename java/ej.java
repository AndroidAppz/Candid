/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.os.Build
 *  android.os.Build$VERSION
 *  android.util.Log
 *  android.view.MenuItem
 *  android.view.View
 *  java.lang.Object
 *  java.lang.String
 */
import android.os.Build;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;

public final class ej {
    static final d a;

    static {
        int n2 = Build.VERSION.SDK_INT;
        a = n2 >= 14 ? new c() : (n2 >= 11 ? new b() : new a());
    }

    public static MenuItem a(MenuItem menuItem, View view) {
        if (menuItem instanceof cl) {
            return ((cl)menuItem).setActionView(view);
        }
        return a.a(menuItem, view);
    }

    public static MenuItem a(MenuItem menuItem, dv dv2) {
        if (menuItem instanceof cl) {
            return ((cl)menuItem).setSupportActionProvider(dv2);
        }
        Log.w((String)"MenuItemCompat", (String)"setActionProvider: item does not implement SupportMenuItem; ignoring");
        return menuItem;
    }

    public static View a(MenuItem menuItem) {
        if (menuItem instanceof cl) {
            return ((cl)menuItem).getActionView();
        }
        return a.a(menuItem);
    }

    public static void a(MenuItem menuItem, int n2) {
        if (menuItem instanceof cl) {
            ((cl)menuItem).setShowAsAction(n2);
            return;
        }
        a.a(menuItem, n2);
    }

    public static MenuItem b(MenuItem menuItem, int n2) {
        if (menuItem instanceof cl) {
            return ((cl)menuItem).setActionView(n2);
        }
        return a.b(menuItem, n2);
    }

    public static boolean b(MenuItem menuItem) {
        if (menuItem instanceof cl) {
            return ((cl)menuItem).expandActionView();
        }
        return a.b(menuItem);
    }

    public static boolean c(MenuItem menuItem) {
        if (menuItem instanceof cl) {
            return ((cl)menuItem).isActionViewExpanded();
        }
        return a.c(menuItem);
    }

    static class a
    implements d {
        a() {
        }

        @Override
        public MenuItem a(MenuItem menuItem, View view) {
            return menuItem;
        }

        @Override
        public View a(MenuItem menuItem) {
            return null;
        }

        @Override
        public void a(MenuItem menuItem, int n2) {
        }

        @Override
        public MenuItem b(MenuItem menuItem, int n2) {
            return menuItem;
        }

        @Override
        public boolean b(MenuItem menuItem) {
            return false;
        }

        @Override
        public boolean c(MenuItem menuItem) {
            return false;
        }
    }

    static class b
    implements d {
        b() {
        }

        @Override
        public MenuItem a(MenuItem menuItem, View view) {
            return ek.a(menuItem, view);
        }

        @Override
        public View a(MenuItem menuItem) {
            return ek.a(menuItem);
        }

        @Override
        public void a(MenuItem menuItem, int n2) {
            ek.a(menuItem, n2);
        }

        @Override
        public MenuItem b(MenuItem menuItem, int n2) {
            return ek.b(menuItem, n2);
        }

        @Override
        public boolean b(MenuItem menuItem) {
            return false;
        }

        @Override
        public boolean c(MenuItem menuItem) {
            return false;
        }
    }

    static class c
    extends b {
        c() {
        }

        @Override
        public boolean b(MenuItem menuItem) {
            return el.a(menuItem);
        }

        @Override
        public boolean c(MenuItem menuItem) {
            return el.b(menuItem);
        }
    }

    static interface d {
        public MenuItem a(MenuItem var1, View var2);

        public View a(MenuItem var1);

        public void a(MenuItem var1, int var2);

        public MenuItem b(MenuItem var1, int var2);

        public boolean b(MenuItem var1);

        public boolean c(MenuItem var1);
    }

    public static interface e {
        public boolean onMenuItemActionCollapse(MenuItem var1);

        public boolean onMenuItemActionExpand(MenuItem var1);
    }

}

