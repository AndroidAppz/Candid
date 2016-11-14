package defpackage;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* compiled from: DigestUtils */
public class aos {
    public static MessageDigest a(String algorithm) {
        try {
            return MessageDigest.getInstance(algorithm);
        } catch (NoSuchAlgorithmException e) {
            throw new IllegalArgumentException(e);
        }
    }

    public static MessageDigest a() {
        return aos.a("MD5");
    }

    public static byte[] a(byte[] data) {
        return aos.a().digest(data);
    }

    public static byte[] b(String data) {
        return aos.a(aor.a(data));
    }
}
