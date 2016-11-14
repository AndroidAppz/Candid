package defpackage;

import java.io.File;

/* compiled from: DiskLruCache */
public final class js$c {
    final /* synthetic */ js a;
    private final String b;
    private final long c;
    private final long[] d;
    private final File[] e;

    private js$c(js jsVar, String key, long sequenceNumber, File[] files, long[] lengths) {
        this.a = jsVar;
        this.b = key;
        this.c = sequenceNumber;
        this.e = files;
        this.d = lengths;
    }

    public File a(int index) {
        return this.e[index];
    }
}
