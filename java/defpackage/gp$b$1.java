package defpackage;

import android.os.Bundle;
import java.util.ArrayList;
import java.util.List;

/* compiled from: AccessibilityNodeProviderCompat */
class gp$b$1 implements gq$a {
    final /* synthetic */ gp a;
    final /* synthetic */ gp$b b;

    gp$b$1(gp$b gp_b, gp gpVar) {
        this.b = gp_b;
        this.a = gpVar;
    }

    public boolean a(int virtualViewId, int action, Bundle arguments) {
        return this.a.performAction(virtualViewId, action, arguments);
    }

    public List<Object> a(String text, int virtualViewId) {
        List<gi> compatInfos = this.a.findAccessibilityNodeInfosByText(text, virtualViewId);
        List<Object> infos = new ArrayList();
        int infoCount = compatInfos.size();
        for (int i = 0; i < infoCount; i++) {
            infos.add(((gi) compatInfos.get(i)).a());
        }
        return infos;
    }

    public Object a(int virtualViewId) {
        gi compatInfo = this.a.createAccessibilityNodeInfo(virtualViewId);
        if (compatInfo == null) {
            return null;
        }
        return compatInfo.a();
    }
}
