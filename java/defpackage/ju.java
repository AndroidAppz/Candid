package defpackage;

import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;

/* compiled from: Util */
final class ju {
    static final Charset a = Charset.forName("US-ASCII");
    static final Charset b = Charset.forName("UTF-8");

    static void a(File dir) throws IOException {
        File[] files = dir.listFiles();
        if (files == null) {
            throw new IOException("not a readable directory: " + dir);
        }
        File[] arr$ = files;
        int len$ = arr$.length;
        int i$ = 0;
        while (i$ < len$) {
            File file = arr$[i$];
            if (file.isDirectory()) {
                ju.a(file);
            }
            if (file.delete()) {
                i$++;
            } else {
                throw new IOException("failed to delete file: " + file);
            }
        }
    }

    static void a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (RuntimeException rethrown) {
                throw rethrown;
            } catch (Exception e) {
            }
        }
    }
}
