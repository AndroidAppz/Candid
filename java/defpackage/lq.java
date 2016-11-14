package defpackage;

import android.util.Log;
import java.io.File;
import java.io.IOException;

/* compiled from: DiskLruCacheWrapper */
public class lq implements lm {
    private static lq a = null;
    private final lo b = new lo();
    private final lv c;
    private final File d;
    private final int e;
    private js f;

    public static synchronized lm a(File directory, int maxSize) {
        lm lmVar;
        synchronized (lq.class) {
            if (a == null) {
                a = new lq(directory, maxSize);
            }
            lmVar = a;
        }
        return lmVar;
    }

    protected lq(File directory, int maxSize) {
        this.d = directory;
        this.e = maxSize;
        this.c = new lv();
    }

    private synchronized js a() throws IOException {
        if (this.f == null) {
            this.f = js.a(this.d, 1, 1, (long) this.e);
        }
        return this.f;
    }

    public File a(kf key) {
        File result = null;
        try {
            js$c value = a().a(this.c.a(key));
            if (value != null) {
                result = value.a(0);
            }
        } catch (IOException e) {
            if (Log.isLoggable("DiskLruCacheWrapper", 5)) {
                Log.w("DiskLruCacheWrapper", "Unable to get from disk cache", e);
            }
        }
        return result;
    }

    public void a(kf key, lm$b writer) {
        js$a editor;
        String safeKey = this.c.a(key);
        this.b.a(key);
        try {
            editor = a().b(safeKey);
            if (editor != null) {
                if (writer.a(editor.a(0))) {
                    editor.a();
                }
                editor.c();
            }
            this.b.b(key);
        } catch (IOException e) {
            try {
                if (Log.isLoggable("DiskLruCacheWrapper", 5)) {
                    Log.w("DiskLruCacheWrapper", "Unable to put to disk cache", e);
                }
                this.b.b(key);
            } catch (Throwable th) {
                this.b.b(key);
            }
        } catch (Throwable th2) {
            editor.c();
        }
    }

    public void b(kf key) {
        try {
            a().c(this.c.a(key));
        } catch (IOException e) {
            if (Log.isLoggable("DiskLruCacheWrapper", 5)) {
                Log.w("DiskLruCacheWrapper", "Unable to delete from disk cache", e);
            }
        }
    }
}
