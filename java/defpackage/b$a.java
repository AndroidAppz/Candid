package defpackage;

import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.support.v4.app.BundleCompat;
import java.util.ArrayList;

/* compiled from: CustomTabsIntent */
public final class b$a {
    private final Intent a;
    private ArrayList<Bundle> b;
    private Bundle c;
    private ArrayList<Bundle> d;

    public b$a() {
        this(null);
    }

    public b$a(c session) {
        IBinder iBinder = null;
        this.a = new Intent("android.intent.action.VIEW");
        this.b = null;
        this.c = null;
        this.d = null;
        if (session != null) {
            this.a.setPackage(session.b().getPackageName());
        }
        Bundle bundle = new Bundle();
        String str = "android.support.customtabs.extra.SESSION";
        if (session != null) {
            iBinder = session.a();
        }
        BundleCompat.putBinder(bundle, str, iBinder);
        this.a.putExtras(bundle);
    }

    public b a() {
        if (this.b != null) {
            this.a.putParcelableArrayListExtra("android.support.customtabs.extra.MENU_ITEMS", this.b);
        }
        if (this.d != null) {
            this.a.putParcelableArrayListExtra("android.support.customtabs.extra.TOOLBAR_ITEMS", this.d);
        }
        return new b(this.a, this.c);
    }
}
