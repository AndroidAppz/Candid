package defpackage;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;

/* compiled from: DecodeJob */
class kt$b {
    kt$b() {
    }

    public OutputStream a(File file) throws FileNotFoundException {
        return new BufferedOutputStream(new FileOutputStream(file));
    }
}
