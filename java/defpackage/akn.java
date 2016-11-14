package defpackage;

import android.app.Application;
import android.content.Context;
import android.os.Build.VERSION;

/* compiled from: ActivityLifecycleManager */
public class akn {
    private final Application a;
    private akn$a b;

    public akn(Context context) {
        this.a = (Application) context.getApplicationContext();
        if (VERSION.SDK_INT >= 14) {
            this.b = new akn$a(this.a);
        }
    }

    public boolean a(akn$b callbacks) {
        return this.b != null && this.b.a(callbacks);
    }

    public void a() {
        if (this.b != null) {
            this.b.a();
        }
    }
}
