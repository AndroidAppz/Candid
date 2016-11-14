package defpackage;

import java.io.File;
import java.io.FilenameFilter;

/* compiled from: CrashlyticsUncaughtExceptionHandler */
class sw$8 implements FilenameFilter {
    sw$8() {
    }

    public boolean accept(File file, String filename) {
        return sw.e.matcher(filename).matches();
    }
}
