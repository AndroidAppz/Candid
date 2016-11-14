package defpackage;

import java.io.File;

/* compiled from: FileLruCache */
final class vh$e implements Comparable<vh$e> {
    private final File a;
    private final long b;

    public /* synthetic */ int compareTo(Object obj) {
        return a((vh$e) obj);
    }

    vh$e(File file) {
        this.a = file;
        this.b = file.lastModified();
    }

    File a() {
        return this.a;
    }

    long b() {
        return this.b;
    }

    public int a(vh$e another) {
        if (b() < another.b()) {
            return -1;
        }
        if (b() > another.b()) {
            return 1;
        }
        return a().compareTo(another.a());
    }

    public boolean equals(Object another) {
        return (another instanceof vh$e) && a((vh$e) another) == 0;
    }

    public int hashCode() {
        return ((this.a.hashCode() + 1073) * 37) + ((int) (this.b % 2147483647L));
    }
}
