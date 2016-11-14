package defpackage;

import java.io.File;
import java.io.FilenameFilter;
import java.util.regex.Pattern;

/* compiled from: Utility */
class vw$3 implements FilenameFilter {
    vw$3() {
    }

    public boolean accept(File dir, String fileName) {
        return Pattern.matches("cpu[0-9]+", fileName);
    }
}
