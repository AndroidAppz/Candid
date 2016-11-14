package defpackage;

import java.io.File;
import java.io.FilenameFilter;

/* compiled from: CrashlyticsUncaughtExceptionHandler */
class sw$1 implements FilenameFilter {
    sw$1() {
    }

    public boolean accept(File dir, String filename) {
        return filename.length() == ".cls".length() + 35 && filename.endsWith(".cls");
    }
}
