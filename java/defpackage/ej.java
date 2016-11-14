package defpackage;

import android.os.Build.VERSION;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;

/* compiled from: MenuItemCompat */
public final class ej {
    static final ej$d a;

    static {
        int version = VERSION.SDK_INT;
        if (version >= 14) {
            a = new ej$c();
        } else if (version >= 11) {
            a = new ej$b();
        } else {
            a = new ej$a();
        }
    }

    public static void a(MenuItem item, int actionEnum) {
        if (item instanceof cl) {
            ((cl) item).setShowAsAction(actionEnum);
        } else {
            a.a(item, actionEnum);
        }
    }

    public static MenuItem a(MenuItem item, View view) {
        if (item instanceof cl) {
            return ((cl) item).setActionView(view);
        }
        return a.a(item, view);
    }

    public static MenuItem b(MenuItem item, int resId) {
        if (item instanceof cl) {
            return ((cl) item).setActionView(resId);
        }
        return a.b(item, resId);
    }

    public static View a(MenuItem item) {
        if (item instanceof cl) {
            return ((cl) item).getActionView();
        }
        return a.a(item);
    }

    public static MenuItem a(MenuItem item, dv provider) {
        if (item instanceof cl) {
            return ((cl) item).setSupportActionProvider(provider);
        }
        Log.w("MenuItemCompat", "setActionProvider: item does not implement SupportMenuItem; ignoring");
        return item;
    }

    public static boolean b(MenuItem item) {
        if (item instanceof cl) {
            return ((cl) item).expandActionView();
        }
        return a.b(item);
    }

    public static boolean c(MenuItem item) {
        if (item instanceof cl) {
            return ((cl) item).isActionViewExpanded();
        }
        return a.c(item);
    }
}
