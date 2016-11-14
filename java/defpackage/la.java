package defpackage;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;

/* compiled from: OriginalKey */
class la implements kf {
    private final String a;
    private final kf b;

    public la(String id, kf signature) {
        this.a = id;
        this.b = signature;
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        la that = (la) o;
        if (!this.a.equals(that.a)) {
            return false;
        }
        if (this.b.equals(that.b)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return (this.a.hashCode() * 31) + this.b.hashCode();
    }

    public void a(MessageDigest messageDigest) throws UnsupportedEncodingException {
        messageDigest.update(this.a.getBytes("UTF-8"));
        this.b.a(messageDigest);
    }
}
