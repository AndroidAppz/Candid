package defpackage;

import android.os.Bundle;
import java.util.ArrayList;
import java.util.List;

/* compiled from: AccessibilityNodeProviderCompat */
class gp$c$1 implements gr$a {
    final /* synthetic */ gp a;
    final /* synthetic */ gp$c b;

    gp$c$1(gp$c gp_c, gp gpVar) {
        this.b = gp_c;
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

    public Object b(int focus) {
        gi compatInfo = this.a.findFocus(focus);
        if (compatInfo == null) {
            return null;
        }
        return compatInfo.a();
    }
}
