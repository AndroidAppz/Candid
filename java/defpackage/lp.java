package defpackage;

import java.io.File;

/* compiled from: DiskLruCacheFactory */
public class lp implements lm$a {
    private final int a;
    private final lp$a b;

    public lp(lp$a cacheDirectoryGetter, int diskCacheSize) {
        this.a = diskCacheSize;
        this.b = cacheDirectoryGetter;
    }

    public lm a() {
        File cacheDir = this.b.a();
        if (cacheDir == null) {
            return null;
        }
        if (cacheDir.mkdirs() || (cacheDir.exists() && cacheDir.isDirectory())) {
            return lq.a(cacheDir, this.a);
        }
        return null;
    }
}
