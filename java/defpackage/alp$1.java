package defpackage;

import android.content.Context;

/* compiled from: InstallerPackageNameProvider */
class alp$1 implements alc<String> {
    final /* synthetic */ alp a;

    alp$1(alp alp) {
        this.a = alp;
    }

    public /* synthetic */ Object b(Context x0) throws Exception {
        return a(x0);
    }

    public String a(Context context) throws Exception {
        String installerPackageName = context.getPackageManager().getInstallerPackageName(context.getPackageName());
        return installerPackageName == null ? "" : installerPackageName;
    }
}
