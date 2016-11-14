package defpackage;

import java.io.File;
import java.io.FilenameFilter;

/* compiled from: CrashlyticsUncaughtExceptionHandler */
class sw$5 implements FilenameFilter {
    final /* synthetic */ String a;
    final /* synthetic */ sw b;

    sw$5(sw swVar, String str) {
        this.b = swVar;
        this.a = str;
    }

    public boolean accept(File f, String name) {
        return name.startsWith(this.a);
    }
}
