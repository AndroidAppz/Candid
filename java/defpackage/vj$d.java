package defpackage;

import android.net.Uri;

/* compiled from: ImageDownloader */
class vj$d {
    Uri a;
    Object b;

    vj$d(Uri url, Object tag) {
        this.a = url;
        this.b = tag;
    }

    public int hashCode() {
        return ((this.a.hashCode() + 1073) * 37) + this.b.hashCode();
    }

    public boolean equals(Object o) {
        if (o == null || !(o instanceof vj$d)) {
            return false;
        }
        vj$d compareTo = (vj$d) o;
        return compareTo.a == this.a && compareTo.b == this.b;
    }
}
