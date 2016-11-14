package defpackage;

import java.io.File;
import java.io.FilenameFilter;

/* compiled from: FileLruCache */
class vh$a$1 implements FilenameFilter {
    vh$a$1() {
    }

    public boolean accept(File dir, String filename) {
        return !filename.startsWith("buffer");
    }
}
