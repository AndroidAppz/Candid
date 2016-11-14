package defpackage;

import java.io.File;
import java.io.FilenameFilter;

/* compiled from: ClsFileOutputStream */
class sq$1 implements FilenameFilter {
    sq$1() {
    }

    public boolean accept(File dir, String filename) {
        return filename.endsWith(".cls_temp");
    }
}
