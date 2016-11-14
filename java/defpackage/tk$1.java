package defpackage;

import java.io.File;
import java.io.FilenameFilter;

/* compiled from: ReportUploader */
class tk$1 implements FilenameFilter {
    tk$1() {
    }

    public boolean accept(File dir, String filename) {
        return filename.endsWith(".cls") && !filename.contains("Session");
    }
}
