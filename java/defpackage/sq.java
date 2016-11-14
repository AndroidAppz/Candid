package defpackage;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FilenameFilter;
import java.io.IOException;

/* compiled from: ClsFileOutputStream */
class sq extends FileOutputStream {
    public static final FilenameFilter a = new sq$1();
    private final String b;
    private File c;
    private File d;
    private boolean e = false;

    public sq(File dir, String fileRoot) throws FileNotFoundException {
        super(new File(dir, fileRoot + ".cls_temp"));
        this.b = dir + File.separator + fileRoot;
        this.c = new File(this.b + ".cls_temp");
    }

    public synchronized void close() throws IOException {
        if (!this.e) {
            this.e = true;
            super.flush();
            super.close();
            File complete = new File(this.b + ".cls");
            if (this.c.renameTo(complete)) {
                this.c = null;
                this.d = complete;
            } else {
                String reason = "";
                if (complete.exists()) {
                    reason = " (target already exists)";
                } else if (!this.c.exists()) {
                    reason = " (source does not exist)";
                }
                throw new IOException("Could not rename temp file: " + this.c + " -> " + complete + reason);
            }
        }
    }

    public void a() throws IOException {
        if (!this.e) {
            this.e = true;
            super.flush();
            super.close();
        }
    }
}
