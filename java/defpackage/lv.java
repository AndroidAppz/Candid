package defpackage;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* compiled from: SafeKeyGenerator */
class lv {
    private final qx<kf, String> a = new qx(1000);

    lv() {
    }

    public String a(kf key) {
        String safeKey;
        synchronized (this.a) {
            safeKey = (String) this.a.b((Object) key);
        }
        if (safeKey == null) {
            try {
                MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
                key.a(messageDigest);
                safeKey = ra.a(messageDigest.digest());
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            } catch (NoSuchAlgorithmException e2) {
                e2.printStackTrace();
            }
            synchronized (this.a) {
                this.a.b(key, safeKey);
            }
        }
        return safeKey;
    }
}
