package defpackage;

import android.os.Build.VERSION;
import android.os.Bundle;
import java.util.List;

/* compiled from: AccessibilityNodeProviderCompat */
public class gp {
    private static final gp$a a;
    private final Object b;

    static {
        if (VERSION.SDK_INT >= 19) {
            a = new gp$c();
        } else if (VERSION.SDK_INT >= 16) {
            a = new gp$b();
        } else {
            a = new gp$d();
        }
    }

    public gp() {
        this.b = a.a(this);
    }

    public gp(Object provider) {
        this.b = provider;
    }

    public Object getProvider() {
        return this.b;
    }

    public gi createAccessibilityNodeInfo(int virtualViewId) {
        return null;
    }

    public boolean performAction(int virtualViewId, int action, Bundle arguments) {
        return false;
    }

    public List<gi> findAccessibilityNodeInfosByText(String text, int virtualViewId) {
        return null;
    }

    public gi findFocus(int focus) {
        return null;
    }
}
