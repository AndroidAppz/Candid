package defpackage;

import java.util.Map;

/* compiled from: Utility */
public class vw$b {
    private boolean a;
    private String b;
    private boolean c;
    private boolean d;
    private int e;
    private Map<String, Map<String, vw$a>> f;
    private vf g;

    private vw$b(boolean supportsImplicitLogging, String nuxContent, boolean nuxEnabled, boolean customTabsEnabled, int sessionTimeoutInSeconds, Map<String, Map<String, vw$a>> dialogConfigMap, vf errorClassification) {
        this.a = supportsImplicitLogging;
        this.b = nuxContent;
        this.c = nuxEnabled;
        this.d = customTabsEnabled;
        this.f = dialogConfigMap;
        this.g = errorClassification;
        this.e = sessionTimeoutInSeconds;
    }

    public boolean a() {
        return this.a;
    }

    public String b() {
        return this.b;
    }

    public boolean c() {
        return this.c;
    }

    public boolean d() {
        return this.d;
    }

    public Map<String, Map<String, vw$a>> e() {
        return this.f;
    }

    public vf f() {
        return this.g;
    }
}
