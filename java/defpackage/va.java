package defpackage;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;

/* compiled from: CustomTab */
public class va {
    private Uri a;

    public va(String action, Bundle parameters) {
        if (parameters == null) {
            parameters = new Bundle();
        }
        this.a = vw.a(vu.a(), vu.d() + "/" + "dialog/" + action, parameters);
    }

    public void a(Activity activity) {
        b customTabsIntent = new b$a().a();
        customTabsIntent.a.setPackage("com.android.chrome");
        customTabsIntent.a(activity, this.a);
    }
}
