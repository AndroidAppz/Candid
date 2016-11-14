package defpackage;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.util.UUID;

/* compiled from: GifFrameLoader */
class oj$d implements kf {
    private final UUID a;

    public oj$d() {
        this(UUID.randomUUID());
    }

    oj$d(UUID uuid) {
        this.a = uuid;
    }

    public boolean equals(Object o) {
        if (o instanceof oj$d) {
            return ((oj$d) o).a.equals(this.a);
        }
        return false;
    }

    public int hashCode() {
        return this.a.hashCode();
    }

    public void a(MessageDigest messageDigest) throws UnsupportedEncodingException {
        throw new UnsupportedOperationException("Not implemented");
    }
}
