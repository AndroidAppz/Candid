package defpackage;

import android.os.Bundle;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityNodeProvider;
import java.util.List;

/* compiled from: AccessibilityNodeProviderCompatJellyBean */
class gq$1 extends AccessibilityNodeProvider {
    final /* synthetic */ gq$a a;

    gq$1(gq$a gq_a) {
        this.a = gq_a;
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
}
