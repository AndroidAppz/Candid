package defpackage;

import android.os.Bundle;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityNodeProvider;
import java.util.List;

/* compiled from: AccessibilityNodeProviderCompatKitKat */
class gr$1 extends AccessibilityNodeProvider {
    final /* synthetic */ gr$a a;

    gr$1(gr$a gr_a) {
        this.a = gr_a;
    }

    public AccessibilityNodeInfo createAccessibilityNodeInfo(int virtualViewId) {
        return (AccessibilityNodeInfo) this.a.a(virtualViewId);
    }

    public List<AccessibilityNodeInfo> findAccessibilityNodeInfosByText(String text, int virtualViewId) {
        return this.a.a(text, virtualViewId);
    }

    public boolean performAction(int virtualViewId, int action, Bundle arguments) {
        return this.a.a(virtualViewId, action, arguments);
    }

    public AccessibilityNodeInfo findFocus(int focus) {
        return (AccessibilityNodeInfo) this.a.b(focus);
    }
}
