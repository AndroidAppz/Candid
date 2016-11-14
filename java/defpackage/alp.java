package defpackage;

import android.content.Context;

/* compiled from: InstallerPackageNameProvider */
public class alp {
    private final alc<String> a = new alp$1(this);
    private final ala<String> b = new ala();

    public String a(Context appContext) {
        try {
            String name = (String) this.b.a(appContext, this.a);
            if ("".equals(name)) {
                return null;
            }
            return name;
        } catch (Exception e) {
            akp.h().e("Fabric", "Failed to determine installer package name", e);
            return null;
        }
    }
}
