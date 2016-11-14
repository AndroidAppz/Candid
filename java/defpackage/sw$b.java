package defpackage;

import java.io.File;
import java.io.FilenameFilter;

/* compiled from: CrashlyticsUncaughtExceptionHandler */
class sw$b implements FilenameFilter {
    private final String a;

    public sw$b(String s) {
        this.a = s;
    }

    public boolean accept(File dir, String filename) {
        return filename.contains(this.a) && !filename.endsWith(".cls_temp");
    }
}
