package defpackage;

import android.os.Bundle;
import android.view.View;

/* compiled from: AccessibilityDelegateCompat */
class ds$c extends ds$a {
    ds$c() {
    }

    public Object a(ds compat) {
        return du.a(new ds$c$1(this, compat));
    }

    public gp a(Object delegate, View host) {
        Object provider = du.a(delegate, host);
        if (provider != null) {
            return new gp(provider);
        }
        return null;
    }

    public boolean a(Object delegate, View host, int action, Bundle args) {
        return du.a(delegate, host, action, args);
    }
}
