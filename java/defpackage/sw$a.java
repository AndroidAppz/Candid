package defpackage;

import java.io.File;
import java.io.FilenameFilter;

/* compiled from: CrashlyticsUncaughtExceptionHandler */
class sw$a implements FilenameFilter {
    private sw$a() {
    }

    public boolean accept(File file, String fileName) {
        return !sw.a.accept(file, fileName) && sw.e.matcher(fileName).matches();
    }
}
